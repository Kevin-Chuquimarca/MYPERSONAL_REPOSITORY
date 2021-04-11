#ifndef NODO_H
#define NODO_H
class Nodo
{
    public:
        Nodo();
        Nodo(int, Nodo*);
        int getDato(void);
		Nodo *getLista();
        void setDato(int);
        Nodo getSiguiente(void);
        void setSiguiente(Nodo*);
        void insertarInicio(int);
        void insertarFinal(int);
        bool vacio(void);
        void imprimir();
    protected:

    private:
        int dato;
        Nodo *siguiente;
};
#endif 
