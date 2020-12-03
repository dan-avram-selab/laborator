package ro.mta.facc.selab.lab8.factory;

public class GeneratorPattern {
    public static NumberGenerator create(GeneratorType type)
    {
        switch (type) {
            case EVEN_RANDOM_NUMBER -> {
                return new EvenRandomNumberGenerator();
            }
            case ODD_RANDOM_NUMBER -> {
                return new OddRandomNumberGenerator();
            }
            case SEQUENTIAL_NUMBERS -> {
                return new SequencialNumberGenerator(0);
            }
        }

        return null;
    }
}
