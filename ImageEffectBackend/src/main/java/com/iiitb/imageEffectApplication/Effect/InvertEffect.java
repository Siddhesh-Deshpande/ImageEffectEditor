package com.iiitb.imageEffectApplication.Effect;

import com.iiitb.imageEffectApplication.baseEffects.PhotoEffect;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.libraryInterfaces.InvertInterface;
import com.iiitb.imageEffectApplication.service.LoggingService;
public class InvertEffect extends InvertInterface implements PhotoEffect{
    @Override
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {
        //logs
        try
        {
            loggingService.addLog(fileName, "Invert", "");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return applyInvert(image); 
    }
    
}