/***********************************************************************
 * Module:  Binary.h
 * Author:  Abigail
 * Modified: martes, 18 de agosto de 2020 19:22:17
 * Purpose: Declaration of the class Tree
 ***********************************************************************/
#if !defined(__BTreeNode_h)
#define __BTreeNode_h
#define inicialize 0
#define TEN_DIVISION 10
#include <iostream>
using namespace std;
template <class T>
class NodeTreeB {
	public:
		NodeTreeB(){	};
		~NodeTreeB();
		NodeTreeB(T, bool);
			
	  void insertNonFull(T );
	  void splitChild(T , NodeTreeB *);
	  void traverse();
	//  void show(NodeTreeB<T>* );
	   NodeTreeB *search(T );
	
	  T *keys;
	  T t;
	  NodeTreeB **C;
	  T n;
	  bool leaf;
};
/**@brief  addNode
@param T newData
@returns void
*/
template <class T>
NodeTreeB<T>::NodeTreeB(T t1, bool leaf1) {
  t = t1;
  leaf = leaf1;

  keys = new int[2 * t - 1];
  C = new NodeTreeB *[2 * t];

  n = 0;
}
/**@brief  addNode
@param T newData
@returns void
*/
template <class T>
void NodeTreeB<T>::traverse() {
  int i;
  for (i = 0; i < n; i++) {
    if (leaf == false)
      C[i]->traverse();
    cout << " " << keys[i];
  }
	cout<<endl;
  if (leaf == false){
   	C[i]->traverse();  	
  }

}

/**@brief  addNode
@param T newData
@returns void
*/
template <class T>
NodeTreeB<T> *NodeTreeB<T>::search(T k) {
  int i = 0;
  while (i < n && k > keys[i])
    i++;

  if (keys[i] == k)
    return this;

  if (leaf == true){
  	    return NULL;	
  }

  return C[i]->search(k);
}
/**@brief  addNode
@param T newData
@returns void
*/
template <class T>
void NodeTreeB<T>::insertNonFull(T data) {
  int i = n - 1;

  if (leaf == true) {
    while (i >= 0 && keys[i] > data) {
      keys[i + 1] = keys[i];
      i--;
    }

    keys[i + 1] = data;
    n = n + 1;
  } else {
    while (i >= 0 && keys[i] > data)
      i--;

    if (C[i + 1]->n == 2 * t - 1) {
      splitChild(i + 1, C[i + 1]);

      if (keys[i + 1] < data)
        i++;
    }
    C[i + 1]->insertNonFull(data);
  }
}
/**@brief  addNode
@param T newData
@returns void
*/
template <class T>
void NodeTreeB<T>::splitChild(T i, NodeTreeB<T> *y) {
  NodeTreeB<T> *z = new NodeTreeB<T>(y->t, y->leaf);
  z->n = t - 1;

  for (int j = 0; j < t - 1; j++)
    z->keys[j] = y->keys[j + t];

  if (y->leaf == false) {
    for (int j = 0; j < t; j++)
      z->C[j] = y->C[j + t];
  }

  y->n = t - 1;
  for (int j = n; j >= i + 1; j--)
    C[j + 1] = C[j];

  C[i + 1] = z;

  for (int j = n - 1; j >= i; j--)
    keys[j + 1] = keys[j];

  keys[i] = y->keys[t - 1];
  n = n + 1;
}

/**@brief  addNode
@param T newData
@returns void
*/
template <class T>
NodeTreeB<T>::~NodeTreeB(){
	
}

#endif
