#include <stdio.h>

void main()
{
 int quantity=0;
 double unit_price=5.0;
 double discount=1;
 printf("Please enter the quantity you want to buy:");
 scanf("%d",&quantity);
 if (quantity > 30)
 {
  if (quantity > 50)
   discount=0.85;
  else 
   discount=0.9;
 }
 printf("You purcahse %d products and your total price is $%.2lf\n",quantity,unit_price*quantity*discount);
}
