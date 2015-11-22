package gl8080.byteman.puzzle;

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
