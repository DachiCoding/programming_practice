#include <stdio.h>
#include <assert.h>
#include <stdlib.h>
#include <string.h>

struct Person {
    char *name;
    int age;
    int height;
    int weight;
};

struct OS {
    char *name;
};

struct Person *Person_create(char *name, int age, int height, int weight){
    struct Person *who = malloc(sizeof(struct Person));
    assert(who != NULL);

    who->name = strdup(name);
    who->age = age;
    who->height = height;
    who->weight = weight;

    return who;
}

void Person_destroy(struct Person *who){
    assert(who != NULL);

    free(who->name);
    free(who);
}

void Person_print(struct Person *who){
    printf("Names: %s\n", who->name);
    printf("\tAge: %d\n", who->age);
    printf("\tHeight: %d\n", who->height);
    printf("\tWeight: %d\n", who->weight);
}

void OS_print(struct OS os){
    if(strncmp(os.name,"win",20)){
        printf("The most popular operating system in computer user is %s.\n",os.name);
    } else if (strncmp(os.name,"posix",20)){
        printf("The most popular operating system in programmers is %s.\n",os.name);
    } else {
        printf("Dude, are you using an embedded calculator?\n");
    }
}

int main(int argc, char *argv[]){
     struct Person *joe = Person_create("Joe Alex",32,64,140);
     struct Person *frank = Person_create("Frank Blank", 20,72,180);

     printf("Joe is at memory location %p:\n", joe);
     Person_print(joe);

     printf("Frank is at memory location %p:\n", frank);
     Person_print(frank);

     joe->age += 20;
     joe->height -= 2;
     joe->weight += 40;
     Person_print(joe);

     frank->age = 40;
     frank->weight += 20;
     Person_print(frank);

     Person_destroy(joe);
     Person_destroy(frank);


     //Initialize struc on stack
     struct OS win;
     struct OS posix;

     win.name = "win";
     posix.name = "posix";

     OS_print(win);
     OS_print(posix);


     return 0;

}


