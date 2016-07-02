#include <iostream>

using namespace std;

class Box {
    public:
        static int objectCount;

        Box(){
            //cout << "A Box is no one." << endl;
            objectCount++;
        }

        ~Box(){
            //cout << "A Box needs to die." << endl;
        }

        double getVolume(void){
            return length * breadth * height;
        }

        static int getCount(){
            return objectCount;
        }

        void setLength(double len){
            length = len;
        }

        void setBreadth(double bre){
            breadth = bre;
        }

        void setHeight(double hei){
            height = hei;
        }

        Box operator+(const Box&b){
            Box box;
            box.length = this->length + b.length;
            box.breadth = this->breadth + b.breadth;
            box.height = this->height + b.height;
            return box;
        }

    private:
        double length;
        double breadth;
        double height;
};

int Box::objectCount = 0;

int main(){

    //cout << Box::getCount() << endl;

    //Box Box1;
    //double volume = 0.0;

    //Box1.height = 5.0;
    //Box1.length = 6.0;
    //Box1.breadth = 7.0;

    //volume = Box1.getVolume();
    //cout << volume << endl;

    //cout << Box::getCount() << endl;
    Box b1;
    Box b2;
    Box b3;

    b1.setLength(6.0);
    b1.setBreadth(7.0);
    b1.setHeight(5.0);

    b2.setLength(12.0);
    b2.setBreadth(13.0);
    b2.setHeight(10.0);

    cout << b1.getVolume() << endl;
    cout << b2.getVolume() << endl;
    b3 = b1 + b2;
    cout << b3.getVolume() << endl;

    return 0;
}

