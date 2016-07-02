#include<iostream>
//#include<string>
using std::cout;
using std::cin;
using std::endl;
using std::fixed;
//using std::string;
#include <iomanip>
using std::setprecision;

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
  cout << "Welcome to the gradebook for \n" << getCourseName() << endl;
}

void GradeBook::determineClassAverage()
{
  int total;
  int gradeCounter;
  int grade;
  double average;
  
  total=0;
  gradeCounter=0;
  
  cout << "Enter grade or -1 to quit: ";
  cin >> grade;
  
  while (grade != -1 )
  {
  	cout << "Enter grade or -1 to quit: ";
    cin >> grade;
  	total = total + grade;
  	gradeCounter = gradeCounter + 1;
  }
  
  if ( gradeCounter != 0 )
  {
  	average = static_cast<double> (total)/gradeCounter;
 	cout << "\nTotal of grades entered is " << total <<endl;
  	cout << "Class average is "<< average << endl; 
  }
  else
  	cout<< "No grades were entered" << endl;
}