/* Bitwise Operation */
#include <stdio.h>

void main()
{
 int a=1;
 int b=2;
 int c=a&b;
 int d=~a;
 int e=a|b;
 int f=a^b;
 int g=a<<3;
 int h=a>>3;
 printf("a&b: %d\n",c);
 printf("~a: %d\n",d);
 printf("a|b: %d\n",e);
 printf("a^b: %d\n",f);
 printf("a<<3: %d\n",g);
 printf("a>>3: %d\n",h);
}
