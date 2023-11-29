package com.iiitb.imageEffectApplication.libraryInterfaces;




public class RotationInterface {
    static {
        String libraryPath = "RotationLib";
        LoadNativeLibrary.loadNativeLibrary(libraryPath);
    }

    public static native Pixel[][] applyRotation(Pixel[][] image, int value);
}
