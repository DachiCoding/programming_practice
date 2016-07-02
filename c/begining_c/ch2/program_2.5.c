#include <stdio.h>

void main()
{
 int cookies = 5;
 int cookie_calories = 125;
 int total_eaten = 0;

 int eaten = 2;
 cookies = cookies - eaten;
 total_eaten = total_eaten + eaten;
 printf("\nI have eaten %d cookies. There are %d cookies left",eaten,cookies);

 eaten = 3;
 cookies = cookies - eaten;
 total_eaten = total_eaten + eaten;
 printf("\nI have eaten %d cookies. There are %d cookies left",eaten,cookies);

 printf("\nTotal energy consumed is %d calories.\n",total_eaten*cookie_calories);
}
