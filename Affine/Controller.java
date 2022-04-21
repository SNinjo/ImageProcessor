package Affine;

import Component.ColorRGB;
import Component.Image;
import Component.LogicalError;

public class Controller {

    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        view.btnExeute.addActionListener(e -> AffineTransform());
    }

    private void AffineTransform(){
        int intTranslationX = Integer.parseInt(view.textTranslationX.getText());
        int intTranslationY = Integer.parseInt(view.textTranslationY.getText());
        int intScalingX = Integer.parseInt(view.textScalingX.getText());
        int intScalingY = Integer.parseInt(view.textScalingY.getText());

        try {
            if (!isEqualDefaultValue(0, intTranslationX, intTranslationY)){
                model.translate(intTranslationX, intTranslationY );
                System.out.println("Enter");
            }
//            if (!isEqualDefaultValue(1, intScalingX, intScalingY)){
//                model.scale(intScalingX, intScalingY );
//                System.out.println("Enter2");
//            }
        } catch (LogicalError logicalError) {
            view.showErrorDialog("矩陣相乘錯誤 (兩矩陣大小不符合規則)");
        }

        Image image = new Image(100, 100);
        image.fillColor(new ColorRGB(255, 0, 0, 255));

        view.showImage(model.getImage());
    }

    private boolean isEqualDefaultValue(int intDefaultValue, int intVariableX, int intVariableY){
        return ((intVariableX == intDefaultValue) && (intVariableY == intDefaultValue));
    }

}
