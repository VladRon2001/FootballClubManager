package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class FootballClub {
    private Trainer trainer;
    private String clubName;
    private final Vector <FootballPlayer> footballTeam;

    FootballClub(String clubName) throws FileNotFoundException {
        this.clubName = clubName;
        File file = new File("C:\\Users\\Vlad\\IdeaProjects\\first\\src\\main\\FootballClub");
        footballTeam = new Vector<FootballPlayer>();
        fillFootballClub(file);
    }

    private Position stringToPosition(String title) {
        if(title.equals("GK"))
            return Position.Goalkeeper;
        else if(title.equals("DF"))
            return Position.Defender;
        else if(title.equals("CM"))
            return Position.Midfielder;
        else
            return Position.Striker;
    }

    private void fillFootballClub(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);

        String trainerName = sc.next();
        int trainerSkill = sc.nextInt();

        trainer = new Trainer(trainerName, trainerSkill);

        while (sc.hasNextLine()) {
            String stringPlayerName = sc.next();
            int ratingScore = sc.nextInt();
            String titlePosition = sc.next();
            int age = sc.nextInt();

            addPlayerToFootballTeam(
                    new FootballPlayer(stringPlayerName, age, ratingScore,
                            stringToPosition(titlePosition)));
        }
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
}
