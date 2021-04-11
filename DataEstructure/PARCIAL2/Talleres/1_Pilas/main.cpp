#include <iostream>

void insertaElementoPila(int newDato){
	Nodo *aux = new Nodo();
	aux->dato=newDato;
	if(vacio()){
		cima=aux;
	esle{
		aux->siguiente = cima;
		cima=aux;	
	}
	}
}

void insertaElementoCola(int newDato){
	Nodo *aux = new Nodo(newDato);
	if(vacio()){
		frente=aux;
		esle{
			final->siguiente = aux;
		}
		final =aux;
	}
}

int main(int argc, char** argv) {
	return 0;
}
