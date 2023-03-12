Imports System.Configuration
Imports System.Data.SqlClient
Public MustInherit Class Repository
    Private ReadOnly connectionString As String
    Public Sub New()
        connectionString = ConfigurationManager.ConnectionStrings("connMyCompany").ToString()
    End Sub

    Protected Function GetConnection() As SqlConnection
        Return New SqlConnection(connectionString)
    End Function
End Class
