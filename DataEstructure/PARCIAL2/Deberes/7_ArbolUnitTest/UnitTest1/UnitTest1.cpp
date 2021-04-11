/**********************************************************************
* UNIVERSIDAD DE LAS FUERZAS ARMADAS ESPE							  *
* Programa principal para UNIT TEST de la funcion recorrido postOrden *
* Autor: Kevin Chuquimarca											  *
* Fecha: 25/01/2021													  *
* Fecha de modificacion: 25/01/2021									  *
***********************************************************************/

#include "pch.h"
#include "CppUnitTest.h"

using namespace Microsoft::VisualStudio::CppUnitTestFramework;

namespace UnitTest1
{
	TEST_CLASS(UnitTest1)
	{
	public:
		
		TEST_METHOD(Test1)
		{
			const char* preOrden = "GEAIBMCLDFKJH";
			const char* inOrden = "IABEGLDCFMKHJ";
			char* posOrden;
			int aux;
			aux = strlen(preOrden);
			posOrden = (char*)malloc(aux * sizeof(char));
			if (posOrden) {
				postOr(preOrden, inOrden, posOrden, aux);
				*(posOrden + aux) = '\0';
			}
			else {
				fprintf(stderr, "Error sin memeoria ");
			}
			Assert::AreEqual("IBAEDLFCHJKMG", posOrden);
		}
		TEST_METHOD(Test2)	//ejercicio 1
		{
			const char* preOrden = "/-*2+381-7+x2";
			const char* inOrden = "2*3+8-1/7-x+2";
			char* posOrden;
			int aux;
			aux = strlen(preOrden);
			posOrden = (char*)malloc(aux * sizeof(char));
			if (posOrden) {
				postOr(preOrden, inOrden, posOrden, aux);
				*(posOrden + aux) = '\0';
			}
			else {
				fprintf(stderr, "Error sin memeoria ");
			}
			Assert::AreEqual("238+*1-7x2+-/", posOrden);
		}
		TEST_METHOD(Test3)	//ejercicio en clase
		{
			const char* preOrden = "+*45*67";
			const char* inOrden = "4*5+6*7";
			char* posOrden;
			int aux;
			aux = strlen(preOrden);
			posOrden = (char*)malloc(aux * sizeof(char));
			if (posOrden) {
				postOr(preOrden, inOrden, posOrden, aux);
				*(posOrden + aux) = '\0';
			}
			else {
				fprintf(stderr, "Error sin memeoria ");
			}
			Assert::AreEqual("45*67*+", posOrden);
		}
		TEST_METHOD(Test4)	
		{
			const char* preOrden = "ECADHFIJ";
			const char* inOrden = "ACDEFHIJ";
			char* posOrden;
			int aux;
			aux = strlen(preOrden);
			posOrden = (char*)malloc(aux * sizeof(char));
			if (posOrden) {
				postOr(preOrden, inOrden, posOrden, aux);
				*(posOrden + aux) = '\0';
			}
			else {
				fprintf(stderr, "Error sin memeoria ");
			}
			Assert::AreEqual("ADCFJIHE", posOrden);
		}
		TEST_METHOD(Test5)	
		{
			const char* preOrden = "KFDCAEHGIJTMLOWUX";
			const char* inOrden = "ACDEFGHIJKLMOTUWX";
			char* posOrden;
			int aux;
			aux = strlen(preOrden);
			posOrden = (char*)malloc(aux * sizeof(char));
			if (posOrden) {
				postOr(preOrden, inOrden, posOrden, aux);
				*(posOrden + aux) = '\0';
			}
			else {
				fprintf(stderr, "Error sin memeoria ");
			}
			Assert::AreEqual("ACEDGJIHFLOMUXWTK", posOrden);
		}
	};
}
