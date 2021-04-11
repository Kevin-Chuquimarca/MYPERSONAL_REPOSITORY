#include <iostream>

#include "ListaCircular.h"
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
	void registrarPersona(ListaCircular<Persona>*);
	void qrPersona(ListaCircular<Persona>*);
	void generarBackUp(ListaCircular<Persona>*);
	void generarPdf(ListaCircular<Persona>*);
	void buscarDatos(ListaCircular<Persona>*);
	IngresoDatos objIngreso;
};

