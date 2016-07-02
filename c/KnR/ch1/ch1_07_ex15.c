#include <stdio.h>

int tempConvertor(int fahr);

int main()
{
 int lower = 0;
 int upper = 300;
 int step = 20;
 int temp = 0;
 
 for(temp = upper; temp > lower; temp -= step)
 {
  printf("fahr: %d, celcius: %d\n", temp,tempConvertor(temp));
 }

}

int tempConvertor(int fahr)
{
 return (fahr - 32)*5/9;
}
