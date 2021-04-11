/******************************************
* UNIVERSIDAD DE LAS FUERZAS ARMADAS ESPE *
* Prorama principal para crear plantillas *
* Autor Fernando Solis					  *
* Fecha de creación 2/12/2020			  *
* Fecha de modificación 13/12/2020         *
******************************************/
#include <iostream>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "ingresoDato.h"
#include "Datos.h"

using namespace std;

int main(int argc, char** argv) {
	int val;
	char valor[10];
	IngresoDato obj;
	cout << "ingrese el valor: " << endl;
	strcpy_s(valor, obj.ingresar("Ingrese el valor entero positivo: "));
	val = atoi(valor);
	Datos<int> obj2(0);
	obj2.setValor(val);
	printf("\nresultado %d", obj2.getValor() * 2);
	return 0;
}