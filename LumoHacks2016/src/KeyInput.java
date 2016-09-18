import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class KeyInput extends KeyAdapter {

    private Handler handler;
    private int Lspeed = 3;
    private int Rspeed = 3;

    public KeyInput(Handler handler) {
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        System.out.println(key);

        for(int i = 0; i < handler.object.size(); i++) {
            System.out.println("looped");
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.Patient) {

                System.out.println("patient");

                switch (key) {
                    case KeyEvent.VK_LEFT:
                        tempObject.setVelX(-Lspeed);
                        //tempObject.setVelY(0);
                        break;
                    case KeyEvent.VK_RIGHT:
                        tempObject.setVelX(Rspeed);
                        //tempObject.setVelY(0);
                        break;
                    case KeyEvent.VK_UP:
                        tempObject.setVelY(-Lspeed);
                        //tempObject.setVelX(0);
                        break;
                    case KeyEvent.VK_DOWN:
                        tempObject.setVelY(Rspeed);
                        //tempObject.setVelX(0);
                        break;


                }
            }
        }
    }

    public void cancerSpeedChange(){
        Lspeed = Lspeed - 1;
        Rspeed = Rspeed - 2;

    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.object.size(); i++) {
            System.out.println("looped");
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.Patient) {

                System.out.println("patient");

                switch (key) {
                    case KeyEvent.VK_LEFT:
                        tempObject.setVelX(0);
                        break;
                    case KeyEvent.VK_RIGHT:
                        tempObject.setVelX(3);
                        tempObject.setVelX(0);
                        break;
                    case KeyEvent.VK_UP:
                        tempObject.setVelY(-3);
                        tempObject.setVelY(0);
                        break;
                    case KeyEvent.VK_DOWN:
                        tempObject.setVelY(3);
                        tempObject.setVelY(0);
                        break;


                }
            }

            if (key == KeyEvent.VK_ESCAPE) {
                System.exit(1);
            }

        }
    }

}
