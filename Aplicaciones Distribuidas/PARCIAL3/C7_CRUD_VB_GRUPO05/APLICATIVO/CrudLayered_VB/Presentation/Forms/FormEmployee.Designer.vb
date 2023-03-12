<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class FormEmployee
    Inherits System.Windows.Forms.Form

    'Form reemplaza a Dispose para limpiar la lista de componentes.
    <System.Diagnostics.DebuggerNonUserCode()> _
    Protected Overrides Sub Dispose(ByVal disposing As Boolean)
        Try
            If disposing AndAlso components IsNot Nothing Then
                components.Dispose()
            End If
        Finally
            MyBase.Dispose(disposing)
        End Try
    End Sub

    'Requerido por el Diseñador de Windows Forms
    Private components As System.ComponentModel.IContainer

    'NOTA: el Diseñador de Windows Forms necesita el siguiente procedimiento
    'Se puede modificar usando el Diseñador de Windows Forms.  
    'No lo modifique con el editor de código.
    <System.Diagnostics.DebuggerStepThrough()> _
    Private Sub InitializeComponent()
        tableEmployee = New DataGridView()
        Panel1 = New Panel()
        Label4 = New Label()
        Label3 = New Label()
        Label2 = New Label()
        Label1 = New Label()
        dtpBirthday = New DateTimePicker()
        txtEmail = New TextBox()
        txtName = New TextBox()
        txtIdentificationCard = New TextBox()
        btnSave = New Button()
        txtBuscar = New TextBox()
        btnDelete = New Button()
        btnEdit = New Button()
        btnAdd = New Button()
        Button1 = New Button()
        CType(tableEmployee, ComponentModel.ISupportInitialize).BeginInit()
        Panel1.SuspendLayout()
        SuspendLayout()
        ' 
        ' tableEmployee
        ' 
        tableEmployee.ColumnHeadersHeightSizeMode = DataGridViewColumnHeadersHeightSizeMode.AutoSize
        tableEmployee.Location = New Point(12, 53)
        tableEmployee.Name = "tableEmployee"
        tableEmployee.RowTemplate.Height = 25
        tableEmployee.Size = New Size(598, 341)
        tableEmployee.TabIndex = 0
        ' 
        ' Panel1
        ' 
        Panel1.Controls.Add(Button1)
        Panel1.Controls.Add(Label4)
        Panel1.Controls.Add(Label3)
        Panel1.Controls.Add(Label2)
        Panel1.Controls.Add(Label1)
        Panel1.Controls.Add(dtpBirthday)
        Panel1.Controls.Add(txtEmail)
        Panel1.Controls.Add(txtName)
        Panel1.Controls.Add(txtIdentificationCard)
        Panel1.Controls.Add(btnSave)
        Panel1.Location = New Point(623, 12)
        Panel1.Name = "Panel1"
        Panel1.Size = New Size(228, 382)
        Panel1.TabIndex = 1
        ' 
        ' Label4
        ' 
        Label4.AutoSize = True
        Label4.Location = New Point(18, 205)
        Label4.Name = "Label4"
        Label4.Size = New Size(117, 15)
        Label4.TabIndex = 14
        Label4.Text = "Fecha de nacimiento"' 
        ' Label3
        ' 
        Label3.AutoSize = True
        Label3.Location = New Point(18, 142)
        Label3.Name = "Label3"
        Label3.Size = New Size(105, 15)
        Label3.TabIndex = 13
        Label3.Text = "Correo electrónico"' 
        ' Label2
        ' 
        Label2.AutoSize = True
        Label2.Location = New Point(18, 84)
        Label2.Name = "Label2"
        Label2.Size = New Size(51, 15)
        Label2.TabIndex = 12
        Label2.Text = "Nombre"' 
        ' Label1
        ' 
        Label1.AutoSize = True
        Label1.Location = New Point(18, 23)
        Label1.Name = "Label1"
        Label1.Size = New Size(142, 15)
        Label1.TabIndex = 11
        Label1.Text = "Número de Identificación"' 
        ' dtpBirthday
        ' 
        dtpBirthday.Location = New Point(18, 223)
        dtpBirthday.Name = "dtpBirthday"
        dtpBirthday.Size = New Size(200, 23)
        dtpBirthday.TabIndex = 10
        ' 
        ' txtEmail
        ' 
        txtEmail.Location = New Point(18, 160)
        txtEmail.Name = "txtEmail"
        txtEmail.Size = New Size(198, 23)
        txtEmail.TabIndex = 9
        ' 
        ' txtName
        ' 
        txtName.Location = New Point(18, 102)
        txtName.Name = "txtName"
        txtName.Size = New Size(198, 23)
        txtName.TabIndex = 8
        ' 
        ' txtIdentificationCard
        ' 
        txtIdentificationCard.Location = New Point(18, 41)
        txtIdentificationCard.Name = "txtIdentificationCard"
        txtIdentificationCard.Size = New Size(198, 23)
        txtIdentificationCard.TabIndex = 7
        ' 
        ' btnSave
        ' 
        btnSave.BackColor = Color.Blue
        btnSave.ForeColor = Color.White
        btnSave.Location = New Point(60, 263)
        btnSave.Name = "btnSave"
        btnSave.Size = New Size(110, 38)
        btnSave.TabIndex = 6
        btnSave.Text = "Guardar"
        btnSave.UseVisualStyleBackColor = False
        ' 
        ' txtBuscar
        ' 
        txtBuscar.Location = New Point(12, 12)
        txtBuscar.Name = "txtBuscar"
        txtBuscar.Size = New Size(596, 23)
        txtBuscar.TabIndex = 2
        ' 
        ' btnDelete
        ' 
        btnDelete.BackColor = Color.Red
        btnDelete.ForeColor = Color.White
        btnDelete.Location = New Point(268, 400)
        btnDelete.Name = "btnDelete"
        btnDelete.Size = New Size(110, 38)
        btnDelete.TabIndex = 3
        btnDelete.Text = "Eliminar"
        btnDelete.UseVisualStyleBackColor = False
        ' 
        ' btnEdit
        ' 
        btnEdit.BackColor = Color.FromArgb(CByte(0), CByte(0), CByte(192))
        btnEdit.ForeColor = Color.White
        btnEdit.Location = New Point(384, 400)
        btnEdit.Name = "btnEdit"
        btnEdit.Size = New Size(110, 38)
        btnEdit.TabIndex = 4
        btnEdit.Text = "Editar"
        btnEdit.UseVisualStyleBackColor = False
        ' 
        ' btnAdd
        ' 
        btnAdd.BackColor = Color.Green
        btnAdd.ForeColor = Color.White
        btnAdd.Location = New Point(500, 400)
        btnAdd.Name = "btnAdd"
        btnAdd.Size = New Size(110, 38)
        btnAdd.TabIndex = 5
        btnAdd.Text = "Nuevo"
        btnAdd.UseVisualStyleBackColor = False
        ' 
        ' Button1
        ' 
        Button1.BackColor = Color.Gray
        Button1.ForeColor = Color.White
        Button1.Location = New Point(60, 318)
        Button1.Name = "Button1"
        Button1.Size = New Size(110, 32)
        Button1.TabIndex = 15
        Button1.Text = "Cancelar"
        Button1.UseVisualStyleBackColor = False
        ' 
        ' FormEmployee
        ' 
        AutoScaleDimensions = New SizeF(7F, 15F)
        AutoScaleMode = AutoScaleMode.Font
        ClientSize = New Size(863, 450)
        Controls.Add(btnAdd)
        Controls.Add(btnEdit)
        Controls.Add(btnDelete)
        Controls.Add(txtBuscar)
        Controls.Add(Panel1)
        Controls.Add(tableEmployee)
        Name = "FormEmployee"
        Text = "FormEmployee"
        CType(tableEmployee, ComponentModel.ISupportInitialize).EndInit()
        Panel1.ResumeLayout(False)
        Panel1.PerformLayout()
        ResumeLayout(False)
        PerformLayout()
    End Sub

    Friend WithEvents tableEmployee As DataGridView
    Friend WithEvents Panel1 As Panel
    Friend WithEvents Label4 As Label
    Friend WithEvents Label3 As Label
    Friend WithEvents Label2 As Label
    Friend WithEvents Label1 As Label
    Friend WithEvents dtpBirthday As DateTimePicker
    Friend WithEvents txtEmail As TextBox
    Friend WithEvents txtName As TextBox
    Friend WithEvents txtIdentificationCard As TextBox
    Friend WithEvents btnSave As Button
    Friend WithEvents txtBuscar As TextBox
    Friend WithEvents btnDelete As Button
    Friend WithEvents btnEdit As Button
    Friend WithEvents btnAdd As Button
    Friend WithEvents Button1 As Button
End Class
