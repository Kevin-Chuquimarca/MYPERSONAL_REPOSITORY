Imports System

Module Program
    Sub Main(args As String())
        Dim num1 As Double = 10.5
        Dim num2 = 1.3
        If ((num1 + num2) > 10) Then
            Console.WriteLine("La suma entre " & num1 & " y " & num2 & " Si es mayor a 10")
        Else
            Console.WriteLine("La suma entre " & num1 & " y " & num2 & " No es mayor a 10")
        End If
        Console.WriteLine(num1 + num2)
        Console.ReadKey()
    End Sub
End Module
