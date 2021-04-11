#include "pch.h"
#include "CppUnitTest.h"

using namespace Microsoft::VisualStudio::CppUnitTestFramework;

namespace UniteTest
{
	TEST_CLASS(UniteTest)
	{
	public:
		
		TEST_METHOD(Test1Insertar)
		{
			int a = 10;
			AVL<int> arbol;
			arbol.insert(101);
			arbol.insert(10);
			arbol.insert(1);
			arbol.insert(23);
			arbol.insert(21);
			Assert::AreEqual(a, arbol.getRoot()->getKey());
		}

		TEST_METHOD(Test2Insertar)
		{
			int a = 16;
			AVL<int> arbol;
			arbol.insert(11);
			arbol.insert(120);
			arbol.insert(16);
			arbol.insert(23);
			arbol.insert(2);
			Assert::AreEqual(a, arbol.getRoot()->getKey());
		}

		TEST_METHOD(Test3Insertar)
		{
			int a = 10;
			AVL<int> arbol;
			arbol.insert(1);
			arbol.insert(10);
			arbol.insert(13);
			arbol.insert(23);
			arbol.insert(8);
			Assert::AreEqual(a, arbol.getRoot()->getKey());
		}

		TEST_METHOD(Test4Insertar)
		{
			int a = 13;
			AVL<int> arbol;
			arbol.insert(6);
			arbol.insert(70);
			arbol.insert(13);
			arbol.insert(43);
			arbol.insert(81);
			Assert::AreEqual(a, arbol.getRoot()->getKey());
		}

		TEST_METHOD(Test5Insertar)
		{
			int a = 19;
			AVL<int> arbol;
			arbol.insert(11);
			arbol.insert(19);
			arbol.insert(75);
			arbol.insert(53);
			arbol.insert(61);
			Assert::AreEqual(a, arbol.getRoot()->getKey());
		}

		TEST_METHOD(Test1Eliminar)
		{
			int a = 101, b = 10;
			AVL<int> arbol;
			arbol.insert(101);
			arbol.insert(10);
			arbol.insert(1);
			arbol.insert(23);
			arbol.insert(21);
			arbol.remove(a);
			Assert::AreEqual(b, arbol.getRoot()->getKey());
		}

		TEST_METHOD(Test2Eliminar)
		{
			int a = 16, b = 23;
			AVL<int> arbol;
			arbol.insert(11);
			arbol.insert(120);
			arbol.insert(16);
			arbol.insert(23);
			arbol.insert(2);
			arbol.remove(a);
			Assert::AreEqual(b, arbol.getRoot()->getKey());
		}

		TEST_METHOD(Test3Eliminar)
		{
			int a = 10, b = 13;
			AVL<int> arbol;
			arbol.insert(1);
			arbol.insert(10);
			arbol.insert(13);
			arbol.insert(23);
			arbol.insert(8);
			arbol.remove(a);
			Assert::AreEqual(b, arbol.getRoot()->getKey());
		}

		TEST_METHOD(Test4Eliminar)
		{
			int a = 13, b = 43;
			AVL<int> arbol;
			arbol.insert(6);
			arbol.insert(70);
			arbol.insert(13);
			arbol.insert(43);
			arbol.insert(81);
			arbol.remove(a);
			Assert::AreEqual(b, arbol.getRoot()->getKey());
		}

		TEST_METHOD(Test5Eliminar)
		{
			int a = 19 , b = 53;
			AVL<int> arbol;
			arbol.insert(11);
			arbol.insert(19);
			arbol.insert(75);
			arbol.insert(53);
			arbol.insert(61);
			arbol.remove(a);
			Assert::AreEqual(b, arbol.getRoot()->getKey());
		}

		TEST_METHOD(Test1Imprimir)
		{
			AVL<std::string> arbol;
			arbol.insert("101");
			arbol.insert("10");
			arbol.insert("1");
			arbol.insert("23");
			arbol.insert("21");
			arbol.inorder();
		}

		TEST_METHOD(Test2Imprimir)
		{
			AVL<std::string> arbol;
			arbol.insert("11");
			arbol.insert("120");
			arbol.insert("16");
			arbol.insert("23");
			arbol.insert("2");
			arbol.inorder();
		}

		TEST_METHOD(Test3Imprimir)
		{
			AVL<std::string> arbol;
			arbol.insert("1");
			arbol.insert("10");
			arbol.insert("13");
			arbol.insert("23");
			arbol.insert("8");
			arbol.inorder();
		}

		TEST_METHOD(Test4Imprimir)
		{
			AVL<std::string> arbol;
			arbol.insert("6");
			arbol.insert("70");
			arbol.insert("13");
			arbol.insert("43");
			arbol.insert("81");
			arbol.inorder();
		}

		TEST_METHOD(Test5Imprimir)
		{
			AVL<std::string> arbol;
			arbol.insert("11");
			arbol.insert("19");
			arbol.insert("75");
			arbol.insert("53");
			arbol.insert("61");
			arbol.inorder();
		}
	};
}
