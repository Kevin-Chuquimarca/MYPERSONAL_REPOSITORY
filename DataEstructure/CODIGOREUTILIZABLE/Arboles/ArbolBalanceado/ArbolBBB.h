#pragma once

#include "NodoABBB.h"

template <class T>
class AVL
{
private:
	NodoAVL<T>* Raiz;
public:
	AVL();
	NodoAVL<T>* RegresaRaiz();
	NodoAVL<T>* Busca(NodoAVL<T>*, T);
	void InsertaBalanceado(T, NodoAVL<T>*, int*);
	NodoAVL<T>* RotacionCompuestaID(NodoAVL<T>*, NodoAVL<T>*);
	NodoAVL<T>* RotacionCompuestaDI(NodoAVL<T>*, NodoAVL<T>*);
	NodoAVL<T>* RotacionHI_HI(NodoAVL<T>*, NodoAVL<T>*);
	NodoAVL<T>* RotacionHD_HD(NodoAVL<T>*, NodoAVL<T>*);
	NodoAVL<T>* RestructuraI(NodoAVL<T>*, int*);
	NodoAVL<T>* RestructuraD(NodoAVL<T>*, int*);
	void EliminaBalanceado(NodoAVL<T>*, NodoAVL<T>*, int*, T);
	void Sustituye(NodoAVL<T>*, NodoAVL<T>*, int*);
	void Imprime(NodoAVL<T>*);
};

template <class T>
AVL<T>::AVL()
{
    Raiz = NULL;
}

template <class T>
NodoAVL<T>* AVL<T>::RegresaRaiz()
{
    return Raiz;
}

template <class T>
NodoAVL<T>* AVL<T>::Busca(NodoAVL<T>* Apunt, T Dato)
{
    if (Apunt != NULL)
        if (Apunt->getDato() == Dato)
            return Apunt;
        else
            if (Apunt->getDato() > Dato)
                return Busca(Apunt->getHijoIzq(), Dato);
            else
                return Busca(Apunt->getHijoDer(), Dato);
    else
        return NULL;
}



template <class T>
void AVL<T>::InsertaBalanceado(T Dato, NodoAVL<T> * Apunt, int* Band)
{
    NodoAVL<T>* ApAux1, * ApAux2;
    if (Apunt != NULL)
    {
        if (Dato < Apunt->getDato())
        {
            InsertaBalanceado(Dato, Apunt->getHijoIzq(), Band);
            Apunt->setHijoIzq(Raiz);
            if (0 < *Band) 
                switch (Apunt->getFE())
                {
                case 1: {
                    Apunt->setFE(0);
                    *Band = 0;
                    break;
                }
                case 0: {
                    Apunt->setFE(- 1);
                    break;
                }
                case - 1: {
                    ApAux1 = Apunt->getHijoIzq();
                    if (ApAux1->getFE() <= 0)
                        Apunt = RotacionHI_HI(Apunt, ApAux1);
                    else
                        Apunt = RotacionCompuestaID(Apunt, ApAux1);
                    Apunt->setFE(0);
                    *Band = 0;
                }
                }
        }
        else
            if (Dato > Apunt->getDato())
            {
                InsertaBalanceado(Dato, Apunt->getHijoDer(), Band);
                Apunt->setHijoDer(Raiz);
                if (0 < *Band)
                    switch (Apunt->getFE())
                    {
                    case - 1: {
                        Apunt->setFE(0);
                        *Band = 0;
                        break;
                    }
                    case 0: {
                               Apunt->setFE(1);
                               break;
                           }
                    case 1: {
                        ApAux1 = Apunt->getHijoDer();
                        if (ApAux1->getFE() >= 0)
                            Apunt = RotacionHD_HD(Apunt, ApAux1);
                        else
                            Apunt = RotacionCompuestaDI(Apunt, ApAux1);
                        Apunt->setFE(0);
                        *Band = 0;
                    }
                    }
            }
        Raiz = Apunt;
    }
    else
    {
        ApAux2 = new NodoAVL<T>();
        ApAux2->setDato(Dato);
        ApAux2->setFE(0);
        *Band = 1;
        Raiz = ApAux2;
    }
}

