/********************************************
* UNIVERSIDAD DE LAS FUERZAS ARMADAS ESPE  *
* Programa principal para crear plantillas *
* Autor: Kevin Chuquimarca                 *
* Fecha: 2/12/2020                         *
* Fecha de modificacion: 3/12/2020         *
********************************************/

#ifndef SMARTPHONE_H_INCLUDED
#define SMARTPHONE_H_INCLUDED

#include <iostream>

template<class type, class type1, class type2> class SmartPhone{
	private:
		type name;
		type brand;
		type1 releaseYear;
		type color;
		type2 price;
	public:
	SmartPhone (type name1, type brand1, type1 releaseYear1, type color1, type2 price1){
		name= name1;
		brand= brand1;
		releaseYear= releaseYear1;
		color= color1;
		price=price1;
	}

	type getName(){
        return name;
	}

	type getBrand(){
        return brand;
	}

	type1 getReleaseYear(){
        return releaseYear;
	}

	type getColor(){
        return color;
	}

	type2 getPrice(){
        return price;
	}
};

#endif // SMARTPHONE_H_INCLUDED
