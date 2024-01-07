#include "Sepia.h"
#include <bits/stdc++.h>
using namespace std;

void ApplySharpen(vector<vector<Pixel>>&image)
{
    //Iterate through each pixel....
    for(int i=0;i<image.size();i++)
    {
        for(int j=0;j<image[0].size();j++)
        {
            //Make pixel object...
            Pixel temp = Pixel();
            //Apply different formula for r,g,b on particular pixel value's.
            temp.r = image[i][j].r*0.393 + image[i][j].b*0.189 + image[i][j].g*0.769;
            temp.g = image[i][j].r*0.349 + image[i][j].b*0.168 + image[i][j].g*0.686;
            temp.b = image[i][j].r*0.272 + image[i][j].b*0.131 + image[i][j].g*0.534;
            //Set the amount in defined range...from 0 to 255.....
            image[i][j].r = min(255,max(0,temp.r));
            image[i][j].b = min(255,max(0,temp.b));
            image[i][j].g = min(255,max(0,temp.g));
        }
    }
}