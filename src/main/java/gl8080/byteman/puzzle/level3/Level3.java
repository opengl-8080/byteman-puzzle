package gl8080.byteman.puzzle.level3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.BufferOverflowException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

import gl8080.byteman.puzzle.PuzzleGame;

public class Level3 implements PuzzleGame {
    private static final long limit = 300;
    private long count = limit;
    
    @Override
    public boolean step() {
        
        try {
            String number = "123";
            return Integer.valueOf(number).equals(123);
        } catch (NumberFormatException e1) {
            System.out.println("a");
            File file = this.createFile();
            
            try (InputStream in = new FileInputStream(file)) {
                byte[] b = new byte[10];
                int off = 0;
                int len = 10;
                in.read(b, off, len);
            } catch (FileNotFoundException e) {
                System.out.println("b");
                return false;
            } catch (NullPointerException e) {
                System.out.println("c");
                
                try {
                    int n = 2;
                    return Arrays.asList(2, 4, 6, 8)
                                    .stream()
                                    .allMatch(i -> (i + n) % 2 == 0);
                } catch (NullPointerException ee) {
                    System.out.println("f");
                    return false;
                } catch (IllegalStateException ee) {
                    System.out.println("g");
                    return false;
                } catch (BufferOverflowException ee) {
                    System.out.println("h");
                    return false;
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("d");
                
                try {
                    int sum = Arrays.asList(1, 2, 3, 4, 5, 6)
                                    .stream()
                                    .reduce(0, this::add)
                                    .intValue();
                    
                    return sum < 22;
                } catch (IndexOutOfBoundsException ee) {
                    System.out.println("i");
                    return false;
                } catch (NullPointerException ee) {
                    System.out.println("j");
                    return false;
                } catch (IllegalArgumentException ee) {
                    System.out.println("k");
                    return false;
                }
            } catch (IOException e) {
                System.out.println("e");
                return false;
            } finally {
                if (file != null) {
                    file.delete();
                }
            }
            
            return true;
        } finally {
            System.out.print(this.count--);
            
            if (this.count < 0) {
                throw new RuntimeException("＼(^o^)／時間切れ");
            } else if (this.count < (limit * 1/4)) {
                System.out.println(" (´ﾟдﾟ｀)");
            } else if (this.count < (limit * 2/4)) {
                System.out.println(" (ﾟＡﾟ　)");
            } else if (this.count < (limit * 3/4)) {
                System.out.println(" ( ﾟдﾟ)");
            } else if (this.count < limit) {
                System.out.println(" ( ﾟ∀ﾟ)o彡°");
            }
        }
    }
    
    private File createFile() {
        File file = new File("./buf");
        try {
            Files.write(file.toPath(), Arrays.asList("byteman level3"), StandardOpenOption.CREATE_NEW);
        } catch (IOException e) {
            throw new RuntimeException("想定外(´ﾟдﾟ｀)これはただのバグ...");
        }
        return file;
    }
    
    private Integer add(Integer a, Integer b) {
        if (a == null) {
            throw new IllegalArgumentException();
        }
        return a + b;
    }

    @Override
    public int getLevel() {
        return 3;
    }

}
