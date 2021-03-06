package gl8080.byteman.puzzle;

import java.util.Arrays;
import java.util.List;

import gl8080.byteman.puzzle.level0.Level0;
import gl8080.byteman.puzzle.level1.Level1;
import gl8080.byteman.puzzle.level2.Level2;
import gl8080.byteman.puzzle.level3.Level3;
import gl8080.byteman.puzzle.level4.Level4;
import gl8080.byteman.puzzle.util.TimeFormatter;

public class Main {
    
    public static void main(String[] args) {
        try {
            new Main(args).start();
        } catch (IllegalParameterException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }
    
    private static final List<PuzzleGame> GAME_LIST = Arrays.asList(
        new Level0(),
        new Level1(),
        new Level2(),
        new Level3(),
        new Level4()
    );
    
    private String[] args;
    private long startTime;
    private long endTime;
    
    public Main(String[] args) {
        this.args = args;
    }
    
    public void start() throws IllegalParameterException {
        PuzzleGame game = this.createGame();
        this.startTime = System.currentTimeMillis();
        System.out.println("LEVEL " + game.getLevel() + " Start!");
        
        boolean flag = true;
        
        while (flag) {
            flag = game.step();
            this.sleep();
        }
        this.endTime = System.currentTimeMillis();
        System.out.println("SUCCESS!! (time = " + this.calcTime() + ")");
    }
    
    private String calcTime() {
        return new TimeFormatter().format(this.endTime - this.startTime);
    }
    
    public PuzzleGame createGame() throws IllegalParameterException {
        if (this.args.length < 1) {
            throw new IllegalParameterException("引数にレベルが指定されていません。");
        }

        try {
            int level = Integer.parseInt(this.args[0]);
            return GAME_LIST.get(level);
        } catch (NumberFormatException e) {
            throw new IllegalParameterException("レベルは数値で指定してください。");
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalParameterException("レベルは 0 ～ " + (GAME_LIST.size() - 1) + " の間で指定してください。");
        }
    }

    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
