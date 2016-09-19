//
//  main.cpp
//  CPPFdm_L6_02
//
//  Created by DACHI XU on 7/24/13.
//  Copyright (c) 2013 DACHI XU. All rights reserved.
//

#include <iostream>
using std::cout;
using std::endl;

#include <iomanip>
using std::setw;

void modifyArray(int[],int);
void modifyElement(int);

int main(int argc, const char * argv[])
{

    const int arraySize=5;
    int a[arraySize]={0,1,2,3,4};
    
    cout<<"The values of the original array are:\n";
    
    for (int i=0;i<arraySize;i++)
        cout<<setw(3)<<a[i];
    
    cout<<"\n\nThe values after modifyArray:\n";
    
    modifyArray(a, arraySize);
    
    for (int i=0;i<arraySize;i++)
        cout<<setw(3)<<a[i];
    
    cout<<"\n\n";
    
    modifyElement(a[3]);
    
    for (int i=0;i<arraySize;i++)
        cout<<setw(3)<<a[i];
    
    return 0;
}
 
void modifyArray(int b[],int sizeOfArray)
{
    for (int k=0;k<sizeOfArray;k++)
        b[k]*=2;
}

void modifyElement(int e)
{
    cout<<"Values of element in modifyElement: "<<(e*=2)<<endl;
}
