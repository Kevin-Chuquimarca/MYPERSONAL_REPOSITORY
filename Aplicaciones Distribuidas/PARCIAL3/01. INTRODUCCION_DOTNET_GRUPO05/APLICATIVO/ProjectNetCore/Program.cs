using System;
using BlC_Standar;
using System.Data;

namespace ProjectNetCore
{
    class Program
    {
        static void Main(string[] args)
        {
            MiClaseComun obj = new MiClaseComun();
            Console.WriteLine("La suma es: " + obj.suma(58, 152));
            Console.WriteLine("Listado de Empleados");
            foreach (DataRow item in obj.consultaBD().Rows)
            {
                Console.WriteLine(item["EmployeeID"].ToString() + " , " + item["LastName"].ToString());
            }
            Console.ReadKey();
        }
    }
}