package ro.mta.facc.selab.lab8.match;

public class PanouAfisaj implements Runnable, Observer {

    Match m;
    boolean end = false;
    private int team1 = 0;
    private int team2 = 0;

    public PanouAfisaj(Match m)
    {
        this.m = m;
    }

    public void stop()
    {
        end = true;
    }

    @Override
    public void run() {
        while (end == false) {
            System.out.println("Score: " + team1 + " - " + team2);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void update()
    {
        team1 = m.getTeamScore(TEAM.FIRST_TEAM);
        team2 = m.getTeamScore(TEAM.SECOND_TEAM);
    }
}
