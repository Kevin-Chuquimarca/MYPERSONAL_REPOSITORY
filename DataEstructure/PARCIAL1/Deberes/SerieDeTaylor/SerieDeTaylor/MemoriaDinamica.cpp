#include "MemoriaDinamica.h"

int** MemoriaDinamica::reservar_m(int dim_x, int  dim_y) {
	int **mat = new int* [dim_x];
	for (int i = 0; i < dim_x; i++) {
		*(mat + i) = new int[dim_y];
	}
	return mat;
}

int* MemoriaDinamica::reservar_m(int dim_x) {
	int *vec = new int [dim_x];
	return vec;
}

void MemoriaDinamica::liberar_m(int** mat, int dim_x) {
	for (int i = 0; i < dim_x; i++) {
		delete[]mat[i];
	}
	delete[]mat;
}

void MemoriaDinamica::liberar_m(int* vec) {
	delete[]vec;
}

void MemoriaDinamica::encerar(int** mat, int x, int y) {
	for (int i = 0; i < x; i++) {
		for (int j = 0; j < y; j++) {
			*(*(mat + i) + j) = 0;
		}
	}
}

void MemoriaDinamica::encerar(int* mat, int t) {
	for (int i = 0; i < t; i++) {
		*(mat + i) = 0;
	}
}