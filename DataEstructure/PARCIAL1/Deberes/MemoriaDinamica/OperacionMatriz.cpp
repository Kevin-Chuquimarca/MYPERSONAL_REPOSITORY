#include "OperacionMatriz.h"

void OperacionMatriz::proceso(int** mat1, int** mat2, int** matr, int d) {
    for (int i = 0; i < d; i++) {
        for (int j = 0; j < d; j++) {
            for (int k = 0; k < d; k++) {
                *(*(matr + i) + j) = *(*(matr + i) + j) + (*(*(mat1 + i) + k)) * (*(*(mat2 + k) + j));      
            }
        }
    }
}