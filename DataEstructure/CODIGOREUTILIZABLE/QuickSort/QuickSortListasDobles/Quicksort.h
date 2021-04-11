#ifndef QUICKSHORT_H
#define QUICKSHORT_H

#include "Vector.h"
#include "ListaDoble.h"
#include "Persona.h"
#include "Nodo.h"

template <class T, class U>
class QuickSort
{
private:
    int opcionOrdenamiento;
    int auxIzq;
    int auxDer;
    U pivote;
    U auxDato1;
    U auxDato2;
    Nodo<T>* aux = new Nodo<T>;
    Nodo<T>* aux2 = new Nodo<T>;
    Nodo<T>* aux3 = new Nodo<T>;
public:
    void intercambiar(ListaDoble<T>* , int, int);
	void ordenar(ListaDoble<T>* , int, int);
    void ordenarPor();
    void setopcionOrd(int);
    void definirPivote(ListaDoble<T>*);
};

template <class T, class U>
void QuickSort<T, U>::intercambiar(ListaDoble<T>* lista, int newIzq, int newDer) {
    auxIzq = newIzq;
    auxDer = newDer;
    definirPivote(lista);
    aux = lista->buscarNodoIzq(newIzq);
    aux2 = lista->buscarNodoDer(lista->tamanio() - newDer + 1);
    do {
        ordenarPor();
        while ((auxDato1 < pivote) && (auxDer <= newDer))
        {
            auxIzq++;
            if(aux)
            aux = aux->getSiguiente();
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
            aux3->setDato(aux->getDato());
            aux->setDato(aux2->getDato());
            aux2->setDato(aux3->getDato());
            if (aux)
                aux = aux->getSiguiente();
            if (aux2)
                aux2 = aux2->getAnterior();
            auxIzq++;
            auxDer--;
        }
    } while (auxIzq <= auxDer);
}

template <class T, class U>
void QuickSort<T, U>::ordenar(ListaDoble<T>* lista , int izq, int der)
{
    intercambiar(lista, izq, der);
    if (izq < auxDer)
        ordenar(lista, izq, auxDer);
    if (auxIzq < der)
        ordenar(lista, auxIzq, der);
}

template <class T, class U>
void QuickSort<T, U>::ordenarPor() 
{
    switch (opcionOrdenamiento)
    {
    case 1:
        auxDato1 = aux->getDato().getCedula();
        auxDato2 = aux2->getDato().getCedula();
        break;
    case 2:
        auxDato1 = aux->getDato().getEdad();
        auxDato2 = aux2->getDato().getEdad();
        break;
    case 3:
        auxDato1 = aux->getDato().getNombre();
        auxDato2 = aux2->getDato().getNombre();
        break;
    }
}

template <class T, class U>
void QuickSort<T, U>::definirPivote(ListaDoble<T>* lista) {
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

template <class T, class U>
void QuickSort<T, U>::setopcionOrd(int newOption) {
    opcionOrdenamiento = newOption;
}

#endif 

