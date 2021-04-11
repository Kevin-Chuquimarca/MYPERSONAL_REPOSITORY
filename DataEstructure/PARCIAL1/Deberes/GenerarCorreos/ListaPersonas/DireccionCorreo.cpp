#include "DireccionCorreo.h"
#include <stdio.h>

bool DireccionCorreo::verificar_correos_rep(Nodo<Persona>* lista, std::string correo) {
	Persona per;
	per = lista-> getDato();
	while (lista != NULL) {
		per = lista->getDato();
		lista = lista->getSiguiente();
		if (per.getCorreo() == correo) {
			num_crep++;
		}
	}
	if (num_crep == 0) {
		return false;
	}
	return true;
}

std::string DireccionCorreo::generar_correo(std::string nom, std::string apell) {
	if (num_crep != 0) {
		std::string num_cont(std::to_string(num_crep));
		return nom[0] + apell + num_cont + ext;
	}
	return nom[0] + apell + ext;
}