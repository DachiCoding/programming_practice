#include <stdio.h>

int main(void)
{
 int hoge = 5;
 int piyo = 10;
 int *hoge_p;
 void *hoge_p2;

 printf("&hoge..%p\n",&hoge);
 printf("&piyo..%p\n",&piyo);
 printf("&hoge_p..%p\n",&hoge_p);

 hoge_p = &hoge;
 hoge_p2 = &hoge;
 printf("hoge_p..%p\n",hoge_p);
 printf("hoge_p2..%p\n",hoge_p2);
 printf("*hoge_p..%d\n",*hoge_p);
 printf("*hoge_p..%d\n",*(int*)hoge_p2);

 *hoge_p = 10;
 printf("hoge..%d\n",hoge);

 return 0;
}
