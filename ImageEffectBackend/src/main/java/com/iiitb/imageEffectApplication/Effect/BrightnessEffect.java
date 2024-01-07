package com.iiitb.imageEffectApplication.Effect;
import com.iiitb.imageEffectApplication.baseEffects.*;
import com.iiitb.imageEffectApplication.libraryInterfaces.BrightnessInterface;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.service.LoggingService;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;

public class BrightnessEffect extends BrightnessInterface implements SingleValueParameterizableEffect
{
    
    private float amount;
    public BrightnessEffect(){}
    @Override
    public void setParameterValue(float parameterValue) throws IllegalParameterException
    {
    	//Exception handeling....
        if(parameterValue>200 || amount < 0)
        {
            throw new IllegalParameterException("Value must be between 0 and 200");
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
            loggingService.addLog(fileName, "Brightness",String.valueOf(amount-100.0f));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return applyBrightness(image,amount);//calling the respective function.
    }
}
