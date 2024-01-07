package com.iiitb.imageEffectApplication.Effect;

import com.iiitb.imageEffectApplication.baseEffects.PhotoEffect;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.libraryInterfaces.SepiaInterface;
import com.iiitb.imageEffectApplication.service.LoggingService;

public class SepiaEffect extends SepiaInterface implements PhotoEffect {
    public SepiaEffect(){}
    @Override
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {
        //logs
        try{
            loggingService.addLog(fileName, "Sepia", "");
        }
        catch(Exception e)
        {
            e.printStackTrace();;
        }
        return applySepia(image); //calling the respective cpp function.
    }
    
}
