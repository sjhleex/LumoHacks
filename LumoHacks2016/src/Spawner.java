import java.util.Random;

/**
 * Created by James Xiao on 2016-09-17.
 */
public class Spawner {

    private Handler handler;
    private int scoreKeep = 0;
    private int cancerKeep = 0;

    public Spawner(Handler handler){
        this.handler = handler;
    }

    public void tick(){
        scoreKeep++;

        if (scoreKeep >= 200) {

            Random r = new Random();
            int Low = 0;
            int High = Game.WIDTH;
            int Result = r.nextInt(High - Low) + Low;

            scoreKeep = 0;
            handler.addObject(new Task(Result, 0, ID.Task));
            cancerKeep++;
        }


    }



}
