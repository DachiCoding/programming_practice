#include <stdio.h>

void main()
{
 long sum=0L;
 int i = 1;
 int j = 1;
 int count = 0;

 printf("\nEnter the number of integers you want to sum: ");
 scanf(" %d",&count);
 for(i=1;i<=count;i++)
 {
  sum=0L;
  for(j=1;j<=i;j++)
    sum+=j;
  printf("\n%d\t%ld",i,sum);
 }
 printf("\n");
 printf("\n");
}
