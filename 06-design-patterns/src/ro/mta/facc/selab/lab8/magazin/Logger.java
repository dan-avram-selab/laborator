package ro.mta.facc.selab.lab8.magazin;

public class Logger {
    static private Logger instance;
    private Logger() {}
    static public Logger getInstance()
    {
        if (instance == null)
            instance = new Logger();
        return instance;
    }

    void log(String msg)
    {
        System.out.println(msg);
    }

}
