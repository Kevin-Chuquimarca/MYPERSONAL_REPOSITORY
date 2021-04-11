#ifndef PERSONA_H
#define PERSONA_H

#include <iostream>

class Persona
{
private:
	std::string nombre;
	std::string apellido;
	int edad;
	std::string cedula;
	std::string correo;
public:
	Persona();
	Persona(std::string, std::string, int, std::string, std::string);
	std::string getNombre(void);
	void setNombre(std::string newNombre);
	std::string getApellido(void);
	void setApellido(std::string newApellido);
	int getEdad(void);
	void setEdad(int newEdad);
	std::string getCedula(void);
	void setCedula(std::string newCedula);
	std::string getCorreo(void);
	void setCorreo(std::string newCorreo);
	std::string toString();
	std::string mostrarInformacion();
	~Persona();
};

#endif