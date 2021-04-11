#ifndef QUICKSHORT_H
#define QUICKSHORT_H

#include "ListaDoble.h"
#include "Persona.h"
#include "Nodo.h"

template <class T>
class QuickSort
{
private:
    int opcionOrdenamiento;
    int auxIzq;
    int auxDer;
    std::string pivote;
    std::string auxDato1;
    std::string auxDato2;
    Nodo<T>* aux1 = new Nodo<T>;
    Nodo<T>* aux2 = new Nodo<T>;
    T auxPersona;
public:
    void intercambiar(ListaDoble<T>* , int, int);
	void ordenar(ListaDoble<T>* , int, int);
    void ordenarPor();
    void setopcionOrd(int);
    void definirPivote(ListaDoble<T>*);
};

template <class T>
void QuickSort<T>::intercambiar(ListaDoble<T>* lista, int newIzq, int newDer) {
    auxIzq = newIzq;
    auxDer = newDer;
    definirPivote(lista);
    aux1 = lista->buscarNodoIzq(newIzq);
    aux2 = lista->buscarNodoDer(lista->tamanio() - newDer + 1);
    do {
        ordenarPor();
        while ((auxDato1 < pivote) && (auxDer <= newDer))
        {
            auxIzq++;
            if(aux1)
            aux1 = aux1->getSiguiente();
            ordenarPor();
        }
        while ((pivote < auxDato2) && (auxDer > newIzq))
        {
            auxDer--;
            if(aux2)
            aux2 = aux2->getAnterior();
            ordenarPor();
        }
        if (auxIzq <= auxDer)
        {
            auxPersona = aux1->getDato();
            aux1->setDato(aux2->getDato());
            aux2->setDato(auxPersona);
            if (aux1)
                aux1 = aux1->getSiguiente();
            if (aux2)
                aux2 = aux2->getAnterior();
            auxIzq++;
            auxDer--;
        }
    } while (auxIzq <= auxDer);
}

template <class T>
void QuickSort<T>::ordenar(ListaDoble<T>* lista , int izq, int der)
{
    intercambiar(lista, izq, der);
    if (izq < auxDer)
        ordenar(lista, izq, auxDer);
    if (auxIzq < der)
        ordenar(lista, auxIzq, der);
}

template <class T>
void QuickSort<T>::ordenarPor() 
{
    switch (opcionOrdenamiento)
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
void QuickSort<T>::definirPivote(ListaDoble<T>* lista) {
    switch (opcionOrdenamiento)
    {
    case 1:
        pivote = lista->buscarNodoIzq((auxIzq + auxDer) / 2)->getDato().getCedula();
        break;
    case 2:
        pivote = lista->buscarNodoIzq((auxIzq + auxDer) / 2)->getDato().getEdad();
        break;
    case 3:
        pivote = lista->buscarNodoIzq((auxIzq + auxDer) / 2)->getDato().getNombre();
        break;
    }
}

template <class T>
void QuickSort<T>::setopcionOrd(int newOption) {
    opcionOrdenamiento = newOption;
}

#endif 

