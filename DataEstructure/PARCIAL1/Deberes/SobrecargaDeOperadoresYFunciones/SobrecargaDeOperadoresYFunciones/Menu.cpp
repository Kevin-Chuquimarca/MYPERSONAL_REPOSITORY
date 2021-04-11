#include "Menu.h"
#include "Operadores.h"
#include <iostream>

using namespace std;

void Menu::escoger_opcion() {
	int option = 0;
	do {
		cout << "1: vector int" << endl << "2: vector float" << endl << "3: salir" << endl;
		cin >> option;
		switch (option)
		{
		case 1:
			calcular_int();
			break;
		case 2:
			calcular_float();
			break;
		}
	} while (option != 3);
}
void Menu::calcular_int() {
	int sum = 0, res = 0;
	float modulo = 0.0, mod_vec_u = 0.0;
	int vec_1[3] = {};
	cout << "ingrese el valor de x: " << endl;
	cin >> vec_1[0];
	cout << "ingrese el valor de y: " << endl;
	cin >> vec_1[1];
	cout << "ingrese el valor de z: " << endl;
	cin >> vec_1[2];
	Operadores obj_op;
	sum = obj_op + vec_1;
	res = obj_op - vec_1;
	modulo = obj_op * vec_1;
	mod_vec_u = obj_op / vec_1;
	cout << "la suma de los valores xyz es: " << sum << endl;
	cout << "la resta de los valores xyz es: " << res << endl;
	cout << "el modulo de los valores xyz es: " << modulo << endl;
	cout << "el modulo del unitario de los valores xyz es: " << mod_vec_u << endl;
}
void Menu::calcular_float() {
	float vec_2[3] = {};
	float sum = 0, res = 0, modulo = 0.0, mod_vec_u = 0.0;
	cout << "ingrese el valor de x: " << endl;
	cin >> vec_2[0];
	cout << "ingrese el valor de y: " << endl;
	cin >> vec_2[1];
	cout << "ingrese el valor de z: " << endl;
	cin >> vec_2[2];
	Operadores obj_op;
	sum = obj_op + vec_2;
	res = obj_op - vec_2;
	modulo = obj_op * vec_2;
	mod_vec_u = obj_op / vec_2;
	cout << "la suma de los valores xyz es: " << sum << endl;
	cout << "la resta de los valores xyz es: " << res << endl;
	cout << "el modulo de los valores xyz es: " << modulo << endl;
	cout << "el modulo del unitario de los valores xyz es: " << mod_vec_u << endl;
}