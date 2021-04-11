#ifndef OPERADORES_H_INCLUDED
#define OPERADORES_H_INCLUDED
#include <math.h>
#include <iostream>
using namespace std;

class Operadores {
public:
	int operator+(int[]);
	float operator+(float[]);
	int operator-(int[]);
	float operator-(float[]);
	float operator*(float[]);
	float operator*(int[]);
	float operator/(float[]);
	float operator/(int[]);
};


#endif