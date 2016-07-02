#include <stdio.h>

void strcat2(char *s, char *t);

int main(){
 char str1[]= "Hello,";
 char str2[] = "world!";
 char *str1Ptr = &str1[0];
 char *str2Ptr = &str2[0];
 strcat2(str1Ptr,str2Ptr);
 while (str1Ptr != '\0'){
  printf("%c",*str1Ptr++);
 }
}

void strcat2(char *s, char *t){
 char *temp;
 while ((*temp++ = *s++) != '\0')
  ;
 while ((*temp++ = *t++) != '\0')
  ;
 s = temp;
}
