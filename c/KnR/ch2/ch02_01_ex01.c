#include <stdio.h>
#include <limits.h>
#include <float.h>

int main()
{
 printf("The min value of char type is %d\n",CHAR_MIN);
 printf("The max value of char type is %d\n",CHAR_MAX);


 printf("The min value of short type is %d\n",SHRT_MIN);
 printf("The max value of short type is %d\n",SHRT_MAX);

 printf("The min value of int type is %d\n",INT_MIN);
 printf("The max value of int type is %d\n",INT_MAX);

 printf("The min value of long type is %ld\n",LONG_MIN);
 printf("The max value of long type is %ld\n",LONG_MAX);

 printf("The min value of float type is %f\n",FLT_MIN);
 printf("The max value of float type is %f\n",FLT_MAX);

 printf("The min value of double type is %lf\n",DBL_MIN);
 printf("The max value of double type is %lf\n",DBL_MAX);

 return 0;
}
