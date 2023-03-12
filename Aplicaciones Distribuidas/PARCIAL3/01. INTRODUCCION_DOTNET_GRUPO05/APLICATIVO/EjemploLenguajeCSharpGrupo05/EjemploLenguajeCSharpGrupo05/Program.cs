using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EjemploLenguajeCSharpGrupo05
{
    class Program
    {
        static void Main(string[] args)
        {
            int num1 = 5;
            int num2 = 3;
            if ((num1 + num2) > 10)
            {
                Console.WriteLine("La suma entre " + num1 + " + " + num2 + " Si es mayor a 10");
            }
            else
            {
                Console.WriteLine("La suma entre " + num1 + " + " + num2 + " No es mayor a 10");
            }
            Console.ReadKey();
        }
    }
}

