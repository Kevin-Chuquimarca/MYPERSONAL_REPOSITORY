#include <iostream>
#include <fstream>  

using namespace std;

class Arfil
{
public:
	int aux, aux2;
	bool** validar;
	char** tablero;
	fstream archivo;
	int contador;
	int n;
	void encerarTablero() {
		for (int i = 0; i < n; i++) {
			validar[i] = new bool[n];
			tablero[i] = new char[n];
			for (int j = 0; j < n; j++) {
				*(*(validar + i) + j) = false;
				*(*(tablero + i) + j) = '*';
			}
		}
	}
	void crearArchivo() {
		archivo.open("solucion.txt", fstream::out); //para leer in, para salir es out escribir
		archivo << "solucion " << n << "*" << n << endl << endl;
		contador = 0;
	}

	Arfil(int n1) {
		n = n1;
		validar = new bool* [n];
		tablero = new char* [n];
		encerarTablero();
		crearArchivo();
	}
	void solucion(int x, int y, int n1) {
		*(*(tablero + x) + y) = 'R';
		bloquear(x, y);
		if (n1 == n) {
			mostrar();
		}
		else {
			for (int i = 0; i < n; i++) {
				if (*(*(validar + i) + y + 1) == false) {
					solucion(i, y + 1, n1 + 1);
				}
			}
		}
		quitarRelleno(x, y);
	}

	void bloquear(int x, int y) {
		int aux1, aux2;
		aux2 = y;
		aux1 = 0;
		while (aux1 < n) { //vertical
			*(*(validar + aux1) + aux2) = true;
			aux1++;
		}
		aux2 = 0;
		aux1 = x;
		while (aux2 < n) {
			*(*(validar + aux1) + aux2) = true;
			aux2++;
		}
		aux2 = y;  //Diagonales
		aux1 = x;
		while (aux1 > 0 && aux2 > 0) {
			aux1--;
			aux2--;
		}
		aux2 = y;
		aux1 = x;
		while (aux1 < n && aux2>0) {
			aux1++;
			aux2--;
		}
		aux1--;
		aux2++;
		while (aux1 >= 0 && aux2 < n) {
			*(*(validar + aux1) + aux2) = true;
			aux1--;
			aux2++;
		}
	}

	void bloquear2(int x, int y) {
		int aux1, aux2;
		aux2 = y;  //Diagonales
		aux1 = x;
		while (aux1 > 0 && aux2 > 0) {
			aux1--;
			aux2--;
		}
		aux2 = y;
		aux1 = x;
		while (aux1 < n && aux2>0) {
			aux1++;
			aux2--;
		}
		aux1--;
		aux2++;
		while (aux1 >= 0 && aux2 < n) {
			*(*(validar + aux1) + aux2) = true;
			aux1--;
			aux2++;
		}
	}

	void quitarRelleno(int x, int y) {
		*(*(tablero + x) + y) = '*';
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				*(*(validar + i) + j) = false;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (*(*(tablero + i) + j) == 'R')
					bloquear(i, j);
			}
		}
	}


	void mostrar() {
		contador++;
		archivo << "Solucion N " << contador << endl;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				archivo << *(*(tablero + i) + j) << " ";
			}
			archivo << endl;
		}
		archivo << endl;
	}
	void solucionReinas() {
		for (int i = 0; i < n; i++) {
			solucion(i, 0, 1);
		}
		archivo.close();
	}

	void generarArfil() {
		aux = aleatorio(n);
		aux2 = aleatorio(n - 1);
		*(*(validar + aux) + aux2) = true;
		*(*(tablero + aux) + aux) = 'X';

	}

	int aleatorio(int numAr) {
		if (numAr == 0) {
			numAr = 1;
		}
		srand(time(NULL));
		return rand() % (numAr);
	}

	void movArfil(int x, int y, bool** validar, char** tablero) {
		if (!(*(*(validar + x) + y) == false)) {
			if (!(x == 0 && y == 0) && (x < n && y < n)) {
				*(*(tablero + x) + y) = 'X';
				*(*(validar + x) + y) = true;
				mostrar();
				movArfil(x + 1, y + 1, validar, tablero);
				movArfil(x - 1, y - 1, validar, tablero);
				movArfil(x + 1, y - 1, validar, tablero);
				movArfil(x - 1, y + 1, validar, tablero);
			}
		}
	}
};

