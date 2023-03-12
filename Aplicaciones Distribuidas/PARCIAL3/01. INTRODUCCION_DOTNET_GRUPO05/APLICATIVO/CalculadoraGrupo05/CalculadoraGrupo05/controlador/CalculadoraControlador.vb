Imports OperacionesCSharpGrupo05
'no es necesario importar proyectos F#

Public Class CalculadoraControlador
    Private form1 As Form1
    Public Sub New(ByVal form As Form1)
        form1 = form
        Dim btnCalcular As Button = form1.btnCalcular
        AddHandler btnCalcular.Click, AddressOf btnCalcular_Click
        Dim btnBorrar As Button = form1.btnBorrar
        AddHandler btnBorrar.Click, AddressOf btnBorrar_Click
    End Sub
    Private Sub btnCalcular_Click(sender As Object, e As EventArgs)
        Dim num1 As String = form1.txtValor1.Text
        Dim num2 As String = form1.txtValor2.Text
        Dim resultadoSuma As Label = form1.lblResultadoSuma
        Dim resultadoResta As Label = form1.lblResultadoResta
        Dim resultadoMultiplicacion As Label = form1.lblResultadoMultiplicacion
        Dim resultadoDivision As Label = form1.lblResultadoDivision
        Dim resultadoSumaDLL As Label = form1.lblResultadoSumaFDLL
        Dim resultadoRestaDLL As Label = form1.lblResultadoRestaFDLL
        Dim resultadoMultiplicacionDLL As Label = form1.lblResultadoMultiplicacionEXE
        Dim resultadoDivisionDLL As Label = form1.lblResultadoDivisionFEXE

        'operaciones con C#
        Dim obj As New ClaseCSharp()
        resultadoSuma.Text = obj.sumar(num1, num2)
        resultadoResta.Text = obj.restar(num1, num2)

        'operaciones con F#
        resultadoMultiplicacion.Text = FuncionesFSharp.multiplicar(num1, num2)
        resultadoDivision.Text = FuncionesFSharp.dividir(num1, num2)

        'operaciones con F# externo .dll (Class library)
        resultadoSumaDLL.Text = OperacionesFSharpExternoDLL.sumar(num1, num2)
        resultadoRestaDLL.Text = OperacionesFSharpExternoDLL.restar(num1, num2)

        'operaciones con F# externo .dll (Console application), VB 6 no soporta referencias a .exe
        resultadoMultiplicacionDLL.Text = OperacionesFSharpExternoEXE.multiplicar(num1, num2)
        resultadoDivisionDLL.Text = OperacionesFSharpExternoEXE.dividir(num1, num2)
    End Sub

    Private Sub btnBorrar_Click(sender As Object, e As EventArgs)
        form1.txtValor1.Text = ""
        form1.txtValor2.Text = ""
        form1.lblResultadoSuma.Text = "Suma = "
        form1.lblResultadoResta.Text = "Resta = "
        form1.lblResultadoMultiplicacion.Text = "Multiplicación = "
        form1.lblResultadoDivision.Text = "División = "
        form1.lblResultadoSumaFDLL.Text = "Suma = "
        form1.lblResultadoRestaFDLL.Text = "Resta = "
        form1.lblResultadoMultiplicacionEXE.Text = "Multiplicación = "
        form1.lblResultadoDivisionFEXE.Text = "División = "
    End Sub

End Class
