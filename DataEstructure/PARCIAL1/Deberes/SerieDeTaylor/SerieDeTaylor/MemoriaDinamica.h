#ifndef MEMORIADINAMICA_H_INCLUDED
#define MEMORIADINAMICA_H_INCLUDED
#include <stdlib.h>

class MemoriaDinamica {
	public:
		int** reservar_m(int, int);
		int* reservar_m(int);
		void liberar_m(int**, int);
		void liberar_m(int*);
		void encerar(int**, int , int);
		void encerar(int*, int);
};

#endif 


