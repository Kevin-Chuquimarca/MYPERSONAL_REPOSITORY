#include "NodoArbolBB.h"

template <class T>
class ArbolBB
{
private:
	NodoArbolBB<T>* raiz;
public:
	ArbolBB();
	NodoArbolBB<T>* getRaiz();
	void preorden(NodoArbolBB<T>*);
	void inorden(NodoArbolBB<T>*);
	void postorden(NodoArbolBB<T>*);
	NodoArbolBB<T>* busqueda(NodoArbolBB<T>*, T);
	void insertarNodo(NodoArbolBB<T>*, T);
	void eliminarNodo(NodoArbolBB<T>*, T);
	~ArbolBB();
	int getNivelDato(NodoArbolBB<T>*, T, int);
};

template <class T>
int ArbolBB<T>::getNivelDato(NodoArbolBB<T>* raiz, T dato, int cont) {
	if (raiz == NULL) {
		return cont;
	}
	else if (raiz->getDato() == dato) {
		return cont;
	}
	else if (dato < raiz->getDato()) {
		return getNivelDato(raiz->getHijoIzq(), dato, cont + 1);
	}
	else {
		return getNivelDato(raiz->getHijoDer(), dato, cont + 1);
	}
}

template <class T>
ArbolBB<T>::ArbolBB()
{
	raiz = NULL;
}


template <class T>
NodoArbolBB<T>* ArbolBB<T>::getRaiz()
{
	return raiz;
}

template <class T>
void ArbolBB<T>::preorden(NodoArbolBB<T>* aux)
{
	if (aux)
	{
		std::cout << aux->getDato() << " ";
		preorden(aux->getHijoIzq());
		preorden(aux->getHijoDer());
	}
}

template <class T>
void ArbolBB<T>::inorden(NodoArbolBB<T>* aux)
{
	if (aux)
	{
		inorden(aux->getHijoIzq());
		std::cout << aux->getDato() << " ";
		inorden(aux->getHijoDer());
	}
}


template <class T>
void ArbolBB<T>::postorden(NodoArbolBB<T>* aux) {
	if (aux)
	{
		postorden(aux->getHijoIzq());
		postorden(aux->getHijoDer());
		std::cout << aux->getDato() << " ";
	}
}


template <class T>
NodoArbolBB<T>* ArbolBB<T>::busqueda(NodoArbolBB<T>* aux, T dato)
{
	if (aux)
		if (dato < aux->getDato())
			return busqueda(aux->getHijoIzq(), dato);
		else
			if (dato > aux->getDato())
				return busqueda(aux->getHijoDer(), dato);
			else
				return aux;
	else
		return NULL;
}

template <class T>
void ArbolBB<T>::insertarNodo(NodoArbolBB<T>* aux, T dato)
{
	NodoArbolBB<T>* aux2;
	if (aux)
	{
		if (dato < aux->getDato())
		{
			insertarNodo(aux->getHijoIzq(), dato);
			aux->setHijoIzq(raiz);
		}
		else
			if (dato >= aux->getDato())
			{
				insertarNodo(aux->getHijoDer(), dato);
				aux->setHijoDer(raiz);
			}
		raiz = aux;
	}
	else
	{
		aux2 = new NodoArbolBB<T>();
		aux2->setDato(dato);
		raiz = aux2;
	}
}


template <class T>
void ArbolBB<T>::eliminarNodo(NodoArbolBB<T>* aux, T dato)
{
	if (aux)
		if (dato < aux->getDato())
		{
			eliminarNodo(aux->getHijoIzq(), dato);
			aux->setHijoIzq(raiz);
		}
		else
			if (dato > aux->getDato())
			{
				eliminarNodo(aux->getHijoDer(), dato);
				aux->setHijoDer(raiz);
			}
			else
			{
				NodoArbolBB<T>* aux1, * aux2, * aux3;
				aux3 = aux;
				if (!aux3->getHijoDer())
					if (!aux3->getHijoIzq())
						aux = NULL;
					else
						aux = aux3->getHijoIzq();
				else
					if (!aux3->getHijoIzq())
						aux = aux3->getHijoDer();
					else
					{
						aux1 = aux3->getHijoIzq();
						aux2 = aux3;
						while (aux1->getHijoDer())
						{
							aux2 = aux1;
							aux1 = aux1->getHijoDer();
						}
						aux3->setDato(aux1->getDato());
						if (aux3 == aux2)
							aux3->setHijoIzq(NULL);
						else
							if (!aux1->getHijoIzq())
								aux2->setHijoDer(NULL);
							else
								aux2->setHijoDer(aux1->getHijoIzq());
						aux3 = aux1;
					}
				delete(aux3);
			}
	raiz = aux;
}

template <class T>
ArbolBB<T>::~ArbolBB()
{
	delete raiz;
}

