package com.iiitb.imageEffectApplication.Effect;

import com.iiitb.imageEffectApplication.baseEffects.SingleValueDiscreteEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.libraryInterfaces.RotationInterface;
import com.iiitb.imageEffectApplication.service.LoggingService;

public class RotationEffect extends RotationInterface implements SingleValueDiscreteEffect  {
    private int optionno;
    public RotationEffect(){}
    @Override
    public void setParameterValue(int parameterValue) throws IllegalParameterException
    {
    	//Exception handeling as value must be between 0 to 3.....
        if(parameterValue<0 || parameterValue >3)
        {
            throw new IllegalParameterException("The value must be between 0 and 3");
        }
        else
        {
            optionno=parameterValue;
        }
    }
    @Override
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {
        try {
            loggingService.addLog(fileName, "Rotation", Integer.toString(optionno));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return applyRotation(image, optionno);
    }

    
    
}
