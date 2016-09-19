#include <iostream>
#include <cmath>
#include <ctime>
#include <cstdlib>
#include <iomanip>
#include <cstring>
#include <ctime>

using namespace std;
using std::setw;

#define LENGTH 10
#define WIDTH 5
#define NEWLINE '\n'

//########################################
double square(double x){
    return x * x;
}

void print_square(double x){
    cout << "The square of " << x << " is " << square(x) << "\n";
}

//########################################
void print_type_size(){
    cout << "Size of char : " << sizeof(char) << endl;
    cout << "Size of int : " << sizeof(int) << endl;
    cout << "Size of short int : " << sizeof(short int) << endl;
    cout << "Size of long int : " << sizeof(long int) << endl;
    cout << "Size of float : " << sizeof(float) << endl;
    cout << "Size of double : " << sizeof(double) << endl;
    cout << "Size of wchar_t : " << sizeof(wchar_t) << endl;
}

//########################################
void print_area(){
    int area;
    area = LENGTH * WIDTH;
    cout << area;
    cout << NEWLINE;
}

//########################################
void print_area2(){
    const int length = 20;
    const int width = 10;
    const char newline = '\n';
    int area;
    area = length*width;
    cout << area;
    cout << newline;
}

//########################################
void print_signed_num(){
    short int i;
    short unsigned int j;
    j = 50000;
    i = j;
    cout << i << " " << j << endl;
}

//########################################
void var_storage(){
    int mount;
    auto int month;
    register int miles;
}

//########################################
void func(void);
static int cc = 10;

void func(void){
    static int i = 5;
    i++;
    cout << " i : " << i << " , count : " << cc << endl;
}

void print_static_var(){
    while(cc--){
        func();
    }
}

//########################################
//int cnt;
//extern void write_extern();
//
//void print_extern(){
//    cnt = 5;
//    write_extern();
//}

//########################################
void print_operations(){
    int a = 21;
    int b = 10;
    int c;

    c = a + b;
    cout << c << endl;
    c = a - b;
    cout << c << endl;
    c = a * b;
    cout << c << endl;
    c = a / b;
    cout << c << endl;
    c = a % b;
    cout << c << endl;
    c = a++;
    cout << c << endl;
    c = a--;
    cout << c << endl;


    short s = 10;
    int i = -1000;
    long l = 100000;
    float f = 230.47;
    double d = 200.374;

    cout << "sin(d) : " << sin(d) << endl;
    cout << "abs(i) : " << abs(i) << endl;
    cout << "floor(d) : " << floor(d) << endl;
    cout << "sqrt(f) : " << sqrt(f) << endl;
    cout << "pow(d, 2) : " << pow(d,2) << endl;
}

//########################################
void random_number(){
    int i, j;
    srand((unsigned) time (NULL));
    for(i = 0; i < 10; i++){
        j = rand();
        cout << "Random number: " << j << endl;
    }
}

void print_array(){
    int n[10];
    for(int i = 0; i < 10; i++){
        n[i] = i + 100;
    }
    cout << "Element " << setw(13) << "Value" << endl;

    for(int i = 0; i < 10; i++){
        cout << setw(7) << i << setw(13) << n[i] << endl;
    }
}

void string_ops(){
    char str1[10] = "Hello";
    char str2[10] = "World";
    char str3[10];
    int len;

    strcpy(str3,str1);
    cout << "strcpy(str3,str1) : " << str3 << endl;
    strcpy(str1,str2);
    cout << "strcat(str1,str2) : " << str1 << endl;
    len = strlen(str1);
    cout << "strlen(str1) : " << len << endl;
}

void print_pointers(){
    int var = 20;
    int *ip;

    cout << ip << endl;
    cout << *ip << endl;

    ip = &var;

    cout << var << endl;
    cout << ip << endl;
    cout << *ip << endl;

}

void print_ref(){
    int i;
    double d;

    int& r = i;
    double& s = d;

    i = 5;
    cout << i << endl;
    cout << r << endl;

    d = 11.7;
    cout << d << endl;
    cout << s << endl;
}

void print_time(){
    time_t now = time(0);
    char* dt = ctime(&now);
    cout << dt << endl;

    tm *ltm = localtime(&now);
    cout << 1900 + ltm->tm_year << endl;
    cout << 1 + ltm->tm_mon << endl;
    cout << ltm -> tm_mday << endl;
    cout << 1 + ltm->tm_hour << ":";
    cout << 1 + ltm->tm_min << ":";
    cout << 1 + ltm->tm_sec << endl;
}

void in_out(){
    char name[50];
    cout << "Please enter your name: ";
    cin >> name;
    cout << "Your name is " << name << endl;
}

struct Books {
    char title[50];
    char author[50];
    char subject[100];
    int book_id;
};

void print_book(struct Books book);
void print_book2(struct Books *book);

void print_struct(){
    struct Books Book1;
    strcpy(Book1.title, "Learn C++ Programming");
    strcpy(Book1.author, "Chand Miyan");
    strcpy(Book1.subject, "C++ Programming");
    Book1.book_id = 6495407;
    
    print_book(Book1);
    print_book2(&Book1);

}

void print_book(struct Books book){
    cout << book.title << endl;
    cout << book.author << endl;
    cout << book.subject << endl;
    cout << book.book_id << endl; 
}

void print_book2(struct Books *book){
    cout << book->title << endl;
    cout << book->author << endl;
    cout << book->subject << endl;
    cout << book->book_id << endl; 
}

int main(){
    //print_square(1.234);
    //print_type_size();
    //print_area();
    //print_area2();
    //print_signed_num();
    //print_static_var();
    //print_extern();
    //print_operations();
    //random_number();
    //print_array();
    //string_ops();
    //print_pointers();
    //print_ref();
    //print_time();
    //in_out();
    print_struct();

    return 0;
}
