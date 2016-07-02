#include <stdio.h>

void main()
{
 const double unit_price = 3.50;
 const double discount1 = 0.05;
 const double discount2 = 0.1;
 const double discount3 = 0.15;
 double total_price=0.0;
 int quantity=0;
 printf("Enter the number that you want to buy:");
 scanf("%d",&quantity);
 total_price = quantity*unit_price*(1.0 - (quantity>50 ? discount3: (quantity>20?discount2:(quantity>10?discount1:0.0))));
 printf("The price for %d is $%.2f\n",quantity,total_price);
 int pet_quantity=0;
 printf("\nEnter the quantity of your pet(s):");
 scanf("%d",&pet_quantity);
 printf("You have %d pet%s\n",pet_quantity,pet_quantity>1? "s":"");
}
