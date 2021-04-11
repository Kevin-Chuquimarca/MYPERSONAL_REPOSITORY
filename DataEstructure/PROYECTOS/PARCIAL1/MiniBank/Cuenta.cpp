
/***********************************************************************
 * Module:  Cuenta.cpp
 * Author:  ismae
 * Modified: mi�rcoles, 6 de enero de 2021 16:37:35
 * Purpose: Implementation of the class Cuenta
 ***********************************************************************/

#include "Cuenta.h"
#include <string>
#include <iostream>

using namespace std;

Cuenta::Cuenta() {
	saldo = 0.0f;
}

string Cuenta::getId() {
	return id;
}

float Cuenta::getSaldo() {
	return saldo;
}

/*bool Cuenta::getTarjeta(){
	return tarjeta;
}*/

void Cuenta::setId(string newId) {
	id = newId;
}
void Cuenta::setSaldo(float newSaldo) {
	this->saldo = newSaldo;
}

/*void Cuenta::setTarjeta(bool newTarjeta){
	tarjeta=newTarjeta;
}*/
Persona Cuenta::getPersona() {
	return persona;
}
void Cuenta::setPersona(Persona newPersona) {
	persona = newPersona;
}

int Cuenta::getTipoDeCuenta() {
	return tipoDeCuenta;
}

void Cuenta::setTipoDeCuenta(int tipo) {
	this->tipoDeCuenta = tipo;
}

void Cuenta::mostrarInformacion(void)
{

	cout << "\t----------------------------------------------------" << endl;
	cout << "\tPropietario: " << this->persona.getNombre() << " " << this->persona.getApellido() << endl;
	cout << "\tNumero de cuenta: " << this->id << endl;
	cout << "\tCedula: " << this->persona.getCedula() << endl;
	cout << "\tEdad: " << this->persona.getEdad().get_anio() << " anios " << this->persona.getEdad().get_mes() <<" meses "<< this->persona.getEdad().get_dia()<<" dias " <<endl;
	cout << "\tSaldo disponible: " << this->saldo << endl;
	cout << "\tTipo de cuenta: " << ((this->tipoDeCuenta == 1)? "Corriente":"Ahorros")  << endl;
	cout << "\tCorreo del propietario: " << this->persona.getCorreo() << endl;
	cout << "\t----------------------------------------------------" << endl;

}
