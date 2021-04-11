#ifndef MATRIZDINAMICA_H_INCLUDED
#define MATRIZDINAMICA_H_INCLUDED

#include <stdio.h>
#include <stdlib.h>

class MatrizDinamica {
	private:
		int** mat;
		int dim;
	public:
		MatrizDinamica(int**, int);
		~MatrizDinamica();
		void ingreso();
		void imprimir();
		int** matriz();
		void encerar();
		int get_dim();
		int** get_mat();
};

#endif 

