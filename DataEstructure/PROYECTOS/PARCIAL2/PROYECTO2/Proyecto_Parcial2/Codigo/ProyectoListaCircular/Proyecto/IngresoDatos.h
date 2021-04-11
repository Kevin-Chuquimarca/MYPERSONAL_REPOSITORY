#pragma once
#include <string>
using namespace std;
class IngresoDatos
{
private:
	string text;
public:
	string IngresoTexto(string mensaje);
	string IngresoNumero(string mensaje);
	string IngresarCedula(string mensaje);
	bool validarCedula(string dato);
	int suma(int[]);
	bool anioBisiesto(int);
};

