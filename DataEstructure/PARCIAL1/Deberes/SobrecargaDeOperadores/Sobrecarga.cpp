/*********************************************************************************
* UNIVERSIDAD DE LAS FUERZAS ARMADAS ESPE								  	     *
* Programa principal para sumar 2 vectores y el control de pago de 2 trbajadores *
* por medio de sobrecarga de operadores											 *
* Autor: Kevin Chuquimarca													     *
* Fecha: 15/12/2020															     *
* Fecha de modificacion: 15/12/2020												 *
**********************************************************************************/

#include <iostream>
#include "Vector.h"
#include "Persona.h"
using namespace std;

int main()
{
	Vector vec_0(3, 1), vec_1(1, 2), vec_r;
	vec_r = vec_0 + vec_1;
	vec_r.ImprimeVector();
	vec_r = vec_0 - vec_1;
	vec_r.ImprimeVector();
	vec_r = vec_0 * vec_1;
	vec_r.ImprimeVector();
	vec_r = vec_0 / vec_1;
	vec_r.ImprimeVector();

	Persona per_0("Luis", 360.0, 13.84, 26, 20.0), per_1("Marta", 460.0, 17.69, 26, 10.0), per_r;
	float a = per_0 + per_1;
	cout << "El salario total de los 2 trabajadores es: " << a<<endl;
	float b = per_0 - per_1;
	cout << "El salario total de los 2 trabajadores menos las multas es: " << b << endl;
	float c = per_0 * per_1;
	cout << "El total de multas de los 2 trabajadores es: " << c << endl;
	float d = per_0 / per_1;
	cout << "El promedio del salario diario de los 2 trabajadores es: " << d << endl;
}
