#include "Invert.h"
#include <bits/stdc++.h>
using namespace std;
void applyInvert(vector<vector<Pixel>>& image) {
    // Check if the image is not empty
    if (image.empty() || image[0].empty()) {
        // Handle empty image case
        return;
    }
    int row = image.size();
    int col = image[0].size();

    // Iterate through each pixel in the image
    for (size_t i = 0; i < row; ++i) {
        for (size_t j = 0; j < col; ++j) {
            // Invert each pixel value like if pixel value 'a' so it's inverse is 255-'a'.....
            image[i][j].r = 255 - image[i][j].r;
            image[i][j].g = 255 - image[i][j].g;
            image[i][j].b = 255 - image[i][j].b;
        }
    }
}