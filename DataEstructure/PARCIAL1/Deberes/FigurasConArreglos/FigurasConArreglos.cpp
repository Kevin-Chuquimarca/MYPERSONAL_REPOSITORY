/*************************************************************************************
* UNIVERSIDAD DE LAS FUERZAS ARMADAS ESPE                                            *
* Programa principal para imprimir el triangulo de pascal, cuadrado magico y latino  *
* Autor: Kevin Chuquimarca                                                           *
* Fecha: 22/12/2020                                                                  *
* Fecha de modificacion: 26/12/2020                                                  *
**************************************************************************************/

#include <iostream>
#include "CuadradoMagico.h"
#include "CuadradoLatino.h"
#include "TrianguloPascal.h"

int main() {
    int op =0;
    do {
        printf_s("1: Cuadrado Magico\n2: Cuadrado Latino\n3: Triangulo de Pascal\n4: Salir\n");
        printf_s("\nIngrese la opcion: ");
        scanf_s("%d", &op);
        switch (op) {
        case 1:
            CuadradoMagico obj_cm{};
            obj_cm.registrar_dim();
            printf_s("\n");
            obj_cm.imprimir_matriz();
            break;
        case 2:
            CuadradoLatino obj_cl;
            obj_cl.cuadrado_latino();
            break;
        case 3:
            TrianguloPascal obj_tp;
            obj_tp.ingresar_dim();
            obj_tp.imprimir_trg();
            break;
        }
        printf_s("\n\n");
        system("pause");
        system("cls");

    } while (op != 4);
}