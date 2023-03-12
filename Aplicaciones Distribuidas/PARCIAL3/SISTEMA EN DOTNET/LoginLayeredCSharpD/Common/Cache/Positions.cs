using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Common.Cache
{
    public static class Positions
    {
        //public static List<char>? Id { get; set; }
        private static List<char> _id = new List<char>();

        public static List<char> Id
        {
            get { return _id; }
            set { _id = value; }
        }

    }
}
