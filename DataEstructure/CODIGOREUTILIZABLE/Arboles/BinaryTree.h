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
class BinaryTree : public Tree <T> {
public:
	BinaryTree() :Tree<T>() {};
	virtual ~BinaryTree();
	void addNode(T);
	void addNodeRecursive(NodeTree<T>*&, T, NodeTree<T>*);
	void deleteNodeRecursive(NodeTree<T>*, T);
	int depthLevel(NodeTree<T>*, T, int);
	int height(NodeTree<T>*, T, int);
	void deleteNode(NodeTree<T>*);
	 void addOneDigit(NodeTree<T>* tree, NodeTree<T> tree1);
	 int sumarDigit(int, int, int);
	void postOrden(NodeTree<T>*);
	void preOrden(NodeTree<T>*);
	void inOrden(NodeTree<T>*);
	T lookRecursive(NodeTree<T>*, T);
	void deleteNode(T);
	void lookNode(T newData);
	string toString();
	void showTree(NodeTree<T>*, int);
	private:
	NodeTree<T>* maxNode(NodeTree<T>*);
	void changeNode(NodeTree<T>*, NodeTree<T>*);
	int rightLeft(NodeTree<T>*);
};

/**@brief  rightLeft
@param Node<T>* &tree
@param T newData
@returns void
*/
template <class T>
int BinaryTree<T>::rightLeft(NodeTree<T>* tree){
	int cont1 = 0, cont = 0;
		if (tree->getLeft() != NULL){
			NodeTree<T>* aux = tree->getLeft();
			while (aux != NULL) {
				if (aux->getLeft() != NULL) {
					aux = aux->getLeft();
					cont++;
				}
				else {
					aux = aux->getRight();
					cont++;
				}
			}
		}
		if(tree->getRight() != NULL){
			NodeTree<T>* aux = tree->getRight();
			while (aux != NULL) {
				if (aux->getLeft() != NULL) {
					aux = aux->getLeft();
					cont1++;
				}
				else {
					aux = aux->getRight();
					cont1++;
				}
			}
		}
		if(cont >= cont1){
			return cont;
		}else{
			return cont1;
		}
}
/**@brief  height
@param Node<T>* &tree
@param T newData
@returns void
*/
template <class T>
int BinaryTree<T>::height(NodeTree<T>*tree, T newData, int cont){
	if(this->isEmpty()){
		cout<<"Arbol vacio"<<endl;
		return cont;
	}else{
		if(tree == NULL){
			return cont;
		}else if(tree->getData() == newData){
			return rightLeft(tree);
		}else if (newData < tree->getData()){
			return height(tree->getLeft(), newData, cont);
		}else{
			return height(tree->getRight(), newData, cont);
		}
	}
}
/**@brief  height
@param Node<T>* &tree
@param T newData
@returns void
*/
template <class T>
int BinaryTree<T>::depthLevel(NodeTree<T>*tree, T newData, int cont){
	if(this->isEmpty()){
		cout<<"Arbol vacio"<<endl;
		return cont;
	}else{
		if(tree == NULL){
			return cont;
		}else if(tree->getData() == newData){
			return cont;
		}else if (newData < tree->getData()){
			return depthLevel(tree->getLeft(), newData, cont+1);
		}else{
			return depthLevel(tree->getRight(), newData, cont+1);
		}
	}
}
/**@brief  changeNode
@param Node<T>* node
@returns void
*/
template <class T>
void BinaryTree<T>::changeNode(NodeTree<T>* node, NodeTree<T>* node1){
	if(node->getDad() != NULL){
		if(node->getData() == node->getDad()->getLeft()->getData()){
			node->getDad()->setLeft(node1);
		}else if(node->getData() == node->getDad()->getRight()->getData()){
			node->getDad()->setRight(node1);	
		}
	}
	if(node1 != NULL ){
		node1->setDad(node->getDad());
	}
}

