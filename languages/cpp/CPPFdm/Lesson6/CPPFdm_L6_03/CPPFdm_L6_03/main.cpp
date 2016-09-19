//
//  main.cpp
//  CPPFdm_L6_03
//
//  Created by DACHI XU on 7/24/13.
//  Copyright (c) 2013 DACHI XU. All rights reserved.
//

#include <iostream>


#include "GradeBook.h"

int main(int argc, const char * argv[])
{
    int gradeArray[GradeBook::students]={87,68,94,100,83,78,85,91,76,87};
    
    GradeBook myGradeBook("CS101 Introduction to C++ Programming",gradeArray);
    myGradeBook.displayMessage();
    myGradeBook.processGrades();
    
    return 0;
}

