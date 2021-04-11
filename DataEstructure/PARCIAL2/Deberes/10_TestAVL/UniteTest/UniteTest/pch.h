#ifndef PCH_H
#define PCH_H

#include <iostream>

template<class T>
class Node
{
private:

    T key;
    int height;
    Node<T>* left;
    Node<T>* right;

public:

    Node<T>(T k);
    T getKey();
    int getHeigth();
    Node<T>* getLeft();
    Node<T>* getRigth();
    void setKey(T);
    void setHeigth(int);
    void setLeft(Node<T>*);
    void setRigth(Node<T>*);
};

template <typename T>
class AVL {
public:
    Node<T>* getRoot();
    int getN();
    void setN(int n);
    void setRoot(Node<T>* root);
    void insert(T x);
    void inorder();
    void remove(T x);
    Node<T>* removeUtil(Node<T>* head, T x);
    void inorderUtil(Node<T>* head);
private:
    Node<T>* root = NULL;
    int n;
    int height(Node<T>* head);
    Node<T>* rightRotation(Node<T>* head);
    Node<T>* leftRotation(Node<T>* head);
    Node<T>* insertUtil(Node<T>*, T);
};

template<class T>
Node<T>::Node(T k)
{
    this->height = 1;
    this->key = k;
    this->left = NULL;
    this->right = NULL;
}



template<class T>
T Node<T>::getKey() {
    return this->key;
}

template<class T>
int Node<T>::getHeigth()
{
    return this->height;
}

template<class T>
Node<T>* Node<T>::getLeft()
{
    return this->left;
}

template<class T>
Node<T>* Node<T>::getRigth()
{
    return this->right;
}

template<class T>
void Node<T>::setKey(T key)
{
    this->key = key;
}

template<class T>
void Node<T>::setHeigth(int h)
{
    this->height = h;
}

template<class T>
void Node<T>::setLeft(Node<T>* L)
{
    this->left = L;
}

template<class T>
void Node<T>::setRigth(Node<T>* R)
{
    this->right = R;
}

template <typename T>
Node<T>* AVL<T>::getRoot() {
    return root;
}

template <typename T>
int AVL<T>::getN() {
    return n;
}
template <typename T>
void AVL<T>::setRoot(Node<T>* root) {
    this->root = root;

}
template <typename T>
void AVL<T>::setN(int n) {
    this->n = n;
}

template <typename T>
void AVL<T>::insert(T x) {
    root = insertUtil(root, x);
}

template <typename T>
void AVL<T> ::inorder() {
    inorderUtil(root);
    //cout<<endl;
}

template <typename T>
void AVL<T> ::remove(T x) {
    root = removeUtil(root, x);
}

template <typename T>
int AVL<T>::height(Node<T>* head)
{
    if (head == NULL) return 0;
    return head->getHeigth();
}

template <typename T>
Node<T>* AVL<T>::rightRotation(Node<T>* head)
{
    Node<T>* newhead = head->getLeft();
    //head->getLeft() = newhead->getRigth();
    head->setLeft(newhead->getRigth());
    //newhead->getRigth() = head;
    newhead->setRigth(head);
    head->setHeigth(1 + std::max(height(head->getLeft()), height(head->getRigth())));// = 1+max(setHeight(head->getLeft()), setHeight(head->getRigth()));
    newhead->setHeigth(1 + std::max(height(newhead->getLeft()), height(newhead->getRigth())));// = 1+max(setHeight(newhead->getLeft()), setHeight(newhead->getRigth()));
    return newhead;
}
template<typename T>
Node<T>* AVL<T>::leftRotation(Node<T>* head)
{
    Node<T>* newhead = head->getRigth();
    head->setRigth(newhead->getLeft());// = newhead->getLeft();
    newhead->setLeft(head);// = head;
    head->setHeigth(1 + std::max(height(head->getLeft()), height(head->getRigth())));
    newhead->setHeigth(1 + std::max(height(newhead->getLeft()), height(newhead->getRigth())));
    return newhead;
}

template <typename T>
void AVL<T>::inorderUtil(Node<T>* head)
{
    if (head) 
    {
        inorderUtil(head->getLeft());
        std::cout << head->getKey() << " ";
        inorderUtil(head->getRigth());
    }
}

template <typename T>
Node<T>* AVL<T>::insertUtil(Node<T>* head, T x)
{
    if (head == NULL) {
        n += 1;
        Node<T>* temp = new Node<T>(x);
        return temp;
    }
    if (x < head->getKey())
        head->setLeft(insertUtil(head->getLeft(), x));
    else if (x > head->getKey())
        head->setRigth(insertUtil(head->getRigth(), x));
    head->setHeigth(1 + std::max(height(head->getLeft()), height(head->getRigth())));
    int bal = height(head->getLeft()) - height(head->getRigth());
    if (bal > 1) {
        if (x < head->getLeft()->getKey()) {
            return rightRotation(head);
        }
        else {
            head->setLeft(leftRotation(head->getLeft()));
            return rightRotation(head);
        }
    }
    else if (bal < -1) {
        if (x > head->getRigth()->getKey()) {
            return leftRotation(head);
        }
        else {
            head->setRigth(rightRotation(head->getRigth()));
            return leftRotation(head);
        }
    }
    return head;
}


template <typename T>

Node<T>* AVL <T> ::removeUtil(Node<T>* head, T x) {
    if (head == NULL) return NULL;
    if (x < head->getKey()) {
        head->setLeft(removeUtil(head->getLeft(), x)); //= removeUtil(head->getLeft(), x);
    }
    else if (x > head->getKey()) {
        head->setRigth(removeUtil(head->getRigth(), x));// = removeUtil(head->getRight(), x);
    }
    else {
        Node<T>* r = head->getRigth();
        if (head->getRigth() == NULL) {
            Node<T>* l = head->getLeft();
            delete(head);
            head = l;
        }
        else if (head->getLeft() == NULL) {
            delete(head);
            head = r;
        }
        else {
            while (r->getLeft() != NULL) r = r->getLeft();
            head->setKey(r->getKey());// = r->getKey();https:
            head->setRigth(removeUtil(head->getRigth(), r->getKey()));// = removeUtil(head->getRight(), r->getKey());///..
        }
    }
    if (head == NULL) return head;
    head->setHeigth(1 + std::max(height(head->getLeft()), height(head->getRigth()))); //= 1 + std::max(setHeight(head->getLeft()), setHeight(head->getLight));
    int bal = height(head->getLeft()) - height(head->getRigth());
    if (bal > 1) {
        if (x > head->getLeft()->getKey()) {
            return rightRotation(head);
        }
        else {
            head->setLeft(leftRotation(head->getLeft())); //= ;
            return rightRotation(head);
        }
    }
    else if (bal < -1) {
        if (x < head->getRigth()->getKey()) {
            return leftRotation(head);
        }
        else {
            head->setRigth(rightRotation(head->getRigth()));// = rightRotation(head->getRight());
            return leftRotation(head);
        }
    }
    return head;
}

#endif 
