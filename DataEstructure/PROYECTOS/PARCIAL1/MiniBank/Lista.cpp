#include "Lista.h"
#include "Nodo.h"
#include "Cuenta.h"

#include <iostream>
#include <string>

using namespace std;
 
Lista::Lista()
{
    this->nodo = NULL;
}

bool Lista::listaVacia()
{
    return (nodo == NULL)?true:false;
}

void Lista::toString() {

    Nodo* aux = this->nodo;
    Nodo* aux1 = new Nodo();

    //aux = this->nodo;
    if (listaVacia())
    {
        cout << "\n\n\n\tSIN DATOS....\n\n\t" ;
    }
    else
    {
        while (aux != NULL)
        {
            aux->cuenta.mostrarInformacion();
            aux = aux->getSiguiente();
        }
    }

    
    
}

int Lista::tamanio()
{
    int tamanio = 0;
    Nodo* aux = this->nodo;
    Nodo* aux_1 = new Nodo();
    //aux = this->lista;
    
    while (aux != NULL)
    {
        tamanio++;
        aux_1 = aux;
        aux = aux->getSiguiente();
    }

    return tamanio ;
}

void Lista::insertarInicio(Cuenta dato)
{
    if (this->listaVacia())
    {
        
        this->nodo = new Nodo(dato, NULL, NULL);
        //this->listaFinal = this->lista;
        
    }
    else
    {
    
        Nodo* aux = new Nodo(dato,nodo, NULL);
        this->nodo->setAnterior(aux);
        this->nodo = aux;
    }

}



void Lista::modificarNodo(string id,float saldo) {
    Nodo* aux = new Nodo();
    Cuenta auxCuenta;
    aux = this->nodo;

    while (aux != NULL)
    {

        if ( aux->getCuenta().getId() == id) {
            auxCuenta = aux->getCuenta();            
            auxCuenta.setSaldo(saldo);
            aux->setCuenta(auxCuenta);

        }

        aux = aux->getSiguiente();
    }

    
}

Nodo* Lista::getNodo() {
    return this->nodo;
}

void Lista::setNodo(Nodo *nodo) {
    this->nodo = nodo;
}


