package ro.mta.facc.selab.lab8.factory;

import java.util.Random;

public class EvenRandomNumberGenerator implements NumberGenerator {
    Random rnd = new Random();

    @Override
    public int getNumber() {
        int nr = rnd.nextInt();
        if (nr % 2 == 1)
            return nr - 1;
        else
            return nr;
    }
}
