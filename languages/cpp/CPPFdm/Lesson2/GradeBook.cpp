#include<iostream>
//#include<string>
using std::cout;
using std::endl;
//using std::string;

#include "GradeBook.h"

GradeBook::GradeBook(string name)
{
	setCourseName(name);
}
	
void GradeBook::setCourseName(string name)
{
  if (name.length()<=25)	
  courseName = name;
  else
  {
  courseName = name.substr(0,25);
  cout<< "Name \"" <<name<< "\" exceeds maximum length (25).\n"<<"Limiting courseName to first 25 characters.\n"<<endl;
  }
}

string GradeBook::getCourseName()
{
   return courseName;
}
	
void GradeBook::displayMessage()
{
  cout << "Welcome to the gradebook for \n" << getCourseName();
}
