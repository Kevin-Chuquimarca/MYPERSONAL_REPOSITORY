/***************************************************************************
* UNIVERSIDAD DE LAS FUERZAS ARMADAS ESPE                      			   *
* Programa principal para ingresar numero usando operadores sobrecargadas  *
* Autor: Kevin Chuquimarca                                     			   *
* Fecha: 17/12/2020                                             		   *
* Fecha de modificacion: 19/12/2020                               		   *
****************************************************************************/

#include <iostream>
#include "Arreglo.h"
#include "IngresoDato.h"

using namespace std;

int main()
{
    IngresoDato obj_ig;
    int *vector;
    vector = obj_ig.ingresar("Ingrese el valor: ");
    Arreglo obj;
    obj.setVectort(vector);
    cout << endl;
    cout << obj<< endl;
    delete[]vector;
    return 0;
}


