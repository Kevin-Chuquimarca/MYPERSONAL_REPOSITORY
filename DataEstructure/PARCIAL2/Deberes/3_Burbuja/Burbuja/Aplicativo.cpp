/***************************************************************
* UNIVERSIDAD DE LAS FUERZAS ARMADAS ESPE                      *
* Programa principal para ordenar numeros usando Burbuja	   *
* Autor: Kevin Chuquimarca                                     *
* Fecha: 28/01/2021                                            *
* Fecha de modificacion: 28/01/2021                            *
****************************************************************/

#include "Ordenamiento.h"
#include "Burbuja.h"

#include <iostream>

int main()
{
	int* vector = {};
	Ordenamiento<int> *br = new Burbuja<int>;
	vector = br->reservar(vector);
	br->encerar(vector);
	br->imprimir(vector);
	br->generar(vector);
	br->imprimir(vector);
	br->ordenar(vector);
	br->imprimir(vector);
	br->ordenarMejorado(vector);
	br->imprimir(vector);
	delete[]vector;
    return 0;
}

