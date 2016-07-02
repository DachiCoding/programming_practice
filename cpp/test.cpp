//C++ Practice
/*
Dachi Xu
2015-02-15
*/

#include <iostream>
#include <string>
using namespace std;

const double pi = 3.14159;
#define PI 3.14159

class Rectangle {
  int width,height;
  public:
    Rectangle (int,int);
    void set_values(int,int);
    int area() {return width*height;}
};

Rectangle::Rectangle(int a, int b){
  width = a;
  height = b;
}

void Rectangle::set_values(int x, int y){
  width = x;
  height = y;
}

int addition(int a, int b)
{
  int r;
  r = a + b;
  return r;
}

int operate(int a, int b)
{
  return (a*b);
}

double operate(double a, double b)
{
  return (a/b);
}

template <class T>
T sum(T a, T b)
{
  T result;
  result = a + b;
  return result;
}

int main()
{
  //cout << "Hello World!\n";
  //cout << "I am a c++ program!\n";

  /*
  int a,b;
  int result;
  a = 5;
  b = 2;
  a = a + 1;
  result = a - b;
  cout << result << endl;
  */

  /*
  string str1 = "This is string.";
  string str2 ("This is string.");
  //string str3 {"This is string."};
  cout << str1 << endl;
  cout << str2 << endl;
  //cout << str3 << endl;
  */

  /*
  double r=5.0;
  double circle;
  circle = 2 * PI * r;
  cout << circle << endl;
  */

  /*
  int i ;
  cout << "Please enter an integer value: ";
  cin >> i;
  cout << "The value you entered is " << i;
  cout << " and its double its " << i*2 << ".\n";
  */

  /*
  string mystr;
  cout << "What's your name? ";
  getline(cin,mystr);
  cout << "Hello " << mystr << ".\n";
  cout << "What is your favorite team? ";
  getline(cin,mystr);
  cout << "I like " << mystr << " too!\n";
  */

  /*
  string str = "Hello!";
  for (char c : str)
  {
    cout << "[" << c << "]";
  }
  cout << endl;
  */
  
  /*
  int z;
  z= addition(5,3);
  cout << "The result is " << z << endl;
  */

  /*
  int x = 5, y = 2;
  double n = 5.0, m = 2.0;
  cout << operate(x,y) << endl;
  cout << operate(n,m) << endl;
  */

  /*
  int i=5, j=6, k;
  string str1="Hello,", str2="world!",str3;
  k=sum<int>(i,j);
  str3=sum<string>(str1,str2);
  cout << k << endl;
  cout << str3 << endl;
  */

  Rectangle rect;
  rect.set_values(3,4);
  cout << "area: " << rect.area() << endl;
   	

  //End of function
  return 0;
}
