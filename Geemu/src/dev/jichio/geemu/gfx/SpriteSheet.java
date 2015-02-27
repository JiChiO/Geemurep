package dev.jichio.geemu.gfx;
import java.awt.image.BufferedImage;

public class SpriteSheet {

    private BufferedImage sheet;

    public SpriteSheet(BufferedImage sheet){

        this.sheet = sheet;

    }
    public int height (){return sheet.getHeight();}
    public int widht (){return sheet.getWidth();}

    public BufferedImage crop(int x, int y, int width, int height){

        return sheet.getSubimage(x, y, width, height);

    }

}