template <class T>
NodoAVL<T>* AVL<T>::RotacionHI_HI(NodoAVL<T> * Apunt, NodoAVL<T>* ApAux1)
{
    Apunt->setHijoIzq(ApAux1->getHijoDer());
    ApAux1->setHijoDer(Apunt);
    Apunt->setFE(0);
    return ApAux1;
}

template <class T>
NodoAVL<T>* AVL<T>::RotacionHD_HD(NodoAVL<T> * Apunt, NodoAVL<T>* ApAux1)
{
    Apunt->setHijoDer(ApAux1->getHijoIzq());
    ApAux1->setHijoIzq(Apunt);
    Apunt->setFE(0);
    return ApAux1;
}

template <class T>
NodoAVL<T>* AVL<T>::RotacionCompuestaID(NodoAVL<T> * Apunt, NodoAVL<T>* ApAux1)
{
    NodoAVL<T>* ApAux2;
    ApAux2 = ApAux1->getHijoDer();
    Apunt->setHijoIzq(ApAux2->getHijoDer());
    ApAux2->setHijoDer(Apunt);
    ApAux1->setHijoDer(ApAux2->getHijoIzq());
    ApAux2->setHijoIzq(ApAux1);
    if (ApAux2->getFE() == - 1)
        Apunt->setFE(1);
    else
        Apunt->setFE(0);
    if (ApAux2->getFE() == 1)
        ApAux1->setFE(- 1);
    else
        ApAux1->setFE(0);
    return ApAux2;
}

template <class T>
NodoAVL<T>* AVL<T>::RotacionCompuestaDI(NodoAVL<T> * Apunt, NodoAVL<T>* ApAux1)
{
    NodoAVL<T>* ApAux2;
    ApAux2 = ApAux1->getHijoIzq();
    Apunt->setHijoDer(ApAux2->getHijoIzq());
    ApAux2->setHijoIzq(Apunt);
    ApAux1->setHijoIzq(ApAux2->getHijoDer());
    ApAux2->setHijoDer(ApAux1);
    if (ApAux2->getFE() == 1)
        Apunt->setFE(- 1);
    else
        Apunt->setFE(0);
    if (ApAux2->getFE() == - 1)
        ApAux1->setFE(1);
    else
        ApAux1->setFE(0);
    return ApAux2;
}

template <class T>
void AVL<T>::Imprime(NodoAVL<T>* Apunt)
{
    if (Apunt != NULL)
    {
        Imprime(Apunt->getHijoIzq());
        std::cout << Apunt->getDato() << " ";
        Imprime(Apunt->getHijoDer());
    }
}

template <class T>
void AVL<T>::EliminaBalanceado(NodoAVL<T>* Apunt, NodoAVL<T>* ApAnt, int* Avisa, T Dato)
{
    NodoAVL<T>* ApAux;
    int Bandera;
    if (Apunt != NULL)
        if (Dato < Apunt->getDato())
        {
            if (*Avisa > 0)
                Bandera = 1;
            else
                if (*Avisa != 0)
                    Bandera = - 1;
            *Avisa = - 1;
            EliminaBalanceado(Apunt->getHijoIzq(), Apunt, Avisa, Dato);
            Apunt = RestructuraI(Apunt, Avisa);
            if (ApAnt != NULL)
                switch (Bandera)
                {
                case - 1: ApAnt->setHijoIzq(Apunt);
                    break;
                case 1: ApAnt->setHijoDer(Apunt);
                    break;
                default: break;
                }
            else
                Raiz = Apunt;
        }
        else
        {
            if (Dato > Apunt->getDato())
            {
                if (*Avisa < 0)
                    Bandera = - 1;
                else
                    if (*Avisa != 0)
                        Bandera = 1;
                *Avisa = 1;
                EliminaBalanceado(Apunt->getHijoDer(), Apunt, Avisa, Dato);
                Apunt = RestructuraD(Apunt, Avisa);
                if (ApAnt != NULL)
                    switch (Bandera)
                    {
                    case - 1: ApAnt->setHijoIzq(Apunt);
                        break;
                    case 1: ApAnt->setHijoDer(Apunt);
                        break;
                    default: break;
                    }
                else
                    Raiz = Apunt;
            }
            else
            {
                ApAux = Apunt;
                if (ApAux->getHijoDer() == NULL)
                {
                    Apunt = ApAux->getHijoIzq();
                    if (*Avisa != 0)
                        if (*Avisa < 0)
                            ApAnt->setHijoIzq(Apunt);
                        else
                            ApAnt->setHijoDer(Apunt);
                    else
                        if (Apunt == NULL)
                            Raiz = NULL;
                        else
                            Raiz = Apunt;
                    *Avisa = 1;
                }
                else
                    if (ApAux->getHijoIzq() == NULL)
                    {
                        Apunt = ApAux->getHijoDer();
                        if (*Avisa != 0)
                            if (*Avisa < 0)
                                ApAnt->setHijoIzq(Apunt);
                            else
                                ApAnt->setHijoDer(Apunt);
                        else
                            if (Apunt == NULL)
                                Raiz = NULL;
                            else
                                Raiz = Apunt;
                        *Avisa = 1;
                    }
                    else
                    {
                        Sustituye(ApAux->getHijoIzq(), ApAux, Avisa);
                        Apunt = RestructuraI(Apunt, Avisa);
                        if (ApAnt != NULL)
                            if (*Avisa <= 0)
                                ApAnt->setHijoIzq(Apunt);
                            else
                                ApAnt->setHijoDer(Apunt);
                        else
                            Raiz = Apunt;
                    }
            }
        }
    else
        std::cout << "\n\nEl dato a eliminar no se encuentra registrado.\n\n";
}

