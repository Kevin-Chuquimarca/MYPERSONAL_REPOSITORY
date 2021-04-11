#include "Hora.h"

Hora::Hora() {
    this->horas = 0;
    this->min = 0;
    this->seg = 0;
}

Hora::Hora(int seg, int min, int horas) {
    this->horas = horas;
    this->min = min;
    this->seg = seg;
}

void Hora::generarHora() {
    time_t currentTime;
    struct tm  localTime;
    time(&currentTime);
    localtime_s(&localTime, &currentTime);
    horas = localTime.tm_hour;
    min = localTime.tm_min;
    seg = localTime.tm_sec;
}

int Hora::getHoras() {
    return horas;
}

int Hora::getMin() {
    return min;
}

int Hora::getSeg() {
    return seg;
}

std::string Hora::formatoHora(int dato) {
    std::string valor=std::to_string(dato);
    if (dato<10)
        valor = "0" + std::to_string(dato);
    return valor;
}

std::string Hora::getHora() {
    std::string sHoras(formatoHora(horas));
    std::string sMin(formatoHora(min));
    std::string sSeg(formatoHora(seg));
    return sHoras + "h" + sMin + "y" + sSeg + "seg";
}