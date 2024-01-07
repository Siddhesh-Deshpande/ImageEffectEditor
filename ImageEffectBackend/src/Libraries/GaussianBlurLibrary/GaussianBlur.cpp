
#include "GaussianBlur.h"
#include <cmath>
#include <vector>
#include <algorithm>
#include "../Pixel.h"
using namespace std;

void applyGaussianBlur(vector<vector<Pixel>> &image, float val) {
    int kernelWidth = 2 * val + 1; //defining the width of the kernal
    vector<vector<float>> kernel(kernelWidth, vector<float>(kernelWidth, 0.0)); //kernel
    float sum = 0.0;
    float sigma = max(val / 2.0f, 1.0f);
    //creating the kernel
    for (int x = -val; x <= val; ++x) {
        for (int y = -val; y <= val; ++y) {
            float exponentNumerator = -(x * x + y * y);
            float exponentDenominator = 2.0f * sigma * sigma;

            float eExpression = exp(exponentNumerator / exponentDenominator);
            float kernelValue = (eExpression / (2.0f * M_PI * sigma * sigma));

            kernel[x + val][y + val] = kernelValue;
            sum += kernelValue;
        }
    }
    //Normalizing the kernel
    for (int x = 0; x < kernelWidth; ++x) {
        for (int y = 0; y < kernelWidth; ++y) {
            kernel[x][y] /= sum;
        }
    }
    //finding the width and the height of the image
    int width = image.size();
    int height = image[0].size();
    //Applying the effect using convolution
    vector<vector<Pixel>> tempImage(width, vector<Pixel>(height, Pixel()));

    for (int i = 0; i < width; ++i) {//these two loops iterate over the image vector
        for (int j = 0; j < height; ++j) {
            float r = 0.0, g = 0.0, b = 0.0;

            for (int k = -val; k <= val; ++k) {//convolves using the weighted sum of the neighbours
                for (int m = -val; m <= val; ++m) {
                    //to ensure the the new indices are appropriate
                    int newX = max(0, min(width - 1, i - k));
                    int newY = max(0, min(height - 1, j - m));

                    float kernelValue = kernel[k + val][m + val];
                    r += static_cast<float>(image[newX][newY].r) * kernelValue;
                    g += static_cast<float>(image[newX][newY].g) * kernelValue;
                    b += static_cast<float>(image[newX][newY].b) * kernelValue;
                }
            }
            //checking and assingning the pixel value depending on the color.
            tempImage[i][j].r = max(0, min(255, static_cast<int>(r)));
            tempImage[i][j].g = max(0, min(255, static_cast<int>(g)));
            tempImage[i][j].b = max(0, min(255, static_cast<int>(b)));
        }
    }
    //copying back the image.

    for (int i = 0; i < width; ++i) {
        for (int j = 0; j < height; ++j) {
            image[i][j] = tempImage[i][j];
        }
    }
}
