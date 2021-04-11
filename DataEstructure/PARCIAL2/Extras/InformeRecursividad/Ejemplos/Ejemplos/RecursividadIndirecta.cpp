#include "RecursividadIndirecta.h"

void RecursividadIndirecta::imprimirAlf(int c)
{
	if (c > 'A')
		decrecerAlf(c);
	putchar(c);
}

void RecursividadIndirecta::decrecerAlf(int c)
{
	imprimirAlf(--c);
}