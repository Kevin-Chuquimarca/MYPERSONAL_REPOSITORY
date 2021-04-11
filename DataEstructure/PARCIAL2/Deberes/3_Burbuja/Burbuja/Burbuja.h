#ifndef BURBUJA_H
#define BURBUJA_H

#include <iostream>

#include "Ordenamiento.h"

template <class T>
class Burbuja: public Ordenamiento<T>
{
private:

public:
	T* reservar(T* vector);
	void encerar(T* vector);
	void generar(T* vector);
	void ordenar(T* vector);
	void imprimir(T* vector);
	void ordenarMejorado(T* vector);
};
template <class T>
T* Burbuja<T>::reservar(T* vector) {
	vector = new T[10];
	return vector;
}

template <class T>
void Burbuja<T>::encerar(T* vector)
{
	for (int i = 0; i < 10; i++)
		*(vector + i) = 0;
}

template <class T>
void Burbuja<T>::generar(T* vector)
{
	srand(time(NULL));
	for (int i = 0; i < 10; i++) {
		*(vector + i) = 1 + rand() % 10;
	}
}

template <class T>
void Burbuja<T>::ordenar(T* vector)
{
	int aux = 0, cont = 0;
	for (int i = 0; i < 10; i++)
		for (int j = 0; j < 10; j++) {
			if (*(vector + i) < *(vector + j)) {
				aux = vector[i];
				*(vector + i) = *(vector + j);
				*(vector + j) = aux;
			}
			cont++;
		}
	std::cout << "numero de comparaciones: " << cont << std::endl;
}

template <class T>
void Burbuja<T>::ordenarMejorado(T* vector)
{
	int aux = 0, cont = 0;
	for (int i = 0; i < 10; i++)
		for (int j = i + 1; j < 10; j++) {
			if (*(vector + i) > *(vector + j)) {
				aux = vector[i];
				*(vector + i) = *(vector + j);
				*(vector + j) = aux;
			}
			cont++;
		}
	std::cout << "numero de comparaciones: " << cont << std::endl;
}

template <class T>
void Burbuja<T>::imprimir(T* vector)
{
	std::cout << "{";
	for (int i = 0; i < 10; i++)
		std::cout << *(vector + i) << " ";
	std::cout << "}" << std::endl;
}

#endif