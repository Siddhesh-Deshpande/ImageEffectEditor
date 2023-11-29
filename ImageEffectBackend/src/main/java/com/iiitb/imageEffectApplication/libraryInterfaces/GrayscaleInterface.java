package com.iiitb.imageEffectApplication.libraryInterfaces;




public class GrayscaleInterface {
    static {
        String libraryPath = "GrayscaleLib";
        LoadNativeLibrary.loadNativeLibrary(libraryPath);
    }
    public static native Pixel[][] applyGrayscale(Pixel[][] image);
}
