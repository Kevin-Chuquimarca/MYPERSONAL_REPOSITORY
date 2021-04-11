// TDA Memoria Dinamica.cpp : Este archivo contiene la función "main". La ejecución del programa comienza y termina ahí.
//

#include <iostream>
#include "Arreglo.h"

using namespace std;

int main()
{
    int vector[] = {1,2,3,4,5,6,7,8,9,10};
    Arreglo obj;
    obj.setVectort(vector);
    cout << obj<< endl;


    return 0;
}

// Ejecutar programa: Ctrl + F5 o menú Depurar > Iniciar sin depurar
// Depurar programa: F5 o menú Depurar > Iniciar depuración

