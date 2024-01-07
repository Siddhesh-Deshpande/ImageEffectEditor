#include "Contrast.h"
#include<bits/stdc++.h>
using namespace std;
void applyContrast(vector<vector<Pixel>> &image, float amount){
    if (image.empty() || image[0].empty() or amount==0.0f) {
            // Handle empty image case
            return;
        }
        amount/=10;

        // Iterate through each pixel in the image
        for (size_t i = 0; i < image.size(); ++i) {
            for (size_t j = 0; j < image[0].size(); ++j) {
                // Adjust the rgb value of each pixel by mlt them with a particular amount.
                image[i][j].r *= amount;
                image[i][j].g *= amount;
                image[i][j].b *= amount;

                // Ensure the pixel values stay within the valid range (0 to 255)
                image[i][j].r = max(0, min(255, image[i][j].r));
                image[i][j].g = max(0, min(255, image[i][j].g));
                image[i][j].b = max(0, min(255, image[i][j].b));
            }
        }

}
