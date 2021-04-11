
#if !defined(__File_h)
#define __File_h
#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <fstream>
#include <string>
using namespace std;
template <class T>
class File
{
	public:
		File();
		void openFile(string fileName);
		void writeData( string,T data);
		void writeDataNatural(T);
		void writeDataLegal(T);
		void contData(T tada);
		void setContador(T cont){this->contador = cont;}
		int getContador(){return this->contador;}
		void makebackUp();
		void makePDF(T data);
		void removePDF();
	private :
	int contador;
	FILE* newFile;
	fstream archivo;
	Date date;

};
/**@brief  Constructor
@param void
@returns void
*/
template <class T>
File<T>::File(){
	this->contador = 0;
}
/**@brief  Crea un archivo
@param void
@returns void
*/

template <class T>
void File<T>::openFile(string fileName){
    newFile = fopen(fileName.c_str(), "a");
    if (newFile == NULL) {
		cout<< "No se puede abrir el fichero.\n";
	}
    fclose(newFile);
}
/**@brief  escribe un dato en un archivo
@param  T** tablero
@param  T n
@returns void
*/
template <class T>
void File<T>::removePDF(){
	newFile = fopen("EstadoCuenta.pdf" , "a");
    if (newFile == NULL) {
		cout<< "No se puede abrir el fichero.\n";
	}
	fclose(newFile);
	remove("EstadoCuenta.pdf");

}
/**@brief  escribe un dato en un archivo
@param  T** tablero
@param  T n
@returns void
*/
template <class T>
void File<T>::makePDF(T data){
	newFile = fopen("EstadoCuenta.pdf" , "a");
    if (newFile == NULL) {
		cout<< "No se puede abrir el fichero.\n";
	}
	fputs("Todas las transacciones de esta cuenta son : \n", newFile);
	fputs(data.c_str(), newFile);
	fputs("\n", newFile);
	fclose(newFile);

}
/**@brief  escribe un dato en un archivo
@param  T** tablero
@param  T n
@returns void
*/
template <class T>
void File<T>::writeData(string  fileName, T data) {
	newFile = fopen(fileName.c_str(), "a");
	if (newFile == NULL) {
		cout << "No se puede abrir el fichero.\n";
	}
	fputs(data.c_str(), newFile);
	fputs("\n", newFile);
	fclose(newFile);

}
/**@brief  escribe un dato en un archivo
@param  T** tablero
@param  T n
@returns void
*/
template <class T>
void File<T>::writeDataNatural(T data) {
	newFile = fopen("NaturalPerson.txt", "a");
	if (newFile == NULL) {
		cout << "No se puede abrir el fichero.\n";
	}
	fputs(data.c_str(), newFile);
	fputs("\n", newFile);
	fclose(newFile);

}
/**@brief  escribe un dato en un archivo
@param  T** tablero
@param  T n
@returns void
*/
template <class T>
void File<T>::writeDataLegal(T data) {
	newFile = fopen("LegalPerson.txt", "a");
	if (newFile == NULL) {
		cout << "No se puede abrir el fichero.\n";
	}
	fputs(data.c_str(), newFile);
	fputs("\n", newFile);
	fclose(newFile);

}

/**@brief  Cuenta los datos iguales en un archivo
@param  T** tablero
@param  T n
@returns void
*/
template <class T>
void File<T>::contData(T data){
	ifstream buscar;
	string cadena;
    buscar.open("NaturalPerson.txt");
    while(!buscar.eof())
    {
        buscar>>cadena;
    	if (cadena==data)
    	{
     		this->contador++;
    	}
    }
        buscar.close();
}
/**@brief BackUp
@param  string
@returns void
*/
template <class T>
void File<T>::makebackUp(){
	string fileName = date.namefile();
	string s, s1;
	string aux1, aux2;
	archivo.open(fileName.c_str(), fstream::out);
	cout << "Natural Person" << endl;
	ifstream f("NaturalPerson.txt");
	if (f.is_open()) {
		getline(f, s);
		//cout << s << endl;
		while (!f.eof()) {
			//cout << s << endl;
			archivo << s << endl;
			getline(f, s);
		}
	}
	cout << "Legal Person" << endl;
	ifstream f1("LegalPerson.txt");
	if (f1.is_open()) {
		getline(f1, s1);
		//cout << s1 << endl;
		while (!f1.eof()) {
			//cout << s1 << endl;
			archivo << s1 << endl;
			getline(f1, s1);
		}
	}
}
#endif