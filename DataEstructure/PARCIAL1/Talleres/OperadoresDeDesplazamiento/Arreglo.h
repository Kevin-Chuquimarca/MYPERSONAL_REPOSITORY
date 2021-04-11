/***********************************************************************
 * Module:  Arreglo.h
 * Author:  Justin
 * Modified: jueves, 17 de diciembre de 2020 9:43:33
 * Purpose: Declaration of the class Arreglo
 ***********************************************************************/

#if !defined(__Class_Diagram_2_Arreglo_h)
#define __Class_Diagram_2_Arreglo_h

#include <iostream>

using namespace std;

class Arreglo
{
public:
	int* getVectort(void);
	void setVectort(int[]);
	Arreglo();
	~Arreglo();
	friend ostream& operator <<(ostream &, Arreglo const &);

protected:
private:
	int vectort[10];


};

#endif