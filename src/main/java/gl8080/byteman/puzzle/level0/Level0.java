package gl8080.byteman.puzzle.level0;

import gl8080.byteman.puzzle.PuzzleGame;

public class Level0 implements PuzzleGame {
    
    private boolean flag = true;
    
    @Override
    public boolean step() {
        return this.flag;
    }

    @Override
    public int getLevel() {
        return 0;
    }
}
