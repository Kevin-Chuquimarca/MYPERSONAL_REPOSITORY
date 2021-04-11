#include <string>
/***********************************************************************
 * Module:  Class_1.cpp
 * Author:  ismae
 * Modified: lunes, 4 de enero de 2021 8:57:46
 * Purpose: Implementation of the class Class_1
 ***********************************************************************/

#include "Persona.h"

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

std::string Persona::getCedula(void)
{
   return cedula;
}

void Persona::setCedula(std::string newCedula)
{
   cedula = newCedula;
}

Persona::Persona()
{
}

Persona::~Persona()
{
   // TODO : implement
}