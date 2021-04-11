#ifndef TMATRIZDINAMICA_H_INCLUDED
#define TMATRIZDINAMICA_H_INCLUDED

#include <stdio.h>
#include <stdlib.h>

template <class T>
class TMatrizDinamica {
private:
	T** mat;
	T dim;
public:
	TMatrizDinamica(T**, T);
	~TMatrizDinamica();
	void ingreso();
	void imprimir();
	T** matriz();
	void encerar();
	T get_dim();
	T** get_mat();
};

template <class T>
TMatrizDinamica<T>::TMatrizDinamica(T** mat, T dim) {
    this->mat = mat;
    this->dim = dim;
    matriz();
    encerar();
}
template <class T>
TMatrizDinamica<T>::~TMatrizDinamica() {
    free(mat);
    printf_s("memoria liberada");
}
template <class T>
void TMatrizDinamica<T>::ingreso() {
    for (int i = 0; i < dim; i++) {
        for (int j = 0; j < dim; j++) {
            scanf_s("%d", &(*(*(mat + i) + j)));
        }
    }
}
template <class T>
void TMatrizDinamica<T>::imprimir() {
    for (int i = 0; i < dim; i++) {
        for (int j = 0; j < dim; j++) {
            printf_s("%d", *(*(mat + i) + j));
            printf_s("%*s", j + 5, "");
        }
        printf_s("\n");
    }
}
template <class T>
T** TMatrizDinamica<T>::matriz() {
    mat = (int**)malloc(dim * sizeof(int*));
    if (!(mat == NULL)) {
        for (int i = 0; i < dim; i++) {
            *(mat + i) = (int*)malloc(dim * sizeof(int));
        }
    }
    else {
        printf_s("error al reservar memoria");
    }
    return mat;
}
template <class T>
void TMatrizDinamica<T>::encerar() {
    for (int i = 0; i < dim; i++) {
        for (int j = 0; j < dim; j++) {
            *(*(mat + i) + j) = 0;
        }
    }
}
template <class T>
T TMatrizDinamica<T>::get_dim() {
    return dim;
}
template <class T>
T** TMatrizDinamica<T>::get_mat() {
    return mat;
}
#endif