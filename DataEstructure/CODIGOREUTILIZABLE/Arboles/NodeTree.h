
/***********************************************************************
 * Module:  NodeTree.h
 * Author:  Abigail
 * Modified: martes, 18 de agosto de 2020 19:22:17
 * Purpose: Declaration of the class Node
 ***********************************************************************/

#if !defined(__NodeTree_h)
#define __NodeTree_h
#include <iostream>
#include "DoubleList.h"
#include <bits/stdc++.h> 
using namespace std;
template <class T>
class NodeTree{
	public:
		NodeTree();
		NodeTree(NodeTree*,T , NodeTree* );
		NodeTree(NodeTree*,T , NodeTree*, NodeTree* );
		NodeTree(int , bool );
		
		~NodeTree();
		
		void setData(T);
    	
     	void setRight(NodeTree* newRight);
     	void setLeft(NodeTree* newLeft);
     	void setDad(NodeTree* newDad);

     	NodeTree* getRight();
     	NodeTree* getLeft();
     	NodeTree* getDad();
     	
     	void setDegree(int);
		int getDegree();
     	
    T getData();   
	//Arbol BB	
	T data;
	NodeTree* right;
	NodeTree* left;
	NodeTree* dad;
	//Arbol B+	
	NodeTree** ptr;
	bool isLeft;
	//DoubleList<T> key;
	int degree = 4 ;
	T* key =  new T[this->degree] ;
	int size;
};
/**@brief  SetDegree
@param int newDegree
@returns void
*/
template <class T>
void NodeTree<T>::setDegree(int newDegree) {
	this->degree = newDegree;
	this->key = new T[this->degree];
}
/**@brief  get
@param int newData
@returns void
*/
template <class T>
int NodeTree<T>::getDegree() {
	return this->degree;
}
/**@brief  Constructor
@param Node* newLeft
@param T newData
@param  Node* newRight
@returns void
*/
template <class T>
NodeTree<T>::NodeTree(NodeTree* newLeft,T newData, NodeTree* newRight, NodeTree* newDad ){
	this->setLeft(newLeft);
	this->setData(newData);
	this->setRight(newRight);
	this->setDad(newDad);
}
/**@brief  Constructor
@param Node* newLeft
@param T newData
@param  Node* newRight
@returns void
*/
template <class T>
NodeTree<T>::NodeTree(NodeTree* newLeft,T newData, NodeTree* newRight ){
	this->setLeft(newLeft);
	this->setData(newData);
	this->setRight(newRight);
}

/**@brief  Constructor
@param void
@returns void
*/
template <class T>
NodeTree<T>::NodeTree(){
	ptr = new NodeTree<T>*[this->degree];
	key = new T[this->degree];
}
/**@brief  SetData
@param T newData
@returns void
*/
template <class T>
void NodeTree<T>::setData(T newData){
	this->data = newData;
}
/**@brief  SetDad
@param T newData
@returns void
*/
template <class T>
void NodeTree<T>::setDad(NodeTree* newDad){
	this->dad = newDad;
}
/**@brief  SetLeft
@param Node* newLeft
@returns void
*/
template <class T>
void NodeTree<T>::setLeft(NodeTree* newLeft){
	this->left = newLeft;
}
/**@brief  SetRight
@param Node* newRight
@returns void
*/
template <class T>
void NodeTree<T>::setRight(NodeTree* newRight){
	this->right = newRight;
}
/**@brief  getRight
@param void
@returns Node* 
*/
template <class T>
NodeTree<T>* NodeTree<T>:: getRight(){
	return this->right;
}
/**@brief  getDad
@param void
@returns Node* 
*/
template <class T>
NodeTree<T>* NodeTree<T>:: getDad(){
	return this->dad;
}
/**@brief  getLeft
@param void
@returns Node* 
*/
template <class T>
NodeTree<T>* NodeTree<T>:: getLeft(){
	return this->left;
}
/**@brief  getData
@param void
@returns Node* 
*/
template <class T>
T NodeTree<T>:: getData(){
	return this->data;
}
/**@brief  Destructor
@param void
@returns void
*/
template <class T>
NodeTree<T>::~NodeTree(){
	
}
#endif
