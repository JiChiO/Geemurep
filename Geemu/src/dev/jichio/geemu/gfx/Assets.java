package dev.jichio.geemu.gfx;

import java.awt.image.BufferedImage;

public class Assets {

    private static final int charwidth = 33, charheight = 56;

    public static BufferedImage player;

    public static void init(){
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/GGs.png"));

        player = sheet.crop(charwidth, 0, charwidth, charheight);

    }
}
