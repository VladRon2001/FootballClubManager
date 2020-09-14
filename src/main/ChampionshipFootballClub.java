package main;

public class ChampionshipFootballClub {
    private int scorePoint;
    private final FootballClub footballClub;

    ChampionshipFootballClub(FootballClub footballClub) {
        this.footballClub = footballClub;
        scorePoint = 0;
    }

    public FootballClub getFootballClub() {
        return footballClub;
    }

    public int getScorePoint() {
        return scorePoint;
    }

    public void setScorePoint(int scorePoint) {
        this.scorePoint = scorePoint;
    }

    @Override
    public String toString() {
        return footballClub.getClubName() + " " + scorePoint;
    }
}
