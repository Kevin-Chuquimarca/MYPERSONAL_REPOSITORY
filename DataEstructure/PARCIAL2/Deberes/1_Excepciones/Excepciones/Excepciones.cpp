/***************************************************
* UNIVERSIDAD DE LAS FUERZAS ARMADAS ESPE          *
* Programa principal para el manejo de excepciones *
* Autor: Kevin Chuquimarca                         *
* Fecha: 20/01/2021                                *
* Fecha de modificacion: 20/01/2021                *
****************************************************/

#include "MiExcepcion.h"
#include "ExcepcionDefault.h"
#include "ExcepcionSistema.h"

#include <iostream>

int main()
{
    int x = 50;
    int y = 0;
    double z = 0;
    ExcepcionDefault edft;
    ExcepcionSistema estm;
   /* try                           //crear excepciones
    {
        throw MiExcepcion();
    }
    catch (MiExcepcion& e)
    {
        std::cout << "Mi Excepcion creada" << std::endl;
        std::cout << e.what() << std::endl;
    }
    catch (std::exception& e)
    {
        //otros errores
    }
    try                             //errores por default, definidas por el programador
    {
        z = edft.dividir(x, y);
        std::cout << z << endl;
    }
    catch (const char* msg) {
        cerr << msg << endl;
    }*/
    estm.abrir_cerrar_arch();       //errores del sistema
}
