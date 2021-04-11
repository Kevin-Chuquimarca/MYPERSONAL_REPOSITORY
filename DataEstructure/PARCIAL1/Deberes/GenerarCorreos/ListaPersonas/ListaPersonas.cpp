/***************************************************************
* UNIVERSIDAD DE LAS FUERZAS ARMADAS ESPE                      *
* Programa principal para registrar personas y generar correos *
* Autor: Kevin Chuquimarca                                     *
* Fecha: 04/01/2021                                            *
* Fecha de modificacion: 05/01/2021                            *
****************************************************************/

#include <stdio.h>
#include <iostream>
#include <string>
#include <conio.h>

#include "Persona.h"
#include "DireccionCorreo.h"
#include "Nodo.h"

using namespace std;

void suma_pares(Nodo<Persona>* lista);

int main(int argc, char** argv) {
	DireccionCorreo cr;
	Persona per;
	string nombre, apellido, cedula, correo;
	Nodo<Persona> *lista = new Nodo<Persona>;
	do{
		printf_s("Ingrese su nombre: ");
		cin >> nombre;
		printf_s("Ingrese su apellido: ");
		cin >> apellido;
		printf_s("Ingrese su cedula: ");
		cin >> cedula;
		if (nombre[0] != '0' or apellido[0] != '0') {
			per.setNombre(nombre);
			per.setApellido(apellido);
			per.setCedula(cedula);
			correo = cr.generar_correo(nombre, apellido);
			if (cr.verificar_correos_rep(lista, correo)) {
				correo = cr.generar_correo(nombre, apellido);
			}
			per.setCorreo(correo);
			lista->insertarFinal(per);
		}
	} while (nombre[0] != '0' or apellido[0] != '0');
	std::cout << endl;
	lista->imprimir();
	delete lista;
}

