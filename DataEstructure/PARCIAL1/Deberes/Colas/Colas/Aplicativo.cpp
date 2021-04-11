/***********************************************************************************************
* UNIVERSIDAD DE LAS FUERZAS ARMADAS ESPE													   *
* Programa principal para registrar personas en una cola e imprimir los datos de las personas  *
* Autor: Kevin Chuquimarca																	   *
* Fecha: 17/01/2021																		       *
* Fecha de modificacion: 17/01/2021															   *
************************************************************************************************/

#include <iostream>
#include "Cola.h"
#include "Persona.h"

int main()
{
    int opcion = 0;
	std::string nombre, apellido, cedula, cor;
	Persona per;
	Cola<Persona> correos;
    do {
		system("cls");
		std::cout << "1: Registrar Persona \n2: Generar Correos \n3: Salir";
		std::cout << "\nIngrese la opcion: ";
		std::cin >> opcion;
		system("cls");
		switch (opcion)
		{
		case 1:
			std::cout << "Ingrese su nombre: ";
			std::cin >> nombre;
			per.setNombre(nombre);
			std::cout << "Ingrese su apellido: ";
			std::cin >> apellido;
			per.setApellido(apellido);
			std::cout << "Ingrese su cedula: ";
			std::cin >> cedula;
			per.setCedula(cedula);
			if (correos.ColaLlena() == 0) {
				correos.InsertaCola(per);
			} else {
				std::cout << "La cola Personas esta llena";
			}
			break;
		case 2:
			do {
				if (correos.ColaVacia() == 0) {
					per = correos.getDato();
					std::cout << per.getNombre() << " "<< per.getApellido() << " " << per.getCedula() << std::endl;
				} else {
					std::cout << "La cola persona esta vacia";
				}
			} while (correos.ColaVacia() != 1);
			system("pause");
			break;
		}
    } while (opcion != 3);
	correos.EliminarCola();
}

