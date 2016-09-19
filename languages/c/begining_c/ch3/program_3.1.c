#include <stdio.h>

void main()
{
 int number=0;
 printf("Please enter an integer between 1 and 10\n");
 scanf("%d",&number);
 if (number > 5)
  printf("You entered %d which is greater than 5.\n",number);
 if (number < 6)
  printf("You entered %d which is less than 6.\n",number);
}
