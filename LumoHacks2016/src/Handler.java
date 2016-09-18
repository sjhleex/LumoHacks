import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Handler {

    LinkedList<GameObject> object = new LinkedList<GameObject>();

    public void tick() {
        ArrayList<GameObject> toRemove = new ArrayList<>();

        for(int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);
            tempObject.tick();


            if (object.get(i).getId() == ID.Task) {
                Rectangle taskr = new Rectangle(object.get(i).getX(), object.get(i).getY(), 8, 8);
                Rectangle patientr = new Rectangle(getPatient().getX(), getPatient().getY(), 32, 32);

                if (taskr.intersects(patientr)) {
                    toRemove.add(object.get(i));
                    //object.remove(object.get(i));

                }
            }


            if (object.get(i).getY() > Game.HEIGHT) {
                //object.remove(object.get(i));
                toRemove.add(object.get(i));
            }
        }
        for(GameObject tormv : toRemove) {
            object.remove(tormv);
        }
    }

    public GameObject getPatient() {
        for (int i = 0; i < object.size(); i++) {
            if (object.get(i).getId() == ID.Patient) {
                return object.get(i);
            }
        }

        return null;
    }


    public void render(Graphics g) {
        for(int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);

            tempObject.render(g);
        }
    }

    public void addObject(GameObject g) {
        this.object.add(g);
    }

    public void removeObject(GameObject g) {
        this.object.remove(g);
    }

}
