#include "Sharpen.h"
#include <bits/stdc++.h>
using namespace std;
void applySharpen(std::vector<std::vector<Pixel>>& image, float amount) {
    // Check if the image is not empty
    if (image.empty() || image[0].empty()) {
        // Handle empty image case
        return;
    }

    // Define a simple sharpening kernel
    std::vector<std::vector<float>> sharpenKernel = {{-1, -1, -1},
                                                    {-1,  9, -1},
                                                    {-1, -1, -1}};

    // Get the dimensions of the kernel
    int kernelSize = static_cast<int>(sharpenKernel.size());
    int kernelRadius = kernelSize / 2;

    // Apply the sharpening filter to the image
    std::vector<std::vector<Pixel>> sharpenedImage = image;

    for (size_t i = kernelRadius; i < image.size() - kernelRadius; ++i) {
        for (size_t j = kernelRadius; j < image[i].size() - kernelRadius; ++j) {
            float sumR = 0.0f, sumG = 0.0f, sumB = 0.0f;

            for (int m = -kernelRadius; m <= kernelRadius; ++m) {
                for (int n = -kernelRadius; n <= kernelRadius; ++n) {
                    sumR += image[i + m][j + n].r * sharpenKernel[m + kernelRadius][n + kernelRadius];
                    sumG += image[i + m][j + n].g * sharpenKernel[m + kernelRadius][n + kernelRadius];
                    sumB += image[i + m][j + n].b * sharpenKernel[m + kernelRadius][n + kernelRadius];
                }
            }

            // Adjust the amount of sharpening
            sumR = image[i][j].r + amount * (sumR - image[i][j].r);
            sumG = image[i][j].g + amount * (sumG - image[i][j].g);
            sumB = image[i][j].b + amount * (sumB - image[i][j].b);

            // Ensure the pixel values stay within the valid range (0 to 255)
            sharpenedImage[i][j].r = std::max(0.0f, std::min(255.0f, sumR));
            sharpenedImage[i][j].g = std::max(0.0f, std::min(255.0f, sumG));
            sharpenedImage[i][j].b = std::max(0.0f, std::min(255.0f, sumB));
        }
    }
    image=sharpenedImage;
}
