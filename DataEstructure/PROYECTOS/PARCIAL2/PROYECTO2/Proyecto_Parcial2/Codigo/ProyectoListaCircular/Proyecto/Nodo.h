#ifndef NODO_H
#define NODO_H

#include <iostream>
using namespace std;
template <class T>
class Nodo{
public:
	Nodo();
	Nodo(T, Nodo*);
	~Nodo();
	void setDato(T);
	void setSiguiente(Nodo*);
	T getDato();
	Nodo* getSiguiente();
private:
	T dato;
	Nodo* siguiente;	
};

template<class T>
Nodo<T>::Nodo() {
	this->siguiente = NULL;
}

template<class T>
Nodo<T>::Nodo(T dato, Nodo* siguiente) {
	this->dato = dato;
	this->siguiente = siguiente;
}

template<class T>
Nodo<T>::~Nodo() {}

template<class T>
void Nodo<T>::setDato(T dato)
{ 
	this->dato = dato; 
}

template<class T>
void Nodo<T>::setSiguiente(Nodo* dato)
{ 
	this->siguiente = dato; 
}

template<class T>
T Nodo<T>::getDato() 
{ 
	return this->dato; 
}

template<class T>
Nodo<T>* Nodo<T>::getSiguiente() 
{ 
	return this->siguiente; 
}

#endif
