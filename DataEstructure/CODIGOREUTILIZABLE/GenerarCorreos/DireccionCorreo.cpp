#include "DireccionCorreo.h"
#include <stdio.h>

bool DireccionCorreo::correos_rep(ListaCircular<Persona>* lista, std::string nom, std::string apell) {
	Persona per, per_aux;
	int aux = 0, tamanio = 0;
	Nodo<Persona>* nodo = lista->getCabeza();
	tamanio = lista->tamanio();
	per = nodo->obtenerValor();
	while (aux != tamanio) {
		per = nodo->obtenerValor();
		nodo = nodo->obtenerSiguiente();
		aux++;
		if (per.getNombre() == nom && per.getApellido() == apell) {
			per_aux = per;
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