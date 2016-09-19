//
//  Time.h
//  CPPFdm_L8_01
//
//  Created by DACHI XU on 7/25/13.
//  Copyright (c) 2013 DACHI XU. All rights reserved.
//

#ifndef CPPFdm_L8_01_Time_h
#define CPPFdm_L8_01_Time_h

class Time
{
public:
    Time( int=0,int=0,int=0);
    void setTime(int,int,int);
    void setHour(int);
    void setMinute(int);
    void setSecond(int);
    
    int getHour();
    int getMinute();
    int getSecond();
    
    void printUniversal();
    void printStandard();
private:
    int hour;
    int minute;
    int second;
};

#endif
