#ifndef SUMA_H_INCLUDED
#define SUMA_H_INCLUDED
#include <iostream>
using namespace std;

class Vector
{
private:
	float x;
	float y;
public:
	Vector(float, float);			//Vector(float x=0, float y=0); si un objeto no recibe valores y los inicializa en 0
	Vector();
	void ImprimeVector();
	Vector operator+(Vector Vec);
	Vector operator-(Vector Vec);
	Vector operator*(Vector Vec);
	Vector operator/(Vector Vec);
};

Vector::Vector(float x, float y)
{
	this->x = x;			//	-> se utiliza para acceder a los elementos de una estructura 
	this->y = y;			//de datos que se tiene referenciada por un puntero o "pointer".
}
Vector::Vector()
{
	this->x = 0.0f;			//	-> se utiliza para acceder a los elementos de una estructura 
	this->y = 0.0f;			//de datos que se tiene referenciada por un puntero o "pointer".
}
void Vector::ImprimeVector()
{
	cout << "x = " << x << " y = " << y << endl;
}
Vector Vector::operator+ (Vector Vec)
{
	return Vector(x + Vec.x, y + Vec.y);
}
Vector Vector::operator- (Vector Vec)
{
	return Vector(x - Vec.x, y - Vec.y);
}
Vector Vector::operator* (Vector Vec)
{
	return Vector(x * Vec.x, y * Vec.y);
}
Vector Vector::operator/ (Vector Vec)
{
	return Vector(x / Vec.x, y / Vec.y);
}
/*
void UsaSobrecarga(void)
{
	Vector ObjVectorU(3, 1), ObjVectorV(1, 2), ObjVectorR;
	ObjVectorR = ObjVectorU + ObjVectorV;
	ObjVectorR.ImprimeVector();
}*/
#endif;
