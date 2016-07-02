#include <stdio.h>

int strlen2(char s[]);

int main()
{
 //Char array
 char array[] = {'a','b','c','d','e'};
 int arrayLen;
 arrayLen = strlen2(array);
 printf("The length of array is %d\n",arrayLen);
 
 //enum
 /*
 enum boolean { true, false};
 enum escapes {BELL = '\a', BACKSPACE = '\b'};
 enum months { JAN = 1, FEB, MAR, APR};
 int enumIter;
 for(enumIter = JAN; enumIter <= APR; enumIter++){
  printf("No.%d element of enum is %d\n",enumIter,months[enumIter]);
 }
 */

 return 0;
}

int strlen2(char s[]){
 int i = 0;

 while(s[i] != '\0')
  ++i;
 return i;
}
