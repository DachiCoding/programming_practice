#define SWAP(a,b) {int temp; temp  = a; a = b; b =temp;}

void quick_sort_sub(int *data,int left, int right)
{
 int left_index = left;
 int right_index = right;
 int pivot = data[(left+right)/2];

 while( left_index <= right_index){
  for (; data[left_index] < pivot; left_index++)
  	;
  for (; data[right_index] > pivot; right_index--)
  	;
  if (left_index <= right_index){
   SWAP[data[left_index],data[right_index]);
   left_index++;
   right_index--;
  }
 }
}
