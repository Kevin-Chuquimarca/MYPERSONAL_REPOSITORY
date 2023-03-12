using System;
using System.Collections;
using System.Net.Sockets;
using System.Net;
using System.Threading;
using Serialization;
using Chat;

namespace Servidor.Controlador
{
    class Server
    {
        Socket socket;
        Thread listenThread;
        Hashtable usersTable;
        public Server()
        {
            try
            {
                IPHostEntry host = Dns.GetHostEntry("localhost");
                IPAddress addr = host.AddressList[0];
                IPEndPoint endPoint = new IPEndPoint(addr, 4404);

                socket = new Socket(endPoint.AddressFamily, SocketType.Stream, ProtocolType.Tcp);
                socket.Bind(endPoint);
                socket.Listen(10);

                listenThread = new Thread(this.Listen);
                listenThread.Start();
                usersTable = new Hashtable();
            }
            catch (Exception e)
            {
                Console.WriteLine("{0}", e.Message);
            }
        }

        private void Listen()
        {
            Socket client;
            while (true)
            {
                client = this.socket.Accept();
                listenThread = new Thread(this.ListenClient);
                listenThread.Start(client);
            }
        }

        private void ListenClient(object o)
        {
            Socket client = (Socket)o;
            object received;

            do
            {
                received = this.Receive(client);
                Console.WriteLine(((Chat.User)received).nick + " en línea...");
            } while (!(received is User));

            this.usersTable.Add(received, client);
            this.BroadCast(received);
            this.SendAllUsers(client);

            while (true)
            {
                received = this.Receive(client);

                if (received is Message)
                {

                    if (!System.IO.Path.IsPathRooted(((Message)received).msg))
                    {
                        Console.WriteLine("De: " + ((Message)received).@from.nick +
                        " \nPara: " + ((Message)received).to.nick +
                        " \nMensaje: " + ((Message)received).msg);
                        this.SendMessage((Message)received);
                    }
                }
            }


        }

        private void BroadCast(object o)
        {
            foreach (DictionaryEntry d in this.usersTable)
            {
                this.Send((Socket)d.Value, o);
            }
        }

        private void SendAllUsers(Socket s)
        {
            foreach (DictionaryEntry d in this.usersTable)
            {
                this.Send(s, d.Key);
            }
        }

        private void SendMessage(Message m)
        {
            User tmpUser;
            foreach (DictionaryEntry d in this.usersTable)
            {
                tmpUser = (User)d.Key;
                if (tmpUser.id == m.to.id)
                {
                    this.Send((Socket)d.Value, m);
                    break;
                }
            }
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
