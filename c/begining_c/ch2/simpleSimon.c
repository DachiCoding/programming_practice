#include <stdio.h>
#include <ctype.h>
#include <stdlib.h>
#include <time.h>

#define TRUE 1
#define FALSE 0

int main(void)
{
 /* Records if another game is to be played */
 char another_game = 'Y';

 /* TRUE if correct sequence entered, FALSE otherwise */
 int correct = TRUE;

 /* Number of sequences entered successfully */
 int counter = 0;

 int sequence_length = 0;
 int i = 0;
 long seed = 0;
 int number = 0;

 long now = 0;
 long time_taken = 0;
 
 /* Rest of the declaration for the program */
 printf("\nTo play Simple Simon, ");
 printf("watch the screen for a sequence of digits. ");
 printf("\nWatch carefully, as the digits are only displayed for a second! ");

 printf("\nThe computer will remove them, and then prompt you ");
 printf("to enter the same sequence.");
 printf("\nWhen you do, you must put spaces between the digits. \n");
 printf("\nGood Luck!\nPress Enter to play\n");
 scanf("%c", &another_game);

 /**/
 do
 {
   correct = TRUE;
   counter = 0;
   sequence_length = 2;
   time_taken = clock();
   
   while(correct)
   {
     /* On every third successful try, increase the sequence length;*/
     sequence_length += (counter++%3 == 0);

     /*Set seed to be the number of seconds since Jan 1, 1970 */
     seed = time(NULL);

     now = clock();

     /**/
     srand((int)seed);
     for(i = 1; i <= sequence_length;i++)
       printf("%d ",rand() % 10);

     /* Wait one second */
     sleep(1);
     //for(;clock() - now < CLOCKS_PER_SEC;);
     
     printf("\r");
     for(i = 1; i <= sequence_length;i++)
       printf("  ");

     if(counter == 1)
       printf("\nNow you enter the sequence - don't forget the spaces\n");
     else
       printf("\r");

     srand((int)seed);
     for(i = 1; i <= sequence_length; i++)
     {
       scanf("%d",&number);
       if(number != rand() % 10)
       {
         correct = FALSE;
	 break;
       }
     }
     printf("%s\n",correct? "Correct!" : "Wrong!");
   }

   /* Output the score when the game is finished */
   time_taken = (clock() - time_taken) / CLOCKS_PER_SEC;

   printf("\n\n Your score is %d", --counter * 100 / time_taken);

   fflush(stdin);

   /* Check if a new game is required */
   printf("\nDo you want to play again (y/n)? ");
   scanf("%c",&another_game);
 }
 while(toupper(another_game) == 'Y');


 //function return
 return 0;
}
