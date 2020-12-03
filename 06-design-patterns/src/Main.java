import ro.mta.facc.selab.lab8.factory.GeneratorPattern;
import ro.mta.facc.selab.lab8.factory.NumberGenerator;
import ro.mta.facc.selab.lab8.magazin.MagazinOnline;
import ro.mta.facc.selab.lab8.magazin.NotEnoughProductsException;
import ro.mta.facc.selab.lab8.match.Match;
import ro.mta.facc.selab.lab8.match.PanouAfisaj;
import ro.mta.facc.selab.lab8.match.TEAM;
import ro.mta.facc.selab.lab8.proxy.Internet;
import ro.mta.facc.selab.lab8.proxy.RoInternet;

import java.util.HashMap;

import static ro.mta.facc.selab.lab8.factory.GeneratorType.*;

public class Main {
    public static void main(String[] args)
    {
        /*
        MagazinOnline magazin = new MagazinOnline();
        HashMap<String, Integer> products = new HashMap<>();
        products.put("TV", 10);
        products.put("iPhone", 5);
        magazin.restock(products);

        try {
            magazin.sell("TV", 1);
            magazin.sell("TV", 1);
            magazin.sell("iPhone", 3);
        } catch (NotEnoughProductsException e) {
            System.out.println("Not enough products... abort selling");
        }

        System.out.println("======== Ex 2 ========");

        Match match = new Match();
        PanouAfisaj panouAfisaj = new PanouAfisaj(match);
        match.addObs(panouAfisaj);

        new Thread(panouAfisaj).start();

        try {
            Thread.sleep(2000);
            match.score(TEAM.FIRST_TEAM); // Prima echipa inscrie gol

            Thread.sleep(4000);
            match.score(TEAM.SECOND_TEAM); // A doua echipa inscrie gol
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        panouAfisaj.stop();


        NumberGenerator gen = GeneratorPattern.create(ODD_RANDOM_NUMBER);
        System.out.println(gen.getNumber());
        gen = GeneratorPattern.create(EVEN_RANDOM_NUMBER);
        System.out.println(gen.getNumber());
        gen = GeneratorPattern.create(SEQUENTIAL_NUMBERS);
        System.out.println(gen.getNumber());
        System.out.println(gen.getNumber());
 */
        Internet internet = new Internet();
        RoInternet roInternet= new RoInternet(internet);

        roInternet.get("https://google.ro");
        roInternet.get("https://google.com");
    }


}
