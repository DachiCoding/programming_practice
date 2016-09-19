#include <stdio.h>

int main()
{
 int c,nc=0;

 while((c=getchar())!=EOF)
 {
	if(c == ' ' || c == '\t' || c == '\n')
	{
  		nc++;
	}
 }
 printf("The total number of blank, tab and newline is %d\n",nc);
}

