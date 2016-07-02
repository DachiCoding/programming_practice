#include <stdio.h>
#include <ctype.h>

/*
int atoi(char s[]);

int main(){
 char charArr[] = {'a','b','c','d'};
 int result;
 result = atoi(charArr);
 for(int i =0; i < 4; i++){
  printf("%d\n",intArr[i]);
 }
}

int atoi(char s[])
{
    int i, n;

    n = 0;
    for (i = 0; s[i] >= ′0′ && s[i] <= ′9′; ++i)
        n = 10 * n + (s[i] - ′0′);
    return n;
}
*/

void htoi(char *str[]);

int main(){
 //function limited to 100 numbers
 char *hexStr[100];
 printf("Please type the hex string, such as 0x190 or 190: ");
 scanf("%c",&hexStr);
 htoi(hexStr);
 return 0;
}

void htoi(char *str[]){
 //Set Up Vars
 char cvtStr[100];
 int i = 0;

 //Copy Input String.
 if (str[0] == 0 && tolower(*str[1]) == 'x'){
  i = 2;
  while (str[i] != '\0'){
   cvtStr[i-2] = *str[i];
   ++i;
  }
 } else {
  cvtStr[i] = *str[i];
  ++i;
 }
 
 int tempNum,tempCnt,sum;
 tempCnt = i;

 for(int j = 0; j < i; j++){
  switch(tolower(cvtStr[i])){
   case 'a':
    tempNum = 10;
    break;
   case 'b':
    tempNum = 11;
    break;
   case 'c':
    tempNum = 12;
    break;
   case 'd':
    tempNum = 13;
    break;
   case 'e':
    tempNum = 14;
    break;
   case 'f':
    tempNum = 15;
    break;
   default:
    tempNum = cvtStr[i] - '0';
    break;
  }
  sum += tempNum*(16^tempCnt);
  tempCnt--;
 }
 printf("The decimal value is %d\n", sum);

}
