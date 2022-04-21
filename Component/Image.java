package Component;

import java.awt.image.BufferedImage;

public class Image {
    private int intHeight;
    private int intWidth;
    private ColorRGB[][] arr2ColorRGBImage; // [intY][intX]

    public Image(int intWidth, int intHeight){
        this.intWidth = intWidth;
        this.intHeight = intHeight;

        arr2ColorRGBImage = new ColorRGB[intHeight][intWidth];
        for (int intY = 0; intY < intHeight; intY++) {
            for (int intX = 0; intX < intWidth; intX++) {
                arr2ColorRGBImage[intY][intX] = new ColorRGB();
            }
        }
    }
    public Image(BufferedImage bufferedImage){
        set(bufferedImage);
    }

    public String toString(){
        String strOutput = "";

        for (int intY = 0; intY < intHeight; intY++) {
            for (int intX = 0; intX < intWidth; intX++) {
                strOutput += "["+ arr2ColorRGBImage[intY][intX] + "]";
            }
            if (intY != (intHeight - 1)) strOutput += "\n";
        }
        return strOutput;
    }

    public BufferedImage get(){
        BufferedImage bufferedImage = new BufferedImage(intWidth, intHeight, BufferedImage.TYPE_INT_ARGB);

        for (int intY = 0; intY < intHeight; intY++) {
            for (int intX = 0; intX < intWidth; intX++) {
                bufferedImage.setRGB(intX, intY, (arr2ColorRGBImage[intY][intX].getColor()) );
            }
        }
        return bufferedImage;
    }
    private void set(BufferedImage bufferedImage){
        intHeight = bufferedImage.getHeight();
        intWidth = bufferedImage.getWidth();
        arr2ColorRGBImage = new ColorRGB[intHeight][intWidth];

        for (int intY = 0; intY < intHeight; intY++) {
            for (int intX = 0; intX < intWidth; intX++) {
                arr2ColorRGBImage[intY][intX] = new ColorRGB(bufferedImage.getRGB(intX, intY));
            }
        }
    }

    public boolean isSizeInRange(int intX, int intY){
        return ((intX >= 0) && (intX < intWidth) && (intY >= 0) && (intY < intHeight));
    }

    public void fillColor(ColorRGB colorRGB){
        for (int intY = 0; intY < intHeight; intY++) {
            for (int intX = 0; intX < intWidth; intX++) {
                arr2ColorRGBImage[intY][intX] = colorRGB;
            }
        }
    }

    public int getWidth(){
        return intWidth;
    }
    public int getHeight(){
        return intHeight;
    }
    public int getWidthInRange(int intValue){
        if (intValue < 0) return 0;
        else if (intValue >= intWidth) return (intWidth - 1);
        else return intValue;
    }
    public int getHeightInRange(int intValue){
        if (intValue < 0) return 0;
        else if (intValue >= intHeight) return intHeight;
        else return intValue;
    }

    public ColorRGB getColor(int intX, int intY){
        return arr2ColorRGBImage[intY][intX];
    }
    public void setColor(int intX, int intY, ColorRGB colorRGB){
        arr2ColorRGBImage[intY][intX] = colorRGB;
    }


