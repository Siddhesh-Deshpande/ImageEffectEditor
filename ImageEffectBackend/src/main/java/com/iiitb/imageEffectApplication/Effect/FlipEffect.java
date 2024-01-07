package com.iiitb.imageEffectApplication.Effect;

import com.iiitb.imageEffectApplication.baseEffects.DiscreteEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.libraryInterfaces.FlipInterface;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.service.LoggingService;

public class FlipEffect extends FlipInterface implements DiscreteEffect  {
    private int verticalflip,horizontalflip;
    public FlipEffect(){}
    @Override 
    public void selectOptionValue(String optionName, int value) throws IllegalParameterException
    {
        //Exception handling
        if(value!=0 && value != 1)
        {
            // System.out.println(value);
            throw new IllegalParameterException("Value must be 0 or 1");
        }
        else
        {
            if(optionName=="vertical")
            {
                this.verticalflip=value;
            }
            else if(optionName=="horizontal")
            {
                this.horizontalflip=value;
            }
        }
    }
    @Override
    public Pixel[][] apply(Pixel[][] image,String fileName,LoggingService loggingService)
    {
        //logs
        try {
            loggingService.addLog(fileName, "Flip",Integer.toString(horizontalflip)+","+Integer.toString(verticalflip));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return applyFlip(image, horizontalflip, verticalflip);
    }
    
}
