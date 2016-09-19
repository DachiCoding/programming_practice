#include <stdio.h>

void main()
{
 int choice = 0;

 /* Get the choice input */
 printf("\nPick a number between 1 and 10 and you may win a prize! ");
 scanf("%d",&choice);

 /* Check for an invalid selection */
 if((choice>10) || (choice<1))
  choice = 11;

 switch(choice)
 {
  case 7:
   printf("\nCongratulations");
   printf("\nYou win the collected works of Amos Gruntfuttock.");
   break;

  case 2:
   printf("\nYou win the folding thermometer-pen-watch-umbrella.");
   break;

  case 8:
   printf("\nYou win the lifetime supply of aspirin tablets.");
   break;

  case 11:
   printf("\nTry bewteen 1 and 10. You wasted your guess.");
   break;

  default:
   printf("\nSorry, you lose.\n");
   break;
 }
 printf("\n");
}
