Imports DataAccess
Imports System.ComponentModel.DataAnnotations

Public Class EmployeeModel
    Private _IdPk As Integer
    Private _IdNumber As String
    Private _Name As String
    Private _Mail As String
    Private _Birthday As Date
    Private _Age As Integer
    Private _State As EntityState
    Private Repository As IEmployeeRepository
    Private listEmployeeViewModel As List(Of EmployeeModel)

#Region "PROPERTIES/VIEWMODELS/DATA ACCESS"
    Public Property IdPk As Integer
        Get
            Return _IdPk
        End Get
        Set(value As Integer)
            _IdPk = value
        End Set
    End Property

    <Required(ErrorMessage:="El campo IdNumber es requerido")>
    <RegularExpression("([0-9]+)", ErrorMessage:="El campo IdNumber solo acepta números")>
    <StringLength(10, MinimumLength:=10, ErrorMessage:="El campo IdNumber debe tener 10 digitos")>
    Public Property IdNumber As String
        Get
            Return _IdNumber
        End Get
        Set(value As String)
            _IdNumber = value
        End Set
    End Property

    <Required>
    <RegularExpression("^[a-zA-Z ]+$", ErrorMessage:="El campo Name solo acepta letras")>
    <StringLength(100, MinimumLength:=3, ErrorMessage:="El campo Name debe tener entre 3 y 50 caracteres")>
    Public Property Name As String
        Get
            Return _Name
        End Get
        Set(value As String)
            _Name = value
        End Set
    End Property

    Public Property Mail As String
        Get
            Return _Mail
        End Get
        Set(value As String)
            _Mail = value
        End Set
    End Property

    Public Property Birthday As Date
        Get
            Return _Birthday
        End Get
        Set(value As Date)
            _Birthday = value
        End Set
    End Property

    Public Property Age As Integer
        Get
            Return _Age
        End Get
        Private Set(value As Integer)
            _Age = value
        End Set
    End Property

    Public Property State As EntityState
        Private Get
            Return _State
        End Get
        Set(value As EntityState)
            _State = value
        End Set
    End Property
#End Region

    Public Sub New()
        Repository = New EmployeeRepository()
    End Sub
    Public Function SaveChanges() As String
        Dim message As String = Nothing
        Try
            Dim employeeDataModel As New Employee()
            employeeDataModel.IdPk = IdPk
            employeeDataModel.IdNumber = IdNumber
            employeeDataModel.Name = Name
            employeeDataModel.Mail = Mail
            employeeDataModel.Birthday = Birthday
            Select Case State
                Case EntityState.Added
                    Repository.Add(employeeDataModel)
                    message = "Registro agregado exitosamente"
                Case EntityState.Modified
                    Repository.Edit(employeeDataModel)
                    message = "Registro modificado exitosamente"
                Case EntityState.Deleted
                    Repository.Remove(IdPk)
                    message = "Registro eliminado exitosamente"
            End Select
        Catch ex As Exception
            Dim sqlEx As System.Data.SqlClient.SqlException = TryCast(ex, System.Data.SqlClient.SqlException)
            If sqlEx IsNot Nothing AndAlso sqlEx.Number = 2627 Then
                message = "El registro ya se encuentra en la base de datos"
            Else
                message = ex.ToString()
            End If
        End Try
        Return message
    End Function
    Public Function GetEmployees() As List(Of EmployeeModel)
        Dim listEmployeeDataModel = Repository.GetAll()
        ListEmployeeViewModel = New List(Of EmployeeModel)
        For Each item As Employee In listEmployeeDataModel
            Dim birthDate = item.Birthday
            listEmployeeViewModel.Add(New EmployeeModel With {
            .IdPk = item.IdPk,
            .IdNumber = item.IdNumber,
            .Name = item.Name,
            .Mail = item.Mail,
            .Birthday = item.Birthday,
            .Age = CalculateAge(birthDate)
        })
        Next
        Return listEmployeeViewModel
    End Function

    Public Function FindById(filter As String) As IEnumerable(Of EmployeeModel)
        Return listEmployeeViewModel.FindAll(Function(emp) emp.IdNumber.Contains(filter) OrElse emp.Name.IndexOf(filter, StringComparison.OrdinalIgnoreCase) >= 0)
    End Function
    Private Function CalculateAge(birthDate As Date) As Integer
        Dim dateNow = Date.Now
        Return dateNow.Year - birthDate.Year
    End Function


End Class
