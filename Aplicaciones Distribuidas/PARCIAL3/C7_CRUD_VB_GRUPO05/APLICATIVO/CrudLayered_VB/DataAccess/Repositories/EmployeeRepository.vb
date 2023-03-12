Imports System.Data.SqlClient
Imports System.Data
Imports DataAccess

Public Class EmployeeRepository
    Inherits MasterRepository
    Implements IEmployeeRepository

    Private selectAll As String
    Private insert As String
    Private update As String
    Private delete As String

    Public Sub New()
        selectAll = "SELECT * FROM Employee"
        insert = "INSERT INTO Employee VALUES(@idNumber,@name,@mail,@birthday)"
        update = "UPDATE Employee SET IdNumber=@idNumber,Name=@name,Mail=@mail,Birthday=@birthday WHERE idPK=@idPK"
        delete = "DELETE FROM Employee WHERE idPk=@idPK"
    End Sub

    Public Function GetAll() As IEnumerable(Of Employee) Implements IGenericRepository(Of Employee).GetAll
        Dim resultTable = ExecuteReader(selectAll)
        Dim listEmployees = New List(Of Employee)
        For Each item As DataRow In resultTable.Rows
            listEmployees.Add(New Employee() With {
                .IdPk = item(0),
                .IdNumber = item(1),
                .Name = item(2),
                .Mail = item(3),
                .Birthday = item(4)
            })
        Next
        Return listEmployees
    End Function
    Public Function Add(entity As Employee) As Integer Implements IGenericRepository(Of Employee).Add
        parameters = New List(Of SqlParameter)
        parameters.Add(New SqlParameter("@idNumber", entity.IdNumber))
        parameters.Add(New SqlParameter("@name", entity.Name))
        parameters.Add(New SqlParameter("@mail", entity.Mail))
        parameters.Add(New SqlParameter("@birthday", entity.Birthday))
        Return ExecuteNonQuery(insert)
    End Function

    Public Function Edit(entity As Employee) As Integer Implements IGenericRepository(Of Employee).Edit
        parameters = New List(Of SqlParameter)
        parameters.Add(New SqlParameter("@idPK", entity.IdPk))
        parameters.Add(New SqlParameter("@idNumber", entity.IdNumber))
        parameters.Add(New SqlParameter("@name", entity.Name))
        parameters.Add(New SqlParameter("@mail", entity.Mail))
        parameters.Add(New SqlParameter("@birthday", entity.Birthday))
        Return ExecuteNonQuery(update)
    End Function



    Public Function Remove(idPk As Integer) As Integer Implements IGenericRepository(Of Employee).Remove
        parameters = New List(Of SqlParameter)
        parameters.Add(New SqlParameter("@idPK", idPk))
        Return ExecuteNonQuery(delete)
    End Function

    Public Function GetBySalary() As IEnumerable(Of Employee) Implements IEmployeeRepository.GetBySalary
        Throw New NotImplementedException()
    End Function

End Class
