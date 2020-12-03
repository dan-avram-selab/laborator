package ro.mta.facc.selab.lab8.match;

import java.util.ArrayList;

public class Match {
    private int team1 = 0;
    private int team2 = 0;
    ArrayList<Observer> obsList = new ArrayList<>();

    public void addObs(Observer obs){
        obsList.add(obs);
    }

    private void notifyObservers() {
        for (Observer o:obsList) {
            o.update();
        }
    }

    public void score(TEAM t) {
        switch (t) {
            case FIRST_TEAM:
                team1++;
                break;
            case SECOND_TEAM:
                team2++;
                break;
        }
        notifyObservers();
    }

    public int getTeamScore(TEAM t)
    {
        switch (t) {
            case FIRST_TEAM:
                return team1;
            case SECOND_TEAM:
                return team2;
        }
        return 0;
    }
}
