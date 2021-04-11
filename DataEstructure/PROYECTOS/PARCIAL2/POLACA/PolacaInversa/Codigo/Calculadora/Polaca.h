#pragma once

#include <cmath>
#include <math.h>
#include <string.h>
#include <string>
#include <stdlib.h> 
#include <iostream>
#include "Pila.h"
#include "ListaDoble.h"

class Polaca {
private:
	Pila <char> pila;
	Pila <float> pilaOpr;
	ListaDoble<char> listaOpr;
public:
	Polaca();
	~Polaca();
	void operadorPostfijo();
	void infAPos(char*, int, char);
	int oprInterna(char*, int, std::string, char*);
};

Polaca::Polaca() {

}


void Polaca::infAPos(char* cad, int tamanio, char aux) {
	for (int i = 0; i < tamanio; i++) {
		if (cad[i] == '(') {
			i += oprInterna(cad, i,"", NULL);
		}
		else if (cad[i + 1] == '(')
		{
			aux = cad[i];
			i += oprInterna(cad, i + 1,"", NULL);
			pila.apilar(aux);
			listaOpr.insertarFinal(aux);
		}
		else if (cad[i] != ')') {
			if (cad[i] != '+' && cad[i] != '-' && cad[i] != '*' && cad[i] != '/' && cad[i] != '^')
			{
				pila.apilar(cad[i]);
				listaOpr.insertarFinal(cad[i]);
			}
			else
			{
				pila.apilar(cad[i + 1]);
				pila.apilar(cad[i]);
				listaOpr.insertarFinal(cad[i + 1]);
				listaOpr.insertarFinal(cad[i]);
				i++;
			}
		}
	}
}

int Polaca::oprInterna(char* cad, int dim, std::string cadena, char* cadAux) {
	for (int j = dim; cad[j] != ')'; j++) {
		if (cad[j] != '(' && cad[j] != ')')
			cadena += cad[j];
	}
	dim = cadena.length();
	cadAux = new char[dim];
	for (int i = 0; i < dim; i++) {
		cadAux[i] = cadena[i];
	}
	infAPos(cadAux, dim, '\0');
	return dim + 1;
}

void Polaca::operadorPostfijo() {
	float aux1 = 0, aux2 = 0;
	for (int i = 0; i < listaOpr.tamanio(); i++) {
		if (isdigit(listaOpr.buscarNodoIzq(i)->getDato()) && listaOpr.buscarNodoIzq(i)->getDato() != '-') {
			char aux = listaOpr.buscarNodoIzq(i)->getDato();
			const char* num = new char(aux);
			pilaOpr.apilar(atof(num));
		}
		else {
			if (listaOpr.buscarNodoIzq(i)->getDato() == '+') {
				pilaOpr.apilar(pilaOpr.desapilar() + pilaOpr.desapilar());
			}
			else if (listaOpr.buscarNodoIzq(i)->getDato() == '-') {
				aux2 = pilaOpr.desapilar();
				aux1 = pilaOpr.desapilar();
				pilaOpr.apilar(aux1 - aux2);
			}
			else if (listaOpr.buscarNodoIzq(i)->getDato() == '*') {
				pilaOpr.apilar(pilaOpr.desapilar() * pilaOpr.desapilar());
			}
			else if (listaOpr.buscarNodoIzq(i)->getDato() == '/') {
				aux2 = pilaOpr.desapilar();
				aux1 = pilaOpr.desapilar();
				pilaOpr.apilar(aux1 / aux2);
			}
			else if (listaOpr.buscarNodoIzq(i)->getDato() == '^') {
				aux2 = pilaOpr.desapilar();
				aux1 = pilaOpr.desapilar();
				pilaOpr.apilar(pow(aux1, aux2));
			}
		}
	}
	if (pilaOpr.tamanio() != 1 || pilaOpr.esVacia()) {
		std::cout << "\nExpresion incorrecta!!" << std::endl;
	}
	else {
		std::cout << "Resultado = ";
		pilaOpr.imprimir();
	}
}

Polaca::~Polaca() {

}
