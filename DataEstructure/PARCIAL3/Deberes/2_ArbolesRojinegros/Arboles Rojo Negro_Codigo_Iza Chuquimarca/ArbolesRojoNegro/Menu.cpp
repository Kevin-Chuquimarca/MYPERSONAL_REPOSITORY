#include <iostream>
#include "ArbolRB.h"
#include "Nodo.h"
#include "Menu.h"

Menu::Menu() {
}

void Menu::dibujarMenu(std::string* opciones, int numOpcs) {
	for (int i = 0; i < numOpcs; i++)
		std::cout << *(opciones + i) << std::endl;
}

void Menu::menuOpciones() {
	ArbolRB<int> arbolOperador;
	int opc, elemento, cont = 0;
	do {
		std::cout << "\nARBOL BINARIO DE BUSQUEDA" << std::endl;
		dibujarMenu(opciones, 4);
		std::cout << "\nINGRESE LA OPCION QUE DESEA EJECUTAR: ";
		std::cin >> opc;
		switch (opc) {
		case 1:
			std::cout << "INGRESAR EL VALOR: ";
			std::cin >> elemento;
			arbolOperador.insertar(elemento);
			system("pause");
			break;
		case 2:
			arbolOperador.mostrarArbol(arbolOperador.getRaiz(), cont);
			system("pause");
			break;
		case 3:
			std::cout << "DIGITE EL ELEMENTO QUE DESEA ELIMINAR: ";
			std::cin >> elemento;
			arbolOperador.eliminar(elemento);
			system("pause");
			break;
		case 4:
			break;
		default:
			std::cout << "\nLA OPCION INGRESADA NO ES VALIDA" << std::endl;
			break;
		}
		system("cls");
	} while (opc != 4);
}