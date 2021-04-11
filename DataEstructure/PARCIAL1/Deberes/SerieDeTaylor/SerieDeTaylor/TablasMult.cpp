#include "TablasMult.h"
#include <stdio.h>

TablasMult::TablasMult(int x, int y) {
	this->x = x;
	this->y = y;
	serie = md.reservar_m(x);
	tablas = md.reservar_m(x, y);
	md.encerar(serie, x);
	md.encerar(tablas, x, y);
	get_serie();
	get_tabla();
}

void TablasMult::get_tabla() {
	for (int i = 0; i < x; i++) {
		for (int j = 0; j < y; j++) {
			*(*(tablas + i) + j) = (*(serie + j)) * (i + 1);
		}
	}
}

void TablasMult::get_serie() {
	for (int i = 0; i < x; i++) {
		*(serie + i) = i + 1;
	}
}

void TablasMult::imprimir_tablas() {
	for (int i = 0; i < x; i++) {
		for (int j = 0; j < y; j++) {
			printf_s("%d ", *(*(tablas + i) + j));
		}
		printf_s("\n");
	}
}

TablasMult::~TablasMult() {
	md.liberar_m(serie);
	md.liberar_m(tablas, x);
}