#include "TrianguloPascal.h"
#include <stdio.h>

TrianguloPascal::TrianguloPascal() {
    this->matriz[0] = {};
    this->filas = 0;
    this->columnas = 0;
    this->posicion = 0;
}

int TrianguloPascal::factorial(int n) {
    int sum = 1;
    for (int i = 0; i < n; i++) {
        sum *= (1 + i);
    }
    return sum;
}

void TrianguloPascal::ingresar_dim() {
    printf_s("\ningrese el numero de filas: ");
    scanf_s(" %d", &filas);
    for (int i = filas; i > 0; i--) {
        columnas += i;
    }
    generar_trg();
}

void TrianguloPascal::generar_trg() {
    int calculo = 0;
    for (int f = 0; f < filas; f++) {
        for (int c = 0; c <= f; c++) {
            calculo = factorial(f) / (factorial(c) * factorial(f - c));
            matriz[posicion] = calculo;
            posicion++;
        }
    }
}

void TrianguloPascal::imprimir_trg() {
    posicion = 0;
    for (int f = 0; f < filas; f++) {
        printf_s("\n%*c", (int)(columnas / 2) - f, ' ');
        for (int c = 0; c <= f; c++) {
            printf_s("%d ", matriz[posicion]);
            posicion++;
        }
    }
}
