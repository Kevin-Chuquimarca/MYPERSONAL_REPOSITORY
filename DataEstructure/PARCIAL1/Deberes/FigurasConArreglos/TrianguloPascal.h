#ifndef TRIANGULOPASCAL_H_INCLUDED
#define TRIANGULOPASCAL_H_INCLUDED

class TrianguloPascal {
	private:
		int matriz[55];
		int filas;
		int columnas;
		int posicion;
	public:
		TrianguloPascal();
		int factorial(int);
		void ingresar_dim();
		void generar_trg();
		void imprimir_trg();
};

#endif

