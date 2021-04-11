/*******************************************************************
* UNIVERSIDAD DE LAS FUERZAS ARMADAS ESPE  						   *
* Programa principal para registrar personas en un alista circular *
* Autor: Kevin Chuquimarca                 						   *
* Fecha: 18/01/2021                         					   *
* Fecha de modificacion: 18/01/2021         					   *
********************************************************************/

#include <iostream>

#include "Persona.h"
#include "ListaCircular.h"

using namespace std;

int main()
{
    std::string nombre, apellido, cd;
    Persona per;
    int op = 0, op2 = 0;
    ListaCircular<Persona> lista;
    do {
        system("cls");
        cout << "1: Registrar Persona \n2: Mostrar Lista \n3: Salir";
        cout << "\ningrese la opcion: ";
        cin >> op;
        switch (op)
        {
        case 1:
            cout << "\nIngrese su nombre: ";
            cin >> nombre;
            per.setNombre(nombre);
            cout << "Ingrese su apellido: ";
            cin >> apellido;
            per.setApellido(apellido);
            cout << "Ingrese su cedula: ";
            cin >> cd;
            per.setCedula(cd);
            cout << "\n1: Insertar al inicio \n2: Insertar al Final \n3: No insertar";
            cout << "\ningrese la opcion: ";
            cin >> op2;
            switch (op2) {
            case 1:
                lista.insertar_inicio(per);
                break;
            case 2:
                lista.insertar_final(per);
                break;
            }
            break;
        case 2:
            cout << "\nDatos de la lista\n";
            lista.imprimir();
            system("pause");
            break;
        }
    }while (op != 3);
}
