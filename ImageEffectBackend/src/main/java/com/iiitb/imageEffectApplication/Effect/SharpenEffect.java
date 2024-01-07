package com.iiitb.imageEffectApplication.Effect;

import com.iiitb.imageEffectApplication.baseEffects.SingleValueParameterizableEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.libraryInterfaces.SharpenInterface;
import com.iiitb.imageEffectApplication.service.LoggingService;

public class SharpenEffect extends SharpenInterface implements SingleValueParameterizableEffect {
    private float val;
    public SharpenEffect(){}
    @Override
    public void setParameterValue(float parameterValue) throws IllegalParameterException
    {
    	//Exception handeling....
        if(parameterValue<0 || parameterValue>200)
        {
            throw new IllegalParameterException("The value must be between 0 and 200");
        }
        else
        {
            this.val = parameterValue;
        }
    }
    @Override
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {
        //logs
        try {
            loggingService.addLog(fileName, "Sharpen",Float.toString(val));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return applySharpen(image, val);
    }

}
