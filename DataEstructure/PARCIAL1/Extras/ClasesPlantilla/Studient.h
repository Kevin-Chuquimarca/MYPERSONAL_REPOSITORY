/********************************************
* UNIVERSIDAD DE LAS FUERZAS ARMADAS ESPE  *
* Programa principal para crear plantillas *
* Autor: Kevin Chuquimarca                 *
* Fecha: 2/12/2020                         *
* Fecha de modificacion: 3/12/2020         *
********************************************/

#ifndef STUDIENT_H_INCLUDED
#define STUDIENT_H_INCLUDED

#include <iostream>

template<class type, class type1> class Student{
    private:
		type name;
		type1 age;
		type schoolName;
		type1 level;
	public:
	Student (type name1, type1 age1, type schoolName1, type1 level1){
		name= name1;
		age= age1;
		schoolName= schoolName1;
		level=level1;
	}

	type getName(){
        return name;
	}

	type1 getAge(){
        return age;
	}

	type getSchoolName(){
        return schoolName;
	}

	type1 getLevel(){
        return level;
	}
};

#endif // STUDIENT_H_INCLUDED
