import java.awt.*;

/**
 * Created by James Xiao on 2016-09-17.
 */
public class Task extends GameObject {

    public Task(int x, int y, ID id) {
        super(x, y, id);

        velY = 2;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 8, 8);
    }

    public void tick() {
        y += velY;
    }

    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, y, 8, 8);
    }
}
