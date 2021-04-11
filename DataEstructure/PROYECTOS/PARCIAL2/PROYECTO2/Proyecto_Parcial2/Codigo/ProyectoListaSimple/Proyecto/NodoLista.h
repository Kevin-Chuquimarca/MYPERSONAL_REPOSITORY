#pragma once
#include <iostream>

using namespace std;

template <class T>
class NodoLista
{
private:
	NodoLista<T>* siguiente;
	T dato;
public:
	NodoLista();
	T regresaInfo();
	NodoLista<T>* getSiguiente();
	T getDato();
	void setSiguiente(NodoLista<T>*);
	void setDato(T);
};

template <class T>
NodoLista<T>::NodoLista() {
	siguiente = NULL;
}

template <class T>
T NodoLista<T>::regresaInfo() {
	return dato;
}

template <class T>
NodoLista<T>* NodoLista<T>::getSiguiente() {
	return siguiente;
}

template <class T>
T NodoLista<T>::getDato() {
	return dato;
}

template <class T>
void NodoLista<T>::setSiguiente(NodoLista<T>* siguiente) {
	this->siguiente = siguiente;
}

template <class T>
void NodoLista<T>::setDato(T dato) {
	this->dato = dato;
}

