#include "Menu.h"

void Menu::mnPrincipal(){
    int op = 0;
    do {
        imprimirOpciones(opcionesPrincipales, 7);
        op = stoi(ingreso.IngresoNumero("Ingrese la opcion: "));
        switch (op)
        {
        case 1:
            objOpr.registrarPersona(lista);
            system("pause");
            break;
        case 2:
            mnOrdenar();
            break;
        case 3:
            objOpr.buscarDatos(lista);
            break;
        case 4:
            mnImprimir();
            break;
        case 5:
            mnExportar();
            break;
        case 6:
            break;
        default:
            std::cout << "\nOPCION INCORRECTA";
            Sleep(400);
            break;
        }
    } while (op != 6);
}

void Menu::mnImprimir() {
    int op = 0;
    do {
        imprimirOpciones(opcionesImprimir, 4);
        op = stoi(ingreso.IngresoNumero("Ingrese la opcion: "));
        switch (op)
        {
        case 1:
            lista->imprimirLista();
            break;
        case 2:
            objOpr.qrPersona(lista);
            break;
        case 3:
            break;
        default:
            std::cout << "\nOPCION INCORRECTA";
            Sleep(400);
            break;
        }
        std::cout << std::endl;
        system("pause");
    } while (op != 3);
}

void Menu::mnOrdenar() {
    int op = 0;
    QuickSort<Persona> qSort;
    if (lista->getPrimero())
        do {
            imprimirOpciones(opcionesOrdenamiento, 5);
            op = stoi(ingreso.IngresoNumero("Ingrese la opcion: "));
            switch (op)
            {
            case 1:
                qSort.setopcionOrd(1);
                break;
            case 2:
                qSort.setopcionOrd(2);
                break;
            case 3:
                qSort.setopcionOrd(3);
                break;
            case 4:
                break;
            default:
                std::cout << "\nOPCION INCORRECTA";
                Sleep(400);
                break;
            }
            if (op > 0 && op < 4) {
                qSort.ordenar(lista, 1, lista->tamanio());
                lista->imprimirLista();
            }
            std::cout << std::endl;
            system("pause");
        } while (op != 4);
}

void Menu::mnExportar() {
    int op = 0;
    do {
        imprimirOpciones(opcionesExportar, 4);
        op = stoi(ingreso.IngresoNumero("Ingrese la opcion: "));
        switch (op)
        {
        case 1:
            objOpr.generarBackUp(lista);
            break;
        case 2:
            objOpr.generarPdf(lista);
            break;
        case 3:
            break;
        default:
            std::cout << "\nOPCION INCORRECTA";
            Sleep(400);
            break;
        }
    } while (op != 3);
}

void Menu::imprimirOpciones(std::string* opciones, int numOp) {
    system("cls");
    std::cout << *(opciones + 0) << std::endl;
    for (int i = 1; i < numOp; i++) {
        std::cout << "\n" << i << " " << *(opciones + i);
    }
    std::cout << std::endl;
}