#include "DireccionCorreo.h"
#include <stdio.h>

bool DireccionCorreo::verificarCorreosRep(ListaCircular<Persona>* lista, std::string correo) {
	Nodo<Persona>* aux = new Nodo<Persona>;
	aux = lista->getPrimero();
	while (aux!= lista->getUltimo()) {
		if (aux->getDato().getCorreo() == correo) {
			num_crep++;
		}
		aux = aux->getSiguiente();
	}
	if (num_crep == 0) {
		return false;
	}
	return true;
}

std::string DireccionCorreo::generarCorreo(std::string nom, std::string apell) {
	if (num_crep != 0) {
		std::string num_cont(std::to_string(num_crep));
		return nom[0] + apell + num_cont + ext;
	}
	return nom[0] + apell + ext;
}