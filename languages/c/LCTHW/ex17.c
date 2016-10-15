#include <stdio.h>
#include <assert.h>
#include <stdlib.h>
#include <errno.h>
#include <string.h>

#define MAX_DATA 512
#define MAX_ROWS 100

/*
 * Connection
 * => Database
 *  => Address
 * */

struct Address {
    int id;
    int set;
    char name[MAX_DATA];
    char email[MAX_DATA];
};

struct Database {
    struct Address rows[MAX_ROWS];
};

struct Connection {
    FILE *file;
    struct Database *db;
};

void die(const char *message){
    if (errno) {
        perror(message);
    } else {
        printf("ERROR: %s\n", message);
    }
    exit(1);
}

void Address_print(struct Address *addr){
     printf("%d %s %s\n", addr->id, addr->name,addr->email);
}

void Database_load(struct Connection *conn){
    int rc = fread(conn->db, sizeof(struct Database), 1, conn->file);
    if (rc != 1)
        die("Failed to load database.");
}

struct Connection *Database_open(const char *filename, char mode){
     struct Connection *conn = malloc(sizeof(struct Connection));
     if(!conn)
         die("Memory error");

     conn->db = malloc(sizeof(struct Database));
     if (!conn->db)
         die("Memory error");

     if (mode == 'c'){
          conn->file = fopen(filename,"w");
     } else {
         conn->file = fopen(filename,"r+");

         if (conn->file){
             Database_load(conn);
         }
     }

     if (!conn->file)
         die("Failed to open the file");

     return conn;
}

void Database_close(struct Connection *conn){
    if (conn){
        if (conn->file){
            fclose(conn->file);
        }
        if (conn->db){
            free(conn->db);
        }
        free(conn);
    }
}

void Database_write(struct Connection *conn){
     rewind(conn->file);
     int rc = fwrite(conn->db, sizeof(struct Database),1, conn->file);
     if (rc != 1)
         die("Failed to write database.");

     rc = fflush(conn->file);
     if (rc == -1)
         die("Cannot flush database.");
}

void Database_create(struct Connection *conn){
     int i = 0;
     for(i = 0; i < MAX_ROWS; i++){
         struct Address addr = {.id = i, .set = 0};
         conn->db->rows[i] = addr;
     }
}

void Database_set(){}

void Database_get(){}

void Database_delete(){}

void Database_list(){}

int main(int argc, char *argv[]){

}



