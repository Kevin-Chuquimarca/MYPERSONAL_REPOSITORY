/***********************************************************************
 * Module:  Controller.h
 * Author:  Abigail
 * Modified: martes, 18 de agosto de 2020 19:22:17
 * Purpose: Declaration of the class Tree
 ***********************************************************************/

#if !defined(__Controller_h)
#define __Controller_h
#include "BinaryTree.h"
#include "NodeTree.h"
#include "Pila.h"
#include "DoubleList.h"
#include <iostream>
#include<bits/stdc++.h> 
#define TEN_DIVISION 10
using namespace std;
template <class T>
class Controller{
	public:
		Controller();
		Controller(BinaryTree<int> btree) { this->bt = btree; this->cont = 0; }
		BinaryTree<T> bt;
		NodeTree<T>* constructTree(char postfix[]);
		void inorder(NodeTree<T>*);
		int countPrimesNumbers(NodeTree<int>* );
		int sumarDigit(int, int, int);
		NodeTree<int>* addOneDigit(NodeTree<int>* tree,int );
		~Controller();
	private:
		int cont = 0;
		DoubleList<int> list;
		BinaryTree<int> treeOne;
		bool  isOperator(char);
		bool check(int);
		
};
///**@brief  Constructor
//@param void
//@returns void
//*/
template <class T>
int  Controller<T>::sumarDigit(int num, int aux, int  sum){
	if(num == 0){

			return sum;	
	}else {
			aux = num % TEN_DIVISION;
		    num /= TEN_DIVISION;
		    sum += aux;
		    sumarDigit(num,aux, sum);	
	}
}
/**@brief  inOrden
@param Node<T>* tree
@returns void
*/
template <class T>
NodeTree<int>* Controller<T>::addOneDigit(NodeTree<int>* tree, int num1){

		if(tree == NULL){
			return treeOne.getTree();
		}else{
			num1 = sumarDigit(tree->getData(), 0,0);
			while(num1 > 9){
				num1 = sumarDigit(num1, 0,0);
			}
			treeOne.addNode(num1);
			addOneDigit(tree->getLeft(), 0);
			addOneDigit(tree->getRight(), 0);
		}
}
/**@brief  Constructor
@param void
@returns void
*/
template <class T>
Controller<T>::Controller(){
	
}
/**@brief  check
@param int num
@returns void
*/
template <class T>
bool Controller<T>:: check(int num) {
        int cont = 0;
        for (int i = 1;i <= num;i++)
        {
            if (num % i == 0)
                cont++;
        }
        if (cont == 2) return true;
        else return false;
}
/**@brief  countPrimesNumbers
@param void
@returns void
*/
template <class T>
int Controller<T>::countPrimesNumbers(NodeTree<int>* node) {		
        if (bt.isEmpty()) {
        	cout<<"Arbol bacio";
            cont = 0;
        }
        else {
            if (node == NULL) {
                //cont = -1;
            }
            else {
                countPrimesNumbers(node->getLeft());
                if (check(node->getData())) {
                	
                	cout<<node->getData()<<endl;
                    cont++;
                }
                countPrimesNumbers(node->getRight());
            }
        }
		return cont;
}
/**@brief  constructTree
@param void
@returns void
*/
template <class T>
NodeTree<T>* Controller<T>::constructTree(char postfix[]) { 
    Pila<NodeTree<T>*> st;
    NodeTree<T>* tree = new NodeTree<T>();
	NodeTree<T>* tree1 = new NodeTree<T>();
	NodeTree<T>* tree2 = new NodeTree<T>(); 
    for (int i=0; i<strlen(postfix); i++) { 
        if (!isOperator(postfix[i])) 
        { 
            tree = new NodeTree<T>(NULL, postfix[i], NULL, NULL);
            st.push(tree); 
        } else { 
            tree = new NodeTree<T>(NULL, postfix[i], NULL, NULL); 
            tree1 = st.pop(); 
            tree2 = st.pop(); 
            tree->setRight(tree1); 
            tree->setLeft(tree2); 
            st.push(tree); 
        } 
    } 
    tree = st.pop(); 
  
    return tree; 
} 
/**@brief  isOperator
@param char c
@returns void
*/
template <class T>
bool Controller<T>:: isOperator(char c) 
{ 
    if (c == '+' || c == '-' || 
            c == '*' || c == '/' || 
            c == '^') 
        return true; 
    return false; 
} 
/**@brief  inorder
@param NodeTree<T>* tree
@returns void
*/
template <class T>
void Controller<T>:: inorder(NodeTree<T>* tree) 
{ 
	if(bt.isEmpty()){
		cout<<"Arbol vacio"<<endl;
	}else{
	    if(tree) { 
	        inorder(tree->getLeft()); 
	        cout<< tree->getData(); 
	        inorder(tree->getRight()); 
	    } 	
	}
} 
/**@brief  Destructor
@param void
@returns void
*/
template <class T>
Controller<T>::~Controller(){
	
}
#endif
