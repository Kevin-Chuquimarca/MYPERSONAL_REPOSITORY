#ifndef PERSONA_H_INCLUDED
#define PERSONA_H_INCLUDED
#include <iostream>

using namespace std;

class Persona {
	private:
		string nombre;
		float salario_mensual;
		float salario_diario;
		int dias_trabajo;
		float multas;
	public:
		Persona(string nombre  = " ", float salario_mensual = 0, float salario_diario = 0, int dias_trabajo = 26, float multas = 0);
		float operator+(Persona per);
		float operator-(Persona per);
		float operator*(Persona per);
		float operator/(Persona per);
};
Persona::Persona(string nombre, float salario_mensual, float salario_diario, int dias_trabajo, float multas) {
	this->nombre = nombre;
	this->salario_mensual = salario_mensual;
	this-> salario_diario = salario_diario;
	this->dias_trabajo = dias_trabajo;
	this->multas = multas;
}
float Persona::operator+ (Persona per) {
	return (salario_mensual + per.salario_mensual);
}
float Persona::operator-(Persona per) {
	return ((salario_mensual - multas) + (per.salario_mensual - per.multas));
}
float Persona::operator*(Persona per) {
	return (multas + per.multas);
}
float Persona::operator/(Persona per) {
	return ((salario_mensual / dias_trabajo) + (per.salario_mensual / per.dias_trabajo));
}
#endif;