#include <stdio.h>
#include <unistd.h>

int main(void){
    int i;
    for(i = 0; i < 2; i++){
        fork();
        printf("-");
    }

    wait(NULL);
    wait(NULL);

    return 0;
}
