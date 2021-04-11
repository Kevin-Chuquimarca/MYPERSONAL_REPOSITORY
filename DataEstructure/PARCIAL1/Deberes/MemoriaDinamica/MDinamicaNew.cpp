#include "MDinamicaNew.h"

MDinamicaNew::MDinamicaNew(int** mat, int dim) {
	this->mat = mat;
	this-> dim = dim;
	reservar_m();
}
MDinamicaNew::~MDinamicaNew() {
	for (int i = 0; i < dim; i++) {
		delete[]mat[i];
	}
	delete[]mat;
	printf_s("liverando memoria...\n");
	Sleep(3000);
}
int** MDinamicaNew::reservar_m() {
	mat = new int* [dim];
	for (int i = 0; i < dim; i++) {
		*(mat + i) = new int[dim];
	}
	printf_s("reservando memoria...\n");
	Sleep(3000);
	return mat;
}