#include <stdio.h>

void main()
{
  /* Initialize variables */
  long shorty = 0L;
  long lofty = 0L;
  long feet = 0L;
  long inches = 0L;
  long shorty_to_lofty = 0;
  long lofty_to_tree = 0;
  long tree_height = 0;
  const long inches_per_foot = 12L;

  /* Get Lofty's height */
  printf("Enter Lofty's height to the top of his/her head, in whole feet: ");
  scanf("%ld",&feet);
  printf("				            ...and then inches: ");
  scanf("%ld",&inches);
  lofty = feet * inches_per_foot + inches;

  /* Get Shorty's height up to his/her eyes */
  printf("Enter Shorty's height up to his/her eyes, in whole feet: ");
  scanf("%ld",&feet);
  printf("				     ...and then inches: ");
  scanf("%ld",&inches);
  shorty = feet * inches_per_foot + inches;

  /* Get the distance from Shorty to Lofty */
  printf("Enter the distance bewteen Shorty and Lofty, in whole feet: ");
  scanf("%ld",&feet);
  printf("					...and then inches: ");
  scanf("%ld",&inches);
  shorty_to_lofty = feet * inches_per_foot + inches;

  /* Get the distance from Lofty to the tree */
  printf("Finally enter the distance to the tree to the nearest foot: ");
  scanf("%ld",&feet);
  lofty_to_tree = feet * inches_per_foot + inches;

  /* Calculate the height of the tree in inches */
  tree_height = shorty + (shorty_to_lofty + lofty_to_tree)*(lofty - shorty)/shorty_to_lofty;

  /* The code to display the result will go here */
  printf("The height of the tree is %ld feet and %ld inches.\n",tree_height/inches_per_foot,tree_height%inches_per_foot);
}
