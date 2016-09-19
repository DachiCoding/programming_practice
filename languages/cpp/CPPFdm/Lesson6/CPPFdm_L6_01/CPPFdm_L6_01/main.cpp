//
//  main.cpp
//  CPPFdm_L6_01
//
//  Created by DACHI XU on 7/23/13.
//  Copyright (c) 2013 DACHI XU. All rights reserved.
//

#include <iostream>
using std::cout;
using std::cin;
using std::endl;

#include <iomanip>
using std::setw;

void staticArrayInit(void);
void automaticArrayInit(void);

int main(int argc, const char * argv[])
{
    /* Number Array
    int n[10]; //class x[]
    
    for (int i=0;i<10;i++)
        n[i]=i;
    
    cout<<"Element"<<setw(13)<<"Value"<<endl;
    
    for (int j=0;j<10;j++)
        cout<<setw(7)<<j<<setw(13)<<n[j]<<endl;
    */
    
    /* Char Array
    char string1[20];
    char string2[]="string literal";
    
    cout<<"Enter the string\"hello there\": ";
    cin>>string1;
    cout<<"string1 is "<<string1<<"\nstring2 is:"<<string2;
    */
    
    cout<<"First call to each function:\n";
    staticArrayInit();
    automaticArrayInit();
    
    cout<<"\n\nSecond call to each function:\n";
    staticArrayInit();
    automaticArrayInit();
    cout<<endl;
     
    return 0;
}


void staticArrayInit(void)
{
    static int array1[3]={1,2,3};
    cout<<"\nValues on entering\n";
    for (int i=0;i<3; i++) {
        cout<<"array1["<<i<<"]="<<array1[i]<<" ";
    cout<<"\nValues on exiting\n";
    }
    
    for (int j=0;j<3;j++)
        cout<<"array1["<<j<<"]="<<(array1[j]+=5)<<" ";
    cout<<endl;
}

void automaticArrayInit(void)
{
    int array2[3]={1,2,3};
    cout<<"\nValues on entering\n";
    for (int i=0;i<3; i++) {
        cout<<"array2["<<i<<"]="<<array2[i]<<" ";
        cout<<"\nValues on exiting\n";
    }
    
    for (int j=0;j<3;j++)
        cout<<"array2["<<j<<"]="<<(array2[j]+=5)<<" ";
    cout<<endl;
}


