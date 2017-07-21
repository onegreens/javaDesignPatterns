package com.cl.pattern.packaging.jframe;

import javax.swing.*;
import java.awt.*;

/**
 * Created by cl on 2017/7/13.
 */
public class MyFrame extends JFrame {

    public MyFrame(String title) throws HeadlessException {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(300,300);
        this.setVisible(true);
    }

    public void paint(Graphics graphics){
        super.paint(graphics);
        String message = "i'm rule";
        graphics.drawString(message,100,100);
    }

    public static void main(String[] args) {
        MyFrame myFrame = new MyFrame("my frist frame");
    }
}
