package gl8080.byteman.puzzle.level1;

import gl8080.byteman.puzzle.PuzzleGame;

public class Level1 implements PuzzleGame {
    
    private int s = 0;
    private int t = 1;
    
    @Override
    public boolean step() {
        if (this.isTruth()) {
            System.out.println("*");
            return true;
        } else {
            System.out.println(".");
            return this.s < this.t;
        }
    }

    private boolean isTruth() {
        return true;
    }

    @Override
    public int getLevel() {
        return 1;
    }
}
