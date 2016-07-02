#include <stdio.h>

void main()
{
 long sum=0L;
 int i=1;
 int j=1;
 int count=0;
 printf("\nEnter how many integers you want to sum:");
 scanf(" %d",&count);
 for(i=1;i<=count;i++) //(;i<=end;)
 {
  sum=1L;
  j=1;
  printf("\n1");
  while(j<i)
  {
   sum+=++j;
   printf("+%d",j);
  }
  printf("=%ld\n",sum);
 }
 printf("\n");
}
