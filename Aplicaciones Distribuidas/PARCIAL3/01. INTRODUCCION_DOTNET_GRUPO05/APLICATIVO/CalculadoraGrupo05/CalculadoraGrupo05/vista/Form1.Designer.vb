<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()>
Partial Class Form1
    Inherits System.Windows.Forms.Form

    'Form overrides dispose to clean up the component list.
    <System.Diagnostics.DebuggerNonUserCode()>
    Protected Overrides Sub Dispose(ByVal disposing As Boolean)
        Try
            If disposing AndAlso components IsNot Nothing Then
                components.Dispose()
            End If
        Finally
            MyBase.Dispose(disposing)
        End Try
    End Sub

    'Required by the Windows Form Designer
    Private components As System.ComponentModel.IContainer

    'NOTE: The following procedure is required by the Windows Form Designer
    'It can be modified using the Windows Form Designer.  
    'Do not modify it using the code editor.
    <System.Diagnostics.DebuggerStepThrough()>
    Private Sub InitializeComponent()
        Dim resources As System.ComponentModel.ComponentResourceManager = New System.ComponentModel.ComponentResourceManager(GetType(Form1))
        Me.txtValor1 = New System.Windows.Forms.TextBox()
        Me.btnCalcular = New System.Windows.Forms.Button()
        Me.txtValor2 = New System.Windows.Forms.TextBox()
        Me.lblResultadoMultiplicacion = New System.Windows.Forms.Label()
        Me.lblResultadoDivision = New System.Windows.Forms.Label()
        Me.lblOperacionesFSharp = New System.Windows.Forms.Label()
        Me.pnlValoresEntrada = New System.Windows.Forms.Panel()
        Me.btnBorrar = New System.Windows.Forms.Button()
        Me.imgMonster = New System.Windows.Forms.PictureBox()
        Me.pnlOperacionesFSharpDLL = New System.Windows.Forms.Panel()
        Me.lblTituloFSharpDLL = New System.Windows.Forms.Label()
        Me.lblResultadoSumaFDLL = New System.Windows.Forms.Label()
        Me.lblResultadoRestaFDLL = New System.Windows.Forms.Label()
        Me.lblResultadoResta = New System.Windows.Forms.Label()
        Me.lblResultadoSuma = New System.Windows.Forms.Label()
        Me.lblOperacionesCSharp = New System.Windows.Forms.Label()
        Me.pnlOperacionesCSharp = New System.Windows.Forms.Panel()
        Me.pnlOperacionesFSharp = New System.Windows.Forms.Panel()
        Me.pnlOperacionesFSharpEXE = New System.Windows.Forms.Panel()
        Me.lblTituloFSharpEXE = New System.Windows.Forms.Label()
        Me.lblResultadoMultiplicacionEXE = New System.Windows.Forms.Label()
        Me.lblResultadoDivisionFEXE = New System.Windows.Forms.Label()
        Me.pnlValoresEntrada.SuspendLayout()
        CType(Me.imgMonster, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.pnlOperacionesFSharpDLL.SuspendLayout()
        Me.pnlOperacionesCSharp.SuspendLayout()
        Me.pnlOperacionesFSharp.SuspendLayout()
        Me.pnlOperacionesFSharpEXE.SuspendLayout()
        Me.SuspendLayout()
        '
        'txtValor1
        '
        Me.txtValor1.Location = New System.Drawing.Point(289, 16)
        Me.txtValor1.Name = "txtValor1"
        Me.txtValor1.PlaceholderText = "Ingrese el valor 1"
        Me.txtValor1.Size = New System.Drawing.Size(150, 23)
        Me.txtValor1.TabIndex = 0
        '
        'btnCalcular
        '
        Me.btnCalcular.Location = New System.Drawing.Point(289, 101)
        Me.btnCalcular.Name = "btnCalcular"
        Me.btnCalcular.Size = New System.Drawing.Size(150, 25)
        Me.btnCalcular.TabIndex = 1
        Me.btnCalcular.Text = "Calcular"
        Me.btnCalcular.UseVisualStyleBackColor = True
        '
        'txtValor2
        '
        Me.txtValor2.Location = New System.Drawing.Point(289, 61)
        Me.txtValor2.Name = "txtValor2"
        Me.txtValor2.PlaceholderText = "Ingrese el valor 2"
        Me.txtValor2.Size = New System.Drawing.Size(150, 23)
        Me.txtValor2.TabIndex = 3
        '
        'lblResultadoMultiplicacion
        '
        Me.lblResultadoMultiplicacion.AutoSize = True
        Me.lblResultadoMultiplicacion.Location = New System.Drawing.Point(6, 36)
        Me.lblResultadoMultiplicacion.Name = "lblResultadoMultiplicacion"
        Me.lblResultadoMultiplicacion.Size = New System.Drawing.Size(97, 15)
        Me.lblResultadoMultiplicacion.TabIndex = 6
        Me.lblResultadoMultiplicacion.Text = "Multiplicación = "
        '
        'lblResultadoDivision
        '
        Me.lblResultadoDivision.AutoSize = True
        Me.lblResultadoDivision.Location = New System.Drawing.Point(6, 65)
        Me.lblResultadoDivision.Name = "lblResultadoDivision"
        Me.lblResultadoDivision.Size = New System.Drawing.Size(63, 15)
        Me.lblResultadoDivision.TabIndex = 7
        Me.lblResultadoDivision.Text = "División = "
        '
        'lblOperacionesFSharp
        '
        Me.lblOperacionesFSharp.AutoSize = True
        Me.lblOperacionesFSharp.Font = New System.Drawing.Font("Segoe UI", 9.75!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point)
        Me.lblOperacionesFSharp.Location = New System.Drawing.Point(6, 11)
        Me.lblOperacionesFSharp.Name = "lblOperacionesFSharp"
        Me.lblOperacionesFSharp.Size = New System.Drawing.Size(143, 17)
        Me.lblOperacionesFSharp.TabIndex = 8
        Me.lblOperacionesFSharp.Text = "Operaciones desde F#"
        '
        'pnlValoresEntrada
        '
        Me.pnlValoresEntrada.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D
        Me.pnlValoresEntrada.Controls.Add(Me.btnBorrar)
        Me.pnlValoresEntrada.Controls.Add(Me.imgMonster)
        Me.pnlValoresEntrada.Controls.Add(Me.txtValor1)
        Me.pnlValoresEntrada.Controls.Add(Me.txtValor2)
        Me.pnlValoresEntrada.Controls.Add(Me.btnCalcular)
        Me.pnlValoresEntrada.Location = New System.Drawing.Point(12, 12)
        Me.pnlValoresEntrada.Name = "pnlValoresEntrada"
        Me.pnlValoresEntrada.Size = New System.Drawing.Size(470, 175)
        Me.pnlValoresEntrada.TabIndex = 10
        '
        'btnBorrar
        '
        Me.btnBorrar.Location = New System.Drawing.Point(289, 132)
        Me.btnBorrar.Name = "btnBorrar"
        Me.btnBorrar.Size = New System.Drawing.Size(150, 25)
        Me.btnBorrar.TabIndex = 5
        Me.btnBorrar.Text = "Borrar"
        Me.btnBorrar.UseVisualStyleBackColor = True
        '
        'imgMonster
        '
        Me.imgMonster.Image = CType(resources.GetObject("imgMonster.Image"), System.Drawing.Image)
        Me.imgMonster.Location = New System.Drawing.Point(3, 3)
        Me.imgMonster.Name = "imgMonster"
        Me.imgMonster.Size = New System.Drawing.Size(260, 165)
        Me.imgMonster.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage
        Me.imgMonster.TabIndex = 4
        Me.imgMonster.TabStop = False
        '
        'pnlOperacionesFSharpDLL
        '
        Me.pnlOperacionesFSharpDLL.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D
        Me.pnlOperacionesFSharpDLL.Controls.Add(Me.lblTituloFSharpDLL)
        Me.pnlOperacionesFSharpDLL.Controls.Add(Me.lblResultadoSumaFDLL)
        Me.pnlOperacionesFSharpDLL.Controls.Add(Me.lblResultadoRestaFDLL)
        Me.pnlOperacionesFSharpDLL.Location = New System.Drawing.Point(252, 204)
        Me.pnlOperacionesFSharpDLL.Name = "pnlOperacionesFSharpDLL"
        Me.pnlOperacionesFSharpDLL.Size = New System.Drawing.Size(230, 100)
        Me.pnlOperacionesFSharpDLL.TabIndex = 10
        '
        'lblTituloFSharpDLL
        '
        Me.lblTituloFSharpDLL.AutoSize = True
        Me.lblTituloFSharpDLL.Font = New System.Drawing.Font("Segoe UI", 9.75!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point)
        Me.lblTituloFSharpDLL.Location = New System.Drawing.Point(3, 9)
        Me.lblTituloFSharpDLL.Name = "lblTituloFSharpDLL"
        Me.lblTituloFSharpDLL.Size = New System.Drawing.Size(188, 17)
        Me.lblTituloFSharpDLL.TabIndex = 2
        Me.lblTituloFSharpDLL.Text = "Operaciones F# externo (.dll)"
        '
        'lblResultadoSumaFDLL
        '
        Me.lblResultadoSumaFDLL.AutoSize = True
        Me.lblResultadoSumaFDLL.Location = New System.Drawing.Point(3, 39)
        Me.lblResultadoSumaFDLL.Name = "lblResultadoSumaFDLL"
        Me.lblResultadoSumaFDLL.Size = New System.Drawing.Size(51, 15)
        Me.lblResultadoSumaFDLL.TabIndex = 4
        Me.lblResultadoSumaFDLL.Text = "Suma = "
        '
        'lblResultadoRestaFDLL
        '
        Me.lblResultadoRestaFDLL.AutoSize = True
        Me.lblResultadoRestaFDLL.Location = New System.Drawing.Point(3, 67)
        Me.lblResultadoRestaFDLL.Name = "lblResultadoRestaFDLL"
        Me.lblResultadoRestaFDLL.Size = New System.Drawing.Size(49, 15)
        Me.lblResultadoRestaFDLL.TabIndex = 5
        Me.lblResultadoRestaFDLL.Text = "Resta = "
        '
        'lblResultadoResta
        '
        Me.lblResultadoResta.AutoSize = True
        Me.lblResultadoResta.Location = New System.Drawing.Point(3, 67)
        Me.lblResultadoResta.Name = "lblResultadoResta"
        Me.lblResultadoResta.Size = New System.Drawing.Size(49, 15)
        Me.lblResultadoResta.TabIndex = 5
        Me.lblResultadoResta.Text = "Resta = "
        '
        'lblResultadoSuma
        '
        Me.lblResultadoSuma.AutoSize = True
        Me.lblResultadoSuma.Location = New System.Drawing.Point(3, 39)
        Me.lblResultadoSuma.Name = "lblResultadoSuma"
        Me.lblResultadoSuma.Size = New System.Drawing.Size(51, 15)
        Me.lblResultadoSuma.TabIndex = 4
        Me.lblResultadoSuma.Text = "Suma = "
        '
        'lblOperacionesCSharp
        '
        Me.lblOperacionesCSharp.AutoSize = True
        Me.lblOperacionesCSharp.Font = New System.Drawing.Font("Segoe UI", 9.75!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point)
        Me.lblOperacionesCSharp.Location = New System.Drawing.Point(3, 9)
        Me.lblOperacionesCSharp.Name = "lblOperacionesCSharp"
        Me.lblOperacionesCSharp.Size = New System.Drawing.Size(144, 17)
        Me.lblOperacionesCSharp.TabIndex = 2
        Me.lblOperacionesCSharp.Text = "Operaciones desde C#"
        '
        'pnlOperacionesCSharp
        '
        Me.pnlOperacionesCSharp.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D
        Me.pnlOperacionesCSharp.Controls.Add(Me.lblOperacionesCSharp)
        Me.pnlOperacionesCSharp.Controls.Add(Me.lblResultadoSuma)
        Me.pnlOperacionesCSharp.Controls.Add(Me.lblResultadoResta)
        Me.pnlOperacionesCSharp.Location = New System.Drawing.Point(12, 204)
        Me.pnlOperacionesCSharp.Name = "pnlOperacionesCSharp"
        Me.pnlOperacionesCSharp.Size = New System.Drawing.Size(230, 100)
        Me.pnlOperacionesCSharp.TabIndex = 9
        '
        'pnlOperacionesFSharp
        '
        Me.pnlOperacionesFSharp.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D
        Me.pnlOperacionesFSharp.Controls.Add(Me.lblOperacionesFSharp)
        Me.pnlOperacionesFSharp.Controls.Add(Me.lblResultadoMultiplicacion)
        Me.pnlOperacionesFSharp.Controls.Add(Me.lblResultadoDivision)
        Me.pnlOperacionesFSharp.Location = New System.Drawing.Point(12, 315)
        Me.pnlOperacionesFSharp.Name = "pnlOperacionesFSharp"
        Me.pnlOperacionesFSharp.Size = New System.Drawing.Size(230, 100)
        Me.pnlOperacionesFSharp.TabIndex = 10
        '
        'pnlOperacionesFSharpEXE
        '
        Me.pnlOperacionesFSharpEXE.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D
        Me.pnlOperacionesFSharpEXE.Controls.Add(Me.lblTituloFSharpEXE)
        Me.pnlOperacionesFSharpEXE.Controls.Add(Me.lblResultadoMultiplicacionEXE)
        Me.pnlOperacionesFSharpEXE.Controls.Add(Me.lblResultadoDivisionFEXE)
        Me.pnlOperacionesFSharpEXE.Location = New System.Drawing.Point(252, 315)
        Me.pnlOperacionesFSharpEXE.Name = "pnlOperacionesFSharpEXE"
        Me.pnlOperacionesFSharpEXE.Size = New System.Drawing.Size(230, 100)
        Me.pnlOperacionesFSharpEXE.TabIndex = 11
        '
        'lblTituloFSharpEXE
        '
        Me.lblTituloFSharpEXE.AutoSize = True
        Me.lblTituloFSharpEXE.Font = New System.Drawing.Font("Segoe UI", 9.75!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point)
        Me.lblTituloFSharpEXE.Location = New System.Drawing.Point(6, 11)
        Me.lblTituloFSharpEXE.Name = "lblTituloFSharpEXE"
        Me.lblTituloFSharpEXE.Size = New System.Drawing.Size(193, 17)
        Me.lblTituloFSharpEXE.TabIndex = 8
        Me.lblTituloFSharpEXE.Text = "Operaciones F# externo (.exe)"
        '
        'lblResultadoMultiplicacionEXE
        '
        Me.lblResultadoMultiplicacionEXE.AutoSize = True
        Me.lblResultadoMultiplicacionEXE.Location = New System.Drawing.Point(6, 36)
        Me.lblResultadoMultiplicacionEXE.Name = "lblResultadoMultiplicacionEXE"
        Me.lblResultadoMultiplicacionEXE.Size = New System.Drawing.Size(97, 15)
        Me.lblResultadoMultiplicacionEXE.TabIndex = 6
        Me.lblResultadoMultiplicacionEXE.Text = "Multiplicación = "
        '
        'lblResultadoDivisionFEXE
        '
        Me.lblResultadoDivisionFEXE.AutoSize = True
        Me.lblResultadoDivisionFEXE.Location = New System.Drawing.Point(6, 65)
        Me.lblResultadoDivisionFEXE.Name = "lblResultadoDivisionFEXE"
        Me.lblResultadoDivisionFEXE.Size = New System.Drawing.Size(63, 15)
        Me.lblResultadoDivisionFEXE.TabIndex = 7
        Me.lblResultadoDivisionFEXE.Text = "División = "
        '
        'Form1
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(7.0!, 15.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(494, 431)
        Me.Controls.Add(Me.pnlOperacionesFSharpEXE)
        Me.Controls.Add(Me.pnlOperacionesFSharp)
        Me.Controls.Add(Me.pnlOperacionesFSharpDLL)
        Me.Controls.Add(Me.pnlValoresEntrada)
        Me.Controls.Add(Me.pnlOperacionesCSharp)
        Me.Name = "Form1"
        Me.Text = "Form1"
        Me.pnlValoresEntrada.ResumeLayout(False)
        Me.pnlValoresEntrada.PerformLayout()
        CType(Me.imgMonster, System.ComponentModel.ISupportInitialize).EndInit()
        Me.pnlOperacionesFSharpDLL.ResumeLayout(False)
        Me.pnlOperacionesFSharpDLL.PerformLayout()
        Me.pnlOperacionesCSharp.ResumeLayout(False)
        Me.pnlOperacionesCSharp.PerformLayout()
        Me.pnlOperacionesFSharp.ResumeLayout(False)
        Me.pnlOperacionesFSharp.PerformLayout()
        Me.pnlOperacionesFSharpEXE.ResumeLayout(False)
        Me.pnlOperacionesFSharpEXE.PerformLayout()
        Me.ResumeLayout(False)

    End Sub

    Dim controlador As CalculadoraControlador

    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        controlador = New CalculadoraControlador(Me)
    End Sub


    Friend WithEvents txtValor1 As TextBox
    Friend WithEvents btnCalcular As Button
    Friend WithEvents txtValor2 As TextBox
    Friend WithEvents lblResultadoMultiplicacion As Label
    Friend WithEvents lblResultadoDivision As Label
    Friend WithEvents lblOperacionesFSharp As Label
    Friend WithEvents pnlValoresEntrada As Panel
    Friend WithEvents imgMonster As PictureBox
    Friend WithEvents pnlOperacionesFSharpDLL As Panel
    Friend WithEvents lblTituloFSharpDLL As Label
    Friend WithEvents lblResultadoSumaFDLL As Label
    Friend WithEvents lblResultadoRestaFDLL As Label
    Friend WithEvents lblResultadoResta As Label
    Friend WithEvents lblResultadoSuma As Label
    Friend WithEvents lblOperacionesCSharp As Label
    Friend WithEvents pnlOperacionesCSharp As Panel
    Friend WithEvents pnlOperacionesFSharp As Panel
    Friend WithEvents pnlOperacionesFSharpEXE As Panel
    Friend WithEvents lblTituloFSharpEXE As Label
    Friend WithEvents lblResultadoMultiplicacionEXE As Label
    Friend WithEvents lblResultadoDivisionFEXE As Label

    Private Sub txtValor1_KeyPress(sender As Object, e As KeyPressEventArgs) Handles txtValor1.KeyPress
        Dim value As Double
        If (Char.IsNumber(e.KeyChar) OrElse e.KeyChar = "."c OrElse Char.IsControl(e.KeyChar)) AndAlso
           Double.TryParse(txtValor1.Text & e.KeyChar, value) Then
            e.Handled = False
        Else
            e.Handled = True
        End If
    End Sub

    Private Sub txtValor2_KeyPress(sender As Object, e As KeyPressEventArgs) Handles txtValor2.KeyPress
        Dim value As Double
        If (Char.IsNumber(e.KeyChar) OrElse e.KeyChar = "."c OrElse Char.IsControl(e.KeyChar)) AndAlso
           Double.TryParse(txtValor2.Text & e.KeyChar, value) Then
            e.Handled = False
        Else
            e.Handled = True
        End If
    End Sub

    Friend WithEvents btnBorrar As Button
End Class
