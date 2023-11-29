package com.iiitb.imageEffectApplication.libraryInterfaces;



public class HueSaturationInterface {
    static {
        String libraryPath = "HueSaturationLib";
        LoadNativeLibrary.loadNativeLibrary(libraryPath);
    }
    public static native Pixel[][] applyHueSaturation(Pixel[][] image, float saturationValue, float hueValue);
}
