package com.iiitb.imageEffectApplication.libraryInterfaces;




public class SharpenInterface {
    static {
        String libraryPath = "SharpenLib";
        LoadNativeLibrary.loadNativeLibrary(libraryPath);
    }
    public static native Pixel[][] applySharpen(Pixel[][] image, float amount);
}
