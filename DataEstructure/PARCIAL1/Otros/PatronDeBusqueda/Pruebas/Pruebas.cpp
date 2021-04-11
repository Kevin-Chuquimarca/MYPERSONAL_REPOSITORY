#include "MDinamicaNew.h"

#include <iostream>

void dibujarptrBusqueda(int** mat, int dx, int dy);
void dibujarptrAlineacion(int** mat);

void dibujarptrBusqueda(int** mat, int x, int y) {
	for (int dx = x; dx < x + 7; dx++) {
		for (int dy = y; dy < y + 7; dy++) {	
			if ((dx == x + 1 || dx == x + 5) && (dy > y && dy < y + 6)) {
				*(*(mat + dx) + dy) = 1;
			} else 
			if ((dy == y + 1 || dy == y + 5) && (dx > x && dx < x + 5)) {
				*(*(mat + dx) + dy) = 1;
			}
			else {
				*(*(mat + dx) + dy) = 0;
			}
		}
	}
}

void dibujarptrAlineacion(int** mat) {
	
}

int main()
{
	int** datos = {};
    MDinamicaNew obj_mat(datos, 41);
	datos =  obj_mat.get_mat();
	dibujarptrBusqueda(datos, 0, 0);
	dibujarptrBusqueda(datos, 34, 0);
	dibujarptrBusqueda(datos, 0, 34);
	obj_mat.imprimir();
}

