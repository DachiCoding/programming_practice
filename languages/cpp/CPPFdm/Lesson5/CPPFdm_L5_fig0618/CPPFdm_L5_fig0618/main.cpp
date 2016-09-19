//
//  main.cpp
//  CPPFdm_L5_fig0618
//
//  Created by DACHI XU on 7/22/13.
//  Copyright (c) 2013 DACHI XU. All rights reserved.
//

#include <iostream>
using std::cout;
using std::endl;
  
int squareByValue(int x=4);
void squareByReference(int &);

int main(int argc, const char * argv[])
{
    int x=2;
    int z=4;
    
    cout<<"x = "<< x <<" before squareByValue"<<endl;
    cout<<"Value returned by squareByValue: "<<squareByValue(x)<<endl;
    cout<<"Value returned by squareByValue with default argm : "<<squareByValue()<<endl;
    cout<<"x = "<< x <<" after squareByValue"<<endl;
        
    cout<<"z = "<< z <<" before squareByReference"<<endl;
    squareByReference(z);
    cout<<"z = "<< z <<" after squareByReference"<<endl;
    
    return 0;
}

int squareByValue(int number)
{
    return number*number;
}

void squareByReference(int &numberRef)
{
    numberRef*=numberRef;
    cout<<numberRef<<" returned by squareByReference"<<endl;
}