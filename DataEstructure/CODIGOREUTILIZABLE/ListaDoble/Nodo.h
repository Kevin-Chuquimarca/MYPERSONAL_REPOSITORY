#ifndef NODO_H
#define NODO_H

template <class T>
class Nodo {
private:
	Nodo<T>* anterior;
	Nodo<T>* siguiente;
	T dato;
public:
	Nodo();
	T getDato();
	Nodo<T>* getAnterior();
	Nodo<T>* getSiguiente();
	void setDato(T);
	void setAnterior(Nodo<T>*);
	void setSiguiente(Nodo<T>*);
	~Nodo();
};

template <class T>
Nodo<T>::Nodo() {
	anterior = NULL;
	siguiente = NULL;
}

template <class T>
T Nodo<T>::getDato() {
	return dato;
}

template <class T>
Nodo<T>* Nodo<T>::getAnterior() {
	return anterior;
}

template <class T>
Nodo<T>* Nodo<T>::getSiguiente() {
	return siguiente;
}

template <class T>
void Nodo<T>::setDato(T dato) {
	this->dato = dato;
}

template <class T>
void Nodo<T>::setAnterior(Nodo<T>* anterior) {
	this->anterior = anterior;
}

template <class T>
void Nodo<T>::setSiguiente(Nodo<T>* siguiente) {
	this->siguiente = siguiente;
}

template <class T>
Nodo<T>::~Nodo() {
	delete anterior;
	delete siguiente;
}
#endif 


