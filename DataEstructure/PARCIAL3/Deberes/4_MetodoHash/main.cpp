/*********************************************
*  UNIVERSIDAD DE LAS FUERZAS ARMADAS ESPE   *
*  metodo para generar claves HASH     		 *
*  Autor: Kevin Chuquimarca					 *
*  Fecha de creacion: 22/03/2021             *
*  Fecha de modificacion: 22/03/2021         *
*********************************************/

#include <iostream>
#include <conio.h>

#include "Vector.h"

int metodoHash(int*, int);

int metodoHash(int* vec, int dim){
	int contenedor = 0, aux = -10;
	for(int i = 0; i<dim; i++)
		contenedor += *(vec + i);
	do{
		aux += 10;
	} while (aux<=(contenedor - 10));
	contenedor = contenedor-(aux);
	return contenedor + aux/10;
}

int main(int argc, char** argv) {
	Vector<int> vc;
	int *vec, dim = 10;
	vec = vc.reservar(dim);
	vc.encerar();
	std::cout<<"\nIngrese numeros: ";
	for(int i = 0; i<dim; i++){
		*(vec + i) = getche() - 48;
		if(*(vec + i)==-35){
			*(vec + i) = 0;
			i = dim;
		}
	}
	std::cout<<"\nResultado: " << metodoHash(vec, dim);	
	return 0;
}
