//
//  main.cpp
//  CPPFdm_L8_01
//
//  Created by DACHI XU on 7/25/13.
//  Copyright (c) 2013 DACHI XU. All rights reserved.
//

#include <iostream>
using std::cout;
using std::cin;
using std::endl;

#include "Time.h"

int main(int argc, const char * argv[])
{
    Time t1;
    Time t2;
    Time t3;
    
    cout<<"The initial universal time is ";
    t1.printUniversal();
    cout<<"The inital standard time is ";
    t1.printStandard();
    cout<<"\n\n";
    
    t1.setTime(13,27,6);
    cout<<"The universal time after setTime is ";
    t1.printUniversal();
    cout<<"The standard time after setTime is ";
    t1.printStandard();
    cout<<"\n\n";
    
    t2.setTime(99,99,99);
    cout<<"The universal time after invalid setTime is ";
    t2.printUniversal();
    cout<<"The standard time after invalid setTime is ";
    t2.printStandard();
    cout<<endl;
    
    t3.setTime(12,24,12);
    cout<<"The universal time after invalid setTime is ";
    t3.printUniversal();
    cout<<"The standard time after invalid setTime is ";
    t3.printStandard();
    cout<<endl;
    
    return 0;
}

