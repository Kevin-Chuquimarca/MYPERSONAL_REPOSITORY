#pragma once
#include "Transferencia.h"
#include "Cuenta.h"

class Deposito : public Transferencia
{

public:
	void movimiento(Lista*, string);

};

