#ifndef LISTACIRCULAR_H
#define LISTACIRCULAR_H


#include "Nodo.h"
#include <iostream>

#include "Persona.h"

using namespace std;

template<class T>
class ListaCircular {
public:
	ListaCircular();
	~ListaCircular() {		}
	void insertar_inicio(T);
	void insertar_final(T);
	bool lista_vacia();
	void imprimir();
private:
	Nodo<T>* siguiente;
	Nodo<T>* primero;
	Nodo<T>* final;
};

template <class T>
ListaCircular<T>::ListaCircular(){
	this->primero= new Nodo<T>;
	this->final = new Nodo<T>;
	this->primero->set_siguiente(this->primero);
	this->final = this->primero;
}

template <class T>
void ListaCircular<T>::insertar_inicio(T d){
	Nodo<T>* aux = new Nodo<T>();
 	aux->set_dato(d);
	aux->set_siguiente(this->primero);
	this->final->set_siguiente(aux);
	this->primero = aux;
}

template <class T>
void ListaCircular<T>::insertar_final(T d){
	if(this->lista_vacia()){
		this->insertar_inicio(d);
	}else{
		Nodo<T>* aux = this->primero;
		Nodo<T>* aux2 = new Nodo<T>();	
		while(aux!= this->final){
			aux2 = aux;
			aux = aux->get_siguiente();
		}
		Nodo<T>* aux3 = new Nodo<T>(d, aux);
		aux2->set_siguiente(aux3);	
	}
}
	
template <class T>
void ListaCircular<T>::imprimir(){
	Nodo<T>* aux = this->primero;
	Persona per;
 	while(aux!= this->final)
 	{
		per = aux->get_dato();
		std::cout << "Nombre: " << per.getNombre() << std::endl;
		std::cout << "Apellido: " << per.getApellido() << std::endl;
		std::cout << "Cedula: " << per.getCedula() << std::endl << std::endl;
 		aux = aux->get_siguiente();
	}
}
template <class T>
bool ListaCircular<T>::lista_vacia(){
	if(this->primero->get_siguiente() == this->final){
		return true;
	}else{
		return false;
	}
}
#endif
