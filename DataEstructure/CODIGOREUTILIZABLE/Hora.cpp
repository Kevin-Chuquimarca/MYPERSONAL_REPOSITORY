#include "Hora.h"

Hora::Hora() {
    this->hora = 0;
    this->min = 0;
    this->seg = 0;
}

void Hora::generar_hora() {
    time_t current_time;
    struct tm  local_time;
    time(&current_time);
    localtime_s(&local_time, &current_time);
    hora = local_time.tm_hour;
    min = local_time.tm_min;
    seg = local_time.tm_sec;
}

int Hora::get_hora() {
    return hora;
}

int Hora::get_min() {
    return min;
}

int Hora::get_seg() {
    return seg;
}

std::string Hora::get_hora_a() {
    std::string s_hora(std::to_string(hora));
    std::string s_min(std::to_string(min));
    std::string s_seg(std::to_string(seg));
    return s_hora + ":" + s_min + ":" + s_seg + "\n";
}

