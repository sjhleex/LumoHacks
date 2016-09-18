import com.sun.org.apache.xpath.internal.SourceTree;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;


public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 400, HEIGHT = 600;

    private Thread thread;
    private boolean running = false;

    private Random r;
    public Handler handler;
    private Spawner spawner;

    public Game() {
        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));

        new Window(WIDTH, HEIGHT, "LumoHacks", this);
        spawner = new Spawner(handler);
        handler.addObject(new Patient(WIDTH / 2 - 10, HEIGHT * 3 / 4, ID.Patient ));

    }

    public synchronized  void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized  void stop() {
        try {
            thread.join();
            running = false;
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running) {
                render();
            }
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void tick() {
        handler.tick();
        spawner.tick();

    }



    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }



        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        handler.render(g);

        g.dispose();
        bs.show();
    }

    public static int clamp(int var, int min, int max) {
        if (var >= max )
            return var = max;
        else if (var <= min)
            return var = min;
        else
            return var;
    }


    public static void main(String args[]) {
        new Game();
    }
}
