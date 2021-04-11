#ifndef NODO_H
#define NODO_H

#include <stdlib.h>
#include <iostream>

template <class T>
class Nodo
{
    public:
        Nodo();
        Nodo(T, Nodo<T>*);
        T getDato();
        Nodo<T>* getLista();
        void setDato(T);
        Nodo<T>* getSiguiente();
        void setSiguiente(Nodo<T>*);
        void insertarInicio(T);
        void insertarFinal(T);
        bool vacio();
        void imprimir();
    protected:

    private:
        T dato;
        Nodo<T> *siguiente;
};

template <class T>
T Nodo<T>::getDato()
{
    return dato;
}

template <class T>
Nodo<T>* Nodo<T>::getLista()
{
    return siguiente;
}

template <class T>
void Nodo<T>::setDato(T dato)
{
    this->dato = dato;
}

template <class T>
Nodo<T>* Nodo<T>::getSiguiente()
{
    return siguiente;
}

template <class T>
void Nodo<T>::setSiguiente(Nodo<T>* siguiente)
{
    this->siguiente = siguiente;
}

template <class T>
Nodo<T>::Nodo()
{
    this->dato;
    this->siguiente = NULL;
}

template <class T>
Nodo<T>::Nodo(T dato, Nodo<T>* siguiente)
{
    this->dato = dato;
    this->siguiente = siguiente;
}

template <class T>
bool Nodo<T>::vacio() {
    if (siguiente == NULL) {
        return true;
    }
    else {
        return false;
    }
}

template <class T>
void Nodo<T>::insertarInicio(T dato) {
    if (vacio()) {
        siguiente = new Nodo<T>(dato, NULL);
    }
    else {
        Nodo<T>* aux = new Nodo<T>();
        aux->setDato(dato);
        aux->setSiguiente(siguiente);
        siguiente = aux;
    }
}

template <class T>
void Nodo<T>::insertarFinal(T dato) {
    if (vacio()) {
        siguiente = new Nodo<T>(dato, NULL);
    }
    else {
        Nodo<T>* aux = new Nodo<T>();
        aux = siguiente;
        Nodo<T>* aux1 = new Nodo<T>();
        while (aux != NULL) {
            aux1 = aux;
            aux = aux->siguiente; //aux->siguiente
        }
        Nodo<T>* aux2 = new Nodo<T>(dato, NULL);
        aux1->setSiguiente(aux2);
    }
}

#include "Persona.h"

template <class T>
void Nodo<T>::imprimir() {
    Nodo<T> *actual = new Nodo<T>();
    Persona per;
    actual = siguiente;
    while (actual != NULL) {
        per = actual->dato;
        std::cout << per.getNombre() << std::endl;
        std::cout << per.getApellido() << std::endl;
        std::cout << per.getCedula() << std::endl;
        std::cout << per.getCorreo() << std::endl;
        actual = actual->siguiente;
    }
}


#endif 
