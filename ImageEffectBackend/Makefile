CC = g++
JAVA_HOME = /Library/Java/JavaVirtualMachines/jdk-17.jdk/Contents/Home

HUE_SATURATION_LIBRARY_DESTINATION = ./src/Libraries/HueSaturationLibrary
HUE_SATURATION_CPP_SRC = ./src/Libraries/HueSaturationLibrary/HueSaturation.cpp ./src/Libraries/HueSaturationLibrary/HueSaturationInterface.cpp
HUE_SATURATION_JAVA_SRC = ./src/main/java/com/iiitb/imageEffectApplication/libraryInterfaces/HueSaturationInterface.java
HUE_SATURATION_JNI_HEADER = ./src/Libraries/HueSaturationLibrary/com_iiitb_imageEffectApplication_libraryInterfaces_HueSaturationInterface.h
HUE_SATURATION_LIB_NAME = ./src/main/resources/HueSaturationLib

BRIGHTNESS_LIBRARY_DESTINATION = ./src/Libraries/BrightnessLibrary
BRIGHTNESS_CPP_SRC = ./src/Libraries/BrightnessLibrary/Brightness.cpp ./src/Libraries/BrightnessLibrary/BrightnessInterface.cpp
BRIGHTNESS_JAVA_SRC = ./src/main/java/com/iiitb/imageEffectApplication/libraryInterfaces/BrightnessInterface.java
BRIGHTNESS_JNI_HEADER = ./src/Libraries/BrightnessLibrary/com_iiitb_imageEffectApplication_libraryInterfaces_BrightnessInterface.h
BRIGHTNESS_LIB_NAME = ./src/main/resources/BrightnessLib

CONTRAST_LIBRARY_DESTINATION = ./src/Libraries/ContrastLibrary
CONTRAST_CPP_SRC = ./src/Libraries/ContrastLibrary/Contrast.cpp ./src/Libraries/ContrastLibrary/ContrastInterface.cpp
CONTRAST_JAVA_SRC = ./src/main/java/com/iiitb/imageEffectApplication/libraryInterfaces/ContrastInterface.java
CONTRAST_JNI_HEADER = ./src/Libraries/ContrastLibrary/com_iiitb_imageEffectApplication_libraryInterfaces_ContrastInterface.h
CONTRAST_LIB_NAME = ./src/main/resources/ContrastLib

FLIP_LIBRARY_DESTINATION = ./src/Libraries/FlipLibrary
FLIP_CPP_SRC = ./src/Libraries/FlipLibrary/Flip.cpp ./src/Libraries/FlipLibrary/FlipInterface.cpp
FLIP_JAVA_SRC = ./src/main/java/com/iiitb/imageEffectApplication/libraryInterfaces/FlipInterface.java
FLIP_JNI_HEADER = ./src/Libraries/FlipLibrary/com_iiitb_imageEffectApplication_libraryInterfaces_FlipInterface.h
FLIP_LIB_NAME = ./src/main/resources/FlipLib

GAUSSIAN_BLUR_LIBRARY_DESTINATION = ./src/Libraries/GaussianBlurLibrary
GAUSSIAN_BLUR_CPP_SRC = ./src/Libraries/GaussianBlurLibrary/GaussianBlur.cpp ./src/Libraries/GaussianBlurLibrary/GaussianBlurInterface.cpp
GAUSSIAN_BLUR_JAVA_SRC = ./src/main/java/com/iiitb/imageEffectApplication/libraryInterfaces/GaussianBlurInterface.java
GAUSSIAN_BLUR_JNI_HEADER = ./src/Libraries/GaussianBlurLibrary/com_iiitb_imageEffectApplication_libraryInterfaces_GaussianBlurInterface.h
GAUSSIAN_BLUR_LIB_NAME = ./src/main/resources/GaussianBlurLib

GRAYSCALE_LIBRARY_DESTINATION = ./src/Libraries/GrayscaleLibrary
GRAYSCALE_CPP_SRC = ./src/Libraries/GrayscaleLibrary/Grayscale.cpp ./src/Libraries/GrayscaleLibrary/GrayscaleInterface.cpp
GRAYSCALE_JAVA_SRC = ./src/main/java/com/iiitb/imageEffectApplication/libraryInterfaces/GrayscaleInterface.java
GRAYSCALE_JNI_HEADER = ./src/Libraries/GrayscaleLibrary/com_iiitb_imageEffectApplication_libraryInterfaces_GrayscaleInterface.h
GRAYSCALE_LIB_NAME = ./src/main/resources/GrayscaleLib

