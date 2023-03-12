using System;
using System.Windows;
using System.Windows.Controls;

namespace Cliente.Components
{
    public partial class Button : UserControl
    {
        public EventHandler clickEvent { set; get; }

        public string Text { get; set; }
        public Button()
        {
            InitializeComponent();
            this.DataContext = this;
        }

        private void Click(object sender, RoutedEventArgs e)
        {
            if (this.clickEvent != null) clickEvent(sender, e);
        }
    }
}
