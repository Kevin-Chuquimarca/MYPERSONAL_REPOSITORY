Imports Domain
Public Class FormEmployee
    Dim employeeModel As New EmployeeModel()
    Private Sub FormEmployee_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        ListEmployee()
        Panel1.Enabled = False
    End Sub
    Private Sub ListEmployee()
        Try
            tableEmployee.DataSource = employeeModel.GetEmployees()
        Catch ex As Exception
            MessageBox.Show(ex.ToString())
        End Try
    End Sub

    Private Sub txtBuscar_TextChanged(sender As Object, e As EventArgs) Handles txtBuscar.TextChanged
        tableEmployee.DataSource = employeeModel.FindById(txtBuscar.Text)
    End Sub

    Private Sub btnAdd_Click(sender As Object, e As EventArgs) Handles btnAdd.Click
        Panel1.Enabled = True
        employeeModel.State = EntityState.Added
    End Sub

    Private Sub btnEdit_Click(sender As Object, e As EventArgs) Handles btnEdit.Click
        If tableEmployee.SelectedRows.Count > 0 Then
            Panel1.Enabled = True
            employeeModel.IdPk = tableEmployee.CurrentRow.Cells(0).Value
            employeeModel.State = EntityState.Modified
            txtIdentificationCard.Text = tableEmployee.CurrentRow.Cells(1).Value
            txtName.Text = tableEmployee.CurrentRow.Cells(2).Value
            txtEmail.Text = tableEmployee.CurrentRow.Cells(3).Value
            dtpBirthday.Text = tableEmployee.CurrentRow.Cells(4).Value
        Else
            MessageBox.Show("Seleccione un registro")
        End If
    End Sub

    Private Sub btnDelete_Click(sender As Object, e As EventArgs) Handles btnDelete.Click
        If tableEmployee.SelectedRows.Count > 0 Then
            Panel1.Enabled = True
            employeeModel.IdPk = tableEmployee.CurrentRow.Cells(0).Value
            employeeModel.State = EntityState.Deleted
            Dim result = employeeModel.SaveChanges()
            MessageBox.Show(result)
            ListEmployee()
        Else
            MessageBox.Show("Seleccione un registro")
        End If
    End Sub

    Private Sub btnSave_Click(sender As Object, e As EventArgs) Handles btnSave.Click
        employeeModel.IdNumber = txtIdentificationCard.Text
        employeeModel.Name = txtName.Text
        employeeModel.Mail = txtEmail.Text
        employeeModel.Birthday = dtpBirthday.Text
        Dim valid = New DataValidation(employeeModel).validate()
        If valid = True Then
            Dim result = employeeModel.SaveChanges()
            MessageBox.Show(result)
            ListEmployee()
            Restart()
        End If
    End Sub
    Private Sub Restart()
        Panel1.Enabled = False
        txtIdentificationCard.Clear()
        txtName.Clear()
        txtEmail.Clear()
    End Sub

    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click
        Restart()
    End Sub
End Class