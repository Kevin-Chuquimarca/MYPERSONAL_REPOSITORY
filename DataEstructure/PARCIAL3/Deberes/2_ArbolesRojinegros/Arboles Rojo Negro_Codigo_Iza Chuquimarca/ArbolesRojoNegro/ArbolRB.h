#pragma once
#include <iostream>
#include "Nodo.h"

template <class T>
class ArbolRB
{
private:
	Nodo<T>* raiz;
public:
	ArbolRB<T>();
    //llamadas directas
    void insertar(T);
    void eliminar(T);
    void inorden();
    void preorden();
    Nodo<T>* getRaiz();
    //procesos internos
	void rotacionIzq(Nodo<T>*);
    void rotacionDer(Nodo<T>*);
    void correccionInsertar(Nodo<T>*);
    void correccionEliminar(Nodo<T>*);
    void inordenInterno(Nodo<T>*);
    void preordenInterno(Nodo<T>*);
    Nodo<T>* valorMinNodo(Nodo<T>*);
    Nodo<T>* valorMaxNodo(Nodo<T>*);
    Nodo<T>* insertarInterno(Nodo<T>*,Nodo<T>*);
    Nodo<T>* eliminarInterno(Nodo<T>*,T);
    int getAlturaNegro(Nodo<T>*);
    void mostrarArbol(Nodo<T>*, int);
};

template <class T>
ArbolRB<T>::ArbolRB<T>()
{
    raiz = NULL;
}

template <class T>
Nodo<T>* ArbolRB<T>::getRaiz() {
    return this->raiz;
}

template <class T>
Nodo<T>* ArbolRB<T>::insertarInterno(Nodo<T>* raiz, Nodo<T>* ptr){
    if (raiz == NULL)
        return ptr;
    if (ptr->getDato() < raiz->getDato()) {
        raiz->setHijoIzq(insertarInterno(raiz->getHijoIzq(), ptr));
        raiz->getHijoIzq()->setPadre(raiz);
    }
    else if (ptr->getDato() >= raiz->getDato()) {
        raiz->setHijoDer(insertarInterno(raiz->getHijoDer(), ptr));
        raiz->getHijoDer()->setPadre(raiz);
    }

    return raiz;
}

template <class T>
void ArbolRB<T>::insertar(T elemento) {
    Nodo<T>* nodo = new Nodo<T>(elemento);
    raiz = insertarInterno(raiz, nodo);
    correccionInsertar(nodo);
}

template <class T>
void ArbolRB<T>::rotacionIzq(Nodo<T>* subRaiz) {
    Nodo<T>* nuevaSubRaiz = subRaiz->getHijoDer();
    subRaiz->setHijoDer(nuevaSubRaiz->getHijoIzq());
    if (subRaiz->getHijoDer() != NULL)
        subRaiz->getHijoDer()->setPadre(subRaiz);
    nuevaSubRaiz->setPadre(subRaiz->getPadre());
    if (subRaiz->getPadre() == NULL)
        raiz = nuevaSubRaiz;
    else if (subRaiz == subRaiz->getPadre()->getHijoIzq())
        subRaiz->getPadre()->setHijoIzq(nuevaSubRaiz);
    else
        subRaiz->getPadre()->setHijoDer(nuevaSubRaiz);
    nuevaSubRaiz->setHijoIzq(subRaiz);
    subRaiz->setPadre(nuevaSubRaiz);
}

template <class T>
void ArbolRB<T>::rotacionDer(Nodo<T>* subRaiz) {
    Nodo<T>* nuevaSubRaiz = subRaiz->getHijoIzq();
    subRaiz->setHijoIzq(nuevaSubRaiz->getHijoDer());
    if (subRaiz->getHijoIzq() != NULL)
        subRaiz->getHijoIzq()->setPadre(subRaiz);
    nuevaSubRaiz->setPadre(subRaiz->getPadre());
    if (subRaiz->getPadre() == NULL)
        raiz = nuevaSubRaiz;
    else if (subRaiz == subRaiz->getPadre()->getHijoIzq())
        subRaiz->getPadre()->setHijoIzq(nuevaSubRaiz);
    else
        subRaiz->getPadre()->setHijoDer(nuevaSubRaiz);
    nuevaSubRaiz->setHijoDer(subRaiz);
    subRaiz->setPadre(nuevaSubRaiz);
}

