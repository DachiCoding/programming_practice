//
//  main.cpp
//  CPPFdm_L7_02
//
//  Created by DACHI XU on 7/24/13.
//  Copyright (c) 2013 DACHI XU. All rights reserved.
//

#include <iostream>
using std::cout;
using std::endl;

int cubeByValue(int );

int cubeByRef(int &);

int cubeByPtr(int *);

int main(int argc, const char * argv[])
{
    int a=3;
    cout<<"cube by value is "<<cubeByValue(a)<<endl;
    cout<<"a is "<<a<<endl;
    cout<<"cube by ref is "<<cubeByRef(a)<<endl;
    cout<<"a is "<<a<<endl;
    cout<<"cube by ptr is "<<cubeByPtr(&a)<<endl;
    cout<<"a is "<<a<<endl;
    
    return 0;
}

int cubeByValue(int a)
{
    return a*a*a;
}

int cubeByRef(int &a)
{
    return a*a*a;
}

int cubeByPtr(int *a)
{
    *a= *a * *a * *a;
    return *a;
}