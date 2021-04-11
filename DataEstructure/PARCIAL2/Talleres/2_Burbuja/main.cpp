/***************************************************************
* UNIVERSIDAD DE LAS FUERZAS ARMADAS ESPE                      *
* Programa principal para ordenar numero por Burbuja		   *
* Autor: Kevin Chuquimarca                                     *
* Fecha: 28/01/2021                                            *
* Fecha de modificacion: 28/01/2021                            *
****************************************************************/

#include <iostream>
#include <stdlib.h>
#include <stdio.h>
#include <conio.h>
#include <time.h>

void encerar(int[]);
void generar(int[]);
void ordenar(int[]);
void imprimir(int[]);
void ordenar2(int[]);

void encerar(int vector[]){
	for (int i=0;i<10;i++)
	vector[i]=0;
}
void generar(int vector[]){
	srand(time(NULL));
	for (int i=0;i<10;i++){
		vector[i]=1+rand()%10;  //se suma 1 para que no salga el 0
	}
}
void ordenar(int vector[]){
	int aux=0, cont=0;
	for (int i=0;i<10;i++)
	for (int j=0;j<10;j++){
		if(vector[i]<vector[j]){
			aux=vector[i];
			vector[i]=vector[j];
			vector[j]=aux;
		}	
		cont++;
	}
	std::cout<<"numero de comparaciones: "<<cont<<std::endl;
}
void ordenar2(int vector[]){
	int aux=0, cont=0;
	for (int i=0;i<10;i++)
	for (int j=i+1;j<10;j++){
		if(vector[i]>vector[j]){
			aux=vector[i];
			vector[i]=vector[j];
			vector[j]=aux;
		}	
		cont++;
	}
	std::cout<<"numero de comparaciones: "<<cont<<std::endl;
}
void imprimir(int vector[]){
	std::cout<<"{";
	for (int i=0;i<10;i++)	//se ejecuta la siguinete linea del for
	std::cout<<vector[i]<<" ";
	std::cout<<"}"<<std::endl;
}

int main(int argc, char** argv) {
	int vector[10];
	encerar(vector);
	imprimir(vector);
	generar(vector);
	imprimir(vector);
	ordenar(vector);
	imprimir(vector);
	ordenar2(vector);
	imprimir(vector);
	return 0;
}
