package Affine;

import javax.swing.*;
import java.awt.*;

import Component.ImagePanel;
import Component.Image;

public class View {

    private String strTitle = "Title";

    private JFrame frame;
    private ImagePanel panelImageArea;
    private JScrollPane scrollPanelWindow;
    private JPanel panelContainer;
    JButton btnExeute;


    private JPanel panelBackgroundColor;
    private JLabel lbBackgroundColor;
    private JPanel panelBackgroundColorRed;
    private JLabel lbBackgroundColorRed;
    JTextField textBackgroundColorRed;
    private JPanel panelBackgroundColorGreen;
    private JLabel lbBackgroundColorGreen;
    JTextField textBackgroundColorGreen;
    private JPanel panelBackgroundColorBlue;
    private JLabel lbBackgroundColorBlue;
    JTextField textBackgroundColorBlue;

    private JPanel panelTranslation;
    private JLabel lbTranslation;
    private JPanel panelTranslationX;
    private JLabel lbTranslationX;
    JTextField textTranslationX;
    private JPanel panelTranslationY;
    private JLabel lbTranslationY;
    JTextField textTranslationY;

    private JPanel panelScaling;
    private JLabel lbScaling;
    private JPanel panelScalingX;
    private JLabel lbScalingX;
    JTextField textScalingX;
    private JPanel panelScalingY;
    private JLabel lbScalingY;
    JTextField textScalingY;

    private JPanel panelShearing;
    private JLabel lbShearing;
    private JPanel panelShearingX;
    private JLabel lbShearingX;
    JTextField textShearingX;
    private JPanel panelShearingY;
    private JLabel lbShearingY;
    JTextField textShearingY;

    private JPanel panelRotation;
    private JLabel lbRotation;
    private JPanel panelRotationInput;
    private JLabel lbRotationDegree;
    JTextField textRotation;


