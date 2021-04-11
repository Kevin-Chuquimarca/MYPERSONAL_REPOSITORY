#include "ExcepcionSistema.h"

void ExcepcionSistema::abrir_cerrar_arch() {
	fstream fichero;
	fichero.exceptions(ios::failbit); 
	try {
		fichero.open("archivo.txt", ios::in); 
	}
	catch (ios_base::failure& ex) {
		cout << "Error al abrir el archivo" << endl;
	}
	try {
		fichero.close();
	}
	catch (ios_base::failure& ex) {
		cout << "Error al cerrar archivo" << endl;
	}
}