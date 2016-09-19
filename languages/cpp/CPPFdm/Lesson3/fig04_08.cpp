#include <iostream>
using std::cout;
using std::cin;
using std::endl;
//#include <string>
//using std::string;
#include "GradeBook.h"


int main()
{
	GradeBook myGradeBook( "CS101 C++ Programming");
	myGradeBook.displayMessage();
	cout<<endl;
	myGradeBook.determineClassAverage();
	return 0;
}