#include <iostream>
using namespace std;

class printData {
    public:
        void print(int i){
            cout << i << endl;
        }

        void print(double f){
            cout << f << endl;
        }

        void print(char* c){
            cout << c << endl;
        }
};

int main(void){
    printData pd;
    pd.print(5);
    pd.print(500.263);
    pd.print("Radio GaGa!");
    return 0;
}
