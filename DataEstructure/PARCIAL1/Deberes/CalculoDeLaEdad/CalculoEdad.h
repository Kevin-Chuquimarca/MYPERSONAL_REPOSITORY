#ifndef CALCULOEDAD_H_INCLUDED   
#define CALCULOEDAD_H_INCLUDED

#include"Fecha.h"

#include "Fecha.h"
#include<iostream>

template<class T>
class CalculoEdad
{
public:
	CalculoEdad();
	Fecha<T> calc_edad(Fecha<T>);
	bool validar_anio(T);
	bool validar_mes(T);
	bool validar_dia(T);
	T get_edad_anios();
	T get_edad_meses();
	T get_edad_dias();
	std::string get_edad();
private:
	T edad_anios;
	T edad_meses;
	T edad_dias;
};

template<class T>
CalculoEdad<T>::CalculoEdad() {
	this->edad_anios = 0;
	this->edad_meses = 0;
	this->edad_dias = 0;
}

template<class T>
Fecha<T> CalculoEdad<T>::calc_edad(Fecha<T> obj_fn) {
	Fecha<T> obj_fa;
	obj_fa.generar_fecha();
	if (obj_fa.get_mes() >= obj_fn.get_mes()) {
		edad_meses = obj_fa.get_mes() - obj_fn.get_mes();
		edad_anios = obj_fa.get_anio() - obj_fn.get_anio();
	}
	else {
		edad_meses = obj_fa.get_mes() - obj_fn.get_mes() + 12;
		edad_anios = obj_fa.get_anio() - obj_fn.get_anio() - 1;
	}
	edad_dias = obj_fa.get_dia() - obj_fn.get_dia() + 1;
	if (edad_dias < 0) {
		edad_dias = edad_dias * (-1);
	}
	Fecha<T> obj_edad(edad_dias, edad_meses, edad_anios);
	return obj_edad;
}

template<class T>
bool CalculoEdad<T>::validar_anio(T anio) {
	Fecha<T> obj_fa;
	obj_fa.generar_fecha();
	if (obj_fa.get_anio() > anio && anio > 1921) {
		return true;
	}
	return false;
} 

template<class T>
bool CalculoEdad<T>::validar_mes(T mes) {
	if (mes > 0 && mes < 13) {
		return true;
	}
	return false;
}

template<class T>
bool CalculoEdad<T>::validar_dia(T dia) {
	if (dia > 0 && dia < 32) {
		return true;
	}
	return false;
}

template<class T>
T CalculoEdad<T>::get_edad_anios() {
	return edad_anios;
}

template<class T>
T CalculoEdad<T>::get_edad_meses() {
	return edad_meses;
}

template<class T>
T CalculoEdad<T>::get_edad_dias() {
	return edad_dias;
}

template<class T>
std::string CalculoEdad<T>::get_edad() {
	std::string e_anio(std::to_string(edad_anios));
	std::string e_mes(std::to_string(edad_meses));
	std::string e_dia(std::to_string(edad_dias));
	return "anios: " + e_anio + " meses: " + e_mes + " dias: " + e_dia + "\n";
}

#endif