#include <iostream>
#include "Busqueda.h"
#include "Nodo.h"
#include "Persona.h"

class Secuencial: public Busqueda{
    public:
    bool buscar(ListaDoble<Persona>* lista, std::string parametro){
        Nodo<Persona> *aux;
        aux = lista->getPrimero();
        bool bandera=false;
        while(bandera==false && aux!=NULL){
            if(aux->getDato().getCedula() == parametro){
                cout << "\nDatos encontrados: " << endl;
                cout<<aux->getDato().toString()<<endl;
                bandera=true;
            }
            aux = aux->getSiguiente();
        }
        return bandera;
    }
};