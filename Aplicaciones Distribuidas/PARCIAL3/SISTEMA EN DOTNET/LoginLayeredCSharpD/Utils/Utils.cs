using System;
using System.Security.Cryptography;
using iTextSharp.text;
using iTextSharp.text.pdf;
using System.IO;

namespace Utils
{
    public abstract class Utils
    {
        public static string EncryptPassword(string password)
        {
            byte[] passwordBytes = System.Text.Encoding.UTF8.GetBytes(password);
            SHA1 sha1 = SHA1.Create();
            byte[] hashBytes = sha1.ComputeHash(passwordBytes);
            string passwordEncrypt = BitConverter.ToString(hashBytes).Replace("-", "");
            return passwordEncrypt;
        }
        public static string GeneratePassword()
        {
            const string validChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
            const int length = 15;
            using (var crypto = new RNGCryptoServiceProvider())
            {
                byte[] data = new byte[length];

                crypto.GetBytes(data);

                char[] password = new char[length];

                for (int i = 0; i < length; i++)
                {
                    int randomIndex = data[i] % validChars.Length;
                    password[i] = validChars[randomIndex];
                }

                return new string(password);
            }

        }
        public static string GenerateCaptcha()
        {
            const string validChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
            const int length = 5;
            using (var crypto = new RNGCryptoServiceProvider())
            {
                byte[] data = new byte[length];

                crypto.GetBytes(data);

                char[] password = new char[length];

                for (int i = 0; i < length; i++)
                {
                    int randomIndex = data[i] % validChars.Length;
                    password[i] = validChars[randomIndex];
                }

                return new string(password);
            }
        }
    }
}