package gl8080.byteman.puzzle.util;

import java.util.ArrayList;
import java.util.List;

public class TimeFormatter {
    
    public String format(long time) {
        List<String> buffer = new ArrayList<>();
        
        if (3599_999 < time) {
            long h = time / 3600_000;
            buffer.add(h + "h");
            time = time - 3600_000 * h;
        }
        
        if (59_000 < time) {
            long m = time / 60_000;
            buffer.add(m + "m");
            time = time - 60_000 * m;
        }
        
        if (999 < time) {
            long s = time / 1_000;
            buffer.add(s + "s");
            time = time - 1_000 * s;
        }
        
        if (0 < time || buffer.isEmpty()) {
            buffer.add(time + "ms");
        }
        
        return String.join(" ", buffer);
    }
}
