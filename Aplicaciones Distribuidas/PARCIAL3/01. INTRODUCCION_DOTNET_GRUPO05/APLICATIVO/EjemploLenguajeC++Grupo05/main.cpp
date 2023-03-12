#include "iostream"

using namespace std;

int main(int argc, char *argv[])
{
    int num1 = 5;
    int num2 = 3;
    if ((num1 + num2) > 10)
    {
        std::cout << "La suma entre " << num1 << " + " << num2 << " Si es mayor a 10" << std::endl;
    }
    else
    {
        std::cout << "La suma entre " << num1 << " + " << num2 << " No es mayor a 10" << std::endl;
    }
    system("Pause");
    return 0;
}