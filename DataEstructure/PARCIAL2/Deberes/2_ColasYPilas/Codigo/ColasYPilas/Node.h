#ifndef NODO_H
#define NODO_H

#include <iostream>

template <class T>
class Node{
private:
	T dato;
	Node* siguiente;
public:
	Node();
	Node(T, Node<T>*);
	~Node();
	void setDato(T);
	void setSiguiente(Node<T>*);
	T getData();
	Node* getNext();
};

template<class T>
Node<T>::Node() {
	this->siguiente = NULL;
}

template<class T>
Node<T>::Node(T dato, Node<T>* nodo) {
	this->dato = dato;
	this->siguiente = nodo;
}

template<class T>
void Node<T>::setDato(T dato) { 
	this->dato = dato; 
}

template<class T>
void Node<T>::setSiguiente(Node<T>* nodo) { 
	this->siguiente = nodo; 
}

template<class T>
T Node<T>::getData() { 
	return this->dato; 
}

template<class T>
Node<T>* Node<T>::getNext() { 
	return this->siguiente; 
}

template<class T>
Node<T>::~Node() {

}

#endif