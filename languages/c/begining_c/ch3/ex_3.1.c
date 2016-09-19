#include <stdio.h>

void main()
{
 double degree=0.0;
 double convert=0.0;
 char unit=0;
 printf("Please enter the degree as -> num unit(h/c)\n");
 scanf("%lf %c",&degree,&unit);
 if(unit=='c')
  convert=degree*1.8+32;
 else
  convert=(degree-32)*5/9;
 printf("The converted degree is %.0lf%c\n",convert,unit=='c'?'h':'c');
}
