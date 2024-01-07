#include "Grayscale.h"
#include <bits/stdc++.h>
using namespace std;
void ApplyGrayscale(vector<vector<Pixel>> &image)
{
    //Change the rgb value of each pixel...
    for(int i=0;i<image.size();i++)
    {
        for(int j=0;j<image[0].size();j++)
        {
            //just apply the formula for converting the image to grey in colour.
            int temp = image[i][j].r*0.299 + image[i][j].g*0.587 + image[i][j].b * 0.114;
            //Set pixel value in range from 0 to 255
            image[i][j].r = max(0,min(255,temp));
            image[i][j].g = max(0,min(255,temp));
            image[i][j].b = max(0,min(255,temp));
        }
    }
}