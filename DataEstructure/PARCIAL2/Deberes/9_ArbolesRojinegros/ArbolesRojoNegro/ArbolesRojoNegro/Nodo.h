#pragma once
#include <iostream>

template <class T>
class Nodo
{
private:
    T dato;
    Nodo<T>* padre;
    Nodo<T>* hijoIzq;
    Nodo<T>* hijoDer;
    int color; /*1 = ROJO, 0 = NEGRO, 2 = DOBLE NEGRO*/
public:
    Nodo<T>(T);
    T getDato();
    void setDato(T);
    Nodo<T>* getHijoIzq();
    void setHijoIzq(Nodo<T>*);
    Nodo<T>* getHijoDer();
    void setHijoDer(Nodo<T>*);
    Nodo<T>* getPadre();
    void setPadre(Nodo<T>*);
    int getColor();
    void setColor(int);
};

template <class T>
Nodo<T>::Nodo<T>(T elemento) {
    dato = elemento;
    hijoIzq = NULL;
    hijoDer = NULL;
    padre = NULL;
    color = 1;
}

template <class T>
T Nodo<T>::getDato() {
    return dato;
}

template <class T>
void Nodo<T>::setDato(T nuevoDato)
{
    this->dato = nuevoDato;
}

template <class T>
Nodo<T>* Nodo<T>::getHijoIzq()
{
    return hijoIzq;
}

template <class T>
void Nodo<T>::setHijoIzq(Nodo<T>* nuevoNodo)
{
    hijoIzq = nuevoNodo;
}

template <class T>
Nodo<T>* Nodo<T>::getHijoDer()
{
    return hijoDer;
}

template <class T>
void Nodo<T>::setHijoDer(Nodo<T>* nuevoNodo)
{
    hijoDer = nuevoNodo;
}

template <class T>
Nodo<T>* Nodo<T>::getPadre()
{
    return padre;
}

template <class T>
void Nodo<T>::setPadre(Nodo<T>* nuevoNodo)
{
    padre = nuevoNodo;
}

template <class T>
int Nodo<T>::getColor()
{
    return color;
}

template <class T>
void Nodo<T>::setColor(int nuevoColor)
{
    this->color = nuevoColor;
}