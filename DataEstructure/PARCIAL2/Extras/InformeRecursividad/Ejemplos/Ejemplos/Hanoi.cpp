#include "Hanoi.h"

int Hanoi::pasos(int discos)
{
	if (discos == 1)
	{
		return 1;
	}
	else {
		return 2 * pasos(discos - 1) + 1;
	}
}

void Hanoi::moverdisco(int disco, int torre1, int torre2, int torre3)
{
	if (disco == 1)
	{
		std::cout << "Mover el disco: " << disco << " de la torre: " << torre1 << " hacia la torre: " << torre3 << std::endl;
	}
	else
	{
		moverdisco(disco - 1, torre1, torre3, torre2);
		std::cout << "Mover el disco: " << disco << " de la torre: " << torre1 << " hacia la torre: " << torre3 << std::endl;
		moverdisco(disco - 1, torre2, torre1, torre3);
	}
}

void Hanoi::hanoi() {
	int discos = 0, torre1 = 1, torre2 = 2, torre3 = 3;
	do {
		system("cls");
		std::cout << "Ingrese el numero de discos: ";
		std::cin >> discos;
	} while (!(discos > 0 && discos < 10));
	std::cout << "El numero de pasos para resolver es: " << pasos(discos) << " , los pasos son: " << std::endl;
	moverdisco(discos, torre1, torre2, torre3);
}