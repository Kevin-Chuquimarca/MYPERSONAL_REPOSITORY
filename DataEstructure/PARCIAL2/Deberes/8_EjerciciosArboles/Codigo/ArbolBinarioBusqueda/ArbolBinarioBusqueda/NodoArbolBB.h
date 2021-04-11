#include <iostream>

template <class T>
class NodoArbolBB
{
private:
	T dato;
	NodoArbolBB<T>* hijoIzq;
	NodoArbolBB<T>* hijoDer;
public:
	NodoArbolBB();
	T getDato();
	void setDato(T);
	NodoArbolBB<T>* getHijoIzq();
	void setHijoIzq(NodoArbolBB<T>*);
	NodoArbolBB<T>* getHijoDer();
	void setHijoDer(NodoArbolBB<T>*);
};

template <class T>
NodoArbolBB<T>::NodoArbolBB()
{
	hijoIzq = NULL;
	hijoDer = NULL;
}


template <class T>
T NodoArbolBB<T>::getDato()
{
	return dato;
}

template <class T>
void NodoArbolBB<T>::setDato(T dato) {
	this->dato = dato;
}

template <class T>
NodoArbolBB<T>* NodoArbolBB<T>::getHijoIzq() {
	return hijoIzq;
}

template <class T>
void NodoArbolBB<T>::setHijoIzq(NodoArbolBB<T>* hijoIzq) {
	this->hijoIzq = hijoIzq;
}

template <class T>
NodoArbolBB<T>* NodoArbolBB<T>::getHijoDer() {
	return hijoDer;
}

template <class T>
void NodoArbolBB<T>::setHijoDer(NodoArbolBB<T>* hijoDer) {
	this->hijoDer = hijoDer;
}