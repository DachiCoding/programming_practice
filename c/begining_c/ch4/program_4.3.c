#include <stdio.h>

void main()
{
 long sum = 0L;
 int count = 0;
 int i = 0;

 /* Read the number of integers to be summed */
 printf("\nEnter the number of integers you want to sum: ");
 scanf(" %d",&count);

 /* Sum integers from 1 to count */
 for(i=1;i<=count;i++)
  sum+=i;
 
 printf("\nTotal of the first %d numbers is %ld\n\n",count,sum);
}
