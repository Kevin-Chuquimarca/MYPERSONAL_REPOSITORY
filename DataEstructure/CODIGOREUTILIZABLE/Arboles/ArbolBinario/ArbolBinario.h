#include "NodoAB.h"
#include <stack>

#include <conio.h>

template <class T>
class ArbolBinario
{
private:
	NodoAB<T>* raiz;
public:
	ArbolBinario();
	NodoAB<T>* getRaiz();
	T leerDato();
	void crearArbol(NodoAB<T>*);
	void preorden(NodoAB<T>*);
	void inorden(NodoAB<T>*);
	void postorden(NodoAB<T>*);
	void imprimirNodosIzq(NodoAB<T>*);
	int getNumeroNodos(NodoAB<T>*, int);
	int getAltura(NodoAB<T>*, int, int);
	int getNivelDato(NodoAB<T>*, T, int);
	void inordenNR(NodoAB<T>*);
	void preordenNR(NodoAB<T>*);
	void posordenNR(NodoAB<T>*);
	int evaluar(NodoAB<T>* n, char x);
	~ArbolBinario();
};

template <class T>
ArbolBinario<T>::ArbolBinario()
{
	raiz = NULL;
}

template <class T>
NodoAB<T>* ArbolBinario<T>::getRaiz()
{
	return raiz;
}

template <class T>
T ArbolBinario<T>::leerDato() {
	T dato{};
	std::cout << "\nIngrese la informacion a almacenar: ";
	std::cin >> dato;
	return dato;
}

template <class T>
void ArbolBinario<T>::crearArbol(NodoAB<T>* aux)
{
	aux = new NodoAB<T>;
	aux->setDato(leerDato());
	std::cout << "\n" << aux->getDato() << " Tiene hijo izquierdo(S / N) ?: ";
	if (_getche() == 's')
	{
		crearArbol(aux->getHijoIzq());
		aux->setHijoIzq(raiz);
	}
	std::cout << "\n" << aux->getDato() << " Tiene hijo derecho(S / N) ?: ";
	if (_getche() == 's')
	{
		crearArbol(aux->getHijoDer());
		aux->setHijoDer(raiz);
	}
	raiz = aux;
}

template <class T>
void ArbolBinario<T>::preorden(NodoAB<T>* aux)
{
	if (aux)
	{
		std::cout << aux->getDato() << " ";
		preorden(aux->getHijoIzq());
		preorden(aux->getHijoDer());
	}
}

template <class T>
void ArbolBinario<T>::inorden(NodoAB<T>* aux)
{
	if (aux)
	{
		inorden(aux->getHijoIzq());
		std::cout << aux->getDato() << " ";
		inorden(aux->getHijoDer());
	}
}

template <class T>
void ArbolBinario<T>::postorden(NodoAB<T>* aux)
{
	if (aux)
	{
		postorden(aux->getHijoIzq());
		postorden(aux->getHijoDer());
		std::cout << aux->getDato() << " ";
	}
}

template <class T>
void ArbolBinario<T>::imprimirNodosIzq(NodoAB<T>* aux)
{
	if (aux)
	{
		if (aux->getHijoIzq())
		{
			std::cout << aux->getHijoIzq()->getDato() << "  ";
			imprimirNodosIzq(aux->getHijoIzq());
		}
		imprimirNodosIzq(aux->getHijoDer());
	}
}

template <class T>
int ArbolBinario<T>::getNumeroNodos(NodoAB<T>* aux, int cont) {
	if (aux)
	{
		cont++;
		cont = getNumeroNodos(aux->getHijoIzq(), cont);
		cont = getNumeroNodos(aux->getHijoDer(), cont);
	}
	return cont;
}

template <class T>
int ArbolBinario<T>::getAltura(NodoAB<T>* aux, int cont, int cont2) {
	if (aux)
	{
		cont = getAltura(aux->getHijoIzq(), cont + 1, cont2);
		cont2 = getAltura(aux->getHijoDer(), cont2, cont2 + 1);
	}
	if (cont > cont2) {
		return cont;
	}
	return cont2;
}

template <class T>
int ArbolBinario<T>::getNivelDato(NodoAB<T>* raiz, T dato, int cont) {
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
void ArbolBinario<T>::inordenNR(NodoAB<T> *raiz) {
	std::stack <NodoAB<T>*> pila;
	NodoAB<T>* actual = raiz;
	NodoAB<T>* temp;
	while (actual != NULL) {
		pila.push(actual);
		actual = actual->getHijoIzq();
	}
	while (actual == NULL && pila.empty() != true) {
		temp = pila.top();
		std::cout << temp->getDato() << " ";
		pila.pop();
		actual = temp->getHijoDer();
		if (actual != NULL || pila.empty() != true) {
			while (actual != NULL) {
				pila.push(actual);
				actual = actual->getHijoIzq();
			}
		}
	}
}

template <class T>
void ArbolBinario<T>::preordenNR(NodoAB<T>* raiz) {		
	std::stack<NodoAB<T>*> pila;
	NodoAB<T>* actual = raiz;
	do
	{
		if (actual != NULL) {
			std::cout << actual->getDato() << " ";
			pila.push(actual);
			actual = actual->getHijoIzq();
		}
		else if (!pila.empty())
		{
			actual = pila.top();
			pila.pop();
			actual = actual->getHijoDer();
		}
	} while (!pila.empty() || actual != NULL);
}

template <class T>
void ArbolBinario<T>::posordenNR(NodoAB<T>* raiz) {		//preorden: R I D	posorden: I D R			inorden: I R D
	std::stack<NodoAB<T>*> pila;
	NodoAB<T>* aux = raiz;
	do {
		if (!pila.empty() && aux == NULL) {
			std::cout << pila.top()->getDato() << " ";
		}
		if (aux != NULL) {
			pila.push(aux);
			aux = aux->getHijoIzq();
		}
		else if (!pila.empty()) {
			aux = pila.top();
			pila.pop();
			aux = aux->getHijoDer();
		}
	} while (!pila.empty() || aux != NULL);
}

template <class T>
int ArbolBinario<T>::evaluar(NodoAB<T>* n, char x) {
	if (n)
	{
		x = n->getDato();
		switch (x) {
		case '+':
			return evaluar(n->getHijoIzq(), x) + evaluar(n->getHijoDer(), x);
			break;
		case '-':
			return evaluar(n->getHijoIzq(), x) - evaluar(n->getHijoDer(), x);
			break;
		case '*':
			return evaluar(n->getHijoIzq(), x) * evaluar(n->getHijoDer(), x);
			break;
		case '/':
			return evaluar(n->getHijoIzq(), x) / evaluar(n->getHijoDer(), x);
			break;
		default:
			return x;
		}
	}
}

template <class T>
ArbolBinario<T>::~ArbolBinario(){
	delete raiz;
}