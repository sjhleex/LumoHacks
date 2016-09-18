import java.awt.*;

/**
 * Created by James Xiao on 2016-09-17.
 */
public class Patient extends GameObject {

    public Patient(int x, int y, ID id) {
        super(x, y, id);

    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32 );
    }

    public void tick() {

        x += velX;
        y += velY;

        x = Game.clamp(x, 0, Game.WIDTH - 36);
        y = Game.clamp(y, 0, Game.HEIGHT - 60);
    }

    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, y, 32, 32);
    }



}
