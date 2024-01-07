#include "Rotation.h"
#include <bits/stdc++.h>
using namespace std;
void RotateImage(vector<vector<Pixel>> &image, int amount)
{
    int row = image.size();
    int col = image[0].size();
    
    //Empty image or zero degree......
    if (image.size() == 0 or image[0].size() == 0 or amount==0)
    {
        return;
    }
    else if(amount==3) //for 270 degrees
    {
        vector<vector<Pixel>> transpose(col,vector<Pixel>(row));
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                transpose[j][i]=image[i][j];
            }
        }
        image = transpose;
        
    }
    else if(amount==2) //for 180 degrees
    {
        for(int i=0;i<row/2;i++)
        {
            swap(image[i],image[row-i-1]);
        }
    }
    else if(amount==1) //for 90 degress
    {
        vector<vector<Pixel>> operation(col,vector<Pixel>(row));
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                
                operation[j][row-i-1] = image[i][j];
            }
        }
        image = operation;
        
    }
}