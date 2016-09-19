#include <stdio.h>

int main(){
 char arr[] = {'a','b','c','d'};
 char *arrPtr = &arr[0];
 printf("The first element of array is %c\n",*arrPtr);
 printf("The second element of array is %c\n",*(arrPtr+1));
}
