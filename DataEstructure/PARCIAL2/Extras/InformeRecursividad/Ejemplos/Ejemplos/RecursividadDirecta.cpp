#include "RecursividadDirecta.h"

int RecursividadDirecta::producto(int a, int b) {
	if (b == 1)
		return a;
	else
		return a + producto(a, b - 1);
}

float RecursividadDirecta::fibonacci(float n)
{
	if (n < 0)
		return -1;
	if (n == 0)
		return(0);
	else
		if (n == 1)
			return(1);
		else
			return fibonacci(n - 1) + fibonacci(n - 2);
}