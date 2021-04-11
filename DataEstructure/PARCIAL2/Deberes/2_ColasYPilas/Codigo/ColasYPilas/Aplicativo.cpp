/*****************************************************
* UNIVERSIDAD DE LAS FUERZAS ARMADAS ESPE            *
* Programa principal de los metodos de pilas y colas *
* Autor: Kevin Chuquimarca                           *
* Fecha: 25/01/2021                                  *
* Fecha de modificacion: 25/01/2021                  *
******************************************************/

#include "Cola.h"
#include "Pila.h"

#include <iostream>

int main()
{
	Cola<int>* cl = new Cola<int>;
	Pila<int>* pi = new Pila<int>;
	for (int i = 0; i < 10; i++) {
		cl->encolar(i);
		pi->apilar(i);
	}
	printf_s("cola: ");
	cl->imprimir();
	printf_s("\n");
	printf_s("pila: ");
	pi->imprimir();
	pi->desapilar();
	printf_s("\n");
	printf_s("pila: ");
	pi->imprimir();
	cl->desencolar();
	printf_s("\n");
	printf_s("cola: ");
	cl->imprimir();
	delete cl;
	delete pi;
}