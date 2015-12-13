package gl8080.byteman.puzzle.level4;

import gl8080.byteman.puzzle.PuzzleGame;

public class Level4 implements PuzzleGame {
    
    private boolean alpha = true;
    private boolean beta = false;
    private boolean gamma = true;
    
    private boolean debugMode = false;
    
    @Override
    public boolean step() {
        if (this.alpha && this.beta && this.gamma) {
            
            this.debug("1");
            return false;
            
        } else if (this.alpha && this.beta && !this.gamma) {
            
            this.debug("2");
            return true;
            
        } else if (this.alpha && !this.beta && this.gamma) {
            
            this.debug("3");
            return true;
            
        } else if (!this.alpha && this.beta && this.gamma) {
            
            this.debug("4");
            return true;
            
        } else if (!this.alpha && !this.beta && !this.gamma) {

            this.debug("5");
            this.debugMode = true;
            return true;
            
        } else {
            
            this.debug("6");
            return true;
            
        }
    }

    private void debug(String message) {
        if (this.debugMode) {
            System.out.println(message);
        }
    }

    @Override
    public int getLevel() {
        return 4;
    }
}
