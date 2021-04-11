/****************************************************************************
* UNIVERSIDAD DE LAS FUERZAS ARMADAS ESPE                                   *
* Programa principal para calcular el sen, cos, tan con series de taylor    *
* Autor: Kevin Chuquimarca                                                  *
* Fecha: 22/12/2020                                                         *
* Fecha de modificacion: 26/12/2020                                         *    
*****************************************************************************/

#include <iostream>
#include "FTrigonometricas.h"
#include "Radian.h"
#include <stdlib.h>
#include "TablasMult.h"

using namespace std;

int main() {
    int op = 0;
    printf_s("0: Serie de taylor\n1: Tablas de multiplicar\n");
    scanf_s("%d", &op);
    if (op == 0) {
        float rad;
        int pres = 5;
        Radian obj_rad;
        printf_s("ingrese el valor del angulo en grados: ");
        scanf_s("%f", &rad);
        FTrigonometricas obj_trg(pres, ((pres * 4) + 1));
        obj_trg.set_rad(obj_rad.covertir_a_rad(rad));
        printf_s("cos= %f\n", obj_trg.get_cos());
        printf_s("sen= %f\n", obj_trg.get_sen());
        printf_s("tan= %f\n", obj_trg.get_tan());
    }else{
        int x, y;
        printf_s("ingrese el ancho: ");
        scanf_s("%d", &x);
        printf_s("ingrese el largo: ");
        scanf_s("%d", &y);
        if (x < y) {
            TablasMult obj_tbl(y, x);
            obj_tbl.imprimir_tablas();
        }
        else {
            TablasMult obj_tbl(x, y);
            obj_tbl.imprimir_tablas();
        }
    }
    return 0;
}
