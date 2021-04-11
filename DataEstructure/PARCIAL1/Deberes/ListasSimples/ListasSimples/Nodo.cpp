#include <stdlib.h>
#include <iostream>
#include "Nodo.h"

using namespace std;

int Nodo::getDato(void)
{
   return dato;
}

Nodo* Nodo::getLista()
{
    return siguiente;
}

void Nodo::setDato(int dato)
{
   this->dato = dato;
}

Nodo Nodo::getSiguiente(void)
{
   return *siguiente;
}

void Nodo::setSiguiente(Nodo *siguiente)
{
   this->siguiente = siguiente;
}

Nodo::Nodo()
{
    this->dato = 0;
    this->siguiente = NULL;
}

Nodo::Nodo(int dato, Nodo *siguiente)
{
    this->dato = dato;
    this->siguiente = siguiente;
}

bool Nodo::vacio(void){
    if(siguiente==NULL){
        return true;
    }
    else{
        return false;
    }
}

void Nodo::insertarInicio(int dato){
    if(vacio()){
         siguiente=new Nodo(dato, NULL);
    }
    else{
        Nodo *aux = new Nodo();
        aux->setDato(dato);
        aux->setSiguiente(siguiente);
        siguiente=aux;
    }
}

void Nodo::insertarFinal(int dato){
    if (vacio()) {
        siguiente = new Nodo(dato, NULL);
    }
    else {
        Nodo* aux = new Nodo();
        aux=siguiente;
        Nodo* aux1 = new Nodo();
        while (aux != NULL) {
            aux1 = aux;
            aux = aux->siguiente;
        }
        Nodo* aux2 = new Nodo(dato, NULL);
        aux1->setSiguiente(aux2);
    }
}

void Nodo::imprimir() {
    Nodo *actual = new Nodo();
    actual = siguiente;
    while (actual != NULL) {
        printf_s("%d ", actual->dato);
        actual = actual->siguiente;
    }
}
