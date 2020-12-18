import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Spy;

import java.util.Scanner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class GuessGameTest {
    GuessGame instance;
    RandomNumber mockRn;
    IScanner sc;

    @Before
    public void setUp() throws Exception {
        mockRn = mock(RandomNumber.class);
        when(mockRn.getRandomNumber()).thenReturn(7);
        instance = new GuessGame(mockRn);
        sc = mock(IScanner.class);
        instance.setScanner(sc);
    }

    @Test
    public void verify() {
        assertTrue(instance.verify(7));
        assertFalse(instance.verify(9));
    }

    @Test
    public void play() {
        when(sc.readInt()).thenReturn(9).thenReturn(3).thenReturn(8).thenReturn(7);
        instance.play();

        try {
            Mockito.verify(sc, Mockito.times(3)).readInt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}