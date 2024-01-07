package com.iiitb.imageEffectApplication.Effect;

import com.iiitb.imageEffectApplication.baseEffects.PhotoEffect;
import com.iiitb.imageEffectApplication.libraryInterfaces.GrayscaleInterface;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.service.LoggingService;

public class GrayscaleEffect extends GrayscaleInterface implements PhotoEffect{

    @Override
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {
        //logging and calling the cpp function
       try{
        loggingService.addLog(fileName, "GrayScale", "");
       }
       catch(Exception e)
       {
        e.printStackTrace();
       }
       return applyGrayscale(image);
    }
}
