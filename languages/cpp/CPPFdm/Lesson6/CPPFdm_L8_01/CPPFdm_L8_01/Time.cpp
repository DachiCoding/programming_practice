//
//  Time.cpp
//  CPPFdm_L8_01
//
//  Created by DACHI XU on 7/25/13.
//  Copyright (c) 2013 DACHI XU. All rights reserved.
//

#include <iostream>
using std::cout;
using std::endl;

#include <iomanip>
using std::setfill;
using std::setw;

#include "Time.h"

Time::Time(int hr=0,int min=0,int sec=0)
{
    setTime(hr, min, sec);
}

void Time::setTime(int h, int m, int s)
{
    setHour(h);
    setMinute(m);
    setSecond(s);
}

void Time:: setHour(int h)
{
    hour=(h>0 && h<24)? h:0;
}

void Time::setMinute(int m)
{
    minute=(m>0 && m<24)? m:0;
}

void Time::setSecond(int s)
{
    second=(s>0 && s<24)? s:0;
}

void Time::printUniversal()
{
    cout<<setfill('0')<<setw(2)<<hour<<":"<<setw(2)<<minute<<":"<<setw(2)<<second<<endl;
}

int Time::getHour()
{
    return hour;
}

int Time::getMinute()
{
    return minute;
}

int Time::getSecond()
{
    return second;
}

void Time::printStandard()
{
    cout<< (( hour==0 || hour==12) ? 12:hour % 12 )<<":"<<setfill('0')<<setw(2)<<minute<<":"<<setw(2)<<second<<(hour<12 ? "AM":"PM");
}