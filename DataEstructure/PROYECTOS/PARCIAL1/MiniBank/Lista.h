#pragma once
#include"Cuenta.h"
#include "Nodo.h"

class Lista
{

public:
    Lista();
    void insertarInicio(Cuenta);
    void modificarNodo(string,float);
    Nodo* getNodo();
    void setNodo(Nodo*);
    bool listaVacia();
    void toString();
    int tamanio();
private:
    Nodo* nodo;
    

};

