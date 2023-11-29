package com.iiitb.imageEffectApplication.libraryInterfaces;




public class SepiaInterface {
    static {
        String libraryPath = "SepiaLib";
        LoadNativeLibrary.loadNativeLibrary(libraryPath);
    }

    public static native Pixel[][] applySepia(Pixel[][] image);
}
