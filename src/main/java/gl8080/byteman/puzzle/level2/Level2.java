package gl8080.byteman.puzzle.level2;

import gl8080.byteman.puzzle.PuzzleGame;

public class Level2 implements PuzzleGame {
    
    private Integer i;
    
    @Override
    public boolean step() {
        MyInterface obj1 = this.createInstance();
        
        String value1 = obj1.process();
        
        if (value1 == null) {
            System.out.println("a");
            return true;
        }
        
        if (value1.length() < this.i) {
            System.out.println("b");
            return true;
        }
        
        MyInterface obj2 = this.method(value1);
        String value2 = obj2.process();
        
        if (value2.startsWith("a")) {
            System.out.println("c");
            return true;
        }

        MyInterface obj3 = this.createInstance();
        String value3 = obj3.process();
        
        System.out.println("value3 = " + value3);
        
        return value2.equals(value3);
    }
    
    private MyInterface method(String value) {
        System.out.println("Level2.method(" + value + ")");
        char c = value.charAt(7);
        
        if (c == 'I') {
            return this.createInstance();
        } else {
            return new Beta();
        }
    }
    
    public MyInterface createInstance() {
        return new Alpha();
    }

    @Override
    public int getLevel() {
        return 2;
    }

}
