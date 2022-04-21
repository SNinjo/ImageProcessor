package Affine;

import Component.AffineTransformation;
import Component.Image;
import Component.LogicalError;

public class Model {

    Model() {}

    Image getImage(){
        return Main.Model.getImage();
    }

    void translate(int intVariableX, int intVariableY) throws LogicalError {
        Main.Model.setImage(
            AffineTransformation.translate(
                Main.Model.getImage(), intVariableX, intVariableY
            )
        );
    }
    void scale(double doubleVariableX, double doubleVariableY) throws LogicalError {
        Main.Model.setImage(
            AffineTransformation.scale(
                Main.Model.getImage(), doubleVariableX, doubleVariableY
            )
        );
        System.out.println(getImage());//
    }

}
