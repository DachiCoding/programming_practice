#include <iostream>
using std::cout;
using std::cin;
using std::endl;
//#include <string>
//using std::string;
#include "GradeBook.h"


int main()
{
	string courseName;
	cout<<"Please enter the course name: \n";
	std::getline(cin,courseName);
	GradeBook gradebook1( courseName );
	cout<<" gradebook1 created for course: "<<gradebook1.getCourseName()<<endl;
	return 0;
}