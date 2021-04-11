/***********************************************************************
 * Module:  Arreglo.cpp
 * Author:  
 * Modified: jueves, 17 de diciembre de 2020 9:43:33
 * Purpose: Implementation of the class Arreglo
 ***********************************************************************/

#include "Arreglo.h"


int* Arreglo::getVectort(void)
{
	return vectort;
}

ostream& operator <<(ostream& out, Arreglo const& A) {

	for (int i : A.vectort) {
		if (i >= 0) {
			out << i << "  ";
		}
	}
	return out;
}

void Arreglo::setVectort(int *newVectort)
{
	//vectort = *newVectort;
	for (int i = 0; i < 10;i++ ) {
			vectort[i] = *(newVectort + i); \
	}
}


Arreglo::Arreglo()
{
}


Arreglo::~Arreglo()
{
	// TODO : implement
}