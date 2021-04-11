#ifndef COLA_H
#define COLA_H

#define MAX 10

template <class T>
class Cola
{
private:
	T *espacioCola = new T[MAX];
	int frente;
	int final;
public:
	Cola();
	void InsertaCola(T);
	void EliminaCola(T*);
	int ColaLlena();
	int ColaVacia();
	T getDato();	
	void EliminarCola();
};

template <class T>
Cola<T>::Cola()
{
	frente = - 1;
	final = - 1;
}

template <class T>
void Cola<T>::InsertaCola(T Dato)
{
	espacioCola[++final] = Dato;
	if (final == 0)
		frente = 0;
}

template <class T>
void Cola<T>::EliminaCola(T* Dato)
{
	*Dato = espacioCola[frente];
	if (frente == final)
	{
		frente = - 1;
		final = - 1;
	}
	else {
		frente++;
	}
}

template <class T>
T Cola<T>::getDato() {
	T dato = espacioCola[frente];
	if (frente == final)
	{
		frente = -1;
		final = -1;
	}
	else {
		frente++;
	}
	return dato;
}

template <class T>
int Cola<T>::ColaLlena()
{
	if (final == MAX - 1) {
		return 1;
	}
	else {
		return 0;
	}
}

template <class T>
int Cola<T>::ColaVacia()
{
	if (frente == - 1) {
		return 1;
	}
	else {
		return 0;
	}
}

template <class T>
void Cola<T>::EliminarCola()
{
	frente = 0;
	final = 0;
	delete[] espacioCola;
}
#endif