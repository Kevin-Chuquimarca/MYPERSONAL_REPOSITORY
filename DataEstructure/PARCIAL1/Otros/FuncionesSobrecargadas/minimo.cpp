#include <iostream>
#include <stdlib.h>
using namespace std;

double raiz(double);
float raiz(float);
double raiz (int);

double raiz(double dato){
    return 3.26588945;
}

float raiz(float dato){
    return 3.52*dato;
}

double raiz(int dato){
    return 3.26*dato;
}


int main(){
    cout<<"Raiz double"<<raiz(3.2546987)<<endl;
    cout<<"Raiz float"<<raiz(3.25)<<endl;
    cout<<"Raiz double int"<<raiz(3.2546987);
    return 0;
}