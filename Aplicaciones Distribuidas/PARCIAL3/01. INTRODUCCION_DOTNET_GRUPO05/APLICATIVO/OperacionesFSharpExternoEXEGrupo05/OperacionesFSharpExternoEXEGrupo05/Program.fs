module OperacionesFSharpExternoEXE
open System

let multiplicacion a b = a*b
let division a b = 
    if b = 0.0 then 
        nan
    else 
        a/b

let multiplicar(num1: double, num2: double) = "Multiplicación = " + Convert.ToString(multiplicacion num1 num2)
let dividir(num1: double, num2: double) = "División = " + Convert.ToString(division num1 num2)