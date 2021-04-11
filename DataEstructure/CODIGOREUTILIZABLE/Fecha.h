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
        void generar_fecha();
        int get_anio();
        int get_mes();
        int get_dia();
        std::string get_fecha();
};

#endif;
