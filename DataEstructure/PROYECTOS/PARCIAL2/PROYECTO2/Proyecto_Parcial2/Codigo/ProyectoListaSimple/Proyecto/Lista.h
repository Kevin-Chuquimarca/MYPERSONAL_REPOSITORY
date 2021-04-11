#pragma once
#include "NodoLista.h"
#include <iostream>

template <class T>

class Lista
{
private:
	NodoLista<T>* primero;
public:
	Lista();
	NodoLista<T>* regresaPrimero();
	void imprimir();
	void insertaInicio(T);
	void insertaFinal(T);
	bool eliminaUnNodo(T);
	NodoLista<T>* buscar(int);
	int tamanio();
};

template <class T>
Lista<T>::Lista() {
	primero = NULL;
}

template <class T>
NodoLista<T>* Lista<T>::regresaPrimero() {
	return primero;
}

template <class T>
void Lista<T>::imprimir() {
	int cont = 0;
	NodoLista<T>* aux = new NodoLista<T>;
	aux = primero;
	std::cout << "\nDatos de la Lista\n\n";
	while (aux) {
		cont++;
		std::cout << cont << aux->getDato().toString() << std::endl;
		aux = aux->getSiguiente();
	}
}

template <class T>
void Lista<T>::insertaInicio(T dato) {
	NodoLista<T>* aux = new NodoLista<T>();
	aux->setDato(dato);
	aux->setSiguiente(primero);
	primero = aux;
}

template <class T>
void Lista<T>::insertaFinal(T dato) {
	NodoLista<T>* aux, * aux2;
	aux = new NodoLista<T>();
	aux->setDato(dato);
	if (primero) {
		aux2 = primero;
		while (aux2->getSiguiente())
			aux2 = aux2->getSiguiente();
		aux2->setSiguiente(aux);
	}
	else
		primero = aux;
}

template <class T>
bool Lista<T>::eliminaUnNodo(T dato) {
	NodoLista<T>* aux, * aux2;
	bool Resp = true;
	if (primero) {
		aux = primero;
		while ((aux->getSiguiente()) && (aux->getDato() != dato)) {
			aux2 = aux;
			aux = aux->getSiguiente();
		}
		if (aux->getDato != dato)
			Resp = 0;
		else {
			if (primero == aux)
				primero = aux->getSiguiente();
			else
				aux2->getSiguiente(aux->getSiguiente());				
			delete (aux);
		}
	}
	else {
		Resp = false;
	}
	return Resp;
}

template <class T>
NodoLista<T>* Lista<T>::buscar(int pos) {
	NodoLista<T>* aux = new NodoLista<T>;
	int cont = 1;
	aux = primero;
	while (aux && cont != pos) {
		aux = aux->getSiguiente();
		cont++;
	}
	return aux;
}

template <class T>
int Lista<T>::tamanio() {
	NodoLista<T>* aux = new NodoLista<T>;
	int cont = 0;
	aux = primero;
	while (aux) {
		cont++;
		aux = aux->getSiguiente();
	}
	return cont;
}
