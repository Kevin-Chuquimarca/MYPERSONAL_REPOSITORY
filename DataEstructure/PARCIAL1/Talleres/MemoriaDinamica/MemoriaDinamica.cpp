/******************************************************************
* UNIVERSIDAD DE LAS FUERZAS ARMADAS ESPE					      *
* Programa principal para reservar memoria y multiplicar matrices *
* Autor: Kevin Chuquimarca                                        *
* Fecha: 21/12/2020                                                *
* Fecha de modificacion: 21/12/2020                                *
*******************************************************************/

#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <stdio.h>
#include <wchar.h>

void ingreso(int**, int);
void proceso(int**, int**, int **, int);
void imprimir(int**, int);
int** matriz(int);
void encerar(int**, int);

void ingreso(int **mat, int t) {
    for (int i = 0; i < t; i++) {
        for (int j = 0; j < t; j++) {
            scanf_s("%d", &(*(*(mat + i) + j)));
        }
    }
}

int **matriz(int d) {
    int **mat = NULL;
    mat = (int **)malloc(d*sizeof(int *));
    if (!(mat == NULL)) {                           //error puntero mat + i = NULL no referenciado
        for (int i = 0; i < d; i++) {
            *(mat + i) = (int*)malloc(d * sizeof(int));
        }
    }
    else {
        printf("error al reservar memoria");
    }
    return mat;
}

void imprimir(int **mat, int d) {
    for (int i = 0; i < d; i++) {
        for (int j = 0; j < d; j++) {
            printf_s("%d", *(*(mat + i) + j));
            printf("%*s", j + 5, "");
        }
        printf("\n");
    }
}

void proceso(int **mat1, int **mat2, int **matr, int t) {
    for (int i = 0; i < t; i++) {
        for (int j = 0; j < t; j++) {
            for (int k = 0; k < t; k++) {
                *(*(matr + i) + j) = *(*(matr + i) + j) + (*(*(mat1 + i) + j)) * (*(*(mat2 + k) + j));      //dinamica
                    //matr[i][j]=matr[i][j]+(mat1[i][h]*mat2[h][j])                                         //estatica
            }
        }
    }
}

void encerar(int **mat, int t) {
    for (int i = 0; i < t; i++) {
        for (int j = 0; j < t; j++) {
            *(*(mat + i) + j) = 0;
        }
    }
}

int main(){
    int d;
    int** mat1, **mat2, **matr;
    printf_s("Ingrese la dimension ");
    scanf_s("%d", &d);
    mat1 = matriz(d);
    mat2 = matriz(d);
    matr = matriz(d);
    ingreso(mat1, d);
    ingreso(mat2, d);
    printf("\nmatriz 1\n");
    imprimir(mat1, d);
    printf("\nmatriz 2\n");
    imprimir(mat2, d);
    encerar(matr, d);
    proceso(mat1, mat2, matr, d);
    imprimir(matr, d);
    free(matr);
    free(mat1);
    free(mat2);
}

