package ro.mta.facc.selab.lab8.proxy;

public class Internet implements Network{
    public void get(String URL) {
        System.out.println("V-ati conectat cu succes la site-ul " + URL);
    }
}
