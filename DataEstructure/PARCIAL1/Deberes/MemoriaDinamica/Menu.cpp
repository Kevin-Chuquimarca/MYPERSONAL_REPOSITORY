#include "Menu.h"

void Menu::selec_opcion() {
	int opcion = 0;
	do {
		printf_s("1: Malloc con Clases \n2: Malloc con Templates\n3: Reservar memoria con new \n4: Salir\n");
		scanf_s("%d", &opcion);
		switch (opcion) {
		case 1:
			procesar_clases();
			break;
		case 2:
			procesar_templates();
			break;
		case 3:
			reservar_m_new();
			break;
		}
		system("pause");
		system("cls");
	} while (opcion != 4);
}
void Menu::procesar_clases() {
	int** mat1 = NULL, ** mat2 = NULL, ** matr = NULL;
	int d = 0;
	printf_s("Ingrese la dimension: ");
	scanf_s("%d", &d);
	MatrizDinamica mat_d1(mat1, d), mat_d2(mat2, d), mat_dr(matr, d);
	printf_s("Ingrese los valores de la matriz 1 : \n");
	mat_d1.ingreso();
	printf_s("Ingrese los valores de la matriz 2 : \n");
	mat_d2.ingreso();
	printf_s("\nmatriz 1\n");
	mat_d1.imprimir();
	printf_s("\nmatriz 2\n");
	mat_d2.imprimir();
	OperacionMatriz o_mat;
	o_mat.proceso(mat_d1.get_mat(), mat_d2.get_mat(), mat_dr.get_mat(), d);
	printf_s("\nmatriz r\n");
	mat_dr.imprimir();
}
void Menu::procesar_templates() {
	int** mat1 = NULL, ** mat2 = NULL, ** matr = NULL;
	int d = 0;
	printf_s("Ingrese la dimension: ");
	scanf_s("%d", &d);
	TMatrizDinamica<int> mat_d1(mat1, d), mat_d2(mat2, d), mat_dr(matr, d);
	printf_s("Ingrese los valores de la matriz 1 : \n");
	mat_d1.ingreso();
	printf_s("Ingrese los valores de la matriz 2 : \n");
	mat_d2.ingreso();
	printf_s("\nmatriz 1\n");
	mat_d1.imprimir();
	printf_s("\nmatriz 2\n");
	mat_d2.imprimir();
	TOperacionMatriz<int> o_mat;
	o_mat.proceso(mat_d1.get_mat(), mat_d2.get_mat(), mat_dr.get_mat(), d);
	printf_s("\nmatriz r\n");
	mat_dr.imprimir();
}
void Menu::reservar_m_new() {
	int** mat=NULL;
	int d = 0;
	printf_s("Ingrese la dimension: ");
	scanf_s("%d", &d);
	MDinamicaNew mat_d(mat, d);
}