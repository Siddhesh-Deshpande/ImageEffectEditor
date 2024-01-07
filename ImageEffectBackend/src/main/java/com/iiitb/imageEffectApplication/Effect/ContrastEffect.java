package com.iiitb.imageEffectApplication.Effect;
import com.iiitb.imageEffectApplication.baseEffects.*;
import com.iiitb.imageEffectApplication.libraryInterfaces.ContrastInterface;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.service.LoggingService;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;

public class ContrastEffect extends ContrastInterface implements SingleValueParameterizableEffect
{
    float amount;
    public ContrastEffect(){}
    @Override
    public void setParameterValue(float parameterValue) throws IllegalParameterException
    {
        //Exception handling 
        if(parameterValue>200 || parameterValue<0)
        {
            throw new IllegalParameterException();
        }
        else
        {
            amount = parameterValue;
        }
    }

    @Override
    public Pixel[][] apply(Pixel[][] image,String fileName,LoggingService loggingService)
    {
        //Logs
        try {
            loggingService.addLog(fileName, "Contrast",String.valueOf(amount/10.0));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return applyContrast(image,amount);

    }

}