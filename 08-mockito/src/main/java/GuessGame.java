import java.util.Scanner;

public class GuessGame {
    RandomNumber generator;
    IScanner key;
    int nr;

    public void setScanner(IScanner s)
    {
        key = s;
    }

    public GuessGame(RandomNumber generator) {
        this.generator = generator;
        nr = generator.getRandomNumber();
    }

    void play()
    {
        int readNr;
        do {
            readNr = key.readInt();
        } while (verify(readNr) == false);
    }

    boolean verify(int verify_nr)
    {
        return nr == verify_nr;
    }
}
