#include <stdio.h>

void main()
{
 long sum =0L;
 int i = 1;
 int count = 0;
 printf("\nEnter the number of integers you want to sum:");
 scanf("%d",&count);
 while(i<=count)
  sum+=i++;
 printf("Total of the first %d numbers is %ld\n",count,sum);
}
