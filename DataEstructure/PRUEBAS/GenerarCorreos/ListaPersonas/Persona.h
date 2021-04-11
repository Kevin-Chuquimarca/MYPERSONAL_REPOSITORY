/***********************************************************************
 * Module:  Class_1.h
 * Author:  ismae
 * Modified: lunes, 4 de enero de 2021 8:57:46
 * Purpose: Declaration of the class Class_1
 ***********************************************************************/

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
   std::string getCorreo(void);
   void setCorreo(std::string newCorreo);
   Persona();
   ~Persona();
protected:
private:
   std::string nombre;
   std::string apellido;
   std::string cedula;
   std::string correo;
};

#endif