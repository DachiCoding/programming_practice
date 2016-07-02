/* 
input length/width in feet and inches and output the area in square yard
*/

#include <stdio.h>

void main()
{
 const float inches_to_yard=0.028f;
 const float inches_to_feet=0.083f;
 float width_feet=0.0f;
 float width_inch=0.0f;
 float length_feet=0.0f;
 float length_inch=0.0f;
 float area=0.0f;
 printf("Please enter the width in feet:");
 scanf("%f",&width_feet);
 printf("Please enter the width in inches:");
 scanf("%f",&width_inch);
 printf("Please enter the length in feet:");
 scanf("%f",&length_feet);
 printf("Please enter the length in inches:");
 scanf("%f",&length_inch);
 width_feet = width_feet/inches_to_feet;
 length_feet = length_feet/inches_to_feet;
 area=(width_feet+width_inch)*(length_feet+length_inch);
 area=area*inches_to_yard*inches_to_yard;
 printf("The area of the room is %.2f square yard\n",area);
}


