/***************************************************************
* UNIVERSIDAD DE LAS FUERZAS ARMADAS ESPE                      *
* Programa principal para registrar personas y calcular la edad*
* Autor: Kevin Chuquimarca                                     *
* Fecha: 8/12/2020                                             *
* Fecha de modificacion: 28/12/2020                            *
****************************************************************/

#include <iostream>
#include "Persona.h"
#include "CalculoEdad.h"
#include "Fecha.h"
using namespace std;

int main(int argc, char** argv)
{
    Persona<double, string, float> persona(1727195420, "Kevin", "Chuquimarca", "Av. Universitaria", 984991746, 100.0);
    //cout << persona.getApellido() << endl;
    //cout << persona.getDireccion() << endl;
    CalculoEdad<int> ca;
    int dia = 0, mes = 0, anio = 0;
    do {
        cout << "Ingrese su anio de nacimiento: ";
        cin >> anio;
    } while(!ca.validar_anio(anio));
    do {
        cout << "Ingrese su mes de nacimiento: ";
        cin >> mes;
    } while (!ca.validar_mes(mes));
    do {
        cout << "Ingrese su dia de nacimiento: ";
        cin >> dia;
    } while (!ca.validar_dia(dia));
    Fecha<int> fa(dia, mes, anio);
    ca.calc_edad(fa);
    cout << "Edad: " << ca.get_edad();
    return 0;
}
