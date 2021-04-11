#ifndef INGRESODATO_H_INCLUDED
#define INGRESODATO_H_INCLUDED

#include<string>
#include<iostream>

using namespace std;

template<class T, class T1>
class IngresoDato {
public:
	T *ingresar(T1);
};

template<class T, class T1>
T* IngresoDato<T, T1>::ingresar(T1 cadena) {
	char valor[10] = {};
	int c = 0;
	int i = 0;
	cout<< cadena;
	while ((c = getchar()) != '\n') {
		if (c >= '0' && c <= '9') {
			valor[i++] = c;
			printf("%c", c);
		}
	}
	return valor;
}
#endif