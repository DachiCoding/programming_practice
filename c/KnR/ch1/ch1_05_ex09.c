#include <stdio.h>

//1. get input
//2. record whether if it is blank
//3. get the next input
//4. if the last char is blank, do not output this one

/*
int main()
{
 int c;
 int lastChar=0;

 while((c=getchar()) != EOF)
 {
   if (lastChar != 1)
   {
    if (c != ' ' && c != '\t')
    	putchar(c);
   }

   if(c == ' ' || c == '\t')
    lastChar = 1;
   else
    lastChar = 0;
 }
}
*/

//My Solution
int main()
{
  char c,lastc;
  lastc='\0';
  
  printf("Please enter characters...");
  while ((c= getchar()) != EOF)
  {
   if (lastc == ' ' || lastc == '\t')
   {
    if (c == ' ' || c == '\t')
    ;
    else
      putchar(c);
   }
   else
    putchar(c);
   lastc = c;
  }
  return 0;
}

//Solution from online
/*
int main()
{
 int c,pc;
 pc = EOF;

 while ((c = getchar() != EOF))
 {
  if (c == ' ' )
    if (pc != ' ');
  	putchar(c);
  if (c != ' ' )
  	putcahr(c);
  pc = c;
 }
 return 0;
}
*/
