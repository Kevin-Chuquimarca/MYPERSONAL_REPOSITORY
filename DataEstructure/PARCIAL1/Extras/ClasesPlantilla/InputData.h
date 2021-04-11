/********************************************
* UNIVERSIDAD DE LAS FUERZAS ARMADAS ESPE  *
* Programa principal para crear plantillas *
* Autor: Kevin Chuquimarca                 *
* Fecha: 2/12/2020                         *
* Fecha de modificacion: 3/12/2020         *
********************************************/

#ifndef INPUTDATA_H_INCLUDED
#define INPUTDATA_H_INCLUDED

#include <stdio.h>
#include <iostream>
#include "Car.h"
#include "Date.h"
#include "Person.h"
#include "SmartPhone.h"
#include "Studient.h"

using namespace std;

class InputData{
	public:
	void chooseOption(){
		int option;
		do {
            printOptions();
			cout<<endl<<"Ingrese la opcion: ";
			cin>>option;
			switch (option){
				case 1:
					registerCar();
				break;
				case 2:
					registerDate();
				break;
				case 3:
				    registerPerson();
				break;
				case 4:
				    registerSmartPhone();
				break;
				case 5:
				    registerStudent();
				break;
				case 6:
                break;
				default:
					cout<<"opcion incorrecta";
				break;
			}
			cout<<endl<<endl;
			system("pause");
            system("cls");
		} while (option!=6);
	}
	void printOptions(){
		cout<<"1 Registrar un auto"<<endl;
		cout<<"2 Registrar una fecha"<<endl;
		cout<<"3 Registrar una persona"<<endl;
		cout<<"4 Registrar un telefono inteligente"<<endl;
		cout<<"5 Registrar un estudinate"<<endl;
		cout<<"6 Salir"<<endl;
	}
    void registerCar(){
        string name;
		string model;
		int releaseYear;
		float price;
		cout<<"nombre: ";
		cin>>name;
		cout<<"modelo: ";
		cin>>model;
		cout<<"anio de lanzamiento: ";
		cin>>releaseYear;
		cout<<"precio: ";
		cin>>price;
		Car<string, int, float> car(name, model, releaseYear, price);
	}
	void registerDate(){
	    int day, year;
	    string month;
		cout<<"dia: ";
		cin>>day;
		cout<<"mes: ";
		cin>>month;
		cout<<"anio: ";
		cin>>year;
		Date<int, string> date(day, month, year);
	}
	void registerPerson(){
	    int age, id;
	    string name, sex;
		cout<<"nombre: ";
		cin>>name;
		cout<<"edad: ";
		cin>>age;
		cout<<"id: ";
		cin>>id;
		cout<<"sexo: ";
		cin>>sex;
		Person<string, int> person(name, age, id, sex);
	}
	void registerSmartPhone(){
	    string name, brand,colour;
	    int releaseYear;
		float price;
	    cout<<"nombre: ";
		cin>>name;
		cout<<"marca: ";
		cin>>brand;
		cout<<"anio: ";
		cin>>releaseYear;
		cout<<"color: ";
		cin>>colour;
		cout<<"precio: ";
		cin>>price;
	    SmartPhone<string, int, float> sPhone(name, brand, releaseYear, colour, price);
	}
	void registerStudent(){
	    string name, schoolName;
		int age, level;
        cout<<"nombre: ";
		cin>>name;
		cout<<"edad: ";
		cin>>age;
		cout<<"Institucion: ";
		cin>>schoolName;
		cout<<"grado: ";
		cin>>level;
		Student<string, int> student(name, age, schoolName, level);
	}
};


#endif // INPUTDATA_H_INCLUDED
