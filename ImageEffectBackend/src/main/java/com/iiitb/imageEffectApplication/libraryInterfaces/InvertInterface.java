package com.iiitb.imageEffectApplication.libraryInterfaces;




public class InvertInterface {
    static {
        String libraryPath = "InvertLib";
        LoadNativeLibrary.loadNativeLibrary(libraryPath);
    }
    public static native Pixel[][] applyInvert(Pixel[][] image);
}
