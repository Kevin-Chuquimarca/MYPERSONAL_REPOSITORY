#ifndef LISTADOBLE_H
#define LISTADOBLE_H

#include "Nodo.h"

#include <iostream>

template <class T>
class ListaDoble
{
private:
	Nodo<T>* primero;
	Nodo<T>* ultimo;
public:
	ListaDoble();
	int tamanio();
	void imprimirLista();
	void imprimirNodo(Nodo<T>*);
	void insertarInicio(T);
	void insertarFinal(T);
	void insertarOrdenado(T);
	int insertarEntre(T, T);
	Nodo<T>* buscarNodoDer(int);
	Nodo<T>* buscarNodoIzq(int);
	Nodo<T>* getPrimero();
	void setPrimero(Nodo<T>*);
	Nodo<T>* getUltimo();
	void liberarLista();
	void cambiarDato(int, T);
};

template <class T>
void ListaDoble<T>::cambiarDato(int posicion, T dato) {
	int cont = 0;
	Nodo<T> *aux = new Nodo<T>;
	aux = ultimo;
	while (aux) {
		if(posicion == cont)
			aux->setDato(dato);
		aux = aux->getAnterior();
		cont++;
	}
}

template <class T>
int ListaDoble<T>::tamanio() {
	int cont = 0;
	Nodo<T>* aux = new Nodo<T>;
	aux = ultimo;
	while (aux) {
		cont++;
		aux = aux->getAnterior();
	}
	return cont;
}

template <class T>
void ListaDoble<T>::setPrimero(Nodo<T>* newPrimero) {
	primero = newPrimero;
}

template <class T>
ListaDoble<T>::ListaDoble() {
	primero = NULL;
	ultimo = NULL;
}

template <class T>
void ListaDoble<T>::imprimirLista() {
	int cont = 0;
	Nodo<T>* aux = new Nodo<T>;
	aux = primero;
	std::cout << "\nDatos de la lista\n";
	while (aux) {
		cont++;
		std::cout << std::endl << cont << aux->getDato().toString();
		aux = aux->getSiguiente();
	}
	std::cout << "\n";
}

template <class T>
void ListaDoble<T>::imprimirNodo(Nodo<T>* aux) {
	std::cout << aux->getDato << "\n";
}

template <class T>
void ListaDoble<T>::insertarInicio(T dato) {
	Nodo<T>* aux = new Nodo<T>();
	aux->setDato(dato);
	aux->setSiguiente(primero);
	if (primero) {
		primero->setAnterior(aux);
	}else {
		ultimo = aux;
	}
	primero = aux;
}

template <class T>
void ListaDoble<T>::insertarFinal(T dato) {
	Nodo<T>* aux;
	aux = new Nodo<T>;
	aux->setDato(dato);
	aux->setAnterior(ultimo);
	if (ultimo) {
		ultimo->setSiguiente(aux);
	}else {
		primero = aux;
	}
	ultimo = aux;
}

template <class T>
void ListaDoble<T>::insertarOrdenado(T dato) {
	Nodo<T>* aux1, * aux2, * aux3;
	if (!primero || dato < primero->getDato()) {
		insertarInicio(dato);
	} else {
		if (dato > ultimo->getDato()) {
			insertarFinal(dato);
		}else {
			aux1 = new Nodo<T>;
			aux1->getDato() = dato;
			aux2 = primero;
			while (aux2->getDato() < aux1->getDato()) {
				aux2 = aux2->getSiguiente();
				aux3 = aux2->getAnterior();
				aux3->setSiguiente(aux1);
				aux1->setSiguiente(aux2);
				aux1->setAnterior(aux3);
				aux2->setAnterior(aux1);
			}
		}
	}
}

template <class T>
int ListaDoble<T>::insertarEntre(T dato, T ref) {
	Nodo<T>* aux1, * aux2, * aux3;
	int Resp = 1;
	if (primero) {
		aux1 = primero;
		while ((aux1 != NULL) && (aux1->getDato() != ref))
			aux1 = aux1->getSiguiente();
		if (aux1 != NULL) {
			aux3 = new Nodo<T>();
			aux3->setDato(dato);
			aux3->setSiguiente(aux1);
			aux2 = aux1->getAnterior();
			aux1->setAnterior(aux3);
			aux3->setAnterior(aux2);
			if (primero == aux1) {
				primero = aux3;
			}else {
				aux2->setSiguiente(aux3);
			}
		} else {
			Resp = 0;
		}
	} else {
		Resp--;
	}
	return Resp;
}

template <class T>
Nodo<T>* ListaDoble<T>::buscarNodoDer(int dato) {
	int cont = 1;
	Nodo<T>* aux = new Nodo<T>;
	aux = ultimo;
	while (aux && dato != cont) {
		aux = aux->getAnterior();
		cont++;
	}
	return aux;
}

template <class T>
Nodo<T>* ListaDoble<T>::buscarNodoIzq(int dato) {
	int cont = 1;
	Nodo<T>* aux = new Nodo<T>;
	aux = primero;
	while (aux && dato != cont) {
		aux = aux->getSiguiente();
		cont++;
	}
	return aux;
}

template <class T>
Nodo<T>* ListaDoble<T>::getPrimero() {
return primero;
}

template <class T>
Nodo<T>* ListaDoble<T>::getUltimo()
{
	return ultimo;
}

template <class T>
void ListaDoble<T>::liberarLista() {
	Nodo<T>* aux1 = new Nodo<T>;
	Nodo<T>* aux2 = new Nodo<T>;
	aux1 = primero;
	while (aux1) {
		aux1 = aux1->getSiguiente();
		aux2 = aux1;
		delete aux2;
	}
	std::cout << "\n";
}

#endif