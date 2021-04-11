#include "MDinamicaNew.h"

MDinamicaNew::MDinamicaNew(int** mat, int dim) {
	this->mat = mat;
	this-> dim = dim;
	reservar_m();
	encerar();
}
MDinamicaNew::~MDinamicaNew() {
	for (int i = 0; i < dim; i++) {
		delete[]mat[i];
	}
	delete[]mat;
}
int** MDinamicaNew::reservar_m() {
	mat = new int* [dim];
	for (int i = 0; i < dim; i++) {
		*(mat + i) = new int[dim];
	}
	return mat;
}

void MDinamicaNew::imprimir() {
	for (int i = 0; i < dim; i++) {
		for (int j = 0; j < dim; j++) {
			printf_s("%d", *(*(mat + i) + j));
			//printf_s("%*s", j + 5, "");
		}
		printf_s("\n");
	}
}

void MDinamicaNew::encerar() {
	for (int i = 0; i < dim; i++) {
		for (int j = 0; j < dim; j++) {
			*(*(mat + i) + j) = - 1;
		}
	}
}

int MDinamicaNew::get_dim() {
	return dim;
}

int** MDinamicaNew::get_mat() {
	return mat;
}

void MDinamicaNew::set_mat(int** newMat) {
	mat = newMat;
}