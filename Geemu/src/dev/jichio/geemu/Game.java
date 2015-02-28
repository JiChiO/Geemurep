package dev.jichio.geemu;

import dev.jichio.geemu.display.Display;
import dev.jichio.geemu.gfx.Assets;
import dev.jichio.geemu.gfx.ImageLoader;
import dev.jichio.geemu.gfx.SpriteSheet;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.nio.Buffer;


public class Game implements Runnable {

    private Display display;
    public  int width, height;
    public String title;

    private boolean running = false;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    public Game(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;


    }

    private void init(){
        display = new Display(title, width, height);
        Assets.init();

    }

    private void tick(){

    }

    private void render(){
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();

        g.clearRect(0,0, width, height); //Это очистит экран
        //Начали рисовать

        g.drawImage(Assets.player, 10, 10, null);

        //Закончили
        bs.show();
        g.dispose();
    }

    public void run() {

        init();

        while (running){
            tick();
            render();

        }

        stop();
    }

    public synchronized void start(){
        if (running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop(){
        if (!running)
            return;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
