//
//  maximum.h
//  CPPFdm_L5_fig0623
//
//  Created by DACHI XU on 7/22/13.
//  Copyright (c) 2013 DACHI XU. All rights reserved.
//

#ifndef CPPFdm_L5_fig0623_maximum_h
#define CPPFdm_L5_fig0623_maximum_h

template <class T>

T maximum(T value1,T value2,T value3)
{
    T maximumValue=value1;
    
    if (value2>maximumValue)
        maximumValue=value2;
        
    if (value3>maximumValue)
        maximumValue=value3;
        
    return maximumValue;
}


#endif