INVERT_LIBRARY_DESTINATION = ./src/Libraries/InvertLibrary
INVERT_CPP_SRC = ./src/Libraries/InvertLibrary/Invert.cpp ./src/Libraries/InvertLibrary/InvertInterface.cpp
INVERT_JAVA_SRC = ./src/main/java/com/iiitb/imageEffectApplication/libraryInterfaces/InvertInterface.java
INVERT_JNI_HEADER = ./src/Libraries/InvertLibrary/com_iiitb_imageEffectApplication_libraryInterfaces_InvertInterface.h
INVERT_LIB_NAME = ./src/main/resources/InvertLib

ROTATION_LIBRARY_DESTINATION = ./src/Libraries/RotationLibrary
ROTATION_CPP_SRC = ./src/Libraries/RotationLibrary/Rotation.cpp ./src/Libraries/RotationLibrary/RotationInterface.cpp
ROTATION_JAVA_SRC = ./src/main/java/com/iiitb/imageEffectApplication/libraryInterfaces/RotationInterface.java
ROTATION_JNI_HEADER = ./src/Libraries/RotationLibrary/com_iiitb_imageEffectApplication_libraryInterfaces_RotationInterface.h
ROTATION_LIB_NAME = ./src/main/resources/RotationLib

SEPIA_LIBRARY_DESTINATION = ./src/Libraries/SepiaLibrary
SEPIA_CPP_SRC = ./src/Libraries/SepiaLibrary/Sepia.cpp ./src/Libraries/SepiaLibrary/SepiaInterface.cpp
SEPIA_JAVA_SRC = ./src/main/java/com/iiitb/imageEffectApplication/libraryInterfaces/SepiaInterface.java
SEPIA_JNI_HEADER = ./src/Libraries/SepiaLibrary/com_iiitb_imageEffectApplication_libraryInterfaces_SepiaInterface.h
SEPIA_LIB_NAME = ./src/main/resources/SepiaLib

SHARPEN_LIBRARY_DESTINATION = ./src/Libraries/SharpenLibrary
SHARPEN_CPP_SRC = ./src/Libraries/SharpenLibrary/Sharpen.cpp ./src/Libraries/SharpenLibrary/SharpenInterface.cpp
SHARPEN_JAVA_SRC = ./src/main/java/com/iiitb/imageEffectApplication/libraryInterfaces/SharpenInterface.java
SHARPEN_JNI_HEADER = ./src/Libraries/SharpenLibrary/com_iiitb_imageEffectApplication_libraryInterfaces_SharpenInterface.h
SHARPEN_LIB_NAME = ./src/main/resources/SharpenLib



all: $(HUE_SATURATION_LIB_NAME) $(BRIGHTNESS_LIB_NAME) $(CONTRAST_LIB_NAME) $(FLIP_LIB_NAME) $(GAUSSIAN_BLUR_LIB_NAME) $(GRAYSCALE_LIB_NAME) $(INVERT_LIB_NAME) $(ROTATION_LIB_NAME) $(SEPIA_LIB_NAME) $(SHARPEN_LIB_NAME)


$(HUE_SATURATION_LIB_NAME): $(HUE_SATURATION_CPP_SRC) $(HUE_SATURATION_JNI_HEADER)
	$(CC) -shared -o $@ $(HUE_SATURATION_CPP_SRC) -I$(JAVA_HOME)/include -I$(JAVA_HOME)/include/darwin

$(HUE_SATURATION_JNI_HEADER): $(HUE_SATURATION_JAVA_SRC)
	javac -cp ./src/main/java -h $(HUE_SATURATION_LIBRARY_DESTINATION) $(HUE_SATURATION_JAVA_SRC)






$(BRIGHTNESS_LIB_NAME): $(BRIGHTNESS_CPP_SRC) $(BRIGHTNESS_JNI_HEADER)
	$(CC) -shared -o $@ $(BRIGHTNESS_CPP_SRC) -I$(JAVA_HOME)/include -I$(JAVA_HOME)/include/darwin

$(BRIGHTNESS_JNI_HEADER): $(BRIGHTNESS_JAVA_SRC)
	javac -cp ./src/main/java -h $(BRIGHTNESS_LIBRARY_DESTINATION) $(BRIGHTNESS_JAVA_SRC)





$(CONTRAST_LIB_NAME): $(CONTRAST_CPP_SRC) $(CONTRAST_JNI_HEADER)
	$(CC) -shared -o $@ $(CONTRAST_CPP_SRC) -I$(JAVA_HOME)/include -I$(JAVA_HOME)/include/darwin

$(CONTRAST_JNI_HEADER): $(CONTRAST_JAVA_SRC)
	javac -cp ./src/main/java -h $(CONTRAST_LIBRARY_DESTINATION) $(CONTRAST_JAVA_SRC)






