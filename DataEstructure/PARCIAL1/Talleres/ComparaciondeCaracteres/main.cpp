/********************************************
* UNIVERSIDAD DE LAS FUERZAS ARMADAS ESPE   *
* Programa principal para comparar cadenas  *
* Autor: Kevin Chuquimarca                  *
* Fecha: 8/12/2020                          *
* Fecha de modificacion: 8/12/2020          *
*********************************************/

#include <iostream>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "cadena.h"
int main(int argc, char** argv) {
        int val;
	char valor[10];
	strcpy(valor,ingresar("Ingrese el valor entero positivo"));
	val=atoi(valor);
	printf("\nresultado %d",val);
	return 0;
}