    public ColorRGB getColorByBilinearInterpolation(double doubleX, double doubleY){
        int intLeft = this.getWidthInRange((int) Math.floor(doubleX));
        int intRight = this.getWidthInRange((int) Math.ceil(doubleX));
        int intTop = this.getHeightInRange((int) Math.floor(doubleY));
        int intBottom = this.getHeightInRange((int) Math.ceil(doubleY));
        double doubleProportionX = (intLeft == intRight) ?  0 : doubleX - intLeft;
        double doubleProportionY = (intTop == intBottom) ?  0 : doubleY - intTop;

        ColorRGB colorRGB = new ColorRGB();
        colorRGB.setRed(
            (int) executeBilinearInterpolation(
                arr2ColorRGBImage[intLeft][intTop].getRed(),
                arr2ColorRGBImage[intRight][intTop].getRed(),
                arr2ColorRGBImage[intLeft][intBottom].getRed(),
                arr2ColorRGBImage[intRight][intBottom].getRed(),
                doubleProportionX,
                doubleProportionY
            )
        );
        colorRGB.setGreen(
            (int) executeBilinearInterpolation(
                arr2ColorRGBImage[intLeft][intTop].getGreen(),
                arr2ColorRGBImage[intRight][intTop].getGreen(),
                arr2ColorRGBImage[intLeft][intBottom].getGreen(),
                arr2ColorRGBImage[intRight][intBottom].getGreen(),
                doubleProportionX,
                doubleProportionY
            )
        );
        colorRGB.setBlue(
            (int) executeBilinearInterpolation(
                arr2ColorRGBImage[intLeft][intTop].getBlue(),
                arr2ColorRGBImage[intRight][intTop].getBlue(),
                arr2ColorRGBImage[intLeft][intBottom].getBlue(),
                arr2ColorRGBImage[intRight][intBottom].getBlue(),
                doubleProportionX,
                doubleProportionY
            )
        );

        return colorRGB;
    }
    private double executeBilinearInterpolation(
            int intLeftTop, int intRightTop, int intLeftBottom, int intRightBottom,
            double doubleX, double doubleY
    ){
        double topHorizontalInterpolation = executeLinearInterpolation(intLeftTop, intRightTop, doubleX);
        double bottomHorizontalInterpolation = executeLinearInterpolation(intLeftBottom, intRightBottom, doubleX);
        return executeLinearInterpolation(topHorizontalInterpolation, bottomHorizontalInterpolation, doubleY);
    }
    private double executeLinearInterpolation(
            double doubleValue01, double doubleValue02, double doubleWeight
    ){
        return doubleValue01 + ((doubleValue02 - doubleValue01) * doubleWeight);
    }


    public void invertColor(){
        for (int intY = 0; intY < intHeight; intY++) {
            for (int intX = 0; intX < intWidth; intX++) {
                arr2ColorRGBImage[intY][intX].invertColor();
            }
        }
    }
    public void convertToGrayScale(){
        for (int intY = 0; intY < intHeight; intY++) {
            for (int intX = 0; intX < intWidth; intX++) {
                arr2ColorRGBImage[intY][intX].convertToGrayScale();
            }
        }
    }

    public Image turnRight90(){
        Image newImage = new Image(intHeight, intWidth);
        for (int intY = 0; intY < intHeight; intY++) {
            for (int intX = 0; intX < intWidth; intX++) {
                newImage.arr2ColorRGBImage[intX][(intHeight - 1) - intY]
                        = this.arr2ColorRGBImage[intY][intX];
            }
        }
        return newImage;
    }
    public Image turnRight180(){
        Image newImage = new Image(intWidth, intHeight);
        for (int intY = 0; intY < intHeight; intY++) {
            for (int intX = 0; intX < intWidth; intX++) {
                newImage.arr2ColorRGBImage[(intHeight - 1) - intY][(intWidth - 1) - intX]
                        = this.arr2ColorRGBImage[intY][intX];
            }
        }
        return newImage;
    }
    public Image turnRight270(){
        Image newImage = new Image(intHeight, intWidth);
        for (int intY = 0; intY < intHeight; intY++) {
            for (int intX = 0; intX < intWidth; intX++) {
                newImage.arr2ColorRGBImage[(intWidth - 1) - intX][intY]
                        = this.arr2ColorRGBImage[intY][intX];
            }
        }
        return newImage;
    }
    public Image oppositeLeftAndRight(){
        Image newImage = new Image(intWidth, intHeight);
        for (int intY = 0; intY < intHeight; intY++) {
            for (int intX = 0; intX < intWidth; intX++) {
                newImage.arr2ColorRGBImage[intY][(intWidth - 1) - intX]
                        = this.arr2ColorRGBImage[intY][intX];
            }
        }
        return newImage;
    }
    public Image oppositeUpAndDown(){
        Image newImage = new Image(intWidth, intHeight);
        for (int intY = 0; intY < intHeight; intY++) {
            for (int intX = 0; intX < intWidth; intX++) {
                newImage.arr2ColorRGBImage[(intHeight - 1) - intY][intX]
                        = this.arr2ColorRGBImage[intY][intX];
            }
        }
        return newImage;
    }
}
