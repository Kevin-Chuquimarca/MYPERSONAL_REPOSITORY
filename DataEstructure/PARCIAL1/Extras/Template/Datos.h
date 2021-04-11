#ifndef Datos_H_INCLUDED
#define DATOS_H_INCLUDED

template<class T>
class Datos {
private:
	T valor;
public:
	Datos(T);
	void setValor(T val);
	T getValor();
};

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
#endif;