#include <stdio.h>

int main(){
 float fahr,celsius;
 float lower,upper,step;

 lower = -17.8;
 upper = 148.9;
 step = 12.0*(5.0/9.0);

 celsius = lower;
 while(celsius <= upper) {
  fahr = celsius * (9.0/5.0) + 32;
  printf("%6.1f %3.0f\n",celsius,fahr);
  celsius = celsius + step;
  }
}
