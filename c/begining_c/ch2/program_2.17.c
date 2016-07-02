#include <stdio.h>
#include <math.h>

void main()
{
 long shorty = 0L;
 long lofty = 0L;
 long feet = 0L;
 long inches = 0L;
 long shorty_to_lofty=0;
 long lofty_to_tree = 0;
 long tree_height=0;
 const long inches_per_foot = 12L;

 /* Get Lofty's height */
 printf("Enter Lofty's height to the top of his/her head, in whole feet: \n");
 scanf("%ld",&feet);
 printf("\t...and then inches: \n");
 scanf("%ld",&inches);
 lofty=feet*inches_per_foot+inches;

 /* Get Shorty's height up to his/her eyes*/
 printf("Enter shorty's heihgt up to his/her eyes, in whole feet: \n");
 scanf("%ld",&feet);
 printf("\t...and then inches: \n");
 scanf("%ld",&inches);
 shorty=feet*inches_per_foot+inches;

 /* Get the distance from Shorty to Lofty */
 printf("Enter the distance between Shorty and Lofty, in whole feet: \n");
 scanf("%ld",&feet);
 printf("\t...and then inches: \n");
 scanf("%ld",&inches);
 shorty_to_lofty=feet*inches_per_foot+inches;

 /* Get the distance from tree to Lofty */
 printf("Enter the distance between tree and Lofty, in whole feet: \n");
 scanf("%ld",&feet);
 printf("\t...and then inches: \n");
 scanf("%ld",&inches);
 lofty_to_tree=feet*inches_per_foot+inches;

 /* Calculate the height of the tree in inches */
 tree_height = shorty + (shorty_to_lofty + lofty_to_tree)*(lofty-shorty)/shorty_to_lofty;

 /* Display the result in feet and inches */
 printf("The height of the tree is %ld feet and %ld inches.\n",tree_height/inches_per_foot,tree_height%inches_per_foot);
}
