#include <stdio.h>

int main(void)
{
  printf("\nBe careful!\a\n");
  //long a = 100000000000000000000000000000000000000;
  //printf("%ld\n",a);
  float plank_length = 10.0f;
  float piece_count = 4.0f;
  float piece_legnth = 0.0f;
  printf("A %8.2f plank foot can be cut into %5.0f pieces %6.2f feet long.\n",plank_length,piece_count,piece_legnth);

  return 0;
}
