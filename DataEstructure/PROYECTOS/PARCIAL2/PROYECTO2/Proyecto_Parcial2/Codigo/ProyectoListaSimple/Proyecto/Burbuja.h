#ifndef BURBUJA_H
#define BURBUJA_H

#include <iostream>

#include "Lista.h"
#include "Persona.h"
#include "IngresoDatos.h"


template <class T>
class Burbuja
{
private:
	std::string auxDato1;
	std::string auxDato2;
	NodoLista<T> *aux1 = new NodoLista<T>;
	NodoLista<T> *aux2 = new NodoLista<T>;
	int opcion;
public:
	void ordenar(Lista<T>*);
	void ordenarPor();
	void setOpcion(int);
};

template <class T>
void Burbuja<T>::ordenar(Lista<T>* lista)
{
	T persona{};
	int cont = lista->tamanio();
	aux1 = lista->regresaPrimero();
	for (int i = 0; i < cont; i++) {
		aux2 = lista->regresaPrimero();
		for (int j = 0; j < cont; j++) {
			ordenarPor();
			if (auxDato1 < auxDato2) {
				persona = aux1->getDato();
				aux1->setDato(aux2->getDato());
				aux2->setDato(persona);
			}
			aux2 = aux2->getSiguiente();
		}
		aux1 = aux1->getSiguiente();
	}
}

template <class T>
void Burbuja<T>::ordenarPor() {
	switch (opcion)
	{
	case 1:
		auxDato1 = aux1->getDato().getCedula();
		auxDato2 = aux2->getDato().getCedula();
		break;
	case 2:
		auxDato1 = aux1->getDato().getEdad();
		auxDato2 = aux2->getDato().getEdad();
		break;
	case 3:
		auxDato1 = aux1->getDato().getNombre();
		auxDato2 = aux2->getDato().getNombre();
		break;
	}
}

template <class T>
void Burbuja<T>::setOpcion(int opcion) {
	this->opcion = opcion;
}

#endif