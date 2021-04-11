/********************************************
* UNIVERSIDAD DE LAS FUERZAS ARMADAS ESPE  *
* Programa principal para crear plantillas *
* Autor: Kevin Chuquimarca                 *
* Fecha: 2/12/2020                         *
* Fecha de modificacion: 3/12/2020         *
********************************************/

#ifndef PERSON_H_INCLUDED
#define PERSON_H_INCLUDED

#include <iostream>

template<class type, class type1> class Person{
	private:
		type name;
		type1 age;
		type1 id;
		type sex;
	public:
	Person (type name1, type1 age1, type1 id1, type sex1){
		name= name1;
		age= age1;
		id= id1;
		sex=sex1;
	}

	type getName(){
        return name;
	}

	type1 getAge(){
        return age;
	}

	type1 getId(){
        return id;
	}

	type getSex(){
        return sex;
	}
};

#endif // PERSON_H_INCLUDED
