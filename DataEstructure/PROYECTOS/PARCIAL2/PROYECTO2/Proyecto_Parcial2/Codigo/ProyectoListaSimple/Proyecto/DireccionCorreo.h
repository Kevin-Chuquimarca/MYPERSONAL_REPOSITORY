#ifndef DIRECCIONCORREO_H
#define DIRECCIONCORREO_H

#include <string>

#include "Persona.h"
#include "Lista.h"
#include "NodoLista.h"

class DireccionCorreo {
	private:
		int num_crep = 0;
		std::string ext = "@espe.edu.ec";
	public:
		bool verificarCorreosRep(Lista<Persona>* , std::string);
		std::string generarCorreo(std::string, std::string);
};

#endif 


