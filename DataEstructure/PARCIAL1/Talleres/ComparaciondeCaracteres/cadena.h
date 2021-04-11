#ifndef CADENA_H_INCLUDED
#define CADENA_H_INCLUDED

#include <conio.h>
#include <string.h>
#include <stdio.h>
char *ingresar(char cadena[]){
	char valor[10];
	int c=0;
	int i=0;
	printf("%s: ",cadena);
	while((c=getchar())!='\n'){
		if(c>='0'&& c<='9'){
			valor[i++]=c;
			printf("%c",c);
		}
	}
	return valor;
}


#endif // CADENA_H_INCLUDED
