#include <iostream>
using namespace std;

int main(){
    /*
    double* pvalue = NULL;
    pvalue = new double;

    *pvalue = 29494.99;
    cout << *pvalue << endl;

    delete pvalue;
    */

    char* pvalue = NULL;
    pvalue = new char[20];
    delete [] pvalue;
    double** pvalue = NULL;
    pvalue = new double[3][4];
    delete [] pvalue;

    return 0;
}
