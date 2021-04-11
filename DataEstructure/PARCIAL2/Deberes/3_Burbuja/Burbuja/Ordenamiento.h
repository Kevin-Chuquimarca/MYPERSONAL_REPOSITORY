#ifndef ORDENAMIENTO_H
#define ORDENAMIENTO_H

template <class T>
class Ordenamiento {
private:

public:
	virtual int* reservar(T* vector) = 0;
	virtual void encerar(T* vector) = 0;
	virtual void generar(T* vector) = 0;
	virtual void ordenar(T* vector) = 0;
	virtual void imprimir(T* vector) = 0;
	virtual void ordenarMejorado(T* vector) = 0;
};

#endif