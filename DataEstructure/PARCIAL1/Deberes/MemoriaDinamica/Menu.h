#ifndef MENU_H_INCLUDED
#define MENU_H_INCLUDED

# include <stdio.h>
#include "MatrizDinamica.h"
#include "OperacionMatriz.h"
#include "TMatrizDinamica.h"
#include "TOperacionMatriz.h"
#include "MDinamicaNew.h"

class Menu {
	public:
		void selec_opcion();
		void procesar_clases();
		void procesar_templates();
		void reservar_m_new();
};

#endif