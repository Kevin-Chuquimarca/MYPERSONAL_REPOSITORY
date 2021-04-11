/*********************************************
*  UNIVERSIDAD DE LAS FUERZAS ARMADAS ESPE   *
*  Calculadora Polaca Inversa        	     *
*  Autores: Kevion Chuquimarca, Marco Iza    *
*  Fecha de creacion: 26/02/2021             *
*  Fecha de modificacion: 1/02/2021          *
*  Calculadora para operar ecuaciones        *
*  matemáticas                               *
*********************************************/

#include <iostream>
#include <conio.h>
#include "Polaca.h"

int main()
{
	char* expresion = new char[50];
	do {
		Polaca* calculo = new Polaca;
		system("cls");
		std::cout << "CALCULADORA POLACA INVERSA\n\n";
		std::cout << "Calcular: ";
		std::cin >> expresion;
		calculo->infAPos(expresion, strlen(expresion), '\0');
		std::cout << "\n";
		calculo->operadorPostfijo();
		std::cout << "\n\nPara salir presion [s] sino presione [enter]: ";
		delete calculo;
	} while (_getche() != 's');
}