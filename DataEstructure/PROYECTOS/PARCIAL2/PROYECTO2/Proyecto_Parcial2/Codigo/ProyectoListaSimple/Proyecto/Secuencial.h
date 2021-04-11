#include <iostream>
#include "Busqueda.h"
#include "NodoLista.h"
#include "Persona.h"

class Secuencial: public Busqueda{
    public:
    bool buscar(ListaDoble<Persona>* lista, std::string parametro){
        Nodo<Persona> *aux;
        aux = lista->getPrimero();
        bool bandera=false;
        cout << "\nDatos encontrados: " << endl;
        while(aux!=NULL){
            if(aux->getDato().getCedula() == parametro){
                cout<<aux->getDato().toString()<<endl;
                bandera=true;
            }
            aux = aux->getSiguiente();
        }
        return bandera;
    }
};
