//
//  main.cpp
//  CPPFdm_L6_04
//
//  Created by DACHI XU on 7/24/13.
//  Copyright (c) 2013 DACHI XU. All rights reserved.
//

#include <iostream>
using std::cout;
using std::endl;

void pirintArray(const int[][3]);

int main(int argc, const char * argv[])
{
    int array1[2][3]={{1,2,3},{4,5,6}};
    int array2[2][3]={1,2,3,4,5};
    int array3[2][3]={{1,2},{4}};
    
    cout<<"Vlaues in array1 by row are: "<<endl;
    pirintArray(array1);
    
//    cout<<"Vlaues in array2 by row are: "<<endl;
//    pirintArray(array2);
//    
//    cout<<"Vlaues in array3 by row are: "<<endl;
//    pirintArray(array3);
    
    return 0;
}

void printArray(const int a[][3])
{
    for (int i=0;i<2;i++)
    {
        for (int j=0;j<3;j++)
            cout<<a[i][j]<<' ';
        
        cout<<endl;
    }
}