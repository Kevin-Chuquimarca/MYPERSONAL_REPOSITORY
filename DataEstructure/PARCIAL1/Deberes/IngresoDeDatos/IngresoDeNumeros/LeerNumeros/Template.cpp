/**************************************************
* UNIVERSIDAD DE LAS FUERZAS ARMADAS ESPE 		  *
* Prorama principal para leer numeros por teclado *
* Autor Fernando Solis							  *
* Fecha de creación 19/12/2020					  *
* Fecha de modificación 20/12/2020     		      *
***************************************************/
#include <iostream>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "ingresoDato.h"

using namespace std;

int main(int argc, char** argv) {
	//int val;
	char valor[20];
	IngresoDato obj;
	strcpy_s(valor, obj.ingresar("Ingrese el valor entero positivo: "));
	//val = atoi(valor);
	return 0;
}