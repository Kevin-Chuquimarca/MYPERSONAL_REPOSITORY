#ifndef LISTA_H
#define LISTA_H

#include "NodoLista.h"
#include <iostream>

using namespace std;

template <class T>
class Lista {
	private:
		NodoLista<T>* primero;
	public:
		Lista();
		NodoLista<T>* regresaPrimero();
		void imprimeIterativo();
		void insertaInicio(T);
		void insertaFinal(T);
		int eliminaUnNodo(T);
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
void Lista<T>::imprimeIterativo() {
	NodoLista<T>* P = new NodoLista<T>;
	P = primero;
	while (P) {
		cout << "Informacion: " << P->getInfo() << endl;
		P = P->getSiguiente();
	}
	cout << "\n";
}

template <class T>
void Lista<T>::insertaInicio(T Dato) {
		NodoLista<T>* P = new NodoLista<T>();
		P->setInfo(Dato);
		P->setSiguiente(primero);
		primero = P;
}

template <class T>
void Lista<T>::insertaFinal(T Dato) {
	NodoLista<T>* P, * Ultimo;
	P = new NodoLista<T>();
	P->setInfo(Dato);
	if (primero) {
		Ultimo = primero;
		while (Ultimo->getSiguiente())
			Ultimo = Ultimo->getSiguiente();
		Ultimo->setSiguiente(P);					//Ultimo->getLiga() = P;
	} else
		primero = P;
}

template <class T>
int Lista<T>::eliminaUnNodo(T Ref) {
	NodoLista<T>* P, * Ant;
	int Resp = 1;
	if (primero) {
		P = primero;
		while ((P->getSiguiente()) && (P->getInfo() != Ref)) 	{
			Ant = P;
			P = P->getSiguiente();
		}
		if (P->getInfo != Ref)
			Resp = 0;
		else {
			if (primero == P)
				primero = P->getSiguiente();
			else
				Ant->getSiguiente(P->getSiguiente());				//Ant->getLiga() = P->getLiga();
			delete (P);
		}
	}
	else {
		Resp--;
	}
	return Resp;
}


#endif