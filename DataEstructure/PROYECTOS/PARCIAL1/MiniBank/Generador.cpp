#include "Generador.h"
#include "Fuente.h"
#include<iostream>

using namespace std;

bool Generador::existeCorreo(string correo,Lista* cuentas) {

	Nodo* aux = new Nodo();
	while (aux != NULL)
	{

		if (correo == aux->getCuenta().getPersona().getCorreo()) {
			return true;
		}
		aux = aux->getSiguiente();
	}

	return false;
}

string Generador::crearCorreo(string apellido, string nombre, Lista* cuentas) {

	Fuente txt;
	string correo; 
	int cont = 1;
	Nodo* aux = new Nodo();
	
	apellido = txt.aMinusculas(apellido);
	nombre = txt.aMinusculas(nombre);
	
	correo = nombre[0] + apellido + this->dominio;
	aux = cuentas->getNodo();

	if (existeCorreo(correo,cuentas))
	{
		correo = nombre[0] + apellido + to_string(cont) + this->dominio;
		cont += 1;
	}

	while (aux != NULL)
	{
		while (existeCorreo(correo,cuentas));
		
		correo = nombre[0] + apellido + to_string(cont) + this->dominio;
		cont += 1;

		aux = aux->getSiguiente();
	}

	return correo;

}

string Generador::generarNumeroDeCuenta(string cedula,int tipoDeCuenta) {
	
	int numero = (tipoDeCuenta == 1)? 65:67;
	string cuenta = to_string(numero);

	for (int i = 9; i>=0;i--)
	{
		cuenta += cedula[i];

	}

	return cuenta;

}

Generador::Generador()
{
	this->dominio = "@espe.edu.ec";
}