/***********************************************************************
 * Module:  Binary.h
 * Author:  Abigail
 * Modified: martes, 18 de agosto de 2020 19:22:17
 * Purpose: Declaration of the class Tree
 ***********************************************************************/

#if !defined(__BinaryTree_h)
#define __BinaryTree_h
#include "Tree.h"
#define inicialize 0
#define TEN_DIVISION 10
#include <iostream>
using namespace std;
template <class T>
class BPlusTree : public Tree <T> {
	public:
		BPlusTree() :Tree<T>() {};
		BPlusTree(int);
		virtual ~BPlusTree();
		void addNode(T);
		string toString();
		void showTree(NodeTree<T>*, int);
		int look(T);
		void show(NodeTree<T> *);
		private:
		void insert(T, NodeTree<T> *, NodeTree<T> *);
		NodeTree<T> *findDad(NodeTree<T> *, NodeTree<T> *);
};
/**@brief  Destructor
@param T newData
@returns void
*/
template <class T>
BPlusTree<T>::BPlusTree(int degree) {
	this->root->setDegree(degree);
}
/**@brief  addNode
@param T newData
@returns void
*/
template <class T>
void BPlusTree<T>::show(NodeTree<T> *cursor){
	  if (cursor != NULL) {
    for (int i = 0; i < cursor->size; i++) {
      cout << cursor->key[i] << " ";
    }
    cout << "\n";
    if (cursor->isLeft != true) {
      for (int i = 0; i < cursor->size + 1; i++) {
        show(cursor->ptr[i]);
      }
    }
  }
}
/**@brief  addNode
@param T newData
@returns void
*/
template <class T>
void BPlusTree<T>::insert(T x, NodeTree<T> *cursor, NodeTree<T> *child) {
   if (cursor->size < this->root->getDegree()) {
    int i = 0;
    while (x > cursor->key[i] && i < cursor->size)
      i++;
    for (int j = cursor->size; j > i; j--) {
      cursor->key[j] = cursor->key[j - 1];
    }
    for (int j = cursor->size + 1; j > i + 1; j--) {
      cursor->ptr[j] = cursor->ptr[j - 1];
    }
    cursor->key[i] = x;
    cursor->size++;
    cursor->ptr[i + 1] = child;
  } else {
    NodeTree<T> *newInternal = new NodeTree<T>();
    int virtualKey[ this->root->getDegree() + 1];
    NodeTree<T> *virtualPtr[ this->root->getDegree() + 2];
    for (int i = 0; i <  this->root->getDegree(); i++) {
      virtualKey[i] = cursor->key[i];
    }
    for (int i = 0; i <  this->root->getDegree() + 1; i++) {
      virtualPtr[i] = cursor->ptr[i];
    }
    int i = 0, j;
    while (x > virtualKey[i] && i <  this->root->getDegree())
      i++;
    for (int j =  this->root->getDegree() + 1; j > i; j--) {
      virtualKey[j] = virtualKey[j - 1];
    }
    virtualKey[i] = x;
    for (int j =  this->root->getDegree() + 2; j > i + 1; j--) {
      virtualPtr[j] = virtualPtr[j - 1];
    }
    virtualPtr[i + 1] = child;
    newInternal->isLeft = false;
    cursor->size = ( this->root->getDegree() + 1) / 2;
    newInternal->size =  this->root->getDegree() - ( this->root->getDegree() + 1) / 2;
    for (i = 0, j = cursor->size + 1; i < newInternal->size; i++, j++) {
      newInternal->key[i] = virtualKey[j];
    }
    for (i = 0, j = cursor->size + 1; i < newInternal->size + 1; i++, j++) {
      newInternal->ptr[i] = virtualPtr[j];
    }
    if (cursor == this->root) {
      NodeTree<T> *newRoot = new NodeTree<T>();
      newRoot->key[0] = cursor->key[cursor->size];
      newRoot->ptr[0] = cursor;
      newRoot->ptr[1] = newInternal;
      newRoot->isLeft = false;
      newRoot->size = 1;
      this->root = newRoot;
    } else {
      insert(cursor->key[cursor->size], findDad(this->root, cursor), newInternal);
    }
  }
}
/**@brief  addNode
@param T newData
@returns void
*/
template <class T>
NodeTree<T> * BPlusTree<T>::findDad(NodeTree<T> *cursor, NodeTree<T> *child) {
	NodeTree<T> *parent = new NodeTree<T>();
  if (cursor->isLeft || (cursor->ptr[0])->isLeft) {
    return NULL;
  }
  for (int i = 0; i < cursor->size + 1; i++) {
    if (cursor->ptr[i] == child) {
      parent = cursor;
      return parent;
    } else {
      parent = findDad(cursor->ptr[i], child);
      if (parent != NULL)
        return parent;
    }
  }
  return parent;
}
/**@brief  addNode
@param T newData
@returns void
*/
template <class T>
void BPlusTree<T>::addNode(T x) {
  if (this->root == NULL) {
    this->root = new NodeTree<T>();
    this->root->key[0] = x;
    this->root->isLeft = true;
    this->root->size = 1;
  } else {
    NodeTree<T>*cursor = this->root;
    NodeTree<T> *parent;
    while (cursor->isLeft == false) {
      parent = cursor;
      for (int i = 0; i < cursor->size; i++) {
        if (x < cursor->key[i]) {
          cursor = cursor->ptr[i];
          break;
        }
        if (i == cursor->size - 1) {
          cursor = cursor->ptr[i + 1];
          break;
        }
      }
    }
    if (cursor->size <  this->root->getDegree()) {
      int i = 0;
      while (x > cursor->key[i] && i < cursor->size)
        i++;
      for (int j = cursor->size; j > i; j--) {
        cursor->key[j] = cursor->key[j - 1];
      }
      cursor->key[i] = x;
      cursor->size++;
      cursor->ptr[cursor->size] = cursor->ptr[cursor->size - 1];
      cursor->ptr[cursor->size - 1] = NULL;
    } else {
      NodeTree<T> *newLeaf = new NodeTree<T>();
      int virtualNode[ this->root->getDegree() + 1];
      for (int i = 0; i < this->root->getDegree(); i++) {
        virtualNode[i] = cursor->key[i];
      }
      int i = 0, j;
      while (x > virtualNode[i] && i <  this->root->getDegree())
        i++;
      for (int j = this->root->getDegree() + 1; j > i; j--) {
        virtualNode[j] = virtualNode[j - 1];
      }
      virtualNode[i] = x;
      newLeaf->isLeft = true;
      cursor->size = (this->root->getDegree() + 1) / 2;
      newLeaf->size = this->root->getDegree() + 1 - (this->root->getDegree() + 1) / 2;
      cursor->ptr[cursor->size] = newLeaf;
      newLeaf->ptr[newLeaf->size] = cursor->ptr[this->root->getDegree()];
      cursor->ptr[this->root->getDegree()] = NULL;
      for (i = 0; i < cursor->size; i++) {
        cursor->key[i] = virtualNode[i];
      }
      for (i = 0, j = cursor->size; i < newLeaf->size; i++, j++) {
        newLeaf->key[i] = virtualNode[j];
      }
      if (cursor == this->root) {
        NodeTree<T> *newRoot = new NodeTree<T>();
        newRoot->key[0] = newLeaf->key[0];
        newRoot->ptr[0] = cursor;
        newRoot->ptr[1] = newLeaf;
        newRoot->isLeft = false;
        newRoot->size = 1;
        this->root = newRoot;
      } else {
        insert(newLeaf->key[0], parent, newLeaf);
      }
    }
  }
}

/**@brief  toString
@param T newData
@returns void
*/
template <class T>
string BPlusTree<T>::toString() {
	return " ";
}
/**@brief  Destructor
@param T newData
@returns void
*/
template <class T>
BPlusTree<T>::~BPlusTree() {
	this->root = NULL;
}
#endif
