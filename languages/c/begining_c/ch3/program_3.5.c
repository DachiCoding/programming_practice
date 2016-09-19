#include <stdio.h>

void main()
{
 char letter = 0;
 printf("Enter an upper case letter:");
 scanf("%c",&letter);
 if ((letter>='A') && (letter<='Z'))
 {
  letter += 'a' - 'A';
  printf("You entered an uppercase %c.\n",letter);
 }
 else
  printf("You did not enter an uppercase letter.\n");
}
