#include "string"
#include "ListaCircular.h"
#include "Persona.h"

class Busqueda{
    public:
    virtual bool buscar(ListaCircular<Persona>*,std::string)=0;
};