#include <stdio.h>

void main()
{
 long chosen = 15;
 int guess = 0;
 int count = 3;
 printf("\nThis is a guessing game.");
 printf("\nI have chosen a number between 1 and 20 which you must guess.\n");
 for(;count>0;--count)
 {
  printf("\nYou have %d tr%s left.",count,count==1 ? "y":"ies");
  printf("\nEnter a guess: ");
  scanf("%d",&guess);
  if(guess == chosen)
  {
   printf("\nYou guessed it!\n");
   return ;
  }
  if(guess<1 || guess>20)
   printf("I said between 1 and 20.\n ");
  else
   printf("Sorry. %d is wrong.\n",guess);
 }
 printf("\nYou have had three tries and failed. Thu number was %ld\n",chosen);
}
