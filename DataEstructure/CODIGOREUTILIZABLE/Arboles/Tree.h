/***********************************************************************
 * Module:  Tree.h
 * Author:  Abigail
 * Modified: martes, 18 de agosto de 2020 19:22:17
 * Purpose: Declaration of the class Tree
 ***********************************************************************/

#if !defined(__Tree_h)
#define __Tree_h
#include "NodeTree.h"
#define inicialize 0
#include <iostream>
using namespace std;
template <class T>
class Tree {
	public:
		Tree();
		virtual void addNode(T) = 0;
		bool isEmpty();
		virtual string toString() = 0;
		NodeTree<T>* getTree() { return this->root; };
		void setTree(NodeTree<T>* newRoot) { this->root = newRoot; };
		virtual ~Tree();
		NodeTree<T>* root;
};
/**@brief  Constructor
@param void
@returns void
*/
template <class T>
Tree<T>::Tree() {
	this->root = NULL;
}

/**@brief  InsertNode
@param T d
@param Node<T>* .
@returns void
*/
template <class T>
bool Tree<T>::isEmpty() {
	if (this->getTree() == NULL) {
		return true;
	}
	else {
		return false;
	}
}
/**@brief  Constructor
@param void
@returns void
*/
template <class T>
Tree<T>::~Tree() {
	this->root = NULL;
}
#endif