template <class T>
void ArbolRB<T>::correccionInsertar(Nodo<T>* subRaiz) {
    Nodo<T>* padre = NULL;
    Nodo<T>* abuelo = NULL;
    while (subRaiz != raiz && subRaiz->getColor() == 1 && subRaiz->getPadre()->getColor() == 1) {
        padre = subRaiz->getPadre();
        abuelo = padre->getPadre();
        if (padre == abuelo->getHijoIzq()) {
            Nodo<T>* tio = abuelo->getHijoDer();
            if (tio && tio->getColor() == 1) {
                tio->setColor(0);
                padre->setColor(0);
                abuelo->setColor(1);
                subRaiz = abuelo;
            }
            else {
                if (subRaiz == padre->getHijoDer()) {
                    rotacionIzq(padre);
                    subRaiz = padre;
                    padre = subRaiz->getPadre();
                }
                rotacionDer(abuelo);
                int aux = padre->getColor();
                padre->setColor(abuelo->getColor());
                abuelo->setColor(aux);
                subRaiz = padre;
            }
        }
        else {
            Nodo<T>* tio = abuelo->getHijoIzq();
            if (tio && tio->getColor() == 1) {
                tio->setColor(0);
                padre->setColor(0);
                abuelo->setColor(1);
                subRaiz = abuelo;
            }
            else {
                if (subRaiz == padre->getHijoIzq()) {
                    rotacionDer(padre);
                    subRaiz = padre;
                    padre = subRaiz->getPadre();
                }
                rotacionIzq(abuelo);
                int aux = padre->getColor();
                padre->setColor(abuelo->getColor());
                abuelo->setColor(aux);
                subRaiz = padre;
            }
        }
    }
    raiz->setColor(0);
}

template <class T>
void ArbolRB<T>::correccionEliminar(Nodo<T>* nodo) {
    if (nodo == NULL)
        return;

    if (nodo == raiz) {
        raiz = NULL;
        return;
    }
    if (nodo->getColor() == 1 || nodo->getHijoIzq()->getColor() == 1 || nodo->getHijoDer()->getColor() == 1) {
        Nodo<T>* hijo = nodo->getHijoIzq() != NULL ? nodo->getHijoIzq() : nodo->getHijoDer();

        if (nodo == nodo->getPadre()->getHijoIzq()) {
            nodo->getPadre()->setHijoIzq(hijo);
            if (hijo != NULL) {
                hijo->setPadre(nodo->getPadre());
                hijo->setColor(0);
                delete (nodo);
            }
        }
        else {
            nodo->getPadre()->setHijoDer(hijo);
            if (hijo != NULL) {
                hijo->setPadre(nodo->getPadre());
                hijo->setColor(0);
                delete (nodo);
            }
        }
    }
    else {
        Nodo<T>* hermano = NULL;
        Nodo<T>* padre = NULL;
        Nodo<T>* ptr = nodo;
        ptr->setColor(2);
        while (ptr != raiz && ptr->getColor() == 2) {
            padre = ptr->getPadre();
            if (ptr == padre->getHijoIzq()) {
                hermano = padre->getHijoDer();
                if (hermano->getColor() == 1) {
                    hermano->setColor(0);
                    padre->setColor(1);
                    rotacionIzq(padre);
                }
                else {
                    if (hermano->getHijoIzq()->getColor() == 0 && hermano->getHijoDer()->getColor() == 0) {
                        hermano->setColor(1);
                        if (padre->getColor() == 1)
                            padre->setColor(0);
                        else
                            padre->setColor(2);
                        ptr = padre;
                    }
                    else {
                        if (hermano->getHijoDer()->getColor() == 0) {
                            hermano->getHijoIzq()->setColor(0);
                            hermano->setColor(1);
                            rotacionDer(hermano);
                            hermano = padre->getHijoDer();
                        }
                        hermano->setColor(padre->getColor());
                        padre->setColor(0);
                        hermano->getHijoDer()->setColor(0);
                        rotacionIzq(padre);
                        break;
                    }
                }
            }
            else {
                hermano = padre->getHijoIzq();
                if (hermano->getColor() == 1) {
                    hermano->setColor(0);
                    padre->setColor(1);
                    rotacionDer(padre);
                }
                else {
                    if (hermano->getHijoIzq()->getColor() == 0 && hermano->getHijoDer()->getColor() == 0) {
                        hermano->setColor(1);
                        if (padre->getColor() == 1)
                            padre->setColor(0);
                        else
                            padre->setColor(2);
                        ptr = padre;
                    }
                    else {
                        if (hermano->getHijoIzq()->getColor() == 0) {
                            hermano->getHijoDer()->setColor(0);
                            hermano->setColor(1);
                            rotacionIzq(hermano);
                            hermano = padre->getHijoIzq();
                        }
                        hermano->setColor(padre->getColor());
                        padre->setColor(0);
                        hermano->getHijoIzq()->setColor(0);
                        rotacionDer(padre);
                        break;
                    }
                }
            }
        }
        if (nodo == nodo->getPadre()->getHijoIzq())
            nodo->getPadre()->setHijoIzq(NULL);
        else {
            nodo->getPadre()->setHijoDer(NULL);
            delete(nodo);
            raiz->setColor(0);
        }
    }
}

