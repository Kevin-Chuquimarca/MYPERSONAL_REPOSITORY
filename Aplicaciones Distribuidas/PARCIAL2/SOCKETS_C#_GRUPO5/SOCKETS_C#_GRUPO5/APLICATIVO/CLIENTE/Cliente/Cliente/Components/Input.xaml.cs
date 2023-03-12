using System;
using System.Windows.Controls;
using System.Windows.Input;

namespace Cliente.Components
{
    public partial class Input : UserControl
    {
        public EventHandler onEnter;
        public Input()
        {
            InitializeComponent();
        }

        public void TextInput_KeyUp(object sender, KeyEventArgs e)
        {
            if (e.Key == Key.Enter && onEnter != null) 
            {
                onEnter(sender, e); 
            }
        }
    }
}
