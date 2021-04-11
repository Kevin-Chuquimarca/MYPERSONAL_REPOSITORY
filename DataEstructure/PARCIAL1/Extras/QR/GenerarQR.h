
#ifndef GENERARQR_H
#define GENERARQR_H

#include <iostream>
#include "QrCode.hpp"

using namespace std;
using qrcodegen::QrCode;

class GeneraQR
{
public:
    GeneraQR();
    void crear_QR(const char*);
protected:
private:
    void imprimir_QR(const QrCode&);
};

#endif
