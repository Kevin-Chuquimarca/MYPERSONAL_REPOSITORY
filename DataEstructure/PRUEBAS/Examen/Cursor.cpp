#include "Cursor.h"
#include "Screen.h"
#include "NumRand.h"
#include "Numero.h"

#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <time.h>
#include <windows.h>
#include <ctype.h>
#include <mmsystem.h>
#include <string>

#define UP 72
#define DOWN 80
#define ENTER 13
#define RIGHT 77 
#define LEFT 75

int Cursor::mover_cursor() {
    NumRand obj_nram;
    Screen screen;
    Numero num;
    int n_ram = 0, n_pos_x = 0, alto = 30, largo = 100, pos_y = 29, 
        pos_x = 50, key = 0, num_select = 0, sum =20, vidas = 15;
    screen.screen_size(largo, alto);
    screen.hide_cursor();
    bool flag = true;
    char curso = '_';
    do {
        if (sum == alto) {
            n_ram = obj_nram.generar_numrand();
            n_pos_x = obj_nram.generar_numrand();
            sum = 1;
            vidas--;
        }
        if (vidas == 0) {
            flag = false;
        }
        if (n_pos_x == pos_x && sum == pos_y) {
            num.set_num(n_ram);
        }
        Sleep(20);
        system("cls");
        screen.gotoxy(0, 0);
        printf("VIDAS: %d", vidas);
        screen.gotoxy(n_pos_x, 0 + sum);
        printf("%d", n_ram);
        screen.gotoxy(pos_x, pos_y);
        printf("%c", curso);
        sum++;
        fflush(stdin);
        if (_kbhit()) {
            key = _getch();
        }
        switch (key) {
        case UP:
            if (pos_y > 0) {
                pos_y--;
            }
            break;
        case DOWN:
            if (pos_y < alto) {
                pos_y++;
            }
            break;
        case RIGHT:
            if (pos_x > 0) {
                pos_x++;
            }
            break;
        case LEFT:
            if (pos_x > 0) {
                pos_x--;
            }
            break;
        case ENTER:
            flag = false;
            break;
        }
        key = 0;
    } while (flag);
    system("cls");
    num.imprimir();
    return num_select;
}

int Cursor::get_cont() {
    return cont;
}

void Cursor::set_cont(int cont) {
    this->cont = cont;
}