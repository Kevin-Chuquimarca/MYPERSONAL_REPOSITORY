#ifndef MENU_H
#define MENU_H

#include <iostream>

#include <Windows.h>

#include "ListaDoble.h"
#include "Persona.h"
#include "Operaciones.h"
#include "Quicksort.h"
#include "IngresoDatos.h"

using namespace std;

class Menu {
private:
    std::string opcionesPrincipales[7] = {"MENU PRINCIPAL","REGISTRAR","ORDDENAR","BUSCAR","MOSTRAR EN PANTALLA","EXPORTAR","SALIR"};
    std::string opcionesImprimir[4] = {"MENU IMPRIMIR","MOSTRAR DATOS DE LISTA","GENERAR QR", "MENU PRINCIPAL"};
    std::string opcionesOrdenamiento[5] = {"MENU ORDENAR","ORDENAR POR CEDULA","ORDENAR POR EDAD","ORDENAR POR ORDEN ALFABETICO","MENU PRINCIPAL" };
    std::string opcionesExportar[4] = { "MENU EXPORTAR","BACKUP","PDF","MENU PRINCIPAL"};
    ListaDoble<Persona>* lista = new ListaDoble<Persona>;
    Operaciones objOpr;
    IngresoDatos ingreso;
public:
    void mnPrincipal();
    void mnImprimir();
    void mnOrdenar();
    void mnExportar();
    void imprimirOpciones(std::string*, int);
    ~Menu(){
        delete lista;
    }
};

#endif 
