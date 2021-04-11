/************************************************************
* UNIVERSIDAD DE LAS FUERZAS ARMADAS ESPE                   *
* Programa principal para guardar datos en un arbol binario *
* Autor: Kevin Chuquimarca                                  *
* Fecha: 14/02/2021                                         *
* Fecha de modificacion: 17/02/2021                         *
*************************************************************/

#include <iostream>

#include "ArbolBinario.h"

int main()
{
    ArbolBinario<char> ab;
    ab.crearArbol(ab.getRaiz());
    std::cout << "\nInorden: ";
    ab.inorden(ab.getRaiz());
    std::cout << "\nPreorden: ";
    ab.preorden(ab.getRaiz());
    std::cout << "\nPostorden: ";
    ab.postorden(ab.getRaiz());
    std::cout << std::endl;
    std::cout << "nivel del nodo raiz: " << ab.getNivelDato(ab.getRaiz(), ab.getRaiz()->getDato(), 0);
    std::cout << std::endl;
    std::cout << "Numero de nodos del arbol: " << ab.getNumeroNodos(ab.getRaiz(), 0);
    std::cout << std::endl;
    std::cout << "Altura del arbol: " << ab.getAltura(ab.getRaiz(), -1, -1);
    std::cout << "\nInOrden No Recursivo: ";
    ab.inordenNR(ab.getRaiz());
    std::cout << "\nPreOrden No Recursivo: ";
    ab.preordenNR(ab.getRaiz());
    std::cout << "\nPosOrden No Recursivo: ";
    ab.posordenNR(ab.getRaiz());
    std::cout << "" << std::endl;
    std::cout << std::endl << "Operaciones\n";
    std::cout << "Resultado: " << ab.evaluar(ab.getRaiz(), ' ');
}

