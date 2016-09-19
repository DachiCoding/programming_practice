#include <stdio.h>

void main()
{
 int number=0;
 int rebmun=0;
 int temp=0;

 /* Get the value to be reversed */
 printf("\nEnter a positive integer: ");
 scanf(" %d",&number);
 temp = number;

 /* Reverse the number stored in temp */
 do
 {
  rebmun = 10*rebmun + temp%10;
  temp=temp/10;
 }while(temp);
 printf("\nThe number %d reversed is %d rebmun ehT\n\n",number,rebmun); 
}
