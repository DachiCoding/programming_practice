/* Ask for a distance in inches and represent with yard,inch and feet */
#include <stdio.h>

void main()
{
 float inches = 0.0f;
 const float inches_to_yard=0.083f;
 const float inches_to_feet=0.028f;
 printf("Please enter the distance in inches:");
 scanf("%f",&inches); //!!!!!!! scanf("",&variable)
 printf("The distance is %f yards\n",inches*inches_to_yard);
 printf("The distance is %f feet\n",inches*inches_to_feet);
 printf("The distance is %f inches\n",inches);
}
