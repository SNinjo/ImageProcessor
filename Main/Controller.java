package Main;

import Affine.Affine;
import Component.Timer;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class Controller {

    private Model model;
    private View view;

    private Affine affineWindow;


    Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        initialize();


        View.getFrame().addWindowListener(new windowOpenAdapter());

        view.btnOpenFile.addActionListener(e -> OpenImage());
        view.btnSaveFileInPng.addActionListener(e -> storeImage());

        view.btnInvertedColor.addActionListener(e -> invertColor());
        view.btnGrayscale.addActionListener(e -> convertToGrayscale());

        view.btnLeft90.addActionListener(e -> turnLeft90());
        view.btnRight90.addActionListener(e -> turnRight90());
        view.btnRight180.addActionListener(e -> turnRight180());
        view.btnOppositeLeftAndRight.addActionListener(e -> oppositeLeftAndRight());
        view.btnUpsideDown.addActionListener(e -> oppositeUpAndDown());

        view.btnOpenAffineWindow.addActionListener(e -> reverseOpenedStateAffineWindow());
    }
    class windowOpenAdapter extends WindowAdapter {
        public void windowDeiconified(WindowEvent e) {
            showImage(true);
        }
    }

    private void initialize(){
        // 顯示異常: 繪製視窗元件蓋掉此圖片(因為此圖片顯示為底層方法)
        //showImage();

//        view.textFieldOpenFilePath.setText(model.strSmallSizeOpenImageName);
        view.textFieldOpenFilePath.setText(model.strDefaultOpenImageName);
        view.textFieldSaveFilePath.setText(model.strDefaultStoreImageName);

        affineWindow = new Affine();
        view.addWindowGUI(affineWindow.getGUI());

//        OpenImage();//
//        reverseOpenedStateAffineWindow();//
    }


    private void showImage(){
        view.showImage(Model.getImage());
    }
    private void showImage(boolean isRequiredDelay){
        // 圖片在刷新物件時會被刷掉 (Graphics 的繪製問題)            not completed!!
        // 此暫時用 setTimeout 解決
        if (isRequiredDelay) Timer.setTimeout(() -> showImage(), 50);
    }


    private void OpenImage(){
        try {
            model.openImage(view.textFieldOpenFilePath.getText());
        } catch (IOException e) {
            view.showErrorDialog("讀取圖片錯誤");
        }
        view.buttonUnlock();
        showImage();
    }
    private void storeImage(){
        try {
            model.saveImageInPng(view.textFieldSaveFilePath.getText());
        } catch (IOException e) {
            view.showErrorDialog("圖片儲存錯誤");
        }
    }

    private void invertColor(){
        model.invertColor();
        showImage();
    }
    private void convertToGrayscale(){
        model.convertToGrayscale();
        showImage();
    }

    private void turnLeft90(){
        model.turnLeft90();
        showImage();
    }
    private void turnRight90(){
        model.turnRight90();
        showImage();
    }
    private void turnRight180(){
        model.turnRight180();
        showImage();
    }
    private void oppositeLeftAndRight(){
        model.oppositeLeftAndRight();
        showImage();
    }
    private void oppositeUpAndDown(){
        model.oppositeUpAndDown();
        showImage();
    }

    private void reverseOpenedStateAffineWindow(){
        affineWindow.reverseOpenedState();
        showImage(true);
    }
}
