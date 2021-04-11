#pragma once

#include <iostream>

template <class T>
class NodoAVL
{
private:
	NodoAVL<T>* HijoIzq;
	NodoAVL<T>* HijoDer;
	T dato;
	int FE;
public:
	NodoAVL();
	T getDato();
	void setDato(T);
	NodoAVL<T>* getHijoIzq();
	void setHijoIzq(NodoAVL<T>*);
	NodoAVL<T>* getHijoDer();
	void setHijoDer(NodoAVL<T>*);
	int getFE();
	void setFE(int);
};

template <class T>
NodoAVL<T>::NodoAVL()
{
	HijoIzq = NULL;
	HijoDer = NULL;
}

template <class T>
T NodoAVL<T>::getDato()
{
	return dato;
}

template <class T>
void NodoAVL<T>::setDato(T Dato)
{
	dato = Dato;
}

template <class T>
NodoAVL<T>* NodoAVL<T>::getHijoIzq() 
{
	return HijoIzq;
}

template <class T>
void NodoAVL<T>::setHijoIzq(NodoAVL<T>* hijoIzq) 
{
	this->HijoIzq = hijoIzq;
}

template <class T>
NodoAVL<T>* NodoAVL<T>::getHijoDer() {
	return HijoDer;
}

template <class T>
void NodoAVL<T>::setHijoDer(NodoAVL<T>* hijoDer) 
{
	this->HijoDer = hijoDer;
}

template <class T>
int NodoAVL<T>::getFE() 
{
	return FE;
}

template <class T>
void NodoAVL<T>::setFE(int FE) 
{
	this->FE = FE;
}