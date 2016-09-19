//
//  main.cpp
//  CPPFdm_L5_fig0623
//
//  Created by DACHI XU on 7/22/13.
//  Copyright (c) 2013 DACHI XU. All rights reserved.
//

#include <iostream>
using std::cout;
using std::endl;

#include <string>
using std::string;

#include "maximum.h"

int square(int x)
{
    cout<<"square of integer "<<x<<" is ";
    return x*x;
}

double square(double y)
{
    cout<<"square of double "<<y<<" is ";
    return y*y;
}

int main(int argc, const char * argv[])
{
    cout<<square(7)<<endl;
    cout<<square(7.5)<<endl;
    
    int v1,v2,v3;
    v1=4;
    v2=10;
    v3=2;
    cout<<maximum(v1,v2,v3)<<endl;
    
    char c1,c2,c3;
    c1='a';
    c2='@';
    c3=':';
    cout<<maximum(c1,c2,c3)<<endl;
    
    string s1,s2,s3;
    s1="hello";
    s2="world";
    s3="cpp";
    cout<<maximum(s1,s2,s3)<<endl;
    
    return 0;
}

