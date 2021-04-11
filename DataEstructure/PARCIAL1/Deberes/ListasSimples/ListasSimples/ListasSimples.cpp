/****************************************************************
* UNIVERSIDAD DE LAS FUERZAS ARMADAS ESPE			   	        *
* Programa principal para registrar datos en una lista simple   *
* Autor: Kevin Chuquimarca									    *
* Fecha: 23/12/2020											    *
* Fecha de modificacion: 30/12/2020                             *
*****************************************************************/

#include <iostream>
#include "Nodo.h"

int main() {
  int op = 0, val = 0;
    Nodo nd;
    Nodo nd1;
    Nodo* lista;
    do {
        printf_s("ingrese un valor: ");
        scanf_s("%d", &val);
        nd.insertarInicio(val);
        nd1.insertarFinal(val);
        printf_s("\ndesea ingresar otro dato[si=1][no:0]: ");
        scanf_s("%d", &op);
    } while (op == 1);
	lista = nd.getLista();
    nd.imprimir();
    printf_s("\n\n");
    nd1.imprimir();
	free(lista);
}


