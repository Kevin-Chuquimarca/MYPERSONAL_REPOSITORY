#pragma once
#include <string>

class Menu {
private:
	std::string opciones[4] = { "1. INGRESAR ELEMENTO","2. MOSTRAR EL ARBOL","3. ELIMINAR ELEMENTO","4. SALIR" };
public:
	Menu();
	void menuOpciones();
	void dibujarMenu(std::string*, int);
};