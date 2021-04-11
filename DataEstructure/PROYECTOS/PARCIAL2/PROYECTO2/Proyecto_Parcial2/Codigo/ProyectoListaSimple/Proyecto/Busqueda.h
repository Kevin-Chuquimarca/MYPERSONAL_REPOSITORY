#include "string"
#include "Lista.h"
#include "Persona.h"

class Busqueda{
    public:
    virtual bool buscar(Lista<Persona>*,std::string)=0;
};