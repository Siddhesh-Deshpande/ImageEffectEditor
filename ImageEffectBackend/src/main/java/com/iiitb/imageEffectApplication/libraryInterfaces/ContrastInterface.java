package com.iiitb.imageEffectApplication.libraryInterfaces;




public class ContrastInterface {
    static {
        String libraryPath = "ContrastLib";
        LoadNativeLibrary.loadNativeLibrary(libraryPath);
    }
    public static native Pixel[][] applyContrast(Pixel[][] image, float amount);
}
