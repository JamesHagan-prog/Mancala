package edu.gonzaga;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.imageio.*;
import java.util.ArrayList;

public class StoneImages {
    ArrayList<ImageIcon> images;

    void loadImages(String imagesPath) {
        BufferedImage currPicture;
        images.add(null);   // Slot 0 is kept empty (no blank die?)
        for( int i = 1; i < 13; i++) {
            try {
                String filename = imagesPath + "/D6-" + i + ".png";
                System.out.println("Loading image: " + filename);
                currPicture = ImageIO.read(new File(filename));
                Image dimg = currPicture.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
                ImageIcon scaledImage = new ImageIcon(dimg);
                images.add(scaledImage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public StoneImages(String imagesPath) {
        images = new ArrayList<>(12);
        loadImages(imagesPath);
    }

    public ImageIcon getStoneImage(int stoneValue) {
        if (stoneValue > 12)
            return images.get(12);
        else
            return images.get(stoneValue);
    }
}
