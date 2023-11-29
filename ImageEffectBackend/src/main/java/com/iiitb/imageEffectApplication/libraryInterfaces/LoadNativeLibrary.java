package com.iiitb.imageEffectApplication.libraryInterfaces;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class LoadNativeLibrary {
    public static void loadNativeLibrary(String libraryName) {
        try {
            // Load the native library from the classpath resource
            InputStream inputStream = LoadNativeLibrary.class.getClassLoader().getResourceAsStream(libraryName);
            File tempFile = File.createTempFile("temp-" + libraryName, "");
            tempFile.deleteOnExit();
            try (FileOutputStream out = new FileOutputStream(tempFile)) {
                byte[] buffer = new byte[8192];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
            }

            // Load the native library from the temporary file
            System.load(tempFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

