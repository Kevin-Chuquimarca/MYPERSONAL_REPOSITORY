/*************************************************************
* UNIVERSIDAD DE LAS FUERZAS ARMADAS ESPE           		 *
* Programa principal para ordenar un array usando QuickSort  *
* Autor: Kevin Chuquimarca                           		 *
* Fecha: 31/01/2021                                   		 *
* Fecha de modificacion: 31/01/2021                  		 *
**************************************************************/


#include <iostream>
#include "Quicksort.h"
#include "Vector.h"

int main()
{
    int dimension = 0;
    Vector<int> vec;
    QuickSort<int> qr = QuickSort<int>();
    std::cout << "Ingrese el numero de elementos a generar: ";
    std::cin >> dimension;
    vec = Vector<int>(dimension);
    vec.generar(dimension);
    std::cout << "Vector desordenado" << std::endl;
    vec.imprimir();
    qr.ordenar(vec.getVector(), 0 , dimension - 1);
    std::cout<< std::endl << "Vector ordenado" << std::endl;
    vec.imprimir();
    delete[] vec.getVector();
    /*Vector<char> vec;
    vec.reservar(10);
    char *cad = new char[10];
    std::string cad2;
    std::cin >> cad2;
    for (int i = 0; i < 10; i++) {
        *(cad + i) = cad2[i];
    }
    vec.setVector(cad);
    QuickSort<char> qr = QuickSort<char>();
    vec.imprimir();
    qr.ordenar(vec.getVector(), 0, 10 - 1);
    std::cout << std::endl << "Vector ordenado" << std::endl;
    vec.imprimir();
    delete[] vec.getVector();*/
}

