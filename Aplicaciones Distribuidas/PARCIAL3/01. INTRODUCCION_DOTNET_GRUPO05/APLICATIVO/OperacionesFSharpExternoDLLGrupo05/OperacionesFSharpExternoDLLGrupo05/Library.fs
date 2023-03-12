module OperacionesFSharpExternoDLL
open System

let suma a b = a + b
let resta a b = a - b

let sumar(num1: double, num2: double) = "Suma = " + Convert.ToString(suma num1 num2)
let restar(num1: double, num2: double) = "Resta = " + Convert.ToString(resta num1 num2)