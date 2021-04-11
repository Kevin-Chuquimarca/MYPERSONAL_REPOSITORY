#include "IngresoDato.h"

int *IngresoDato::ingresar(string cadena) {
	int* valor = new int[10];
	int c = 0;
	int cont = 0;
	cout << cadena;
	while((c=_getch())!=13){
		if(c>=48 && c<=57){
			*(valor + cont) = c - 48;
			cout << valor[cont];
			cont++;
		}
	}
	return valor;
}