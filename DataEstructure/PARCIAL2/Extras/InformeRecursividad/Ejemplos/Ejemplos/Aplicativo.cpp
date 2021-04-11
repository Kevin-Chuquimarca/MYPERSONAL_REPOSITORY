/***********************************************************************
* UNIVERSIDAD DE LAS FUERZAS ARMADAS ESPE							   *
* Programa principal para generar los movimientos de la torre de hanoi *
* Autor: Kevin Chuquimarca											   *
* Fecha: 21/02/2021													   *
* Fecha de modificacion: 21/02/2021									   *
************************************************************************/

#include <iostream>

#include "Hanoi.h"
#include "RecursividadDirecta.h"
#include "RecursividadIndirecta.h"

int main()
{
	Hanoi hni;
	RecursividadDirecta rd;
	RecursividadIndirecta ri;
	int op = 0, aux = 0, aux1 = 0;
	do {
		system("cls");
		std::cout << "1 Hanoi\n2 Producto\n3 fibonacci\n4 Alfabeto\n5 Salir";
		std::cout << "\n\nIngrese la opcion: ";
		std::cin >> op;
		switch (op)
		{
		case 1:
			hni.hanoi();
			break;
		case 2:
			std::cout << "Ingrese un numero: ";
			std::cin >> aux;
			std::cout << "Ingrese otro numero: ";
			std::cin >> aux1;
			std::cout << "\nResultado: " << rd.producto(aux, aux1);
			break;
		case 3:
			std::cout << "Ingrese un numero: ";
			std::cin >> aux;
			std::cout << "\nSerie:";
			for (int i = 0; i < aux; i++)
			std::cout << " " << rd.fibonacci(i);
			break;
		case 4:
			std::cout << "\n";
			ri.imprimirAlf('Z');
			std::cout << std::endl;
			break;
		case 5:
			break;
		default:
			std::cout << "\nOpcion Incorrecta\n";
			break;
		}
		std::cout << "\n\n";
		system("pause");
	} while (op != 5);
	return 0;
}


