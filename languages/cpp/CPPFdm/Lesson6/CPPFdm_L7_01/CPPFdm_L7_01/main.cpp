//
//  main.cpp
//  CPPFdm_L7_01
//
//  Created by DACHI XU on 7/24/13.
//  Copyright (c) 2013 DACHI XU. All rights reserved.
//

#include <iostream>
using std::cout;
using std::endl;

int main(int argc, const char * argv[])
{
    int a;
    int *aPtr;
    
    a=7;
    aPtr=&a;
    
    cout<<"Address of a is "<<&a<<endl;
    cout<<"Value of pointer is "<<aPtr<<endl;
    cout<<"Value of the variable pointer is ref:"<<*aPtr<<endl;
    cout<<"&*aPtr is "<<&*aPtr<<endl;
    cout<<"*&aPtr is "<<*&aPtr<<endl;

    return 0;
}

