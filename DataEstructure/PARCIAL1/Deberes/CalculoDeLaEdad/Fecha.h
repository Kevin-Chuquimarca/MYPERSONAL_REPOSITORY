#pragma once

#include <stdio.h>
#include <string>
#include <time.h>

template <class T>
class Fecha
{
public:
    Fecha();
    Fecha(T, T, T);
    void generar_fecha();
    T get_anio();
    T get_mes();
    T get_dia();
    std::string get_fecha();
    void setDia(T);
    void setMes(T);
    void setAnio(T);
private:
    T anio;
    T mes;
    T dia;

};

template <class T>
Fecha<T>::Fecha() {
    this->anio = 0;
    this->mes = 0;
    this->dia = 0;
}

template <class T>
Fecha<T>::Fecha(T dia, T mes, T anio) {
    this->anio = anio;
    this->mes = mes;
    this->dia = dia;
}

template <class T>
void Fecha<T>::generar_fecha() {
    time_t current_time;
    struct tm  local_time;
    time(&current_time);
    localtime_s(&local_time, &current_time);
    anio = local_time.tm_year + 1900;
    mes = local_time.tm_mon + 1;
    dia = local_time.tm_mday;
}

template <class T>
T Fecha<T>::get_anio() {
    return anio;
}

template <class T>
T Fecha<T>::get_mes() {
    return mes;
}

template <class T>
T Fecha<T>::get_dia() {
    return dia;
}

template <class T>
void Fecha<T>::setDia(T newDia) {
    dia = newDia;
}

template <class T>
void Fecha<T>::setMes(T newMes) {
    mes = newMes;
}

template <class T>
void Fecha<T>::setAnio(T newAnio) {
    anio = newAnio;
}

template <class T>
std::string Fecha<T>::get_fecha() {
    std::string s_anio(std::to_string(anio));
    std::string s_mes(std::to_string(mes));
    std::string s_dia(std::to_string(dia));
    return s_dia + "/" + s_mes + "/" + s_anio + "\n";
}

