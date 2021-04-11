#include <iostream>
#include "Complejo.hpp"
#include "Fraccion.hpp"

using namespace std;

int main()
{
    Complejo<int> A(1,3),B(2,4);
    Complejo<int> C;
    Fraccion<int> D(1,2), E(3,5);
    Fraccion<int> F;
    int x,y;
    cout<<"Suma de complejos"<<endl;
    C = A+B;
    cout<<C.getReal()<<" + "<<C.getImg()<<" i"<<endl;
    C.setImg(0);C.setReal(0);
    cout<<"Resta de complejos"<<endl;
    C = A-B;
    cout<<C.getReal()<<" + "<<C.getImg()<<" i"<<endl;
    //cout<<C;
    cout<<"Multiplicacion de fracciones"<<endl;
    F = D*E;
    cout<<F.getNum()<<"/"<<F.getDen()<<endl;
    D.setDen(2);D.setNum(1);
    cout<<"Divicion de fracciones"<<endl;
    F = D/E;
    cout<<F.getNum()<<"/"<<F.getDen()<<endl;

    cout<<"Ingrese 2 numeros a , b :";
    cin>>x>>y;
    cout<<x<<" "<<y;

    cin.ignore();

    return 0;
}
