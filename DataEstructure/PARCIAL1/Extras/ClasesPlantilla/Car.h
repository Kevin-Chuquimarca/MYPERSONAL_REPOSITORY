/********************************************
* UNIVERSIDAD DE LAS FUERZAS ARMADAS ESPE  *
* Programa principal para crear plantillas *
* Autor: Kevin Chuquimarca                 *
* Fecha: 2/12/2020                         *
* Fecha de modificacion: 3/12/2020         *
********************************************/

#ifndef CAR_H_INCLUDED
#define CAR_H_INCLUDED

#include <iostream>

template<class type, class type1, class type2> class Car{
	private:
		type name;
		type model;
		type1 releaseYear;
		type2 price;
	public:
	Car (type name1, type model1, type1 releaseYear1, type2 price1){
		name= name1;
		model= model1;
		releaseYear= releaseYear1;
		price=price1;
	}

	type getName(){
        return name;
	}

	type getModel(){
        return model;
	}

	type1 getReleaseYear(){
        return releaseYear;
	}

	type2 getPrice(){
        return price;
	}
};

#endif // CAR_H_INCLUDED
