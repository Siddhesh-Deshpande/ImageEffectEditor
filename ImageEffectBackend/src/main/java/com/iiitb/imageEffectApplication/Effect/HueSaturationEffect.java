package com.iiitb.imageEffectApplication.Effect;

import com.iiitb.imageEffectApplication.baseEffects.ParameterizableEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.libraryInterfaces.HueSaturationInterface;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.service.LoggingService;



public class HueSaturationEffect extends HueSaturationInterface implements ParameterizableEffect {
    private float  hue,sat;
    public HueSaturationEffect(){}
    @Override
    public void setParameter(String paramName, float value) throws IllegalParameterException
    {
    	//Exception handeling.....
        if(value <0 || value>200)
        {
            throw new IllegalParameterException("THe value must be between 0 and 200");
        }
        else
        {
            //setting the parameters
            if(paramName=="hue")
            {
                this.hue = value;
            }
            else if(paramName=="sat")
            {
                this.sat=value;
            }
        }
    }
    @Override
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {
        try{
            loggingService.addLog(fileName, "Hue Saturation",Float.toString(sat)+","+Float.toString(hue));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return applyHueSaturation(image, sat, hue);
    }
}
