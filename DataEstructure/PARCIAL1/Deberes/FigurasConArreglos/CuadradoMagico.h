#ifndef CUADRADOMAGICO_H_INCLUDED
#define CUADRADOMAGICO_H_INCLUDED

class CuadradoMagico {
	private:
		int sz;
		int matriz[10][10];
		int constMagica;
		bool esMagico;
	public:
		void registrar_dim();
		void llenar_matriz();
		void imprimir_matriz();
		void identificar_c();
};

#endif 

