#include "Operadores.h"

int Operadores::operator+(int vec[]) {
	int sum = 0;
	for (int i = 0; i < 3; i++) {
		sum += vec[i];
	}
	return sum;
}
float Operadores::operator+(float vec[]) {
	float sum = 0;
	for (int i = 0; i < 3; i++) {
		sum += vec[i];
	}
	return sum;
}
int Operadores::operator-(int vec[]) {
	int res = 0;
	for (int i = 0; i < 3; i++) {
		if (i == 0) {
			res = vec[i];
		}
		else {
			res -= vec[i];
		}
	}
	return res;
}
float Operadores::operator-(float vec[]) {
	float res = 0;
	for (int i = 0; i < 3; i++) {
		if (i == 0) {
			res = vec[i];
		}
		else {
			res -= vec[i];
		}
	}
	return res;
}
float Operadores::operator*(float vec[]) {
	float modulo = 0;
	for (int i = 0; i < 3; i++) {
		modulo += vec[i] * vec[i];
	}
	return sqrtf(modulo);
}
float Operadores::operator*(int vec[]) {
	float modulo = 0;
	for (int i = 0; i < 3; i++) {
		modulo += vec[i] * vec[i];
	}
	return sqrtf(modulo);
}
float Operadores::operator/(int vec[]) {
	Operadores obj_op;
	float modulo;
	float unitario = 0, sum_cuad = 0;
	modulo = obj_op * vec;
	for (int i = 0; i < 3; i++) {
		unitario = vec[i] / modulo;
		sum_cuad += unitario * unitario;
	}
	return sqrtf(sum_cuad);
}
float Operadores::operator/(float a[]) {
	Operadores obj;
	float modulo;
	float unitario = 0, sum_cuad = 0;
	modulo = obj * a;
	for (int i = 0; i < 3; i++) {
		unitario = a[i] / modulo;
		sum_cuad += unitario * unitario;
	}
	return sqrtf(sum_cuad);
}