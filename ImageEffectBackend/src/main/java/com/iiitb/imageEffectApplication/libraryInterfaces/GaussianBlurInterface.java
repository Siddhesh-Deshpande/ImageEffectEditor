package com.iiitb.imageEffectApplication.libraryInterfaces;




public class GaussianBlurInterface {
    static {
        String libraryPath = "GaussianBlurLib";
        LoadNativeLibrary.loadNativeLibrary(libraryPath);
    }
    public static native Pixel[][] applyGaussianBlur(Pixel[][] image, float radius);
}
