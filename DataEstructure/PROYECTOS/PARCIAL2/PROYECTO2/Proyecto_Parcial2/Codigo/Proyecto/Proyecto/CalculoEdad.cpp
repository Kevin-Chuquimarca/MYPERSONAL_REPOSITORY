#include "CalculoEdad.h"
#include "IngresoDatos.h"

CalculoEdad::CalculoEdad() {
	this->edadAnios = 0;
	this->edadMeses = 0;
	this->edadDias = 0;
}

bool CalculoEdad::calcEdad(Fecha objFn) {
	Fecha objFa;
	objFa.generarFecha();
	if (objFa.getAnio() > objFn.getAnio()) {
		if (objFa.getMes() >= objFn.getMes()) {
			edadMeses = objFa.getMes() - objFn.getMes();
			edadAnios = objFa.getAnio() - objFn.getAnio();
		}
		else {
			edadMeses = objFa.getMes() - objFn.getMes() + 12;
			edadAnios = objFa.getAnio() - objFn.getAnio() - 1;
		}
		edadDias = objFa.getDia() - objFn.getDia() + 1;
		return true;
	}
	return false;
}

void CalculoEdad::registrarEdad() {
	int dia = 0, mes = 0, anio = 0;
	IngresoDatos ingreso;
	Fecha objFn;
	do {
		dia = validarRango(1, 31, "Ingrese su dia de nacimiento: ");
		mes = validarRango(1, 12, "Ingrese su mes de nacimiento: ");
		anio = validarRango(1920, 2020, "Ingrese su anio de nacimiento: ");
		objFn = Fecha(dia, mes, anio);
	} while (!calcEdad(objFn));
}

int CalculoEdad::getEdadAnios() {
	return edadAnios;
}

int CalculoEdad::getEdadMeses() {
	return edadMeses;
}

int CalculoEdad::getEdadDias() {
	return edadDias;
}

std::string CalculoEdad::getEdad() {
	std::string eAnio(std::to_string(edadAnios));
	std::string eMes(std::to_string(edadMeses));
	std::string eDia(std::to_string(edadDias));
	return "\nEdad del usuario: " + eAnio +  " anios\n";
}

int CalculoEdad::validarRango(int r1, int r2, std::string cadena) {
	IngresoDatos ingreso;
	std::string aux;
	int dato = 0;
	do{
		aux = ingreso.IngresoNumero(cadena);
		if (aux != "")
		dato = stoi(aux);
	} while (!(dato >= r1 && dato <= r2));
	return dato;
}