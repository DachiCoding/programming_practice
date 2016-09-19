#include <iostream>

extern int cnt;

void write_extern(void){
    std::cout << "Count is " << cnt << std::endl;
}
