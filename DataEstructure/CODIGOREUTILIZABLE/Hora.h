#ifndef HORA_H
#define HORA_H

#include <stdio.h>
#include <string>
#include <time.h>

class Hora {
private:
    int hora;
    int min;
    int seg;
public:
    Hora();
    void generar_hora();
    int get_hora();
    int get_min();
    int get_seg();
    std::string get_hora_a();
};

#endif
