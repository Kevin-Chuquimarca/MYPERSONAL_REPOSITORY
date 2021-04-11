#include "Retiro.h"
#include"IngresoDatos.h"
#include "Opciones.h"
#include <iostream>
#include "IngresoDatos.h"

using namespace std;

void Retiro::movimiento(Lista* cuentas, string idCuenta) {

    float monto;
    string dato = "";
    IngresoDatos ingreso;
    Opciones opc;
    Cuenta aux;
 

    if (opc.buscar(cuentas,idCuenta))
    {
   
        dato = ingreso.IngresoNumero("Ingrese el monto que se desea retirar: ");
        monto = stof(dato);
        aux = opc.buscarYTraer(cuentas, idCuenta);
        if (monto > aux.getSaldo()) {
            cout << "\n\tSaldo insuficiente...\n\t";
        }
        else {
            aux = opc.buscarYTraer(cuentas, idCuenta);
            cuentas->modificarNodo(idCuenta, aux.getSaldo() - monto);
            cout << "\n\tTransaccion exitosa!";
        }
        
    }
    else {

        cout << "\n\tNo existe el numero de cuenta....\n\t ";
        system("pause");
    }



}