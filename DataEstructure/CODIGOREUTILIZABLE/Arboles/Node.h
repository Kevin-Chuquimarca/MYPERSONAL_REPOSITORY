/******************************************************************
*            UNIVERSIDAD DE LAS FUERZAS ARMADAS ESPE              *
* CARRERA: Ingenieria de Software                                 *
* SEMESTRE: Tercer semestre                                       *
* MATERIA: Estructura de Datos                                    *
* NRC: 6396                                                       *
******************************************************************/
/***********************************************************************
 * Module:  Node.h
 * Author:  Abigail Cabascango
 * Modified: domingo, 28 de mayo de 2020 17:51:04
 * Purpose: Ingresar datos por consola
 ***********************************************************************/
#if !defined(__Node_h)
#define __Node_h

#include <iostream>
using namespace std;
template <class T>
class Node{
	public:
		Node();
		Node(T d, Node* n);
		Node(T d, Node* n, Node* p);
		~Node();
		
		void setData(T d){	this->data = d;	};
    	void setNext(Node* n){	this->next = n; };
    	void setPrevious(Node* p){	this->previous = p; };
     
    	T getData(){return this->data;};
    	Node* getNext(){return this->next;};
    	Node* getPrevious(){return this->previous;};
    
    	
    	
	private:
	T data;
	Node* next;	
	Node* previous;
};
/**@brief  Constructor
@param void
@returns void
*/
template<class T>
Node<T>::Node() {this->next = NULL;}
/**@brief  Constructor
@param  T d
@param  Node* n
@returns void
*/
template<class T>
Node<T>::Node(T d, Node* n) {
	this->data = d;
	this->next = n;
}
/**@brief  Constructor
@param  T d
@param  Node* n
@returns void
*/
template<class T>
Node<T>::Node(T d, Node* n, Node* p) {
	this->data = d;
	this->next = n;
	this->previous = p;
}
/**@brief  Destructor
@param  void
@returns void
*/
template<class T>
Node<T>::~Node() {}
#endif
