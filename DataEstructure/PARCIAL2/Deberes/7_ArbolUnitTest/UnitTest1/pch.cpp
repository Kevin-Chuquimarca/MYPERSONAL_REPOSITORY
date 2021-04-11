// pch.cpp: el archivo de código fuente correspondiente al encabezado precompilado

#include "pch.h"

void postOr(const char* pre, const char* in, char* pos, int n) {
	int izq;
	if (n != 0) {
		*(pos + (n - 1)) = *(pre + 0);
		izq = strchr(in, *(pre + 0)) - in;
		postOr(pre + 1, in, pos, izq);
		postOr(pre + 1 + izq, in + 1 + izq, pos + izq, n - 1 - izq);
	}
}