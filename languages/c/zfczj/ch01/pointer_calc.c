#include <stdio.h>

int main(void)
{
 int hoge;
 int *hoge_p;
 printf("The size of hoge is %lu\n",izeof(hoge));
 printf("0x1c + 0x08 is %x\n",0x1c + 12);

 hoge_p = &hoge;
 printf("hoge_p..%p\n",hoge_p);

 hoge_p++;
 printf("hoge_p..%p\n",hoge_p);

 printf("hoge_p..%p\n",hoge_p + 3);

 return 0;
}
