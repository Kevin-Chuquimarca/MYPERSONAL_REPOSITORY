#include "Fecha.h"

Fecha::Fecha() {
    this->anio = 0;
    this->mes = 0;
    this->dia = 0;
}

Fecha::Fecha(int dia, int mes, int anio) {
    this->anio = anio;
    this->mes = mes;
    this->dia = dia;
}

void Fecha::generarFecha() {
    time_t currentTime;
    struct tm  localTime;
    time(&currentTime);
    localtime_s(&localTime, &currentTime);
    anio = localTime.tm_year + 1900;
    mes = localTime.tm_mon + 1;
    dia = localTime.tm_mday;
}

int Fecha::getAnio() {
    return anio;
}

int Fecha::getMes() {
    return mes;
}

int Fecha::getDia() {
    return dia;
}

std::string Fecha::getFecha() {
    std::string sAnio(std::to_string(anio));
    std::string sMes(std::to_string(mes));
    std::string sDia(std::to_string(dia));
    return sDia + "/" + sMes + "/" + sAnio + "\n";
}