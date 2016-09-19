//
//  main.cpp
//  CPPFdm_L8_02
//
//  Created by DACHI XU on 7/25/13.
//  Copyright (c) 2013 DACHI XU. All rights reserved.
//

#include <iostream>
using std::cout;
using std::endl;

class Count
{
public:
    void setX(int value){x=value;}
    void print(){cout<<x<<endl;}
private:
    int x;
};

int main(int argc, const char * argv[])
{
    Count counter;
    Count *counterPtr=&counter;
    Count &counterRef = counter;
    
    cout<<"Set counter to 1..\n";
    counter.setX(1);
    counter.print();
    
    cout<<"Set counter Ref to 2..\n";
    counterRef.setX(2);
    counter.print();
    
    cout<<"Set counter Ptr to 3..\n";
    counterPtr->setX(3);
    counterPtr->print();

    
    return 0;
}

