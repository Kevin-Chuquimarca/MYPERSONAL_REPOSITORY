#ifndef COLA_H
#define COLA_H
#include "Node.h"

#include <iostream>

template <class T>
class Cola  {
private:
    Node<T>* cabeza;
    Node<T>* cola;
public:
    Cola();
    ~Cola();
    void encolar(T);
    T desencolar();
    int tamanio();
    bool esVacia();
    void imprimir();
};

template <class T>
Cola<T>::Cola()
{
	this->cabeza = NULL;
	this->cola = NULL;
}

template<class T>
void Cola<T>::encolar(T dato) {
    if (this->esVacia()) {
        this->cabeza = new Node<T>(dato, NULL);
        this->cola = this->cabeza;
    }
    else {
        Node<T>* aux = new Node<T>(dato, NULL);
        this->cola->setSiguiente(aux);
        this->cola = aux;
    }
}

template<class T>
bool Cola<T>::esVacia() {
    if (this->cabeza == NULL && this->cola == NULL) {
        return true;
    }
    else {
        return false;
    }
}

template<class T>
void Cola<T>::imprimir() {
    Node<T>* aux = new Node<T>();
    aux = this->cabeza;
    while (aux != NULL) {
        std::cout << aux->getData() << "  ";
        aux = aux->getNext();
    }
}

template<class T>
T Cola<T>::desencolar(){
	 if (!esVacia()) {
        Node<T>* aux = this->cabeza->getNext();
        T d = this->cabeza->getData();
        delete this->cabeza;
        this->cabeza = aux; 
        return  d;		
    }
    else {
    	std::cout<<"Cola vacia"<<std::endl;
    	return 0;
    }
}

template<class T>
int Cola<T>::tamanio(){
	int cont = 0;
	Node<T>* aux = this->cabeza;
    while (aux != NULL) {
    	cont++;
        aux = aux->getNext();
    }
    return cont;
}

template <class T>
Cola<T>::~Cola(){}
#endif