template <class T>
Nodo<T>* ArbolRB<T>::eliminarInterno(Nodo<T>* raiz, T elemento) {
    if (raiz == NULL)
        return raiz;

    if (elemento < raiz->getDato())
        return eliminarInterno(raiz->getHijoIzq(), elemento);

    if (elemento > raiz->getDato())
        return eliminarInterno(raiz->getHijoDer(), elemento);

    if (raiz->getHijoIzq() == NULL || raiz->getHijoDer() == NULL)
        return raiz;

    Nodo<T>* temporal = valorMinNodo(raiz->getHijoDer());
    raiz->setDato(temporal->getDato());
    return eliminarInterno(raiz->getHijoDer(), temporal->getDato());
}

template <class T>
void ArbolRB<T>::eliminar(T elemento) {
    Nodo<T>* nodo = eliminarInterno(raiz, elemento);
    correccionEliminar(nodo);
}

template <class T>
void ArbolRB<T>::inordenInterno(Nodo<T>* ptr) {
    if (ptr == NULL)
        return;

    inordenInterno(ptr->getHijoIzq());
    std::cout << ptr->getDato() << " " << ptr->getColor() << std::endl;
    inordenInterno(ptr->getHijoDer());
}

template <class T>
void ArbolRB<T>::inorden() {
    inordenInterno(raiz);
}

template <class T>
void ArbolRB<T>::preordenInterno(Nodo<T>* ptr) {
    if (ptr == NULL)
        return;
    std::cout << ptr->getDato() << " " << ptr->getColor() << std::endl;
    preordenInterno(ptr->getHijoIzq());
    preordenInterno(ptr->getHijoDer());
}

template <class T>
void ArbolRB<T>::preorden() {
    preordenInterno(raiz);
    std::cout << "-------" << std::endl;
}

template <class T>
Nodo<T>* ArbolRB<T>::valorMinNodo(Nodo<T>* nodo) {
    Nodo<T>* ptr = nodo;
    while (ptr->getHijoIzq() != NULL)
        ptr = ptr->getHijoIzq();
    return ptr;
}

template <class T>
Nodo<T>* ArbolRB<T>::valorMaxNodo(Nodo<T>* nodo) {
    Nodo<T>* ptr = nodo;
    while (ptr->getHijoDer() != NULL)
        ptr = ptr->getHijoDer();
    return ptr;
}

template <class T>
int ArbolRB<T>::getAlturaNegro(Nodo<T>* nodo) {
    int alturaNegro = 0;
    while (nodo != NULL) {
        if (nodo->getColor() == 0)
            alturaNegro++;
        nodo = nodo->getHijoIzq();
    }
    return alturaNegro;
}

template <class T>
void ArbolRB<T>::mostrarArbol(Nodo<T>* arbol, int contador) {
    if (arbol == NULL)
        return;
    else {
        mostrarArbol(arbol->getHijoDer(), contador + 1);
        for (int i = 0; i < contador; i++) {
            std::cout << "  ";
        }
        std::cout << arbol->getDato() << arbol->getColor() << std::endl;
        mostrarArbol(arbol->getHijoIzq(), contador + 1);
    }
}