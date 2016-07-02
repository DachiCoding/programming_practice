/*
Input: weekly salary/weekly work hour
Output: weekly average salary
*/

#include <stdio.h>

void main()
{
 int weekly_salary=0.0f;
 int weekly_wrkhrs=0.0f;
 int avg_salary_d=0;
 int avg_salary_c=0;
 printf("Please enter your weekly salary:");
 scanf("%d",&weekly_salary);
 printf("Please enter your weekly work hours:");
 scanf("%d",&weekly_wrkhrs);
 avg_salary_d=weekly_salary/weekly_wrkhrs;
 avg_salary_c=weekly_salary%weekly_wrkhrs;
 printf("Your average hourly pay rate is %d dollars and %d cents\n",avg_salary_d,avg_salary_c);
}
