#include "IngresoDatos.h"
#include<iostream>
#include <conio.h>
#include <sstream> 

using namespace std;

string IngresoDatos::IngresoTexto(string mensaje) {
    string text = "";
    char letter = {};
    do {
        cout << endl << mensaje;
        do {
            letter = _getche();
            if ((letter < 91 && letter > 64) || (letter < 123 && letter > 96)) {
                text.push_back(letter);
            }
            if (text != "" && letter == 8) {
                text.pop_back();
            }
        } while (text !="" && letter != 13);
    } while (text == "");
    return text;
}

string IngresoDatos::IngresoNumero(string mensaje) {
    string num = "";
    char dig = {};
    do {
        cout << endl << mensaje;
        do {
            dig = _getche();
            if (dig < 58 && dig > 47) {
                num.push_back(dig);
            }
            if (num != "" && dig == 8) {
                num.pop_back();
            }
        } while (num != "" && dig != 13);
    } while (num == "");
    return num;
}

string IngresoDatos::IngresarCedula(string mensaje) {
    std::string dato;
    do
    {
        dato = IngresoNumero("Ingrese numero de cedula: ");
    } while (dato == "" || dato.size() != 10 || !validarCedula(dato));
    return dato;
}

bool IngresoDatos::validarCedula(string dato) { 
    int cedula[10] = {};
    string aux;
    for (int i = 0; i < 10; i++) {
        aux = dato[i];
        cedula[i] = stoi(aux);
    }
    int verif[10] = {}, num, i;
    if (cedula[2] < 0 || cedula[2]>6) {

        return false;
    }
    if (cedula[0] < 0 || cedula[0]>2) {

        return false;
    }
    if (cedula[0] == 2 && (cedula[1] < 1 || cedula[1]>4)) {

        return false;
    }
    for (i = 0; i <= 8; i++) {
        if (i % 2 == 0) {
            verif[i] = cedula[i] * 2;
            if (verif[i] >= 10) {
                verif[i] = verif[i] - 9;

            }
        }
        else {
            verif[i] = cedula[i] * 1;
            if (verif[i] >= 10) {
                verif[i] = verif[i] - 9;

            }
        }
    }

    verif[9] = 90 - suma(verif);
    num = verif[9] % 10;
    if (cedula[9] == num) {

        return true;
    }
    else {

        return false;
    }
    return false;
}
int IngresoDatos::suma(int verif2[9]) {
    int i, suma = 0;
    for (i = 0; i <= 8; i++) {
        suma = suma + verif2[i];
    }
    return suma;
}

bool IngresoDatos::anioBisiesto(int anio) {
    return (anio % 4 == 0 && anio % 100 != 0 || anio % 400 == 0) ? true : false;
}

