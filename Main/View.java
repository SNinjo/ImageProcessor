package Main;

import javax.swing.*;
import java.awt.*;

import Component.ImagePanel;
import Component.Image;

public class View {

    private String strTitle = "Image Processor";


    private int intScreenWidth = (int) getScreenSize().getWidth();
    private int intScreenHeight = (int) getScreenSize().getHeight() - 50;
    private int intHeaderHeight = 20;
    private int intFooterHeight = 100;
    private int intToolbarWidth = 200;
    private int intAsideWindowWidth = 200;
    private int intHorizontalInterval = 10;
    private int intImageShowAreaWidth =
            intScreenWidth - intToolbarWidth - intAsideWindowWidth - (intHorizontalInterval * 2);
    private int intMiddelComponentHeight =
            intScreenHeight - intHeaderHeight - intFooterHeight;

    private Rectangle recHeader = new Rectangle(
            new Point(0, 0),
            new Dimension(intScreenWidth, intHeaderHeight)
    );
    private Rectangle recFooter = new Rectangle(
            new Point(0, (intScreenHeight - intFooterHeight)),
            new Dimension(intScreenWidth, intFooterHeight)
    );
    private Rectangle recToolbar = new Rectangle(
            new Point(0, intHeaderHeight),
            new Dimension(intToolbarWidth, intMiddelComponentHeight)
    );
    Rectangle recAsideWindow = new Rectangle(
            new Point((intScreenWidth - intAsideWindowWidth), intHeaderHeight),
            new Dimension(intAsideWindowWidth, intMiddelComponentHeight)
    );
    private Rectangle recImageArea = new Rectangle(
            new Point((intToolbarWidth + intHorizontalInterval),
                    intHeaderHeight
            ),
            new Dimension(intImageShowAreaWidth, intMiddelComponentHeight)
    );


    private static JFrame frame;
    private JPanel panelFooter;
    private Container container;
    private JLabel lbCopyRight;
    private static ImagePanel panelImageArea;


    private JScrollPane scrollPaneToolbar;
    private JPanel panelContainer;
    private JPanel panelFile;
    JTextField textFieldOpenFilePath;
    JButton btnOpenFile;
    JTextField textFieldSaveFilePath;
    JButton btnSaveFileInPng;
    private JPanel panelColor;
    JButton btnInvertedColor;
    JButton btnGrayscale;
    private JPanel panelRotation;
    JButton btnLeft90;
    JButton btnRight90;
    JButton btnRight180;
    JButton btnOppositeLeftAndRight;
    JButton btnUpsideDown;
    private JPanel panelWindow;
    JButton btnOpenAffineWindow;


