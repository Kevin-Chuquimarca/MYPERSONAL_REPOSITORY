/***********************************************************************
* UNIVERSIDAD DE LAS FUERZAS ARMADAS ESPE  							   *
* Programa principal para guardar personas en uns lista cricular doble *
* Autor: Kevin Chuquimarca                 							   *
* Fecha: 18/01/2020                         						   *
* Fecha de modificacion: 18/01/2020         						   *
************************************************************************/

#include <iostream>

#include "Persona.h"
#include "ListaCircularDoble.h"

using namespace std;

int main()
{
    std::string nombre, apellido, cd;
    Persona per;
    int op = 0, op2 = 0, pos = 0;
    ListaCircularDoble<Persona> lista;
    lista.insertar_inicio(per);
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
            cout << "\n1: Insertar al inicio \n2: Insertar al Final \n3: Insertar entre \n4: No insertar";
            cout << "\ningrese la opcion: ";
            cin >> op2;
            switch (op2) {
            case 1:
                lista.insertar_inicio(per);
                break;
            case 2:
                lista.insertar_final(per);
                break;
            case 3:
                cout << "Ingrese la posicion: ";
                cin >> pos;
                if (lista.tamanio() >= pos) {
                    lista.insertar_entre(per, pos);
                }
                break;
            }
            break;
        case 2:
            cout << "\nDatos de la lista\n";
            lista.imprimir();
            system("pause");
            break;
        }
    } while (op != 3);
}
