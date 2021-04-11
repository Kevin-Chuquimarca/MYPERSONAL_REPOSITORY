/*********************************************
*  UNIVERSIDAD DE LAS FUERZAS ARMADAS ESPE   *
*  Programa para el movimiento de un marfil  *
*  Autores: Kevin Chuquimarca			     *
*  Fecha de creacion:  7/04/2021             *
*  Fecha de modificacion:  7/04/2021         *  
*********************************************/

#include <iostream>

#include "Arfil.h"

using namespace std;



int main() {
	int n;
	cout << "Ingrese la dimension del tablero: ";
	cin >> n;
	Arfil* obj = new Arfil(n);
	obj->encerarTablero();
	obj->generarArfil();
	obj->mostrar();
	obj->movArfil(obj->aux, obj->aux2, obj->validar, obj->tablero);
	cout << "Se creo el archivo solucion.txt" << endl;
	return 0;
}