    View(){
        this.frame = Main.View.getFrame();
        this.panelImageArea = Main.View.getPanelImageArea();


        scrollPanelWindow = new JScrollPane();
        scrollPanelWindow.setVisible(false);

        panelContainer = new JPanel();
        panelContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
        panelContainer.setPreferredSize(new Dimension(190, 0));
        scrollPanelWindow.setViewportView(panelContainer);


        panelBackgroundColor = new JPanel();
        panelBackgroundColor.setBackground(Color.white);
        panelBackgroundColor.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 5));
        panelBackgroundColor.setPreferredSize(new Dimension(190, 130));
        panelContainer.add(panelBackgroundColor);

        lbBackgroundColor = new JLabel("Background Color");
        panelBackgroundColor.add(lbBackgroundColor);

        panelBackgroundColorRed = new JPanel();
        panelBackgroundColorRed.setBackground(Color.white);
        panelBackgroundColor.add(panelBackgroundColorRed);
        lbBackgroundColorRed = new JLabel("red");
        panelBackgroundColorRed.add(lbBackgroundColorRed);
        textBackgroundColorRed = new JTextField("0");
        textBackgroundColorRed.setColumns(6);
        panelBackgroundColorRed.add(textBackgroundColorRed);

        panelBackgroundColorGreen = new JPanel();
        panelBackgroundColorGreen.setBackground(Color.white);
        panelBackgroundColor.add(panelBackgroundColorGreen);
        lbBackgroundColorGreen = new JLabel("green");
        panelBackgroundColorGreen.add(lbBackgroundColorGreen);
        textBackgroundColorGreen = new JTextField("0");
        textBackgroundColorGreen.setColumns(6);
        panelBackgroundColorGreen.add(textBackgroundColorGreen);

        panelBackgroundColorBlue = new JPanel();
        panelBackgroundColorBlue.setBackground(Color.white);
        panelBackgroundColor.add(panelBackgroundColorBlue);
        lbBackgroundColorBlue = new JLabel("blue");
        panelBackgroundColorBlue.add(lbBackgroundColorBlue);
        textBackgroundColorBlue = new JTextField("0");
        textBackgroundColorBlue.setColumns(6);
        panelBackgroundColorBlue.add(textBackgroundColorBlue);


        panelTranslation = new JPanel();
        panelTranslation.setBackground(Color.white);
        panelTranslation.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 5));
        panelTranslation.setPreferredSize(new Dimension(190, 100));
        panelContainer.add(panelTranslation);

        lbTranslation = new JLabel("Translation");
        panelTranslation.add(lbTranslation);

        panelTranslationX = new JPanel();
        panelTranslationX.setBackground(Color.white);
        panelTranslation.add(panelTranslationX);
        lbTranslationX = new JLabel("x");
        panelTranslationX.add(lbTranslationX);
        textTranslationX = new JTextField("0");
        textTranslationX.setColumns(6);
        panelTranslationX.add(textTranslationX);

        panelTranslationY = new JPanel();
        panelTranslationY.setBackground(Color.white);
        panelTranslation.add(panelTranslationY);
        lbTranslationY = new JLabel("y");
        panelTranslationY.add(lbTranslationY);
        textTranslationY = new JTextField("0");
        textTranslationY.setColumns(6);
        panelTranslationY.add(textTranslationY);


        panelScaling = new JPanel();
        panelScaling.setBackground(Color.white);
        panelScaling.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 5));
        panelScaling.setPreferredSize(new Dimension(190, 100));
        panelContainer.add(panelScaling);

        lbScaling = new JLabel("Scaling");
        panelScaling.add(lbScaling);

        panelScalingX = new JPanel();
        panelScalingX.setBackground(Color.white);
        panelScaling.add(panelScalingX);
        lbScalingX = new JLabel("x");
        panelScalingX.add(lbScalingX);
        textScalingX = new JTextField("1");
        textScalingX.setColumns(6);
        panelScalingX.add(textScalingX);

        panelScalingY = new JPanel();
        panelScalingY.setBackground(Color.white);
        panelScaling.add(panelScalingY);
        lbScalingY = new JLabel("y");
        panelScalingY.add(lbScalingY);
        textScalingY = new JTextField("1");
        textScalingY.setColumns(6);
        panelScalingY.add(textScalingY);


        panelShearing = new JPanel();
        panelShearing.setBackground(Color.white);
        panelShearing.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 5));
        panelShearing.setPreferredSize(new Dimension(190, 100));
        panelContainer.add(panelShearing);

        lbShearing = new JLabel("Shearing");
        panelShearing.add(lbShearing);

        panelShearingX = new JPanel();
        panelShearingX.setBackground(Color.white);
        panelShearing.add(panelShearingX);
        lbShearingX = new JLabel("x");
        panelShearingX.add(lbShearingX);
        textShearingX = new JTextField("0");
        textShearingX.setColumns(6);
        panelShearingX.add(textShearingX);

        panelShearingY = new JPanel();
        panelShearingY.setBackground(Color.white);
        panelShearing.add(panelShearingY);
        lbShearingY = new JLabel("y");
        panelShearingY.add(lbShearingY);
        textShearingY = new JTextField("0");
        textShearingY.setColumns(6);
        panelShearingY.add(textShearingY);


        panelRotation = new JPanel();
        panelRotation.setBackground(Color.white);
        panelRotation.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 5));
        panelRotation.setPreferredSize(new Dimension(190, 60));
        panelContainer.add(panelRotation);

        lbRotation = new JLabel("Rotation");
        panelRotation.add(lbRotation);

        panelRotationInput = new JPanel();
        panelRotationInput.setBackground(Color.white);
        panelRotation.add(panelRotationInput);
        textRotation = new JTextField("0");
        textRotation.setColumns(6);
        panelRotationInput.add(textRotation);
        lbRotationDegree = new JLabel("°");
        panelRotationInput.add(lbRotationDegree);


        btnExeute = new JButton("Ok");
        btnExeute.setPreferredSize(new Dimension(136, 25));
        panelContainer.add(btnExeute);

    }

    void showErrorDialog(String message) {
        showDialog(message, 0);
    }
    void showPlainDialog(String message) {
        showDialog(message, -1);
    }
    private void showDialog(String message, int type) {
        JOptionPane.showMessageDialog(frame, message, strTitle, type);
    }

    void showImage(Image image){
        Graphics graphics = panelImageArea.getGraphics();
        panelImageArea.paintComponent(graphics); // 清除 Graphics 的內容
        graphics.drawImage(image.get(), 0, 0, null);
    }

    JScrollPane getGUI() {
        return scrollPanelWindow;
    }
    void show(){
        scrollPanelWindow.setVisible(true);
    }
    void hide(){
        scrollPanelWindow.setVisible(false);
    }

}
