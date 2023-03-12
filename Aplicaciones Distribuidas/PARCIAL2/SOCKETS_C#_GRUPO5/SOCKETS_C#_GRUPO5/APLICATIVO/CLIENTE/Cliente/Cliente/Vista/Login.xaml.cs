using Cliente.Chat;
using System;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Navigation;

namespace Cliente
{
    public partial class Login : Page
    {
        public Login()
        {
            InitializeComponent();
            btn.clickEvent = StartChat;
        }
        private void StartChat(object sender, EventArgs e)
        {
            string user = username.textInput.Text;
            Vista.ChatPage chatPage;
            Client c;
            if (user.Trim() != "")
            {
                chatPage = new Vista.ChatPage();
                c = new Client(user, chatPage.UpdateUI);
                c.Start();
                chatPage.client = c;
                NavigationService.Navigate(chatPage);
            }
            else
                MessageBox.Show("Ingrese un usuario");
        }
    }
}
