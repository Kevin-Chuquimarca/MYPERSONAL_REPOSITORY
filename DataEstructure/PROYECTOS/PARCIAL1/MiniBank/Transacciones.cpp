/***********************************************************************
 * Module:  Transacciones.cpp
 * Author:  ismae
 * Modified: miércoles, 6 de enero de 2021 17:49:50
 * Purpose: Implementation of the class Transacciones
 ***********************************************************************/

#include "Transacciones.h"
#include "Lista.h"
#include <iostream>

using namespace std;


bool Transacciones::deposito(Lista cuentas, string idCuenta)
{
    bool respuesta = false;
    float monto;
    if (cuentas.buscar(idCuenta)) {
        cout << "Ingrese el monto que se desea depositar en la cuenta: ";
        cin >> monto;
        while (monto < 0)
        {
            cout << "Ingrese nuevamente el monto que se desea depositar en la cuenta: ";
            cin >> monto;
        }

        Cuenta aux;
        aux = cuentas.buscarYTraer(idCuenta);
        aux.setSaldo(aux.getSaldo() + monto);
        cout << "Transaccion exitosa!";
        respuesta = true;
    }
    else {
        cout << "Por favor ingresar un número de cuenta válido" << endl;
    }
    return respuesta;
}


bool Transacciones::retiro(Lista cuentas, string idCuenta)
{

    bool respuesta = false;
    float monto;

    Cuenta aux;

    if (cuentas.buscar(idCuenta)) {
        cout << "Ingrese el monto que se desea retirar de la cuenta: ";
        cin >> monto;
        while (monto < 0 || monto > aux.getSaldo())
        {
            cout << "Ingrese nuevamente el monto que se desea retirar: ";
            cin >> monto;
        }

        Cuenta aux;
        aux = cuentas.buscarYTraer(idCuenta);
        aux.setSaldo(aux.getSaldo() - monto);
        cout << "Transaccion exitosa!";
        respuesta = true;
    }
    else {
        cout << "Por favor ingresar un número de cuenta válido" << endl;
    }
    return respuesta;


}

void Transacciones::comprobante(void)
{
	
}