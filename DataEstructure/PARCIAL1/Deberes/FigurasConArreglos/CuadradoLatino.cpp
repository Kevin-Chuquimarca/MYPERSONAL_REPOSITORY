#include "CuadradoLatino.h"
#include <stdio.h>

void CuadradoLatino::cuadrado_latino() {
    int n, i, j, k;
    printf_s("\ningrese el tamaño n del cuadrado: ");
    scanf_s("%d", &n);
    for (i = 1; i <= n; i++) {
        for (j = i, k = 1; k <= n; k++, j++) {
            if (j > n) {
                for (j = 1; k <= n; k++, j++) {
                    printf_s(" %d", j);
                }
            } else {
                printf_s(" %d", j);
            }
        }
        printf_s("\n");
    }
}
