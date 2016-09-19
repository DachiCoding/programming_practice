#include <stdio.h>

void main()
{
 int y=0;
 int m=0;
 int d=0;
 char day[]="";
 char mon[]="";
 printf("Please enter your date as mm dd yyyy:");
 scanf("%d %d %d",&m,&d,&y);
 switch(d)
 {
  case 1: case 11: case 21: case 31:
   day='st';
   break;

  case 2: case 12: case 22:
   day='nd';
   break;

  case 3: case 13: case 23:
   day='rd';
   break;

  case 4: case 14: case 24:
   day='th';
   break;

  default:
   day='st';
   break;
 }
 switch(m)
 {
  case 1:
   mon="Janaury";
   break;

  case 2:
   mon="Feburary";
   break;

  case 3:
   mon="March";
   break;

  case 4:
   mon="April";
   break;

  case 5:
   mon="Janaury";
   break;

  case 6:
   mon="Janaury";
   break;

  case 7:
   mon="July";
   break;

  case 8:
   mon="August"
   break;

  case 9:
   mon="Sepetember";
   break;

  case 10:
   mon="October";
   break;

  case 11:
   mon="Novemeber";
   break;

  case 12:
   mon="December";
   break;
  
  default:
   printf("Please enter a month between 1 and 12\n");
   break;
 }
 printf("Your date is %d%c %c %d",d,day,mon,y);
}
