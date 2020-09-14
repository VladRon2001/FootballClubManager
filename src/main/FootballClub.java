package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class FootballClub {
    private Trainer trainer;
    private String clubName;
    private final Vector <FootballPlayer> footballTeam;

    FootballClub(String clubName, Trainer trainer) {
        this.clubName = clubName;
        footballTeam = new Vector<FootballPlayer>();
        this.trainer = trainer;
    }

    public String getClubName() {
        return clubName;
    }

    public Vector<FootballPlayer> getFootballTeam() {
        return footballTeam;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void addPlayerToFootballTeam(FootballPlayer footballPlayer) {
        footballTeam.add(footballPlayer);
    }

    public void deletePlayerToFootballTeam(FootballPlayer footballPlayer) {
        footballTeam.remove(footballPlayer);
    }

    public String showFootballClub() {
        String trainerToString = "Trainer\n" + trainer.toString();

        String listPlayersInClub = "\nPlayers\n";
        for (FootballPlayer footballPlayer: footballTeam) {
            listPlayersInClub += footballPlayer.toString();
            listPlayersInClub += "\n";
        }

        return trainerToString+listPlayersInClub;
    }

    public int calculateStrongTeam() {
        int sumRatingScore = 0;

        for(FootballPlayer footballPlayer:footballTeam) {
            sumRatingScore += footballPlayer.getRatingScore();
        }

        return sumRatingScore/footballTeam.size();
    }
}
