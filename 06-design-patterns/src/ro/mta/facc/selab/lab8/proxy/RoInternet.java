package ro.mta.facc.selab.lab8.proxy;

public class RoInternet implements Network {
    Internet internet = null;

    public RoInternet(Internet internet) {
        this.internet = internet;
    }

    @Override
    public void get(String URL) {
        // Very bad verifying, easy to bypass ex: 'https://google.com?.ro'
        if (URL.contains(".ro"))
            internet.get(URL);
        else
            System.out.println("Nu s-a putut realiza conexiunea!");
    }
}
