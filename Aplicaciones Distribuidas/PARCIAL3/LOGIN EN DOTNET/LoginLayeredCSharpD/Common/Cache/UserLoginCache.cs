using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Common.Cache
{
    public static class UserLoginCache
    {
        public static char? Id { get; set; }
        public static char? Rol { get; set; }
        public static string? DescriptionRol { get; set; }
        public static string? Email { get; set; }
        public static string? Lastname { get; set; }
        public static string? Name { get; set; }
        public static string? Photo { get; set; }
        public static string? Phone { get; set; }
        public static string? IdentificationCard { get; set; }
        public static string? Password { get; set; }
        public static char? State { get; set; }
    }
}
