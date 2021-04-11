/*#ifndef PERSON_CPP_INCLUDED   
#define PERSON_CPP_INCLUDED
#include "Persona.h"

template<class T, class T1, class T2>
Persona<T, T1, T2>::Persona(T cedula, T1 nombre, T1 apellido, T1 direccion, T telefono, T2 sueldo) {
	this-> cedula = cedula;
	this-> nombre = nombre;
	this-> apellido = apellido;
	this-> direccion = direccion;
	this-> telefono = telefono;
	this-> sueldo = sueldo;
}

template<class T, class T1, class T2>
void Persona<T, T1, T2>::setCedula(T cedula) {
	this -> cedula = cedula;
}
template<class T, class T1, class T2>
void Persona<T, T1, T2>::setNombre(T1 nombre) {
	this-> nombre = nombre;
}
template<class T, class T1, class T2>
void Persona<T, T1, T2>::setApellido(T1 apellido) {
	this-> apellido = apellido;
}
template<class T, class T1, class T2>
void Persona<T, T1, T2>::setDireccion(T1 direccion) {
	this-> direccion = direccion;
}
template<class T, class T1, class T2>
void Persona<T, T1, T2>::setTelefono(T telefono) {
	this-> telefono = telefono;
}
template<class T, class T1, class T2>
void Persona<T, T1, T2>::setSueldo(T2 sueldo) {
	this-> sueldo = sueldo;
}
template<class T, class T1, class T2>
T Persona<T, T1, T2>::getCedula() {
	return cedula;
}
template<class T, class T1, class T2>
T1 Persona<T, T1, T2>::getNombre() {
	return nombre;
}
template<class T, class T1, class T2>
T1 Persona<T, T1, T2>::getApellido() {
	return apellido;
}
template<class T, class T1, class T2>
T1 Persona<T, T1, T2>::getDireccion() {
	return direccion;
}
template<class T, class T1, class T2>
T Persona<T, T1, T2>::getTelefono() {
	return telefono;
}
template<class T, class T1, class T2>
T2 Persona<T, T1, T2>::getSueldo() {
	return sueldo;
}
#endif;*/