/*************************************************************
* UNIVERSIDAD DE LAS FUERZAS ARMADAS ESPE                    *
* Programa principal para calcular el factorial de un numero *
* usando una funcion recursiva para imprimir                 *
* Autor: Kevin Chuquimarca                                   *
* Fecha: 22/12/2020                                          *
* Fecha de modificacion: 22/12/2020                          *
**************************************************************/

#include <iostream>
#include <stdio.h>

int factor(int);
int factor(int n) {
	if (n == 0) {		//caso base
		return 1;
	}
	return factor(n - 1) * n;		//caso recursivo
}

int main() {
	printf_s("%d", factor(5));
}

