#ifndef CALCULOEDAD_H  
#define CALCULOEDAD_H

#include <iostream>
#include "Fecha.h"

using namespace std;
class CalculoEdad {
	private:
		int edadAnios;
		int edadMeses;
		int edadDias;
	public:
		CalculoEdad();
		bool calcEdad(Fecha);
		void registrarEdad();
		int getEdadAnios();
		int getEdadMeses();
		int getEdadDias();
		int validarRango(int, int, std::string cadena);
		std::string getEdad();
};
#endif;
