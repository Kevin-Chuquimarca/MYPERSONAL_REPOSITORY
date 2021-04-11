#pragma once
#include "Fecha.h"
#include "Hora.h"
#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <fstream>
#include <string>
#pragma warning(disable : 4996)

using namespace std;
template <class T>
class Archivo
{
public:
	Archivo();
	void abrirArchivo(string nombreArchivo);
	void escribirEnArchivo(string, T dato);
	void contDato(T dato);
	void setContador(T cont) { this->contador = cont; }
	int getContador() { return this->contador; }
	void generarBackUp();
	void generarPDF(T dato);
	void eliminarPDF();
private:
	int contador;
	FILE* newArchivo;
	fstream archivo;
	Fecha fecha;
	Hora hora;
};

template <class T>
Archivo<T>::Archivo() {
	this->contador = 0;
}

template <class T>
void Archivo<T>::abrirArchivo(string nombreArchivo) {
	newArchivo = fopen(nombreArchivo.c_str(), "a");
	if (newArchivo == NULL) {
		cout << "No se puede abrir el fichero.\n";
	}
	fclose(newArchivo);
}

template <class T>
void Archivo<T>::eliminarPDF() {
	newArchivo = fopen("Personas.pdf", "a");
	if (newArchivo == NULL) {
		cout << "No se puede abrir el fichero.\n";
	}
	fclose(newArchivo);
	remove("Personas.pdf");

}

template <class T>
void Archivo<T>::generarPDF(T dato) {
	newArchivo = fopen("Personas.pdf", "a");
	if (newArchivo == NULL) {
		cout << "No se puede abrir el fichero.\n";
	}
	fputs("Todas las personas de esta lista : \n", newArchivo);
	fputs(dato.c_str(), newArchivo);
	fputs("\n", newArchivo);
	fclose(newArchivo);

}

template <class T>
void Archivo<T>::escribirEnArchivo(string  nombreArchivo, T dato) {
	newArchivo = fopen(nombreArchivo.c_str(), "a");
	if (newArchivo == NULL) {
		cout << "No se puede abrir el fichero.\n";
	}
	fputs(dato.c_str(), newArchivo);
	fputs("\n", newArchivo);
	fclose(newArchivo);

}

template <class T>
void Archivo<T>::contDato(T dato) {
	ifstream buscar;
	string cadena;
	buscar.open("Personas.txt");
	while (!buscar.eof())
	{
		buscar >> cadena;
		if (cadena == dato)
		{
			this->contador++;
		}
	}
	buscar.close();
}
template <class T>
void Archivo<T>::generarBackUp() {
	fecha.generarFecha();
	hora.generarHora();
	string fechaEnFormato = to_string(fecha.getDia()) + "-" + to_string(fecha.getMes()) + "-" + to_string(fecha.getAnio());
	cout<< endl << fechaEnFormato +" "+ hora.getHora()<<endl;
	string nombreArchivo = fechaEnFormato +" " + hora.getHora() + ".txt";
	FILE* file1, * file2;
	int data1 = 0;

	file1 = fopen("PersonasLC.txt", "r");
	file2 = fopen(nombreArchivo.c_str(), "w");

	while ((data1 = fgetc(file1)) != EOF) {
		fputc(data1, file2);
	}

	fclose(file1);
	fclose(file2);
}

