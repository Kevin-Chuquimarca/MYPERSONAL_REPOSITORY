#include "Fraccion.hpp"
#include <iostream>

using namespace std;

template <class T>
Fraccion<T>::Fraccion(T num ,T den)
{
    this->num = num;
    this->den = den;
}

template<class T>
void Fraccion<T>::setNum(T num){
    this->num = num;
}

template<class T>
void Fraccion<T>::setDen(T den){
    this->den = den;
}

template<class T>
T Fraccion<T>::getNum(){
    return this->num;
}

template<class T>
T Fraccion<T>::getDen(){
    return this->den;
}

template<class T>
Fraccion<T>& Fraccion<T>::operator * (const Fraccion<T> &A){
    this->den *= A.den;
    this->num *= A.num;
    return *this;
}

template<class T>
Fraccion<T>& Fraccion<T>::operator / (const Fraccion<T> &A){
    this->den *= A.num;
    this->num *= A.den;
    return *this;
}
template class Fraccion<int>;
