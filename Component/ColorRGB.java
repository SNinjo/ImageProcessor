package Component;

public class ColorRGB {
    private int intRed = 0;
    private int intGreen = 0;
    private int intBlue = 0;
    private int intAlpha = 255; // 在 PNG 中為透明度 0透明 255不透明


    ColorRGB(){}
    ColorRGB(int intBytesValue){
        intRed = getRedFromBytes(intBytesValue);
        intGreen = getGreenFromBytes(intBytesValue);
        intBlue = getBlueFromBytes(intBytesValue);
        intAlpha= getAlphaFromBytes(intBytesValue);
    }
    public ColorRGB(int intRed, int intGreen, int intBlue, int intAlpha){
        this.intRed = getValueInRange(intRed);
        this.intGreen = getValueInRange(intGreen);
        this.intBlue = getValueInRange(intBlue);
        this.intAlpha= getValueInRange(intAlpha);
    }

    public String toString(){
        return intRed + " " + intGreen + " " + intBlue + " " + intAlpha;
    }

    int getRed(){
        return intRed;
    }
    int getGreen(){
        return intGreen;
    }
    int getBlue(){
        return intBlue;
    }
    int getAlpha(){
        return intAlpha;
    }

    void setRed(int intNewValue){
        intRed = getValueInRange(intNewValue);
    }
    void setGreen(int intNewValue){
        intGreen = getValueInRange(intNewValue);
    }
    void setBlue(int intNewValue){
        intBlue = getValueInRange(intNewValue);
    }
    void setAlpha(int intNewValue){
        intAlpha = getValueInRange(intNewValue);
    }


    // 圖片一個 Pixel 會有 4 Bytes = 32 bits
    // (A、R、G、B channel 各 1 Byte, A 在不同地方有不同用途 Ex. 透明度、遊戲碰撞界線判定)
    private int getRedFromBytes(int intBytesValue){
        return getValueInRange((intBytesValue & 0x00ff0000) >>> 16);
    }
    private int getGreenFromBytes(int intBytesValue){
        return getValueInRange((intBytesValue & 0x0000ff00) >>> 8);
    }
    private int getBlueFromBytes(int intBytesValue){
        return getValueInRange(intBytesValue & 0x000000ff);
    }
    private int getAlphaFromBytes(int intBytesValue){
        return getValueInRange((intBytesValue & 0xff000000) >>> 24);
    }
    int getColor(){
        return ((intAlpha << 24) | (intRed << 16) | (intGreen << 8) | intBlue);
    }

    private int getValueInRange(int intValue){
        if (intValue > 255) return 255;
        if (intValue < 0) return 0;
        return intValue;
    }


    void invertColor(){
        intRed = 255 - intRed;
        intGreen = 255 - intGreen;
        intBlue = 255 - intBlue;
    }
    void convertToGrayScale(){
        int intGrayscaleColor = getValueInRange((int) ((0.2126 * intRed) + (0.7152 * intGreen) + (0.0722 * intBlue)));
        intRed = intGrayscaleColor;
        intGreen = intGrayscaleColor;
        intBlue = intGrayscaleColor;
    }
}
