#include "ExcepcionDefault.h"

float ExcepcionDefault::dividir(float num, float den) {
	if (den == 0) {
		throw "Division para cero no definida";
	}
	return num / den;
}