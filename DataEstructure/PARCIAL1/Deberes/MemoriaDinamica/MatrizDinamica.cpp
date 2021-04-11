#include "MatrizDinamica.h"

MatrizDinamica::MatrizDinamica(int** mat, int dim) {
	this->mat = mat;
	this->dim = dim;
    matriz();
    encerar();
}
MatrizDinamica::~MatrizDinamica() {
	for (int i = 0; i < dim; i++){
		free (mat[i]);
	}
    free(mat);
    printf_s("memoria liberada");
}
void MatrizDinamica::ingreso() {
    for (int i = 0; i < dim; i++) {
        for (int j = 0; j < dim; j++) {
            scanf_s("%d", &(*(*(mat + i) + j)));
        }
    }
}
void MatrizDinamica::imprimir() {
    for (int i = 0; i < dim; i++) {
        for (int j = 0; j < dim; j++) {
            printf_s("%d", *(*(mat + i) + j));
            printf_s("%*s", j + 5, "");
        }
        printf_s("\n");
    }
}
int** MatrizDinamica::matriz() {
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
void MatrizDinamica::encerar() {
    for (int i = 0; i < dim; i++) {
        for (int j = 0; j < dim; j++) {
            *(*(mat + i) + j) = 0;
        }
    }
}
int MatrizDinamica::get_dim() {
    return dim;
}

int** MatrizDinamica::get_mat() {
    return mat;
}