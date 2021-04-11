/********************************************
* UNIVERSIDAD DE LAS FUERZAS ARMADAS ESPE  *
* Programa principal para crear plantillas *
* Autor: Kevin Chuquimarca                 *
* Fecha: 2/12/2020                         *
* Fecha de modificacion: 3/12/2020         *
********************************************/

#ifndef DATE_H_INCLUDED
#define DATE_H_INCLUDED

#include <iostream>

template<class type, class type1> class Date{
	private:
		type day;
		type1 month;
		type year;
	public:
	Date (type day1, type1 month1, type year1){
		day= day1;
		month= month1;
		year= year1;
	}

	type getDay(){
        return day;
	}

	type1 getMonth(){
        return month;
	}

	type getYear(){
        return year;
	}
};

#endif // DATE_H_INCLUDED
