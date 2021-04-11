#ifndef LISTACIRCULARDOBLE_H
#define LISTACIRCULARDOBLE_H

#include <iostream>

#include "Persona.h"
#include "Nodo.h"

using namespace std;

template<class T>
class ListaCircularDoble
{
public:
    ListaCircularDoble();

    void insertar_inicio(T dato);
    void insertar_final(T dato);
    void insertar_entre(T dato, int posicion);
    Nodo<T>* get_nodo();
    Nodo<T>* get_nodo_final();
    int tamanio();
    bool lista_vacia();
    void imprimir();
    ~ListaCircularDoble();

protected:
private:
    Nodo<T>* primero;
    Nodo<T>* ultimo;
};

template<class T>
ListaCircularDoble<T>::ListaCircularDoble() {
    this->primero = NULL;
    this->ultimo = NULL;
}

template<class T>
void ListaCircularDoble<T>::insertar_inicio(T dato) {
    if (this->lista_vacia()) {
        this->primero = new Nodo<T>(dato, this->ultimo, this->ultimo);
        this->ultimo = this->primero;
    }
    else {
        Nodo<T>* aux = new Nodo<T>(dato, primero, this->ultimo);
        this->primero->set_anterior(aux);
        this->ultimo->set_suguiente(aux);
        this->primero = aux;
    }
}

template<class T>
void ListaCircularDoble<T>::insertar_final(T dato) {

    if (lista_vacia()) {
        this->primero = new Nodo<T>(dato, this->ultimo, this->ultimo);
        this->ultimo = this->primero;
    }
    else {
        Nodo<T>* aux = new Nodo<T>(dato, this->primero, this->ultimo);
        this->ultimo->set_suguiente(aux);
        this->primero->set_anterior(aux);
        this->ultimo = aux;
    }
}

template<class T>
void ListaCircularDoble<T>::insertar_entre(T dato, int position) {
    if (lista_vacia()) {
        this->primero = new Nodo<T>(dato, this->ultimo, this->ultimo);
        this->ultimo = this->primero;
    }
    else if (position <= 1 || this->tamanio() <= position) {
        if (position == 1) {
            this->insertar_inicio(dato);
        }
        else if (position == this->tamanio()) {
            this->insertar_final(dato);
        }
        else {
            cout << "Fuera de rango" << endl;
        }
        system("pause");
    }
    else {
        Nodo<T>* aux = this->primero;
        Nodo<T>* aux_1 = NULL;

        int _index_position = 0;
        while (aux != this->ultimo && _index_position != position)
        {
            aux_1 = aux;
            aux = aux->get_siguiente();
            _index_position++;
        }
        Nodo<T>* _back_node = aux_1->get_anterior();
        Nodo<T>* aux_2 = new Nodo<T>(dato, aux_1, _back_node);

        _back_node->set_suguiente(aux_2);
        aux_1->set_anterior(aux_2);
    }
}

template<class T>
int ListaCircularDoble<T>::tamanio() {
    Nodo<T>* aux = new Nodo<T>();
    Nodo<T>* aux_1 = new Nodo<T>();

    aux = this->primero;

    int _index_position = 0;
    while (aux != this->ultimo)
    {
        _index_position++;
        aux_1 = aux;
        aux = aux->get_siguiente();
    }

    return _index_position + 1;
}

template<class T>
Nodo<T>* ListaCircularDoble<T>::get_nodo() {
    return this->primero;
}

template<class T>
Nodo<T>* ListaCircularDoble<T>::get_nodo_final() {
    return this->ultimo;
}

template<class T>
bool ListaCircularDoble<T>::lista_vacia() {
    return (this->primero == NULL) ? true : false;
}

template<class T>
void ListaCircularDoble<T>::imprimir() {
    Nodo<T>* aux = this->primero;
    Persona per;
    while (aux != this->ultimo)
    {
        per = aux->get_dato();
        std::cout << "Nombre: " << per.getNombre() << std::endl;
        std::cout << "Apellido: " << per.getApellido() << std::endl;
        std::cout << "Cedula: " << per.getCedula() << std::endl << std::endl;
        aux = aux->get_siguiente();
    }
}

template<class T>
ListaCircularDoble<T>::~ListaCircularDoble() {}

#endif
