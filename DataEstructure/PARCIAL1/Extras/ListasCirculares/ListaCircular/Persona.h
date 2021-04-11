#pragma once

#include <string>

using namespace std;

class Persona
{
public:
	std::string getNombre(void);
	void setNombre(std::string newNombre);
	std::string getApellido(void);
	void setApellido(std::string newApellido);
	std::string getCedula(void);
	void setCedula(std::string newCedula);
	std::string getCorreo(void);
	void setCorreo(std::string newCorreo);
	void mostrarInformacion();
protected:
private:
	std::string nombre;
	std::string apellido;
	std::string cedula;
	std::string correo;
};

