#pragma once

//#include <string>
#include "Persona.h"


class Cuenta
{

public:
	Cuenta();
	void mostrarInformacion();
	string getId();
	float getSaldo();
	//bool getTarjeta();
	void setId(string);
	void setSaldo(float);
	Persona getPersona();
	void setPersona(Persona);
	void setTipoDeCuenta(int);
	int getTipoDeCuenta();
	//void setTarjeta(bool); 
	enum TipoDeCuenta {
		Ahorros = 1,
		Corriente = 2
	};
protected:
private:
	std::string id;
	float saldo;
	Persona persona;
	int tipoDeCuenta;
	//bool tarjeta;


};

