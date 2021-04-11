#ifndef DIRECCIONCORREO_H
#define DIRECCIONCORREO_H

#include <string>

#include "Persona.h"
#include "ListaCircular.h"

class DireccionCorreo {
	private:
		int num_crep = 0;
		std::string ext = "@espe.edu.ec";
	public:
		bool correos_rep(ListaCircular<Persona>* , std::string , std::string );
		std::string generar_correo(std::string, std::string);
};

#endif 


