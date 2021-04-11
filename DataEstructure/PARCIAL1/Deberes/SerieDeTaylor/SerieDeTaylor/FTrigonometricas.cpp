#include "FTrigonometricas.h"
#include <stdio.h>
#include <iostream>

FTrigonometricas::FTrigonometricas(int pres, int n) {
	this->pres = pres;
	this->n = n;
	this->rad = 0.0;
	fact = md.reservar_m(n);
	md.encerar(fact, n);
	factorial();
}

void FTrigonometricas::factorial() {
	int sum = 1;
	*(fact) = sum;
	for (int i = 0; i < n; i++) {
		sum *= (1 + i);
		*(fact + i + 1) = sum;
	}
}

float FTrigonometricas::get_taylor(int x, int y) {
	float pos = 0, neg = 0;
	for (int i = 0; i < pres; i++) {
		pos += pow(rad, x) / fact[x];
		neg += pow(rad, y) / fact[y];
		x += 4;
		y += 4;
	}
	return (pos - neg);
}

float FTrigonometricas::get_sen() {
	return get_taylor(1, 3);
}

float FTrigonometricas::get_cos() {
	return get_taylor(0, 2);
}

float FTrigonometricas::get_tan() {
	return (get_taylor(1, 3)/ get_taylor(0, 2));
}

void FTrigonometricas::set_rad(float rad) {
	this->rad = rad;
}

FTrigonometricas::~FTrigonometricas() {

}