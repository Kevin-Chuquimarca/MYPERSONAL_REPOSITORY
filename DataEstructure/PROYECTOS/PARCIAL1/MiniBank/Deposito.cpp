#include "Deposito.h"
#include "Opciones.h"
#include "IngresoDatos.h"
#include <iostream>

using namespace std;

void Deposito::movimiento(Lista* cuentas, string idCuenta) {
    
    float monto;
    string dato = "";
    IngresoDatos ingreso;
    Opciones opc;
    Cuenta aux;

    if (opc.buscar(cuentas,idCuenta)) {
        dato = ingreso.IngresoNumero("Ingrese el monto que se desea retirar: ");
        monto = stof(dato);
        
        aux = opc.buscarYTraer(cuentas,idCuenta);
        cuentas->modificarNodo(idCuenta,aux.getSaldo()+ monto);
        cout << "\n\t Transaccion exitosa!";
        
    }
    else {
        cout << "\n\t Por favor ingresar un numero de cuenta valido" << endl << "\t";
        system("pause");
    }
    
}
