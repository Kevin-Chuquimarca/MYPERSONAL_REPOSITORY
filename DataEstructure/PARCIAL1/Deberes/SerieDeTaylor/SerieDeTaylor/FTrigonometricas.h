#ifndef FTRIGONOMETRICAS_H_INCLUDED
#define FTRIGONOMETRICAS_H_INCLUDED
#include "MemoriaDinamica.h"

class FTrigonometricas {
	private:
		MemoriaDinamica md;
		int* fact;
		int n;
		int pres;
		float rad;
	public:
		FTrigonometricas(int, int);
		void factorial();
		float get_taylor(int, int);
		float get_sen();
		float get_cos();
		float get_tan();
		void set_rad(float);
		~FTrigonometricas();
};

#endif 

