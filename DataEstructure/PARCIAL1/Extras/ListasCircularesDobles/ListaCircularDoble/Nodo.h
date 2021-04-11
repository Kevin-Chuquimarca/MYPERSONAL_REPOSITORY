#ifndef NODO_H
#define NODO_H

#include <iostream>

using namespace std;

template<class T>
class Nodo
{
public:
    Nodo();
    Nodo(T _data, Nodo* _next, Nodo* _back);
    void set_dato(T _data);
    void set_suguiente(Nodo* _node);
    void set_anterior(Nodo* _node);
    T get_dato();
    Nodo* get_siguiente();
    Nodo* get_anterior();
    ~Nodo();
protected:
private:
    T dato;
    Nodo* siguiente;
    Nodo* anteriror;
};

template<class T>
Nodo<T>::Nodo() {
	this->siguiente = NULL;
	this->anteriror = NULL;
}

template<class T>
Nodo<T>::Nodo(T _data, Nodo* _next, Nodo* _back) {
	this->dato = _data;
	this->siguiente = _next;
	this->anteriror = _back;
}

template<class T>
void Nodo<T>::set_dato(T _data) {
	this->dato = _data;
}

template<class T>
void Nodo<T>::set_suguiente(Nodo* _node) {
	this->siguiente = _node;
}

template<class T>
void Nodo<T>::set_anterior(Nodo* _node) {
	this->anteriror = _node;
}

template<class T>
T Nodo<T>::get_dato() {
	return this->dato;
}

template<class T>
Nodo<T>* Nodo<T>::get_siguiente() {
	return this->siguiente;
}

template<class T>
Nodo<T>* Nodo<T>::get_anterior() {
	return this->anteriror;
}

template<class T>
Nodo<T>::~Nodo() {}

#endif
