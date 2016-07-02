typedef struct {
  char title[64];
  int price;
  char isbn[32];
} BookData;

BookData *book_data_p;

book_data_p = malloc(sizeof(BookData));

