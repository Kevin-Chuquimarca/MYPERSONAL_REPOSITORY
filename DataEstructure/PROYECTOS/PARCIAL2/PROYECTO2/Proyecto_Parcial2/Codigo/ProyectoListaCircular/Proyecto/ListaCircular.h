#ifndef LISTACIRCULAR_H
#define LISTACIRCULAR_H


#include "Nodo.h"
#include <iostream>

#include "Persona.h"

using namespace std;

template<class T>
class ListaCircular {
public:
	ListaCircular();
	~ListaCircular() {		}
	void insertarInicio(T);
	void insertarFinal(T);
	bool listaVacia();
	void imprimir();
	int tamanio();
	Nodo<T>* buscar(int);
	Nodo<T>* getPrimero();
	Nodo<T>* getUltimo();
private:
	Nodo<T>* primero;
	Nodo<T>* ultimo;
};

template <class T>
ListaCircular<T>::ListaCircular(){
	this->primero = new Nodo<T>;
	this->primero->setSiguiente(primero);
	this->ultimo = primero;
}

template <class T>
void ListaCircular<T>::insertarInicio(T dato){
	Nodo<T>* aux = new Nodo<T>();
 	aux->setDato(dato);
	aux->setSiguiente(primero);
	ultimo->setSiguiente(aux);
	primero = aux;
}

template <class T>
void ListaCircular<T>::insertarFinal(T dato){
	if(this->listaVacia()){
		this->insertarInicio(dato);
	}else{
		Nodo<T>* aux = primero;
		Nodo<T>* aux2 = new Nodo<T>();	
		while(aux!= ultimo){
			aux2 = aux;
			aux = aux->getSiguiente();
		}
		Nodo<T>* aux3 = new Nodo<T>(dato, aux);
		aux2->setSiguiente(aux3);	
	}
}
	
template <class T>
void ListaCircular<T>::imprimir(){
	Nodo<T>* aux = primero;
	int cont = 0;
	std::cout << "\nDatos de la lista\n";
 	while(aux!= ultimo)
 	{
		cont++;
		std::cout << cont << aux->getDato().toString() << std::endl;
 		aux = aux->getSiguiente();
	}
}

template <class T>
bool ListaCircular<T>::listaVacia(){
	if(primero->getSiguiente() == ultimo){
		return true;
	}else{
		return false;
	}
}

template <class T>
int ListaCircular<T>::tamanio() {
	Nodo<T>* aux = primero;
	int cont = 0;
	while (aux != ultimo)
	{
		cont++;
		aux = aux->getSiguiente();
	}
	return cont;
}

template <class T>
Nodo<T>* ListaCircular<T>::buscar(int pos) {
	int cont = 1;
	Nodo<T>* aux = new Nodo<T>;
	aux = primero;
	while (aux != ultimo && pos != cont) {
		aux = aux->getSiguiente();
		cont++;
	}
	return aux;
}

template <class T>
Nodo<T>* ListaCircular<T>::getPrimero() {
	return primero;
}

template <class T>
Nodo<T>* ListaCircular<T>::getUltimo() {
	return ultimo;
}

#endif
