package ro.mta.facc.selab.lab8.factory;

public class SequencialNumberGenerator implements NumberGenerator {
    int start = 0;
    SequencialNumberGenerator(int x)
    {
        start = x;
    }

    @Override
    public int getNumber() {
        return start++;
    }
}
