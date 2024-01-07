package com.iiitb.imageEffectApplication.service;
import  com.iiitb.imageEffectApplication.service.LoggingService;
import com.iiitb.imageEffectApplication.Effect.*;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.libraryInterfaces.*;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.utils.ProcessingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@Service
public class PhotoEffectService {

    @Autowired
    private ProcessingUtils processingUtils;

    @Autowired
    private LoggingService loggingService;

    public ResponseEntity<byte[]> applyHueSaturationEffect(float hueAmount, float saturationAmount, MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();
            //creating the object of the effect class and setting the parameters if required and then applyiing it by calling the apply function that is overriden in java files while implementing 
            HueSaturationEffect h = new HueSaturationEffect();
            h.setParameter("hue",hueAmount);
            h.setParameter("sat", saturationAmount);
            // TODO
            Pixel[][] modifiedImage = h.apply(inputImage, imageName, loggingService);
            // ACTUAL WORK ENDS HERE


            return processingUtils.postProcessing(modifiedImage);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applyBrightnessEffect(float amount, MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();
            //creating the object of the effect class and setting the parameters if required and then applyiing it by calling the apply function that is overriden in java files while implementing 

            BrightnessEffect bright = new BrightnessEffect();
            bright.setParameterValue(amount);

            Pixel[][] modifiedImage = bright.apply(inputImage, imageName, loggingService);

            // ACTUAL WORK ENDS HERE



            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException | IllegalParameterException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applyContrastEffect(float amount, MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();
//creating the object of the effect class and setting the parameters if required and then applyiing it by calling the apply function that is overriden in java files while implementing 


            // ACTUAL WORK STARTS HERE
            ContrastEffect contrast  = new ContrastEffect();
            contrast.setParameterValue(amount);
            // TODO
            Pixel[][] modifiedImage = contrast.apply(inputImage, imageName, loggingService); // Replace this with actual modified image

            // ACTUAL WORK ENDS HERE



            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException |  IllegalParameterException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applyFlipEffect(MultipartFile imageFile, int horizontalFlipValue, int verticalFlipValue) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();
            //creating the object of the effect class and setting the parameters if required and then applyiing it by calling the apply function that is overriden in java files while implementing 
            FlipEffect flip = new FlipEffect();
            flip.selectOptionValue("vertical",verticalFlipValue);
            flip.selectOptionValue("horizontal", horizontalFlipValue);
            
            
            Pixel[][]modifiedImage = flip.apply(inputImage, imageName, loggingService);

            // ACTUAL WORK ENDS HERE




            return processingUtils.postProcessing(modifiedImage);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applyGaussianBlurEffect(float radius, MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();
            //creating the object of the effect class and setting the parameters if required and then applyiing it by calling the apply function that is overriden in java files while implementing 
            GaussianBlurEffect gb = new GaussianBlurEffect();
            gb.setParameterValue(radius);

            
            Pixel[][] modifiedImage = gb.apply(inputImage, imageName, loggingService);

            // ACTUAL WORK ENDS HERE



            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException | IllegalParameterException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applyGrayscaleEffect(MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();
            //creating the object of the effect class and setting the parameters if required and then applyiing it by calling the apply function that is overriden in java files while implementing 
            GrayscaleEffect gray = new GrayscaleEffect();
            // ACTUAL WORK STARTS HERE
            
            // TODO
            Pixel[][] modifiedImage = gray.apply(inputImage, imageName, loggingService); // Replace this with actual modified image

            // ACTUAL WORK ENDS HERE

            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applyInvertEffect(MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();
            //creating the object of the effect class and setting the parameters if required and then applyiing it by calling the apply function that is overriden in java files while implementing 
            InvertEffect invert = new InvertEffect();
            Pixel[][] modifiedImage = invert.apply(inputImage, imageName, loggingService); // Replace this with actual modified image

            // ACTUAL WORK ENDS HERE

            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applyRotationEffect(int value, MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();
            //creating the object of the effect class and setting the parameters if required and then applyiing it by calling the apply function that is overriden in java files while implementing 
            RotationEffect rotate =  new RotationEffect();
            rotate.setParameterValue(value);

            
            Pixel[][] modifiedImage = rotate.apply(inputImage, imageName, loggingService);


            // ACTUAL WORK ENDS HERE


            return processingUtils.postProcessing(modifiedImage);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applySepiaEffect(MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();
            //creating the object of the effect class and setting the parameters if required and then applyiing it by calling the apply function that is overriden in java files while implementing 
            SepiaEffect sepia = new SepiaEffect();
            

            // ACTUAL WORK STARTS HERE
            
            // TODO
            Pixel[][] modifiedImage = sepia.apply(inputImage, imageName, loggingService); // Replace this with actual modified image

            // ACTUAL WORK ENDS HERE

            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applySharpenEffect(float amount, MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();
            //creating the object of the effect class and setting the parameters if required and then applyiing it by calling the apply function that is overriden in java files while implementing 
            SharpenEffect sharpen = new SharpenEffect();
            // ACTUAL WORK STARTS HERE
            sharpen.setParameterValue(amount);

           
            Pixel [][]modifiedImage = sharpen.apply(inputImage, imageName, loggingService);

            // ACTUAL WORK ENDS HERE

            return processingUtils.postProcessing(modifiedImage);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> getDominantColour(MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();

            // ACTUAL WORK STARTS HERE
            // TODO
            Pixel[][] modifiedImage = inputImage; // Replace this with actual modified image

            // ACTUAL WORK ENDS HERE

            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
