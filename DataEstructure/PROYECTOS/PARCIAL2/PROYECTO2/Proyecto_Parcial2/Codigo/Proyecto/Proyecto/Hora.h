#ifndef HORAACTUAL_H 
#define HORAACTUAL_H

#include <stdio.h>
#include <string>
#include <time.h>

class Hora {
private:
    int horas;
    int min;
    int seg;
public:
    Hora();
    Hora(int, int, int);
    void generarHora();
    int getHoras();
    int getMin();
    int getSeg();
    std::string formatoHora(int);
    std::string getHora();
};

#endif;