#include "Numero.h"
#include "Screen.h"

void Numero::guardar_nums() {
    lista.insertaFinal(num);
}

void Numero::set_num(int num) {
    this->num = num;
    guardar_nums();
}

void Numero::imprimir() {
    Screen screen;
    std::cout << std::endl << std::endl;
    screen.gotoxy(0, 10);
    printf_s("Numeros Atrapados\n");
    lista.imprimeIterativo();
    delete nodo;
}