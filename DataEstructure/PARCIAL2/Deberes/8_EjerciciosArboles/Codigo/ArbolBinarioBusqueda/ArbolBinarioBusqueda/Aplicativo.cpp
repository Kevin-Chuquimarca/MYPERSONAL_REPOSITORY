/*************************************************************************
* UNIVERSIDAD DE LAS FUERZAS ARMADAS ESPE                                *
* Programa principal para guardar datos en un arbol binario de busqueda  *
* Autor: Kevin Chuquimarca                                               *
* Fecha: 14/02/2021                                                      *
* Fecha de modificacion: 17/02/2021                                      *
**************************************************************************/

#include "ArbolBB.h"

#include <iostream>

int main()
{
    ArbolBB<int> abb;
    int op = 0, rep = 0, dato = 0;
    do {
        std::cout << "\n\nIngrese un numero: ";
        std::cin >> dato;
        abb.insertarNodo(abb.getRaiz(), dato);
        std::cout << "\n\nDesea ingresar otro caracter[1=si | 0=no]: ";
        std::cin >> rep;
    } while (rep == 1);
    std::cout << "\nInorden: ";
    abb.inorden(abb.getRaiz());
    std::cout << "\nPreorden: ";
    abb.preorden(abb.getRaiz());
    std::cout << "\nPostorden: ";
    abb.postorden(abb.getRaiz());
}

