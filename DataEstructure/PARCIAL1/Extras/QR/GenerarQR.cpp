#include "GenerarQR.h"

#include <iostream>
#include <stdio.h>
#include <stdlib.h>

using namespace std;
using qrcodegen::QrCode;
using qrcodegen::QrSegment;

GeneraQR::GeneraQR() {

}

void GeneraQR::crear_QR(const char* cad) {
	const QrCode::Ecc correction_LV = QrCode::Ecc::MEDIUM;
	const QrCode qr = QrCode::encodeText(cad, correction_LV);
	imprimir_QR(qr);
}

void GeneraQR::imprimir_QR(const QrCode& cad) {
	int borde = 2;

	for (int i = -borde; i < cad.getSize() + borde; i++) {
		for (int j = -borde; j < cad.getSize() + borde; j++) {
			int pixel = (cad.getModule(j, i)) ? 32 : 219;
			cout << (char)pixel << (char)pixel;
		}
		cout << endl;
	}
	cout << endl;
}
