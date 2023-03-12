using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using BlC_Standar;
using System.Data;

namespace ProjectNetFramework
{
    internal class Program
    {
        static void Main(string[] args)
        {
            MiClaseComun obj = new MiClaseComun();
            Console.WriteLine("La suma es: " + obj.suma(58, 152));
            //CONSULTA LA BD
            Console.WriteLine("\nLista de Empleados\n");
            foreach (DataRow item in obj.consultaBD().Rows)
            {
                Console.WriteLine(item["EmployeeID"].ToString() + " , " + item["LastName"].ToString());
            }
            Console.ReadKey();
        }
    }
}
