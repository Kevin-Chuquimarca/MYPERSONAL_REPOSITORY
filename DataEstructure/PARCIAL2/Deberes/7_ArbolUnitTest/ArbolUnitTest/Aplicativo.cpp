/**************************************************************
* UNIVERSIDAD DE LAS FUERZAS ARMADAS ESPE					  *
* Programa principal para imprimir los recorridos de un arbol *
* Autor: Kevin Chuquimarca									  *
* Fecha: 25/01/2021											  *
* Fecha de modificacion: 25/01/2021							  *
***************************************************************/

#include <iostream>
#include <stdlib.h>
#include <string.h>
#include <conio.h>
#include <stdio.h>
const char* preOrden = "GEAIBMCLDFKJH";
const char* inOrden = "IABEGLDCFMKHJ";
char* posOrden;

void post(const char*, const char*, char*, int);
void post(const char* pre, const char* in, char* pos, int n) {
	int izq;
	if (n != 0) {
		*(pos + (n - 1)) = *(pre + 0);
		izq = strchr(in, *(pre + 0)) - in;
		post(pre + 1, in, pos, izq);
		post(pre + 1 + izq, in + 1 + izq, pos + izq, n - 1 - izq);
	}
}
int main(int argc, char** argv) {
	int aux;
	aux = strlen(preOrden);
	posOrden = (char*)malloc(aux * sizeof(char));
	if (posOrden) {
		printf("Preorden %s\n", preOrden);
		printf("Inorden %s\n", inOrden);
		post(preOrden, inOrden, posOrden, aux);
		*(posOrden + aux) = '\0';
		printf("Postorden %s\n", posOrden);
	}
	else {
		fprintf(stderr, "Error sin memeoria ");
		return 1;
	}
	return 0;
}
