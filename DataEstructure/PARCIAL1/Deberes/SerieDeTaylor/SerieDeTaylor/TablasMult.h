#ifndef TABLASMULT_H_INCLUDED
#define TABLASMULT_H_INCLUDED
#include "MemoriaDinamica.h"

class TablasMult {
	private: 
		int *serie;
		int **tablas;
		int x;
		int y;
		MemoriaDinamica md;
	public:
		TablasMult(int, int);
		void get_tabla();
		void get_serie();
		void imprimir_tablas();
		~TablasMult();
};

#endif 
