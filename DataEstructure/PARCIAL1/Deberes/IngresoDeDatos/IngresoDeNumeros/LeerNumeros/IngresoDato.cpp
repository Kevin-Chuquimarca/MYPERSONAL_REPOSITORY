#include "IngresoDato.h"

char *IngresoDato::ingresar(string cadena) {
	char valor[20] = {};
	int c=0;
	int i=0;
	cout << cadena;
	while((c=_getch())!=13){
		if(c>=48 && c<=57){
			valor[i++]=c;
			printf("%c", c);
		}
	}
	return valor;
}