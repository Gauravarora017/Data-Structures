#include<bits/stdc++.h>
using namespace std;

class Node{

    public:
    int data;
    Node* next;

    //constructor
    Node(int d){
        this->data=d;
        this->next=NULL;
    }

    //destructor
    ~Node(){
        int value=this->data;
        if(this->next!=NULL){
            delete next;
            next=NULL;
        }
        cout<<"Memory is free for the node of data "<<value<<endl;
    }

};


void insertNode(Node* &tail,int element,int d){

    //empty list
    if(tail==NULL){
        Node* newNode= new Node(d);
        tail=newNode;
        newNode->next=newNode;
    }

    else{

        //non empty list-> assuming that element is present in the list

        Node*curr=tail;
        while(curr->data!=element){
            curr=curr->next;
        }

        //element found-> curr is representing the element

        Node* temp= new Node(d);
        temp->next=curr->next;
        curr->next=temp;
    }
}

void print(Node* tail){
    Node* temp=tail;

    do{
        cout<<tail->data<<" ";
        tail=tail->next;
    }
    while(tail!=temp);
    cout<<endl;
}

void deleteNode(Node* &tail, int value){

    //empty list
    if(tail==NULL){
        cout<<"List is empty"<<endl;
        return;
    }

    else{
        //non empty list

        Node* previous=tail;
        Node* curr= previous->next;

        while(curr->data!=value){
            previous=curr;
            curr=curr->next;
        }

        previous->next=curr->next;
        if(tail==NULL){
            tail=previous;
        }
        curr->next=NULL;
        delete curr;
    }
}

int main(){

    Node* tail=NULL;
    
    insertNode(tail,5,3);
    print(tail);

    insertNode(tail,3,5);
    print(tail);

    insertNode(tail,5,7);
    print(tail);

    insertNode(tail,5,22);
    print(tail);

    deleteNode(tail,5);
    print(tail);
    

                

return 0;
}