template <class T>
NodoAVL<T>* AVL<T>::RestructuraI(NodoAVL<T>* Nodo, int* Aviso)
{
    NodoAVL<T>* ApAux;
    if (*Aviso > 0)
    {
        switch (Nodo->getFE())
        {
        case -1: Nodo->setFE(0);
            break;
        case 0: Nodo->setFE(1);
            *Aviso = 0;
            break;
        case 1: ApAux = Nodo->getHijoDer();
            if (ApAux->getFE() >= 0) //Rotación HD-HD
            {
                Nodo->setHijoDer(ApAux->getHijoIzq());
                ApAux->setHijoIzq(Nodo);
                switch (ApAux->getFE())
                {
                case 0: Nodo->setFE(1);
                    ApAux->setFE(-1);
                    *Aviso = 0;
                    break;
                case 1: Nodo->setFE(0);
                    ApAux->setFE(0);
                    break;
                }
                Nodo = ApAux;
            }
            else //Rotación HD-HI
            {
                Nodo = RotacionCompuestaDI(Nodo, ApAux);
                Nodo->setFE(0);
            }
            break;
        }
    }
    return Nodo;
}

template <class T>
NodoAVL<T>* AVL<T>::RestructuraD(NodoAVL<T>* Nodo, int* Aviso)
{
    NodoAVL<T>* ApAux;
    if (*Aviso > 0)
    {
        switch (Nodo->getFE())
        {
        case 1: Nodo->setFE(0);
            break;
        case 0: Nodo->setFE(- 1);
            *Aviso = 0;
            break;
        case -1: ApAux = Nodo->getHijoIzq();
            if (ApAux->getFE() <= 0) //Rotación HI-HI
            {
                Nodo->setHijoIzq(ApAux->getHijoDer());
                ApAux->setHijoDer(Nodo);
                switch (ApAux->getFE())
                {
                case 0: Nodo->setFE(- 1);
                    ApAux->setFE(1);
                    *Aviso = 0;
                    break;
                case -1: Nodo->setFE(0);
                    ApAux->setFE(0);
                    break;
                }
                Nodo = ApAux;
            }
            else //Rotación HI-HD
            {
                Nodo = RotacionCompuestaID(Nodo, ApAux);
                Nodo->setFE(0);
            }
            break;
        }
    }
    return Nodo;
}

template <class T>
void AVL<T>::Sustituye(NodoAVL<T>* Nodo, NodoAVL<T>* ApAux, int* Avisa)
{
    if (Nodo->getHijoDer() != NULL)
    {
        Sustituye(Nodo->getHijoDer(), ApAux, Avisa);
        if (ApAux->getHijoIzq() == NULL)
            Nodo->setHijoDer(NULL);
        else
            Nodo->setHijoDer(ApAux->getHijoIzq());
        Nodo = RestructuraD(Nodo, Avisa);
    }
    else
    {
        ApAux->setDato(Nodo->getDato());
        Nodo = Nodo->getHijoIzq();
        *Avisa = 1;
    }
    ApAux->setHijoIzq(Nodo);
}

