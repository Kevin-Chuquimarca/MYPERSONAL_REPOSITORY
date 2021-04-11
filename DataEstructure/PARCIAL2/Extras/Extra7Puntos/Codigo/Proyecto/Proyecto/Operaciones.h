#include <iostream>

#include "ListaDoble.h"
#include "IngresoDatos.h"
#include "Persona.h"
#include "CalculoEdad.h"
#include "DireccionCorreo.h"
#include "GenerarQR.h"
#include "Quicksort.h"
#include "Archivo.h"
#include "Secuencial.h"

class Operaciones
{
public:
	void registrarPersona(ListaDoble<Persona>*);
	void qrPersona(ListaDoble<Persona>*);
	void generarBackUp(ListaDoble<Persona>*);
	void generarPdf(ListaDoble<Persona>*);
	void buscarDatos(ListaDoble<Persona>*);
	IngresoDatos objIngreso;
};

