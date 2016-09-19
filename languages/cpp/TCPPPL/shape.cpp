#include <iostream>

using namespace std;

class Shape {
    protected:
        int width, height;

    public:
        Shape(int a = 0, int b = 0){
            width = a;
            height = b;
        }

        virtual int area(){
            return 0;
        }

        void setWidth(int w){
            width = w;
        }
        void setHeight(int h){
            height = h;
        }
};

class PiantCost {
    public:
        int getCost(int area){
            return area * 70;
        }
};

class Rectangle: public Shape, public PiantCost {
    public:
        Rectangle(int a = 0, int b = 0):Shape(a, b){}
        int area(){
            return getArea();
        }

        int getArea(){
            return (width * height);
        }
};

class Triangle: public Shape {
    public:
        Triangle(int a = 0, int b = 0):Shape(a,b){}
        int area(){
            return (width*height/2);
        }
};

int main(void){
    /*
    Rectangle Rect;
    Rect.setWidth(5);
    Rect.setHeight(7);
    int area = Rect.getArea();

    cout << Rect.getArea() << endl;
    cout << Rect.getCost(area) << endl;
    */

    Shape *shape;
    Rectangle rec(10,7);
    Triangle tri(10,5);

    shape = &rec;
    cout << shape->area() << endl;
    shape = &tri;
    cout << shape->area() << endl;

    return 0;
}
