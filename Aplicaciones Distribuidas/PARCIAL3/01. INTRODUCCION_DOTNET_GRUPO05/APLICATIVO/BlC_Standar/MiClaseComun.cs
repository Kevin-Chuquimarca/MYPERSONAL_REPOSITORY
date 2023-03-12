using System;
using System.Data;
using System.Collections;
using System.Data.SqlClient;
using System.Linq.Expressions;

namespace BlC_Standar
{
    public class MiClaseComun
    {
        public String suma(double a, double b)
        {
            return Convert.ToString((a + b));
        }
        public DataTable consultaBD()
        {
            string ConnectionString = "Data Source=.;Initial Catalog=TestNorthwind;Integrated Security=true";
            DataTable tabla = new DataTable();
            SqlCommand cmd = new SqlCommand();
            SqlDataReader leer;
            SqlConnection conexion = new SqlConnection(ConnectionString);
            conexion.Open();
            cmd.Connection = conexion;
            cmd.CommandText = "select * from Employees";
            leer = cmd.ExecuteReader();
            tabla.Load(leer);
            leer.Close();
            return tabla;
        }
    }
}
