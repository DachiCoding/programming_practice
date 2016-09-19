//
//  GradeBook.h
//  CPPFdm_L6_03
//
//  Created by DACHI XU on 7/24/13.
//  Copyright (c) 2013 DACHI XU. All rights reserved.
//

#ifndef CPPFdm_L6_03_GradeBook_h
#define CPPFdm_L6_03_GradeBook_h

#include <string>
using std::string;


class GradeBook
{
public:
    const static int students=10;
    GradeBook(string,const int[]);
    void setCourseName(string);
    string getCourseName();
    void displayMessage();
    void processGrades();
    int getMinimum();
    int getMaximum();
    double getAverage();
    void outputBarChart();
    void outputGrades();
private:
    string courseName;
    int grades[students];
};

#endif
