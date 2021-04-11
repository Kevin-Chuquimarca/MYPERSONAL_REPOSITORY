#include "CuadradoMagico.h"
#include <stdio.h>

void CuadradoMagico::registrar_dim() {
    printf_s("\nIngrese la dimension de la matriz: ");
    scanf_s("%d", &sz);
    constMagica = (sz * (sz * sz + 1)) / 2;
    llenar_matriz();
}

void CuadradoMagico::llenar_matriz() {
    printf_s("\nllenar matriz (1 al %d\n", sz * sz);
    for (int i = 0; i < sz; i++) {
        for (int j = 0; j < sz; j++) {
            printf_s("[%d][%d]: ",i , j);
            scanf_s("%d", &matriz[i][j]);
        }
    }
}

void CuadradoMagico::imprimir_matriz() {
    for (int i = 0; i < sz; i++) {
        for (int j = 0; j < sz; j++) {
            printf_s("%d ", matriz[i][j]);
        }
        printf_s("\n");
    }
    identificar_c();
}

void CuadradoMagico::identificar_c(){
    int j = 0;
    esMagico = true;
    while (j < sz && esMagico == true) {
        int suma = 0;
        for (int i = 0; i < sz; i++) {
            suma += matriz[i][j];
        }
        if (suma != constMagica) esMagico = false;
        j++;
    }
    if (!esMagico) {
        printf_s("\nno es un cuadrado magico");
    } else {
        printf_s("\nes un cuadrado magico");
    }
}
