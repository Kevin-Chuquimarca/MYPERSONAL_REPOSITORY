/***********************************************************************
 * Module:  Binary.h
 * Author:  Abigail
 * Modified: martes, 18 de agosto de 2020 19:22:17
 * Purpose: Declaration of the class Tree
 ***********************************************************************/

#if !defined(__BTree_h)
#define __BTree_h
#include "NodeTreeB.h"
#define inicialize 0
#define TEN_DIVISION 10
#include <iostream>
using namespace std;
template <class T>
class BTree {
   public:
   	  NodeTreeB<T>* root;
   	    int size; //int t
  BTree(T );
  ~BTree();
  void traverseTree();
	void show(NodeTreeB<T>*&);
  NodeTreeB<T> *searchTree(T) ; //int k

  void insertTree(T );
};
/**@brief  Destructor
@param T newData
@returns void
*/
template <class T>
BTree<T>::BTree(T degree) {
	this->root = NULL;
	this->size = degree;
}
/**@brief  addNode
@param T newData
@returns void
*/
template <class T>
void BTree<T>::show(NodeTreeB<T>*& cursor) {
	if (cursor != NULL) {
    for (int i = 0; i < cursor->n; i++) {
      cout << cursor->keys[i] << " ";
    }
    cout << "\n";
    if (cursor->leaf != true) {
      for (int i = 0; i < cursor->n + 1; i++) {
        show(cursor->C[i]);
      }
    }
  }

}
/**@brief  addNode
@param T newData
@returns void
*/
template <class T>
void BTree<T>::traverseTree(){
    if (root != NULL)
      root->traverse();
}

/**@brief  addNode
@param T newData
@returns void
*/
template <class T>
NodeTreeB<T>* BTree<T>::searchTree(T data){
 return (root == NULL) ? NULL : root->search(data);
}
/**@brief  addNode
@param T newData
@returns void
*/
template <class T>
void BTree<T>::insertTree(T data) {
  if (root == NULL) {
    root = new NodeTreeB<T>(size, true);
    root->keys[0] = data;
    root->n = 1;
  } else {
    if (root->n == 2 * size - 1) {
      NodeTreeB<T> *s = new NodeTreeB<T>(size, false);

      s->C[0] = root;

      s->splitChild(0, root);

      int i = 0;
      if (s->keys[0] < data)
        i++;
      s->C[i]->insertNonFull(data);

      root = s;
    } else
      root->insertNonFull(data);
  }
}

/**@brief  Destructor
@param T newData
@returns void
*/
template <class T>
BTree<T>::~BTree() {
	this->root = NULL;
}
#endif
