#if !defined(__File_h)
#define __File_h
#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <fstream>
using namespace std;

template <class T>
class File
{
	public:
		File();
		void crearArchivo();
		void mostrar(T** tablero, T n);
		void escribir(T dato, T dato1, T dato2, T dato3);
		void escribir(T dato);
	private :
	int contador;
	fstream archivo;	
};
/**@brief  Constructor
@param void 
@returns void
*/
template <class T>
File<T>::File(){
	
}
/**@brief  Crea un archivo
@param void 
@returns void
*/
template <class T>
void File<T>::crearArchivo(){
	archivo.open("solucion.txt",fstream::out); //para leer in, para salir es out escribir
	contador=0;	
}
/**@brief  Escribe una matriz en un archivo
@param  T** tablero
@param  T n 
@returns void
*/
template <class T>
void File<T>::mostrar(T ** tablero, T n){
	   	contador++;
	   	archivo<<"Solucion "<<contador<<endl;
	   	for(int i=0;i<n;i++){
	   		for(int j=0;j<n;j++){
	   			archivo<<*(*(tablero+i)+j)<<"  ";
			   }
			   archivo<<endl;
		   }
}
/**@brief  escribe un dato en un archivo
@param  T dato
@param  T dato1
@param  T dato2
@param  T dato3
@returns void
*/
template <class T>
void File<T>::escribir(T dato, T dato1, T dato2, T dato3){
	archivo<<"Mover disco: "<< dato<<" de la torre: "<<dato1<<" hacia la torre: "<<dato3<<endl;
}
/**@brief  escribe un dato en un archivo
@param  T dato
@returns void
*/
template <class T>
void File<T>::escribir(T dato){
	archivo<<"Numero de pasos: "<<dato<<endl;
}
#endif 
