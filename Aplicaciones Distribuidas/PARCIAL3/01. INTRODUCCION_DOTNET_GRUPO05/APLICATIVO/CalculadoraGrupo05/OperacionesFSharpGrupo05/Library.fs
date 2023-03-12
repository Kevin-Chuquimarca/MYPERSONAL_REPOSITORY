module FuncionesFSharp
open System

let multiplicar (num1: double, num2: double) = "Multiplicación = " + Convert.ToString(num1 * num2)

let dividir (num1: double, num2: double) = "División = " + Convert.ToString(if num2 = 0.0 then nan else num1 / num2)