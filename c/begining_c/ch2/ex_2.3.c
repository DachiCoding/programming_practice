/* 
Input:  amounts for two different products
Output: aggregate price for all the products
*/

#include <stdio.h>

void main()
{
 int a_amount;
 int b_amount;
 float a_price=3.50f;
 float b_price=5.50f;
 float all_price=0.0f;
 printf("Please enter the amounts for product A:");
 scanf("%d",&a_amount);
 printf("Please enter the amounts for product B:");
 scanf("%d",&b_amount);
 all_price=a_amount*a_price+b_amount*b_price;
 printf("The aggregate price is %f\n",all_price);
}
