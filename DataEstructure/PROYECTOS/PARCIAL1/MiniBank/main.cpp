#include <iostream>
#include "Lista.h"
#include "Menu.h"
#include "Opciones.h"
using namespace std;
 
//void menu(Lista* cuentas);
//void mostrarmenu();

using namespace std;

int main()
{
    Lista* cuentas = new Lista();
    Cuenta cuenta;
    Menu menu;
    Opciones opc;
    int opcion,transaccion;
    string opcMenu[] = {"Crear Cuenta","Movimientos","Mostrar","Salir"};
    string SubMenuTransacciones[] = {"Retiro","Deposito","Atras"};
    string SubMenuMostrar[] = { "Mostrar Cuentas","Buscar una cuenta","Atras" };

    do
    {   
        
        opcion = menu.hacerMenu("Mini-Bank", opcMenu, 4);

        switch (opcion)
        {
        case 1:

            cuenta = opc.IngresarnuevaCuenta(cuentas);
            cuentas->insertarInicio(cuenta);
            break;

        case 2:

                transaccion = menu.hacerMenu("Realizar Trasaccion", SubMenuTransacciones, 3);
                switch (transaccion)
                {
                case 1:
                    opc.realizarRetiro(cuentas);
                    break;
                case 2:
                    opc.realizarDeposito(cuentas);
                    break;
                default:
                    break;
                }
            break;
        case 3:

            transaccion = menu.hacerMenu("Mostrar Cuentas", SubMenuMostrar, 3);
            switch (transaccion)
            {
            case 1:
                system("cls");
                cuentas->toString();
                system("pause");
                break;
            case 2:
                opc.buscarCuenta(cuentas);
                break;
            default:
                break;
            }

            break;

        default:
            system("cls");
            break;
        }

    } while (opcion > 0 && opcion <4);
    
    
    

}
