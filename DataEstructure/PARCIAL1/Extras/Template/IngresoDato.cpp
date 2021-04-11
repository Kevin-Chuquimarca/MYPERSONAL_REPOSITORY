#include "IngresoDato.h"

char *IngresoDato::ingresar(string cadena) {
	char valor[10];
	int c=0;
	int i=0;
	printf("%s : ",cadena);
	while((c=getchar())!='\n'){
		if(c>='0'&& c<='9'){
			valor[i++]=c;
			printf("%c",c);			
		}
	}
	return valor;
}