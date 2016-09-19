#include <stdio.h>

void main()
{
 float diameter = 0.0f;
 float radius = 0.0f;
 const float Pi = 3.14159f;
 printf("Input the diameter of the table:\n");
 scanf("%f",&diameter);
 radius=diameter/2.0f;
 printf("\nThe circumference is %.2f",2.0f*Pi*radius);
 printf("\nThe area is %.2f",Pi*radius*radius);
}
