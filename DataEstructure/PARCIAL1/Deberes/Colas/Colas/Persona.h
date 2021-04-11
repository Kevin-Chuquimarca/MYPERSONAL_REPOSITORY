#if !defined(__Class_Diagram_1_Class_1_h)
#define __Class_Diagram_1_Class_1_h

#include <iostream>

class Persona
{
public:
   std::string getNombre(void);
   void setNombre(std::string newNombre);
   std::string getApellido(void);
   void setApellido(std::string newApellido);
   std::string getCedula(void);
   void setCedula(std::string newCedula);
   Persona();
   ~Persona();
protected:
private:
   std::string nombre;
   std::string apellido;
   std::string cedula;
};

#endif