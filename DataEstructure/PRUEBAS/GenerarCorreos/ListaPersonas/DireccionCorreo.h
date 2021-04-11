#ifndef DIRECCIONCORREO_H
#define DIRECCIONCORREO_H

#include <string>

#include "Persona.h"
#include "Nodo.h"

class DireccionCorreo {
	private:
		int num_crep = 0;
		std::string ext = "@espe.edu.ec";
	public:
		bool verificar_correos_rep(Nodo<Persona>* , std::string);
		std::string generar_correo(std::string, std::string);
};

#endif 


