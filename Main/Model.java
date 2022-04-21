package Main;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

import Component.Image;

public class Model {

    private static Image image = null;
    final String strDefaultFilePath = "./img/";
    final String strSmallSizeOpenImageName = "smallSize.png";
    final String strDefaultOpenImageName = "Lenna.gif";
    final String strDefaultStoreImageName = "Lenna(new)";

    Model() {}

    public static Image getImage(){
        return image;
    }
    public static void setImage(Image image){
        Model.image = image;
    }


    Image openImage(String strImageName) throws IOException {
        image = new Image(ImageIO.read(new File(strDefaultFilePath + strImageName)));
        return image;
    }
    void saveImageInPng(String strImageName) throws IOException {
        File file = new File(strDefaultFilePath + strImageName + ".png");
        ImageIO.write(image.get(), "png", file);
    }

    void invertColor(){
        image.invertColor();
    }
    void convertToGrayscale(){
        image.convertToGrayScale();
    }

    void turnLeft90(){
        image = image.turnRight270();
    }
    void turnRight90(){
        image = image.turnRight90();
    }
    void turnRight180(){
        image = image.turnRight180();
    }
    void oppositeLeftAndRight(){
        image = image.oppositeLeftAndRight();
    }
    void oppositeUpAndDown(){
        image = image.oppositeUpAndDown();
    }

}
