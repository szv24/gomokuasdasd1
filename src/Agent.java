///LETN1,Szvoreny.Viktor@stud.u-szeged.hu

import java.util.ArrayList;
import java.util.Random;
import game.gmk.GomokuAction;
import game.gmk.GomokuGame;
import game.gmk.GomokuPlayer;


public class Agent extends GomokuPlayer {

    protected ArrayList<GomokuAction> actions = new ArrayList<GomokuAction>();

    public Agent(int color, int[][] board, Random random){
        super(color, board, random);
        // lehetseges lepesek eltarolasa
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                actions.add(new GomokuAction(i, j));
            }
        }
    }
    @Override
    public GomokuAction getAction(GomokuAction prevAction, long[] remainingTimes) {
        // kozepen kezdunk, ha lehetseges
        if (prevAction == null) {
            int i = board.length / 2;
            int j = board[i].length / 2;
            while (board[i][j] != GomokuGame.EMPTY) {
                i = random.nextInt(board.length);
                j = random.nextInt(board[i].length);
            }
            board[i][j] = color;
            return new GomokuAction(i, j);
        }

        // ellenfel lepesenek eltarolasa
        board[prevAction.i][prevAction.j] = 1 - color;



    }
}




