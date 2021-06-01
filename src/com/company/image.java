package com.company;

import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.IOException;

class image extends JFrame {
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private ImageIcon image1;
    private ImageIcon image2;
    private ImageIcon image3;
    private ImageIcon image4;

    image(String title) {
        super(title);
        setLayout(new FlowLayout());

        image1 = new ImageIcon(getClass().getResource("ex.jpeg"));
        label1 = new JLabel(image1);
        add(label1);
        invertImage("ex.jpeg");
        image2 = new ImageIcon(getClass().getResource("invert-ex.jpeg"));
        label2 = new JLabel(image2);
        add(label2);


    }
    public static void invertImage(String imageName) {
        BufferedImage inputFile = null;
        try {
            inputFile = ImageIO.read(new File(imageName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int x = 0; x < inputFile.getWidth(); x++) {
            for (int y = 0; y < inputFile.getHeight(); y++) {
                int rgba = inputFile.getRGB(x, y);
                Color col = new Color(rgba, true);
                col = new Color(255 - col.getRed(),
                        255 - col.getGreen(),
                        255 - col.getBlue());
                inputFile.setRGB(x, y, col.getRGB());
            }
        }
        try {
            File outputFile = new File("invert-"+imageName);
            ImageIO.write(inputFile, "jpeg", outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
