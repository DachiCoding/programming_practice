//
//  main.cpp
//  CPPFdm_L5_fig0611
//
//  Created by DACHI XU on 7/22/13.
//  Copyright (c) 2013 DACHI XU. All rights reserved.
//

#include <iostream>
using std::endl;
using std::cout;
using std::cin;

#include <iomanip>
using std::setw;

void useLocal();
void useStaticLocal();
void useGlobal();

int x=1;

int main(int argc, const char * argv[])
{
    /* Static Int Example
    for (int x=0; x<10; x++) {
        for (int y=0; y<10; y++) {
            static int num=0;
            cout<<setw(3)<<num<<" ";
            num++;
        }
        cout<<endl;
    }
    cout<<endl;
    */
    
    cout<<"global x in main is "<<x<<endl;
    
    int x=5;
    
    cout<<"local x in main's outer scope is "<<x<<endl;
    
    {
        int x=7;
        
        cout <<"local x in main's inner scope is "<<x<<endl;
    }
    
    cout<<"local x in main's outer scope is "<<x<<endl;
    
    
    useLocal();
    useStaticLocal();
    useGlobal(); //why use 1 instead of 5?
    useLocal();
    useStaticLocal();
    useGlobal();
    
    cout<<"\nlocal x in main is "<<x<<endl;
    return 0;
}

void useLocal()
{
    int x=25;
    cout<<"\nlocal x is "<<x<<" on entering useLocal"<<endl;
    x++;
    cout<<"\nlocal x is "<<x<<" on exiting useLocal"<<endl;
}

void useStaticLocal()
{
    static int x=50;
    cout<<"\nlocal x is "<<x<<" on entering useStaticLocal"<<endl;
    x++;
    cout<<"\nlocal x is "<<x<<" on exiting useStaticLocal"<<endl;
}

void useGlobal()
{
    cout<<"\nlocal x is "<<x<<" on entering useGlobal"<<endl;
    x*=10;
    cout<<"\nlocal x is "<<x<<" on exiting useGlobal"<<endl;
}






