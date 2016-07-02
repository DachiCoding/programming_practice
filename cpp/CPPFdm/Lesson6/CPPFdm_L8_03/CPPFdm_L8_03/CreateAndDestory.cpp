//
//  CreateAndDestory.cpp
//  CPPFdm_L8_03
//
//  Created by DACHI XU on 7/25/13.
//  Copyright (c) 2013 DACHI XU. All rights reserved.
//

#include <iostream>
using std::cout;
using std::endl;

#include "CreateAndDestory.h"

CreateAndDestory::CreateAndDestory(int ID,string messageString)
{
    objectID=ID;
    message=messageString;
    
    cout<<"ObjectID: "<<objectID<<" constructors runs"<<message<<endl;
}

CreateAndDestory::~CreateAndDestory()
{
    cout<<"ObjectID: "<<objectID<<" deconstructors runs"<<message<<endl;
}