#include "com_iiitb_imageEffectApplication_libraryInterfaces_SharpenInterface.h"
#include "Sharpen.h"
#include "../Pixel.h"
#include <vector>
using namespace std;

JNIEXPORT jobjectArray JNICALL Java_com_iiitb_imageEffectApplication_libraryInterfaces_SharpenInterface_applySharpen
  (JNIEnv * env, jclass jobj, jobjectArray image, jfloat amount) {

    vector< vector<Pixel> > imageVector;
    jsize rows = env->GetArrayLength(image);
    jclass pixelArrayClass, pixelClass;

    for (jsize i = 0; i < rows; ++i) {
        jobjectArray rowArray = (jobjectArray)env->GetObjectArrayElement(image, i);
        jsize cols = env->GetArrayLength(rowArray);
        pixelArrayClass = env->GetObjectClass(rowArray);

        vector<Pixel> rowVector;
        for (jsize j = 0; j < cols; ++j) {
            jobject pixelObj = env->GetObjectArrayElement(rowArray, j);

            // Extract r, g, b values from Pixel object
            pixelClass = env->GetObjectClass(pixelObj);
            jfieldID rField = env->GetFieldID(pixelClass, "r", "I");
            jfieldID gField = env->GetFieldID(pixelClass, "g", "I");
            jfieldID bField = env->GetFieldID(pixelClass, "b", "I");

            jint rValue = env->GetIntField(pixelObj, rField);
            jint gValue = env->GetIntField(pixelObj, gField);
            jint bValue = env->GetIntField(pixelObj, bField);

            Pixel pixel;
            pixel.r = static_cast<int>(rValue);
            pixel.g = static_cast<int>(gValue);
            pixel.b = static_cast<int>(bValue);

            rowVector.push_back(pixel);

            env->DeleteLocalRef(pixelObj);
        }

        imageVector.push_back(rowVector);
        env->DeleteLocalRef(rowArray);
    }










    // Call the function here
    // TODO












    int nrows = imageVector.size();
    int ncols = imageVector[0].size();
    jobjectArray resultArray = env->NewObjectArray(nrows, pixelArrayClass, nullptr);

    for (jsize i = 0; i < nrows; ++i) {
        jsize cols = imageVector[i].size();
        jobjectArray rowArray = env->NewObjectArray(ncols, pixelClass, nullptr);

        for (jsize j = 0; j < ncols; ++j) {
            const Pixel &pixel = imageVector[i][j];
            jobject pixelObj = env->AllocObject(pixelClass);

            env->SetIntField(pixelObj, env->GetFieldID(pixelClass, "r", "I"), pixel.r);
            env->SetIntField(pixelObj, env->GetFieldID(pixelClass, "g", "I"), pixel.g);
            env->SetIntField(pixelObj, env->GetFieldID(pixelClass, "b", "I"), pixel.b);

            env->SetObjectArrayElement(rowArray, j, pixelObj);
            env->DeleteLocalRef(pixelObj);
        }

        env->SetObjectArrayElement(resultArray, i, rowArray);
        env->DeleteLocalRef(rowArray);
    }

    return resultArray;
}