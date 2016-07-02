#include <stdio.h>

void main()
{
 start_calculation:
 {
  double a=0.0;
  double b=0.0;
  double result=0.0;
  char operator=0;
  printf("\nEnter the formula as ->\'num1 operator num2\':");
  scanf("%lf %c %lf",&a,&operator,&b);
  
  switch(operator)
  {
   case '+':
    result=a+b;
    break;

   case '-':
    result=a-b;
    break;

   case '*':
    result=a*b;
    break;

   case '/':
    if(b==0)
     printf("\n\n\aDivision by zero error!\n");
    else
     result=a/b;
    break;

   case '%':
    if((long)b==0)
     printf("\n\n\aDivision by zero error!\n");
    else
     result=(long)a%(long)b;
    break;

   default:
    printf("\nPlease enter a valid operator from +,-,*,/,%%.\n");
    break;
  }
  printf("\nThe result is %.2f\n",result);
 }
 char another_run=0;
 printf("Please hit Y(y) for another formua or N(n) to quit\n");
 scanf(" %c",&another_run);
 if(another_run =='Y'|| another_run=='y')
  goto start_calculation;
}
