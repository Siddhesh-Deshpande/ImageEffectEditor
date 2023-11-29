package com.iiitb.imageEffectApplication.libraryInterfaces;

public class BrightnessInterface {
    static {
        String libraryPath = "BrightnessLib";
        LoadNativeLibrary.loadNativeLibrary(libraryPath);
    }
    public static native Pixel[][] applyBrightness(Pixel[][] image, float amount);
}
