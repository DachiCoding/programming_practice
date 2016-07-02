//
//  CreateAndDestory.h
//  CPPFdm_L8_03
//
//  Created by DACHI XU on 7/25/13.
//  Copyright (c) 2013 DACHI XU. All rights reserved.
//

#ifndef CPPFdm_L8_03_CreateAndDestory_h
#define CPPFdm_L8_03_CreateAndDestory_h

#include <string>
using std::string;

class CreateAndDestory
{
public:
    CreateAndDestory(int,string);
    ~CreateAndDestory();
private:
    int objectID;
    string message;
};


#endif
