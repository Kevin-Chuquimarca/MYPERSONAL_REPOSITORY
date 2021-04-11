#ifndef PILA_H
#define PILA_H
#include "Node.h"

#include <iostream>

template <class T>
class Pila  {
private:
    Node<T>* siguiente;
public:
    Pila();
    ~Pila();
    void apilar(T);
    T desapilar();
    int tamanio();
    bool esVacia();
    void imprimir();
};

template <class T>
Pila<T>::Pila()
{
	this-> siguiente = NULL;
}

template<class T>
void Pila<T>::apilar(T dato) {
    if (this->esVacia()) {
        this->siguiente = new Node<T>(dato, NULL);
    }
    else {
        Node<T>* aux = new Node<T>(dato, this->siguiente);
        this->siguiente = aux;
    }
}

template<class T>
bool Pila<T>::esVacia() {
    if (this->siguiente == NULL) {
        return true;
    }
    else {
        return false;
    }
}

template<class T>
void Pila<T>::imprimir() {
    Node<T>* aux = new Node<T>();
    aux = this->siguiente;
    while (aux != NULL) {
        std::cout << aux->getData() << "  ";
        aux = aux->getNext();
    }
}

template<class T>
T Pila<T>::desapilar(){
	 if (!esVacia()) {
        Node<T>* aux = this->siguiente->getNext();
        T d = this->siguiente->getData();
        delete this->siguiente;
        this->siguiente = aux; 
        return  d;		
    }
    else {
    	std::cout<<"Pila vacia"<<std::endl;
    	return 0;
    }
}

template<class T>
int Pila<T>::tamanio(){
	int cont = 0;
	Node<T>* aux = new Node<T>();
    aux = this->siguiente;
    while (aux != NULL) {
    	cont++;
        aux = aux->getNext();
    }
    return cont;
}
	
template <class T>
Pila<T>::~Pila(){
}

#endif
