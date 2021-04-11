#include <iostream>

template <class T>
class NodoAB
{
private:
	T dato;
	NodoAB<T>* hijoIzq;
	NodoAB<T>* hijoDer;
public:
	NodoAB();
	T getDato();
	void setDato(T);
	NodoAB<T>* getHijoIzq();
	void setHijoIzq(NodoAB<T>*);
	NodoAB<T>* getHijoDer();
	void setHijoDer(NodoAB<T>*);
};

template <class T>
NodoAB<T>::NodoAB()
{
	hijoIzq = NULL;
	hijoDer = NULL;
}

template <class T>
T NodoAB<T>::getDato()
{
	return dato;
}

template <class T>
void NodoAB<T>::setDato(T dato)
{
	this->dato = dato;
}

template <class T>
NodoAB<T>* NodoAB<T>::getHijoIzq() {
	return hijoIzq;
}

template <class T>
void NodoAB<T>::setHijoIzq(NodoAB<T>* hijoIzq) {
	this->hijoIzq = hijoIzq;
}

template <class T>
NodoAB<T>* NodoAB<T>::getHijoDer() {
	return hijoDer;
}

template <class T>
void NodoAB<T>::setHijoDer(NodoAB<T>* hijoDer) {
	this->hijoDer = hijoDer;
}