$(FLIP_LIB_NAME): $(FLIP_CPP_SRC) $(FLIP_JNI_HEADER)
	$(CC) -shared -o $@ $(FLIP_CPP_SRC) -I$(JAVA_HOME)/include -I$(JAVA_HOME)/include/darwin

$(FLIP_JNI_HEADER): $(FLIP_JAVA_SRC)
	javac -cp ./src/main/java -h $(FLIP_LIBRARY_DESTINATION) $(FLIP_JAVA_SRC)







$(GAUSSIAN_BLUR_LIB_NAME): $(GAUSSIAN_BLUR_CPP_SRC) $(GAUSSIAN_BLUR_JNI_HEADER)
	$(CC) -shared -o $@ $(GAUSSIAN_BLUR_CPP_SRC) -I$(JAVA_HOME)/include -I$(JAVA_HOME)/include/darwin

$(GAUSSIAN_BLUR_JNI_HEADER): $(GAUSSIAN_BLUR_JAVA_SRC)
	javac -cp ./src/main/java -h $(GAUSSIAN_BLUR_LIBRARY_DESTINATION) $(GAUSSIAN_BLUR_JAVA_SRC)






$(GRAYSCALE_LIB_NAME): $(GRAYSCALE_CPP_SRC) $(GRAYSCALE_JNI_HEADER)
	$(CC) -shared -o $@ $(GRAYSCALE_CPP_SRC) -I$(JAVA_HOME)/include -I$(JAVA_HOME)/include/darwin

$(GRAYSCALE_JNI_HEADER): $(GRAYSCALE_JAVA_SRC)
	javac -cp ./src/main/java -h $(GRAYSCALE_LIBRARY_DESTINATION) $(GRAYSCALE_JAVA_SRC)






$(INVERT_LIB_NAME): $(INVERT_CPP_SRC) $(INVERT_JNI_HEADER)
	$(CC) -shared -o $@ $(INVERT_CPP_SRC) -I$(JAVA_HOME)/include -I$(JAVA_HOME)/include/darwin

$(INVERT_JNI_HEADER): $(INVERT_JAVA_SRC)
	javac -cp ./src/main/java -h $(INVERT_LIBRARY_DESTINATION) $(INVERT_JAVA_SRC)




$(ROTATION_LIB_NAME): $(ROTATION_CPP_SRC) $(ROTATION_JNI_HEADER)
	$(CC) -shared -o $@ $(ROTATION_CPP_SRC) -I$(JAVA_HOME)/include -I$(JAVA_HOME)/include/darwin

$(ROTATION_JNI_HEADER): $(ROTATION_JAVA_SRC)
	javac -cp ./src/main/java -h $(ROTATION_LIBRARY_DESTINATION) $(ROTATION_JAVA_SRC)




$(SEPIA_LIB_NAME): $(SEPIA_CPP_SRC) $(SEPIA_JNI_HEADER)
	$(CC) -shared -o $@ $(SEPIA_CPP_SRC) -I$(JAVA_HOME)/include -I$(JAVA_HOME)/include/darwin

$(SEPIA_JNI_HEADER): $(SEPIA_JAVA_SRC)
	javac -cp ./src/main/java -h $(SEPIA_LIBRARY_DESTINATION) $(SEPIA_JAVA_SRC)




$(SHARPEN_LIB_NAME): $(SHARPEN_CPP_SRC) $(SHARPEN_JNI_HEADER)
	$(CC) -shared -o $@ $(SHARPEN_CPP_SRC) -I$(JAVA_HOME)/include -I$(JAVA_HOME)/include/darwin

$(SHARPEN_JNI_HEADER): $(SHARPEN_JAVA_SRC)
	javac -cp ./src/main/java -h $(SHARPEN_LIBRARY_DESTINATION) $(SHARPEN_JAVA_SRC)



clean:
	rm -f $(HUE_SATURATION_LIB_NAME) $(HUE_SATURATION_JNI_HEADER) \
	$(BRIGHTNESS_LIB_NAME) $(BRIGHTNESS_JNI_HEADER) \
	$(CONTRAST_LIB_NAME) $(CONTRAST_JNI_HEADER) \
	$(FLIP_LIB_NAME) $(FLIP_JNI_HEADER) \
	$(GAUSSIAN_BLUR_LIB_NAME) $(GAUSSIAN_BLUR_JNI_HEADER) \
	$(GRAYSCALE_LIB_NAME) $(GRAYSCALE_JNI_HEADER) \
	$(INVERT_LIB_NAME) $(INVERT_JNI_HEADER) \
	$(ROTATION_LIB_NAME) $(ROTATION_JNI_HEADER) \
	$(SEPIA_LIB_NAME) $(SEPIA_JNI_HEADER) \
	$(SHARPEN_LIB_NAME) $(SHARPEN_JNI_HEADER)