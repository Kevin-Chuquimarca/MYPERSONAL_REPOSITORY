#include "Persona.h"

#include "iostream"

#include <string>

Persona::Persona(std::string newNom, std::string newApell, int newEdad, std::string newCed, std::string newCorreo) {
	nombre = newNom;
	apellido = newApell;
	edad = newEdad;
	cedula = newCed;
	correo = newCorreo;
}

std::string Persona::getNombre(void)
{
   return nombre;
}

void Persona::setNombre(std::string newNombre)
{
   nombre = newNombre;
}

std::string Persona::getApellido(void)
{
   return apellido;
}

void Persona::setApellido(std::string newApellido)
{
   apellido = newApellido;
}

int Persona::getEdad(void) {
	return edad;
}

void Persona::setEdad(int newEdad) {
	edad = newEdad;
}

std::string Persona::getCedula(void)
{
   return cedula;
}

void Persona::setCedula(std::string newCedula)
{
   cedula = newCedula;
}

std::string Persona::getCorreo(void)
{
   return correo;
}

void Persona::setCorreo(std::string newCorreo)
{
   correo = newCorreo;
}

Persona::Persona()
{
}

std::string Persona::toString() {
	std::string edadS(std::to_string(edad));
	return " Nombre:" + nombre + " Apellido:" + apellido + " Edad:" + edadS + " Cedula:" + cedula + " Correo:" + correo;
}

std::string Persona::mostrarInformacion() {
	return  "Nombre: " + nombre + "\nApellido: " + apellido + "\nCedula: " + cedula;
}

Persona::~Persona()
{
   // TODO : implement
}