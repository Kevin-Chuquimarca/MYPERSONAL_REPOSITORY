using System.Data.SqlClient;

namespace App_Registros.DAO
{
    class ConexionBD
    {
        protected SqlConnection Conexion =
            new SqlConnection(
                "Server=.;DataBase=Practica_Patrones; integrated security=true"
                );
    }
}
