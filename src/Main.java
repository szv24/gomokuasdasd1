import game.engine.Engine;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        int rand_int1 = ThreadLocalRandom.current().nextInt();
        String number = Integer.toString(rand_int1);
        String[] args1 = {"5","game.gmk.GomokuGame",number,"15","15","0.1","2000","game.gmk.players.GreedyPlayer","Agent"};
        try{
            Engine.main(args1);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
