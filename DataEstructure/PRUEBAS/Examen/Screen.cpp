/***********************************************************************
 * Module:  Array.cpp
 * Author:  USUARIO
 * Modified: jueves, 28 de mayo de 2020 19:07:11
 * Purpose: Implementation of the class Array
 ***********************************************************************/

#include "Screen.h"

#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <time.h>
#include <windows.h>
#include <ctype.h>
#include <mmsystem.h>

#pragma once

using namespace std;

/**
 * @brief gotoxy
 * @param x 
 * @param y 
*/
void Screen::gotoxy(int x, int y)
{
    HANDLE hcon = GetStdHandle(STD_OUTPUT_HANDLE);
    COORD dwPos;
    dwPos.X = x;
    dwPos.Y = y;
    SetConsoleCursorPosition(hcon, dwPos);
}

/**
 * @brief hide_cursor
*/
void Screen::hide_cursor()
{
    HANDLE Cursor = GetStdHandle(STD_OUTPUT_HANDLE);
    CONSOLE_CURSOR_INFO info;
    info.dwSize = 100;
    info.bVisible = false;
    SetConsoleCursorInfo(Cursor, &info);
}

/**
 * @brief screen_size
 * @param width 
 * @param height 
*/
void Screen::screen_size(int width, int height) {
    _COORD size;
    _SMALL_RECT rect;
    size.X = width;
    size.Y = height;

    rect.Top = 0;
    rect.Left = 0;
    rect.Right = width - 1;
    rect.Bottom = height - 1;

    HANDLE _console = GetStdHandle(STD_OUTPUT_HANDLE);
    SetConsoleScreenBufferSize(_console, size);
    SetConsoleWindowInfo(_console, TRUE, &rect);

}

/**
 * @brief color_text
 * @param color 
*/
void Screen::color_text(int color) {
    HANDLE ColorText = GetStdHandle(STD_OUTPUT_HANDLE);
    SetConsoleTextAttribute(ColorText, color);
}

//void Screen::color_background() {
//
//}