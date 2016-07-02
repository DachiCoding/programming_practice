//Print the length of arbitraily long input lines

#include <stdio.h>
#define MAXLINE 1000

int getlineNew(char line[]);
void copy(char to[], char from[]);
char * doubleSize(char charArr[]);

//Output the longest line
int main()
{
 int len;
 int max;
 char line[MAXLINE];
 char longest[MAXLINE];

 max = 0;

 while ((len = getlineNew(line)) > 0 ){
  if (len > max){
   max = len;
   if (max > sizeof(longest[])/sizeof(char)) {
     while (sizeof(longest[]) < sizeof(char)) {
      longest = *doubleSize(longest);
    }
   }
   copy(longest,line);
  }
 }
 if (max > 0)
   printf("%s", longest);
 return 0;
}

//getline
int getlineNew(char s[])
{
 int c, i;
 i = 0;

 while ((c =getchar()) != EOF && c != '\n'){
   ++i;
   if (i == sizeof(s[])/sizeof(char) - 1 ){
    s = *doubleSize(s);
   }
   s[i] = c;
 }
 if (c == '\n') {
   s[i] = c;
   ++i;
 }
 s[i] = '\0';
 return i;
}

//Copy
void copy(char to[], char from[])
{
 int i;

 i = 0;
 while ((to[i] = from[i]) != '\0')
   ++i;
}

//Function return the double sized array
char * doubleSize(char charArr[]){
 int length = sizeof(charArr[])/sizeof(char);
 char doubleArr[2*length];

 for(int i = 0; i < length; i++){
  doubleArr[i] = charArr[i];
 }
 return doubleArr;
}
