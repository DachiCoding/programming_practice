#include <stdio.h>
#include <limits.h>
#include <float.h>

void main()
{
 printf("Variable of type char store values from %d to %d",CHAR_MIN,CHAR_MAX);
 printf("\nVariable of type unsigend char store values from 0 to %u",UCHAR_MAX);
 printf("\nVariable of type short store values from %d to %d",SHRT_MIN,SHRT_MAX);
 printf("\nVariable of type unsigned short store values from 0 to %u",USHRT_MAX);
 printf("\nVariable of type int store values from %d to %d",INT_MIN,INT_MAX);
 printf("\nVariable of type unsigned int store values from 0 to %u",UINT_MAX);
 printf("\nVariable of type long store values from %d to %d",LONG_MIN,LONG_MAX);
 printf("\nVariable of type unsigned long store values from 0 to %d",ULONG_MAX);
 printf("\n\nThe size of the smallest non-zero value of type float is %.3e",FLT_MIN);
 printf("\n\nThe size of the largest non-zero value of type float is %.3e",FLT_MAX);
 printf("\n\nThe size of the smallest non-zero value of type double is %.3e",DBL_MIN);
 printf("\n\nThe size of the largest non-zero value of type double is %.3e",DBL_MAX);
 printf("\n");
}
