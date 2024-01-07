#include <iostream>
#include <cmath>
#include <algorithm>
#include <vector>
// #include "libraryInterfaces_HueSaturationInterface.h"
#include "HueSaturation.h"
#include "../Pixel.h"
using namespace std;
int clamp(float v)
{
    if (v < 0)
        return 0;
    if (v > 255)
        return 255;
    return static_cast<int>(v);
}
vector< vector<Pixel> > applyHueSaturation(vector< vector<Pixel> > imageVector, float saturationValue, float hueValue) {
    vector< vector<Pixel> > inputImage = imageVector;
    saturationValue = saturationValue/100;
    int row = inputImage.size();
    int col = inputImage[0].size();
    for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                float cosA = cos(hueValue * 3.6 * M_PI / 180); // convert degrees to radians
                float sinA = sin(hueValue * 3.6 * M_PI / 180); // convert degrees to radians

                // calculate the rotation matrix, only depends on Hue
                float matrix[3][3] = {
                    {cosA + (1.0f - cosA) / 3.0f, 1.0f / 3.0f * (1.0f - cosA) - sqrt(1.0f / 3.0f) * sinA, 1.0f / 3.0f * (1.0f - cosA) + sqrt(1.0f / 3.0f) * sinA},
                    {1.0f / 3.0f * (1.0f - cosA) + sqrt(1.0f / 3.0f) * sinA, cosA + 1.0f / 3.0f * (1.0f - cosA), 1.0f / 3.0f * (1.0f - cosA) - sqrt(1.0f / 3.0f) * sinA},
                    {1.0f / 3.0f * (1.0f - cosA) - sqrt(1.0f / 3.0f) * sinA, 1.0f / 3.0f * (1.0f - cosA) + sqrt(1.0f / 3.0f) * sinA, cosA + 1.0f / 3.0f * (1.0f - cosA)}
                };

                // Use the rotation matrix to convert the RGB directly
                inputImage[i][j].r = (clamp((inputImage[i][j].r) * matrix[0][0] + (inputImage[i][j].g) * matrix[0][1] + (inputImage[i][j].b) * matrix[0][2]));
                inputImage[i][j].g = (clamp((inputImage[i][j].r) * matrix[1][0] + (inputImage[i][j].g) * matrix[1][1] + (inputImage[i][j].b) * matrix[1][2]));
                inputImage[i][j].b = (clamp((inputImage[i][j].r) * matrix[2][0] + (inputImage[i][j].g) * matrix[2][1] + (inputImage[i][j].b) * matrix[2][2]));
                float gray = 0.2989*inputImage[i][j].r + 0.5870*inputImage[i][j].g + 0.1140*inputImage[i][j].b; //weights from CCIR 601 spec
                inputImage[i][j].r = clamp(-gray * saturationValue + (inputImage[i][j].r)  * (1+saturationValue));
                inputImage[i][j].g = clamp(-gray * saturationValue + (inputImage[i][j].g)  * (1+saturationValue));
                inputImage[i][j].b= clamp(-gray * saturationValue + (inputImage[i][j].b)  * (1+saturationValue));
                //normalize over- and under-saturated values

            }
        }

    return inputImage;
}
