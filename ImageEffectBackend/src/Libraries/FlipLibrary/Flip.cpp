#include "Flip.h"
#include <bits/stdc++.h>
using namespace std;
void applyFlip(vector<vector<Pixel>>& image,int horizontal,int vertical)
{
    if (image.empty() || image[0].empty()) {
        // Handle empty image case..
        return;
    }
    size_t rows = image.size();
    //For horizontal shift
    if(horizontal==1)
    {
        for(size_t i=0;i<rows;i++)
        {
            //reverse the rows element of 2d arrays's...
            std::reverse(image[i].begin(),image[i].end());
        }
    }
    //For vertical shift
    if(vertical==1)
    {
        for(size_t i=0;i<rows/2;i++)
        {
            //swapping the ith and n-1-1th row because we want to reverse the columns.
            std::swap(image[i],image[rows-1-i]);
        }
    }
}
