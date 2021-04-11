#ifndef MDINAMICANEW_H_INCLUDED
#define MDINAMICANEW_H_INCLUDED
#include <stdio.h>
#include <stdlib.h>
#include <Windows.h>

class MDinamicaNew {
	private:
		int** mat;
		int dim;
	public:
		MDinamicaNew(int** mat, int dim);
		~MDinamicaNew();
		int** reservar_m();
		void imprimir();
		void encerar();
		int get_dim();
		int** get_mat();
		void set_mat(int**);
};

#endif