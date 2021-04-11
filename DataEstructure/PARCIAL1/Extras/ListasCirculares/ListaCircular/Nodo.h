#ifndef NODO_H
#define NODO_H

#include <iostream>
using namespace std;
template <class T>
class Nodo{
public:
	Nodo();
	Nodo(T d, Nodo* n);
	Nodo(T d, Nodo* n, Nodo* p);
	~Nodo();
	void set_dato(T d);
	void set_siguiente(Nodo* n);
	void set_anterior(Nodo* p);
	T get_dato();
	Nodo* get_siguiente();
	Nodo* get_anterior();
private:
	T dato;
	Nodo* siguiente;	
	Nodo* anterior;
};

template<class T>
Nodo<T>::Nodo() {this->siguiente = NULL;}

template<class T>
Nodo<T>::Nodo(T d, Nodo* n) {
	this->dato = d;
	this->siguiente = n;
}

template<class T>
Nodo<T>::Nodo(T d, Nodo* n, Nodo* p) {
	this->dato = d;
	this->siguiente = n;
	this->anterior = p;
}

template<class T>
Nodo<T>::~Nodo() {}

template<class T>
void Nodo<T>::set_dato(T d)
{ 
	this->dato = d; 
}

template<class T>
void Nodo<T>::set_siguiente(Nodo* n)
{ 
	this->siguiente = n; 
}

template<class T>
void Nodo<T>::set_anterior(Nodo* p)
{ 
	this->anterior = p; 
}

template<class T>
T Nodo<T>::get_dato() 
{ 
	return this->dato; 
}

template<class T>
Nodo<T>* Nodo<T>::get_siguiente() 
{ 
	return this->siguiente; 
}

template<class T>
Nodo<T>* Nodo<T>::get_anterior() 
{ 
	return this->anterior; 
}

#endif
