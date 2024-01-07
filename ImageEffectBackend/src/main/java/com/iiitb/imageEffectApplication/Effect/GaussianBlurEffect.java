package com.iiitb.imageEffectApplication.Effect;
import com.iiitb.imageEffectApplication.baseEffects.*;
import com.iiitb.imageEffectApplication.libraryInterfaces.GaussianBlurInterface;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.service.LoggingService;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;

public class GaussianBlurEffect extends GaussianBlurInterface implements SingleValueParameterizableEffect
{
    float radius;
    public GaussianBlurEffect(){}
    @Override
    public void setParameterValue(float parameterValue) throws IllegalParameterException
    {
        //exception handling.
        if(parameterValue>200 || parameterValue<0)
        {
            throw new IllegalParameterException("the value must be between 0 and 200");
        }
        else
        {
            radius = parameterValue;
        }
    }

    @Override
    public Pixel[][] apply(Pixel[][] image,String fileName,LoggingService loggingService)
    {

       

        //Logs
        try {
            loggingService.addLog(fileName, "GaussianBlur",String.valueOf(radius/5.0));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  applyGaussianBlur(image, radius/5);
    }

}