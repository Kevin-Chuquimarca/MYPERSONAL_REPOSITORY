

#include "Datos.h"


template<class T>
Datos<T>::Datos(T val) {
	valor = val;
}
template<class T>
void Datos<T>::setValor(T val) {
	valor = val;
}
template<class T>
T Datos<T>::getValor() {
	return valor;
}
