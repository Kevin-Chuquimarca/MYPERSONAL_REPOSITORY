Public Interface IEmployeeRepository
    Inherits IGenericRepository(Of Employee)
    ''Other Methods
    Function GetBySalary() As IEnumerable(Of Employee)
End Interface
