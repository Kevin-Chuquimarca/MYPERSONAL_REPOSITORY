#ifndef FECHAACTUAL_H 
#define FECHAACTUAL_H

#include <stdio.h>
#include <string>
#include <time.h>

class Fecha {
    private:
        int anio;
        int mes;
        int dia;
    public:
        Fecha();
        Fecha(int, int, int);
        void generarFecha();
        int getAnio();
        int getMes();
        int getDia();
        std::string getFecha();
};

#endif;
