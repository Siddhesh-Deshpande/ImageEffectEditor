#include "Brightness.h"
#include <bits/stdc++.h>
using namespace std;
void applyBrightness(vector<vector<Pixel>>& image, float amount) {
    // Check if the image is not empty
    amount-=100.0f;
    if (image.empty() || image[0].empty()) {
        // Handle empty image case
        return;
    }
    

    // Iterate through each pixel in the image
    for (size_t i = 0; i < image.size(); ++i) {
        for (size_t j = 0; j < image[i].size(); ++j) {
            // Adjust the brightness of each pixel
            // You can customize this part based on your brightness algorithm
            image[i][j].r+= amount;
            image[i][j].g+= amount;
            image[i][j].b += amount;

            // Ensure the pixel values stay within the valid range (0 to 255)
            image[i][j].r = std::max(0, std::min(255, image[i][j].r));
            image[i][j].g = std::max(0, std::min(255, image[i][j].g));
            image[i][j].b = std::max(0, std::min(255, image[i][j].b));
        }
    }
}
