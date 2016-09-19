#include <stdio.h>
#include <ctype.h>

int getch(void);
void ungetch(int);

void swap(int *px, int *py)
{
 int temp;
 temp = *px;
 *px = *py;
 *py = temp;
}

int getint(int *pn)
{
 int c, sign;
 while (isspace(c = getch()))
  ;
 if (!isdigit(c) && c != EOF && c != '+' && c != '-'){
  ungetch(c);
  return 0;
 }
 sign = (c == '-') ? -1 : 1;
 if (c == '+' || c == '-')
  c = getch();
 for (*pn = 0; isdigit(c); c = getch())
  *pn = 10 * *pn + (c - '0')
 *pn *= sign;
 if (c != EOF)
  ungetch(c);
 return c;
}

