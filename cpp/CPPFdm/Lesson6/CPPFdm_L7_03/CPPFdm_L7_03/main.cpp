//
//  main.cpp
//  CPPFdm_L7_03
//
//  Created by DACHI XU on 7/24/13.
//  Copyright (c) 2013 DACHI XU. All rights reserved.
//

#include <iostream>
using std::cout;
using std::cin;
using std::endl;

#include <iomanip>
using std::setw;

#include <cctype>
using std::islower;
using std::toupper;

size_t getSize(double *);

void convertToUpperCase(char *);

void printCharacters( const char *);

void selectionSort(int [],const int,bool (*)(int,int));
void swap(int * const,int * const);
bool ascending(int,int);
bool descending(int,int);

void foo0(int);
void foo1(int);
void foo2(int);

int main()
{
    /* convertToUpperCase Test
    char phrase[] ="characters and $32.98";
    cout<<"The phrase before conversion is: "<<phrase<<endl;
    convertToUpperCase(phrase);
    cout<<"The phrase after conversion is: "<<phrase<<endl;
    */
    
    /*
    const char phrase[]="print characters of a string";
    cout<<"The string is:\n";
    printCharacters(phrase);
    cout<<endl;
    */
    
    /* const ptr
    int x,y;
    int *const ptr=&x;
    *ptr=7; //allowed sicne the value is not const
    // ptr=&y; error since ptr address is const
    */
    
    /* const ptr ref to const value
    int x=5,y;
    const int *const ptr = &x;
    cout<<*ptr<<endl;
    *ptr=7; error, value is const
    otr=&y; error, address is const
    */
    
    /* sizeof
    double array[20];
    cout<<"bytes of array is "<<sizeof(array)<<endl;
    cout<<"bytes of ptr   is "<<getSize(array)<<endl;
    */
    
    /* get value by ptr
    int b[]={10,20,30,40};
    int *bPtr=b;
    
    cout<<"print array:\n";
    for (int i=0; i<4; i++) {
        cout<<"\nb["<<i<<"]"<<b[i]<<"\n";
    }
    
    cout<<endl;
    
    cout<<"print array by offset: ";
    for (int offset1=0;offset1<4;offset1++) {
        cout<<"\n(b+"<<offset1<<")="<<*(b+offset1)<<"\n";
    }
    
    cout<<endl;
    
    cout<<"print array by ptr: ";
    for (int offset2=0;offset2<4;offset2++) {
        cout<<"\nbPtr["<<offset2<<"]="<<bPtr[offset2]<<"\n";
    }
    */
    
    /* WTF point test
    const int arraySize=210;
    int order;
    int counter;
    int a[arraySize]={2,6,4,8,10,12,89,68,45,37};
    
    cout<<"Enter 1 to sort in ascending order, 2 for descending order: ";
    cin>>order;
    cout<<"\nData items in original order\n";
    
    for (counter=0;counter<arraySize;counter++)
        cout<<setw(4)<<a[counter];
    
    if (order==1)
    {
        selectionSort(a,arraySize,ascending);
        cout<<"\nData items in ascending order\n";
    }
    else
    {
        selectionSort(a,arraySize,descending);
        cout<<"\nData items in descending order\n";
    }
    */
    
    void(*f[3])(int)={foo0,foo1,foo2};
    int choice;
    cout<<"Enter Choice: "<<endl;
    cin>>choice;
    
    while ((choice>=0) && (choice<3))
    {
        (*f[choice])(choice);
        
        cout<<"Enter a number between 0 and 2,or 3 to end"<<endl;
        cin>>choice;
    }
    
    return 0;
}

void convertToUpperCase(char *sPtr)
{
    while (*sPtr !='\0')
    {
        if (islower(*sPtr))
            *sPtr=toupper(*sPtr);
        
        sPtr++;
    }
}

void printCharactrers(const char *sPtr)
{
    for (;*sPtr!='\0';sPtr++)
        cout<<*sPtr;
}

size_t getSize(double *ptr)
{
    return sizeof(*ptr);
}

void selectionSort(int work[],const int size,bool(*compare(int,int)))
{
    int smallestOrLargest;
    
    for (int i=0;i<size-1;i++)
    {
        smallestOrLargest = i;
        
        for (int index=i+1;index<size;index++)
            if (!(*compare)(work[smallestOrLargest],work[index]))
                smallestOrLargest=index;
        
        swap(&work[smallestOrLargest],&work[i]);
    }
}

void swap(int * const element1Ptr, int * const element2Ptr)
{
    int hold = *element1Ptr;
    *element1Ptr = *element2Ptr;
    *element2Ptr = hold;
}

bool ascending(int a,int b)
{
    return a<b;
}

bool descending(int a,int b)
{
    return a>b;
}

void foo0(int a)
{
    cout<<"You entered "<<a<<" so foo0 is called"<<endl;
}

void foo1(int b)
{
    cout<<"You entered "<<b<<" so foo1 is called"<<endl;
}

void foo2(int c)
{
    cout<<"You entered "<<c<<" so foo2 is called"<<endl;
}


