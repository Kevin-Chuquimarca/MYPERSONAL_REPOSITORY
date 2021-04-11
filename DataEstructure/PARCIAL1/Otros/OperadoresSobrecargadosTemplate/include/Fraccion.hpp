#ifndef FRACCION_HPP
#define FRACCION_HPP

template <class T>
class Fraccion
{
    public:
        Fraccion(T num = 1, T den = 1);
        void setNum(T real);
        void setDen(T img);
        T getNum();
        T getDen();
        Fraccion<T>& operator * (const Fraccion<T> &A);
        Fraccion<T>& operator / (const Fraccion<T> &A);
    private:
        T num;
        T den;
};

#endif // FRACCION_HPP
