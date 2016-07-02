#include <stdio.h>

void main()
{
 const float Revenue_Per_150=4.5f;
 short JanSold = 23500;
 short FebSold = 19300;
 short MarSold = 21600;
 float RevQuarter = 0.0f;

 long QuarterSold = JanSold + FebSold + MarSold;
 printf("\nStock sold in \n Jan:%d\n Feb:%d\n Mar:%d",JanSold,FebSold,MarSold);
 printf("\nTotal stock sold in first quarter:%ld",QuarterSold);
 RevQuarter = QuarterSold*Revenue_Per_150/150;
 printf("\nSales revenue this quarter is:$%.2f\n",RevQuarter);
}
