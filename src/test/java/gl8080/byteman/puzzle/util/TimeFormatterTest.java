package gl8080.byteman.puzzle.util;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TimeFormatterTest {
    
    private TimeFormatter formatter;
    
    @Before
    public void setup() {
        formatter = new TimeFormatter();
    }
    
    @Test
    public void _0ミリ秒はそのまま() {
        // exercise
        String actual = formatter.format(0L);
        
        // verify
        assertThat(actual, is("0ms"));
    }
    
    @Test
    public void _999ミリ秒はそのまま() {
        // exercise
        String actual = formatter.format(999L);
        
        // verify
        assertThat(actual, is("999ms"));
    }
    
    @Test
    public void _1_000ミリ秒は1秒() {
        // exercise
        String actual = formatter.format(1_000L);
        
        // verify
        assertThat(actual, is("1s"));
    }
    
    @Test
    public void _1_001ミリ秒は1秒と1ミリ秒() {
        // exercise
        String actual = formatter.format(1_001L);
        
        // verify
        assertThat(actual, is("1s 1ms"));
    }
    
    @Test
    public void _1_999ミリ秒は1秒と999ミリ秒() {
        // exercise
        String actual = formatter.format(1_999L);
        
        // verify
        assertThat(actual, is("1s 999ms"));
    }
    
    @Test
    public void _59_000ミリ秒は59秒() {
        // exercise
        String actual = formatter.format(59_000L);
        
        // verify
        assertThat(actual, is("59s"));
    }
    
    @Test
    public void _60_000ミリ秒は1分() {
        // exercise
        String actual = formatter.format(60_000L);
        
        // verify
        assertThat(actual, is("1m"));
    }
    
    @Test
    public void _80_500ミリ秒は1分20秒500ミリ秒() {
        // exercise
        String actual = formatter.format(80_500L);
        
        // verify
        assertThat(actual, is("1m 20s 500ms"));
    }
    
    @Test
    public void _3599_999ミリ秒は59分59秒999ミリ秒() {
        // exercise
        String actual = formatter.format(3599_999L);
        
        // verify
        assertThat(actual, is("59m 59s 999ms"));
    }
    
    @Test
    public void _3600_000ミリ秒は1時間() {
        // exercise
        String actual = formatter.format(3600_000L);
        
        // verify
        assertThat(actual, is("1h"));
    }
    
    @Test
    public void _7290_100ミリ秒は2時間1分30秒100ミリ秒() {
        // exercise
        String actual = formatter.format(7290_100L);
        
        // verify
        assertThat(actual, is("2h 1m 30s 100ms"));
    }

    @Test
    public void _86_400_000ミリ秒は24時間() {
        // exercise
        String actual = formatter.format(86_400_000L);
        
        // verify
        assertThat(actual, is("24h"));
    }

    @Test
    public void _172_800_000ミリ秒は48時間() {
        // exercise
        String actual = formatter.format(172_800_000L);
        
        // verify
        assertThat(actual, is("48h"));
    }
}
