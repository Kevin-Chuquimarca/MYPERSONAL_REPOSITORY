#include "string"
#include "ListaDoble.h"
#include "Persona.h"

class Busqueda{
    public:
    virtual bool buscar(ListaDoble<Persona>*,std::string)=0;
};