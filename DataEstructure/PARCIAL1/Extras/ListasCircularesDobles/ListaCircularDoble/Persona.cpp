/***********************************************************************
 * Module:  Persona.cpp
 * Author:  ismae
 * Modified: mi�rcoles, 6 de enero de 2021 16:37:35
 * Purpose: Implementation of the class Persona
 ***********************************************************************/

#include "Persona.h"
#include <string>
#include<iostream>

using namespace std;


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



std::string Persona::getCorreo(void)
{
	return correo;
}



void Persona::setCorreo(std::string newCorreo)
{
	correo = newCorreo;

}


void Persona::get_persona(){
   cout<<"\n\n\tNombre: "<<nombre<<endl;
   cout<<"\tApellido: "<<apellido<<endl;
   cout<<"\tCedula: "<<cedula<<endl;
   cout<<"\Correo electronico: "<<correo<<endl;
   //cout<< edad.toString()<<endl;
   //edad.toString();
}