    View(){
        frame = new JFrame();
        frame.setTitle(strTitle);
//        frame.setBounds(0, 0, intScreenWidth, intScreenHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // full screen
//        frame.setUndecorated(true); // hide title bar
        frame.setResizable(false);
        container = frame.getContentPane();
        container.setFont(new Font("Arial", Font.BOLD, 15));
        container.setBackground(Color.LIGHT_GRAY);
        container.setLayout(null);

        panelFooter = new JPanel();
        panelFooter.setBackground(Color.LIGHT_GRAY);
        panelFooter.setLayout(new FlowLayout(FlowLayout.CENTER, 5, ((intFooterHeight - 70) / 2) ));
        panelFooter.setBounds(recFooter);
        container.add(panelFooter);

        lbCopyRight = new JLabel("Made by 廖儒均");
        lbCopyRight.setForeground(Color.WHITE);
        lbCopyRight.setFont(new Font("新細明體", Font.BOLD, 15));
        panelFooter.add(lbCopyRight, BorderLayout.EAST);

        panelImageArea = new ImagePanel();
        panelImageArea.setBounds(recImageArea);
        container.add(panelImageArea);




        scrollPaneToolbar = new JScrollPane();
        scrollPaneToolbar.setBounds(recToolbar);
        container.add(scrollPaneToolbar);

        panelContainer = new JPanel();
        panelContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
        panelContainer.setPreferredSize(new Dimension(190, 0));
        scrollPaneToolbar.setViewportView(panelContainer);


        panelFile = new JPanel();
        panelFile.setBackground(Color.white);
        panelFile.setPreferredSize(new Dimension(190, 120));
        panelContainer.add(panelFile);

        textFieldOpenFilePath = new JTextField();
        textFieldOpenFilePath.setColumns(12);
        panelFile.add(textFieldOpenFilePath);

        btnOpenFile = new JButton("Open File");
        btnOpenFile.setPreferredSize(new Dimension(136, 25));
        panelFile.add(btnOpenFile);

        textFieldSaveFilePath = new JTextField();
        textFieldSaveFilePath.setColumns(12);
        panelFile.add(textFieldSaveFilePath);

        btnSaveFileInPng = new JButton("Save in png");
        btnSaveFileInPng.setPreferredSize(new Dimension(136, 25));
        btnSaveFileInPng.setEnabled(false);
        panelFile.add(btnSaveFileInPng);


        panelColor = new JPanel();
        panelColor.setBackground(Color.white);
        panelColor.setPreferredSize(new Dimension(190, 70));
        panelContainer.add(panelColor);

        btnInvertedColor = new JButton("Inverted Color");
        btnInvertedColor.setPreferredSize(new Dimension(136, 25));
        btnInvertedColor.setEnabled(false);
        panelColor.add(btnInvertedColor);

        btnGrayscale = new JButton("Grayscale");
        btnGrayscale.setPreferredSize(new Dimension(136, 25));
        btnGrayscale.setEnabled(false);
        panelColor.add(btnGrayscale);


        panelRotation = new JPanel();
        panelRotation.setBackground(Color.white);
        panelRotation.setPreferredSize(new Dimension(190, 160));
        panelContainer.add(panelRotation);

        btnLeft90 = new JButton("Left 90");
        btnLeft90.setPreferredSize(new Dimension(136, 25));
        btnLeft90.setEnabled(false);
        panelRotation.add(btnLeft90);

        btnRight90 = new JButton("Right 90");
        btnRight90.setPreferredSize(new Dimension(136, 25));
        btnRight90.setEnabled(false);
        panelRotation.add(btnRight90);

        btnRight180 = new JButton("Right 180");
        btnRight180.setPreferredSize(new Dimension(136, 25));
        btnRight180.setEnabled(false);
        panelRotation.add(btnRight180);

        btnOppositeLeftAndRight = new JButton("Left <=> Right");
        btnOppositeLeftAndRight.setPreferredSize(new Dimension(136, 25));
        btnOppositeLeftAndRight.setEnabled(false);
        panelRotation.add(btnOppositeLeftAndRight);

        btnUpsideDown = new JButton("Up <=> Down");
        btnUpsideDown.setPreferredSize(new Dimension(136, 25));
        btnUpsideDown.setEnabled(false);
        panelRotation.add(btnUpsideDown);


        panelWindow = new JPanel();
        panelWindow.setBackground(Color.white);
        panelWindow.setPreferredSize(new Dimension(190, 35));
        panelContainer.add(panelWindow);

        btnOpenAffineWindow = new JButton("Affine");
        btnOpenAffineWindow.setPreferredSize(new Dimension(136, 25));
        btnOpenAffineWindow.setEnabled(false);
        panelWindow.add(btnOpenAffineWindow);


        frame.setVisible(true);
    }

    public static JFrame getFrame(){
        return frame;
    }
    public static ImagePanel getPanelImageArea(){
        return panelImageArea;
    }

    void buttonUnlock(){
        btnSaveFileInPng.setEnabled(true);
        btnInvertedColor.setEnabled(true);
        btnGrayscale.setEnabled(true);
        btnLeft90.setEnabled(true);
        btnRight90.setEnabled(true);
        btnRight180.setEnabled(true);
        btnOppositeLeftAndRight.setEnabled(true);
        btnUpsideDown.setEnabled(true);
        btnOpenAffineWindow.setEnabled(true);
    }

    Dimension getScreenSize(){
        return Toolkit.getDefaultToolkit().getScreenSize();
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

    void addWindowGUI(JScrollPane scrollPaneWindow){
        scrollPaneWindow.setBounds(recAsideWindow);
        container.add(scrollPaneWindow);
    }

}