/**@brief  max
@param Node<T>* node
@returns void
*/
template <class T>
NodeTree<T>*  BinaryTree<T>::maxNode(NodeTree<T>* node){
	if(node == NULL){
		return NULL;
	}
	if(node->getRight() != NULL && node->getLeft() == NULL && node->getRight()->getRight() != NULL){
		return node->getRight()->getRight();
	}else if(node->getRight() != NULL){
		return maxNode(node->getRight());
	}else if(node->getRight() == NULL){
		return node;
	}
}
/**@brief  deleteNodeRecursive
@param Node<T>* &tree
@param T newData
@returns void
*/
template <class T>
void BinaryTree<T>::deleteNodeRecursive(NodeTree<T>* tree, T newData){
	if(this->isEmpty()){
		cout<<"Arbol vacio"<<endl;
	}else{
		if(tree == NULL){
			return;
		}else if(newData < tree->getData()){
			deleteNodeRecursive(tree->getLeft(), newData);
		}else if(newData > tree->getData()){
			deleteNodeRecursive(tree->getRight(), newData);
		}else{
			deleteNode(tree);
		}
	}
}
/**@brief  deleteNodeRecursive
@param Node<T>* &tree
@param T newData
@returns void
*/
template <class T>
void BinaryTree<T>::deleteNode(NodeTree<T>* node){
	if(node->getLeft() != NULL && node->getRight() != NULL ){
		NodeTree<T>* aux = new NodeTree<T>();
		aux = maxNode(node->getLeft());
		node->setData(aux->getData());
//		if(aux->getRight() != NULL && aux->getLeft() == NULL && (aux->getDad()->getLeft()->getData() == aux->getData()) ){
//			aux = NULL;
//		}else{
			deleteNode (aux);	
//		}
	}else if(node->getLeft() != NULL && node->getRight() == NULL ){
		changeNode(node, node->getLeft());
		delete node;
	}else if(node->getRight() != NULL && node->getLeft() == NULL){
		changeNode(node, node->getRight());
		delete node;
	}else if(node->getRight() != NULL && node->getLeft() != NULL){
		changeNode(node, NULL);
		delete node;
	}else{
		changeNode(node, NULL);
		delete node;
	}
}
/**@brief  inOrden
@param Node<T>* tree
@returns void
*/
template <class T>
void BinaryTree<T>::inOrden(NodeTree<T>* tree){
	if(this->isEmpty()){
		cout<<"Arbol vacio"<<endl;
	}else{
		if(tree == NULL){
			return;
		}else{
			inOrden(tree->getLeft());
			cout<< tree->getData()<<" - ";
			inOrden(tree->getRight());
		}
	}
}
///**@brief  sumarDigit
//@param void
//@returns void
//*/
template <class T>
int  BinaryTree<T>::sumarDigit(int num, int aux, int  sum){
	if(num == 0){
		return sum;
	}else{
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
void BinaryTree<T>::addOneDigit(NodeTree<T>* tree, NodeTree<T> tree1){
	if(this->isEmpty()){
		cout<<"Arbol vacio"<<endl;
	}else{
		if(tree == NULL){
			return;
		}else{
			inOrden(tree->getLeft());
			inOrden(tree->getRight());
		}
	}
}
/**@brief  postOrden
@param Node<T>* tree
@returns void
*/
template <class T>
void BinaryTree<T>::postOrden(NodeTree<T>* tree){
	if(this->isEmpty()){
		cout<<"Arbol vacio"<<endl;
	}else{
		if(tree == NULL){
			return;
		}else{
			postOrden(tree->getLeft());
			postOrden(tree->getRight());
			cout<< tree->getData()<<" - ";
		}
	}
}
/**@brief  preOrden
@param Node<T>* tree
@returns void
*/
template <class T>
void BinaryTree<T>::preOrden(NodeTree<T>* tree){
	if(this->isEmpty()){
		cout<<"Arbol vacio"<<endl;
	}else{
		if(tree == NULL){
			return;
		}else{
			cout<< tree->getData()<<" - ";
			preOrden(tree->getLeft());
			preOrden(tree->getRight());
		}
	}
}
/**@brief  addNodeRecursive
@param Node<T>* &tree
@param T newData
@param Node<T>* dad
@returns void
*/
template <class T>
void BinaryTree<T>::addNodeRecursive(NodeTree<T>* &tree, T newData, NodeTree<T>*dad){
	if(tree == NULL){
		tree = new NodeTree<T>(NULL, newData, NULL, dad);
	}else{
		if(newData< tree->getData()){
			addNodeRecursive(tree->left, newData, tree);
		}else{
			addNodeRecursive(tree->right, newData, tree);
		}
	}
}
/**@brief  lookRecursive
@param Node<T>* &tree
@param T newData
@returns void
*/
template <class T>
T BinaryTree<T>::lookRecursive(NodeTree<T>*tree, T newData ){
	if(this->isEmpty()){
		cout<<"Arbol vacio"<<endl;
		return NULL;
	}else{
		if(tree == NULL){
			cout<<"No existe ese nodo"<<endl;
			return NULL;
		}else if(tree->getData() == newData){
			return tree->getData();
		}else if (newData < tree->getData()){
			return lookRecursive(tree->getLeft(), newData);
		}else{
			return lookRecursive(tree->getRight(), newData);
		}
	}
}
/**@brief  showTree
@param T newData
@returns void
*/
template <class T>
void BinaryTree<T>::showTree(NodeTree<T>* tree, int cont){
	if(this->isEmpty()){
		cout<<"Arbol vacio"<<endl;
	}else{
		if(tree == NULL){
			return;
		}else{
			showTree(tree->getRight(), cont+1);
			for(int i = 0; i < cont; i++){
				cout<<"   ";
			}
			cout<<tree->getData()<<endl;
			showTree(tree->getLeft(), cont+1);
		}
	}
}

/**@brief  addNode
@param T newData
@returns void
*/
template <class T>
void BinaryTree<T>::addNode(T newData) {
	NodeTree<T>* dataNode = new NodeTree<T>(NULL, newData, NULL);
	if (this->isEmpty()) {
		this->root = dataNode;
		cout<<"Nuevo nodo"<<endl;
		//return dataNode->getData();
	}
	else {
		NodeTree<T>* aux = this->root;
		NodeTree<T>* aux1 = this->root;
		while (aux != NULL) {
			aux1 = aux;
			if (newData < aux->getData()) {
				aux = aux->getLeft();
			}
			else {
				aux = aux->getRight();
			}
		}
		if (newData < aux1->getData()) {
			aux1->setLeft(dataNode);
		}
		else {
			aux1->setRight(dataNode);
		}
		//return dataNode->getData();
	}
}
/**@brief  lookNode
@param T newData
@returns void
*/
template <class T>
void BinaryTree<T>::lookNode(T newData) {
	if (this->isEmpty()) {
		cout << "Nodo vacio" << endl;
		return ;
	}
	else {
		NodeTree<T>* aux = this->root;
		while (aux != NULL && newData != aux->getData()) {
			if (newData < aux->getData()) {
				aux = aux->getLetf();
			}
			else {
				aux = aux->getRight();
			}
		}
		if (aux == NULL) {
			cout << "No existe" << endl;
			return ;
		}
		else {
			//return aux->getData();
		}
	}
}
/**@brief  deleteNode
@param T newData
@returns void
*/
template <class T>
void BinaryTree<T>::deleteNode(T newData) {
	if (this->isEmpty()) {
		cout << "Nodo vacio" << endl;
		//return 1;
	}
	else {
		NodeTree<T>* aux = this->root;
		//	Node<T>* aux1 = this->root;
		while (aux != NULL && newData != aux->getData()) {
			//aux1 = aux;
			if (newData < aux->getData()) {
				aux = aux->getLeft();
			}
			else {
				aux = aux->getRight();
			}
		}
		if (aux == NULL) {
			cout << "No existe" << endl;
		}
		else {
			if (aux->getLeft() != NULL && aux->getRight() != NULL) {
				NodeTree<T>* aux1 = aux->getLeft();
				NodeTree<T>* aux2 = aux1;
				while (aux1 != NULL) {
					aux2 = aux1;
					aux1 = aux1->getRight();
				}
				aux = aux2;
			}
			else if (aux->getLeft() != NULL && aux->getRight() == NULL) {
				NodeTree<T>* aux1 = aux->getLeft();
				aux = aux1;
			}
			else if (aux->getLeft() == NULL && aux->getRight() != NULL) {
				NodeTree<T>* aux1 = aux->getRight();
				aux = aux1;
			}
			else {
				delete aux;
			}
		}
		//return 2;
	}
}
/**@brief  toString
@param T newData
@returns void
*/
template <class T>
string BinaryTree<T>::toString() {
	return " ";
}
/**@brief  Destructor
@param T newData
@returns void
*/
template <class T>
BinaryTree<T>::~BinaryTree() {
	this->root = NULL;
}
#endif
