#include <iostream>

#include "Lista.h"
#include "IngresoDatos.h"
#include "Persona.h"
#include "CalculoEdad.h"
#include "DireccionCorreo.h"
#include "GenerarQR.h"
#include "Archivo.h"
#include "Secuencial.h"

class Operaciones
{
public:
	void registrarPersona(Lista<Persona>*);
	void qrPersona(Lista<Persona>*);
	void generarBackUp(Lista<Persona>*);
	void generarPdf(Lista<Persona>*);
	void buscarDatos(Lista<Persona>*);
	IngresoDatos objIngreso;
};

