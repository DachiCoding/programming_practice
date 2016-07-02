#include <stdio.h>
#define Pi 3.14159f

void main()
{
 float radius = 0.0f;
 float diameters = 0.0f;
 float circumference = 0.0f;
 float area = 0.0f;
 
 printf("Input the diameter of the table:");
 scanf("%f",&diameters);
 radius=diameters/2.0f;
 circumference = 2.0f*Pi*radius;
 area=Pi*radius*radius;
 printf("\nThe circumference is %.2f\n",circumference);
 printf("\nThe area is %.2f\n",area);
}
