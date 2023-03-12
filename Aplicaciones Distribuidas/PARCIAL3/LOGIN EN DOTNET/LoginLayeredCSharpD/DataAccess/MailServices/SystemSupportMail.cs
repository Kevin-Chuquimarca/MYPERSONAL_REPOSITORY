using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DataAccess.MailServices
{
    class SystemSupportMail: MasterMailServer
    {
        public SystemSupportMail()
        {
            senderMail = "santi.kevin0983@gmail.com";
            password = "rsspamigisxvpexu";
            host = "smtp.gmail.com";
            port = 587;
            ssl = true;
            initializeSmtpClient();
        }
    }
}
