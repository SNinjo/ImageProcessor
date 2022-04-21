package Affine;

import javax.swing.JScrollPane;

public class Affine {

    private boolean isOpen = false;
    private Model model;
    private View view;

    public Affine() {
        model = new Model();
        view = new View();
        new Controller(model, view);
    }

    public JScrollPane getGUI(){
        return view.getGUI();
    }

    public void open(){
        view.show();
        isOpen = true;
    }
    public void close(){
        view.hide();
        isOpen = false;
    }
    public void reverseOpenedState(){
        if (isOpen) close();
        else open();
    }

}
