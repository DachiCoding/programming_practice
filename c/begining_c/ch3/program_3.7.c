#include <stdio.h>

void main()
{
 int age=0;
 int college=0;
 int subject=0;
 int interview=0;

 /* Get data on the applicant */
 printf("\nWhat college? 1 for Harvard, 2 for Yale, 3 for other:");
 scanf("%d",&college);
 printf("\nWhat subject? 1 for Chemistry, 2 for economics, 3 for other:");
 scanf("%d",&subject);
 printf("\nHow old is the applicant?");
 scanf("%d",&age);

 /* Check out the applicant */
 if ((age>25 && subject==1) && (college==3||college==1))
  interview=1;
 if (college==2 && subject ==1)
  interview=1;
 if (college==1 && subject ==2 && !(age>28))
  interview=1;
 if (college==2 && (subject==2 || subject==3) && age>25)
  interview=1;

 /* Output decision for interview */
 if(interview)
  printf("\n\nGive 'em an interview\n");
 else
  printf("\n\nReject 'em\n");
}
