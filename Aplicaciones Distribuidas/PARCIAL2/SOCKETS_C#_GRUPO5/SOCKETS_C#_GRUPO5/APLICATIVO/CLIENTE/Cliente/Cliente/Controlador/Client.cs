using System;
using System.Collections.Generic;
using System.Net.Sockets;
using System.Net;
using System.Threading;
using Serialization;
using Chat;

namespace Cliente.Chat
{
    public class Client
    {
        public delegate void UpdateDelegate(object o);
        public UpdateDelegate onUpdate;

        User u;
        ChatManager chat;

        readonly IPHostEntry host;
        readonly IPAddress addr;
        readonly IPEndPoint endPoint;
        readonly Socket socket;
        Thread listenThread;

        public Client(string username, UpdateDelegate onUpdate)
        {
            this.onUpdate = onUpdate;

            this.u = new User(Guid.NewGuid().ToString("N"), username);
            this.chat = new ChatManager(u);

            try
            {
                host = Dns.GetHostEntry("localhost");
                addr = host.AddressList[0];
                endPoint = new IPEndPoint(addr, 4404);
                socket = new Socket(endPoint.AddressFamily, SocketType.Stream, ProtocolType.Tcp);
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
            }
        }

        public void Start()
        {
            this.socket.Connect(endPoint);
            this.Send(this.socket, this.u);
            listenThread = new Thread(this.Listen);
            listenThread.SetApartmentState(ApartmentState.STA);
            listenThread.Start();
        }

        private void Listen()
        {
            object received;
            while (true)
            {
                received = this.Receive(this.socket);
                if (received is Message)
                {
                    this.AddMessage((Message)received);
                }
                else if (received is User)
                {
                    this.AddUser((User)received);
                }
            }
        }

        private void AddUser(User user)
        {
            if (user.id != this.u.id && this.chat.AddUser(user))
                onUpdate(user);
        }

        private void AddMessage(Message m)
        {
            this.chat.AddMessage(m);
            onUpdate(m);
        }

        public LinkedList<Message> GetMessages(User u)
        {
            return chat.GetMessages(u);
        }

        public LinkedList<User> GetUsers()
        {
            return chat.GetUsers();
        }

        public Message SendMessage(string msg, User to)
        {
            Message m = new Message(this.u, to, msg);
            this.Send(this.socket, m);
            this.AddMessage(m);
            return m;
        }

        public Message SendFile(string file, User to)
        {
            Message fl = new Message(this.u, to, file);
            this.Send(this.socket, fl);
            return fl;
        }

        private void Send(Socket s, object o)
        {
            byte[] buffer = new byte[1024];
            byte[] obj = BinarySerialization.Serializate(o);
            Array.Copy(obj, buffer, obj.Length);
            s.Send(buffer);
        }

        private object Receive(Socket s)
        {
            byte[] buffer = new byte[1024];
            s.Receive(buffer);
            return BinarySerialization.Deserializate(buffer);
        }
    }
}
