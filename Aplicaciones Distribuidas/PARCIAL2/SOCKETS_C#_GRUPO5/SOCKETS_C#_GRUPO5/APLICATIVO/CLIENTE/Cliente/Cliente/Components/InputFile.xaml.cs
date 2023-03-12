using Microsoft.Win32;
using System;
using System.Text;
using System.Windows;
using System.Windows.Controls;

namespace Cliente.Components
{

    public partial class InputFile : UserControl
    {
        public EventHandler onSelected;
        public InputFile()
        {
            InitializeComponent();
        }
        private void OpenFileButton_Click(object sender, RoutedEventArgs e)
        {
            OpenFileDialog openFileDialog = new OpenFileDialog();
            if (openFileDialog.ShowDialog() == true)
            {
                string filePath = openFileDialog.FileName;
                byte[] filePathByte = Encoding.UTF8.GetBytes(filePath);
                onSelected(filePathByte, e);
            }
        }
    }

}
