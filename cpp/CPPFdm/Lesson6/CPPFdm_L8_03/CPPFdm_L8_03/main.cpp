//
//  main.cpp
//  CPPFdm_L8_03
//
//  Created by DACHI XU on 7/25/13.
//  Copyright (c) 2013 DACHI XU. All rights reserved.
//

#include <iostream>
using std::cout;
using std::endl;

#include "CreateAndDestory.h"
void create(void);

CreateAndDestory first(1,"(global before main)");

int main(int argc, const char * argv[])
{
    cout<<"\nMAIN FUNCTION:EXCUTION BEGINS"<<endl;
    CreateAndDestory second(2,"(local automatic in main)");
    static CreateAndDestory third(3,"(local static in main)");
    
    create();
    
    cout<<"\nMAIN FUNCTION: EXECUTION RESUMES"<<endl;
    CreateAndDestory fourth(4,"(local automaic in main)");
    cout<<"\nMAIN FUNCTION: EXECUTION ENDS"<<endl;
    
    return 0;
}

void create(void)
{
    cout<<"\nCREATE FUNCTION: EXECUTION BEGINS"<<endl;
    CreateAndDestory fifth(5,"(local automatic in create)");
    static CreateAndDestory six(6,"(local static in create)");
    CreateAndDestory seven(7,"(local automatic in create)");
}