#include <iostream>
#include <exception>

using namespace std;

class MiExcepcion : public exception
{
public:
	const char* what() const throw ();
};

