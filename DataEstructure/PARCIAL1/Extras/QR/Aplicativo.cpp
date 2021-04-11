/***************************************************************
* UNIVERSIDAD DE LAS FUERZAS ARMADAS ESPE                      *
* Programa principal para generar codigos QR                   *
* Autor: Kevin Chuquimarca                                     *
* Fecha: 18/12/2020                                            *
* Fecha de modificacion: 18/12/2020                            *
****************************************************************/

#include "GenerarQR.h"
#include "Persona.h"

#include <iostream>

int main()
{
    std::string nombre, apellido, cd, cad;
    Persona per;
    int res = 0;
    char* cadena = new char[50];
    do {
        std::cout << "Ingrese su nombre: ";
        std::cin >> nombre;
        per.setNombre(nombre);
        std::cout << "Ingrese su apellido: ";
        std::cin >> apellido;
        per.setApellido(apellido);
        std::cout << "Ingrese su cedula: ";
        std::cin >> cd;
        per.setCedula(cd);
        GeneraQR qr;
        cad = per.mostrarInformacion();
        for (int i = 0; i < cad.size(); i++) {
            *(cadena + i) = cad[i];
        }
        std::cout << std::endl;
        qr.crear_QR(cadena);
        std::cout << "Ingresar otra persona?[y = 1/n = 0]: ";
        std::cin >> res;
    } while (res == 1);
}

