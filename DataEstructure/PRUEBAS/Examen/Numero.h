#ifndef NUMERO_H
#define NUMERO_H

#include "Lista.h"

class Numero
{
private:
	int num;
	Lista<int> lista;
	NodoLista<int>* nodo = new NodoLista<int>;
public:
	void guardar_nums();
	void set_num(int);
	void imprimir();
};

#endif