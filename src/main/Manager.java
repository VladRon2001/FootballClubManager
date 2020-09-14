package main;

import java.util.Random;
import java.util.Scanner;

public class Manager {
    private int budget;
    private final FootballClub footballClub;
    ITraining training;
    IQualificationCourse qualificationCourse;

    Manager(FootballClub footballClub, int budget) {
        this.budget = budget;
        this.footballClub = footballClub;
        training = new Training();
        qualificationCourse = new QualificationCourse();
    }

    public void showFootballTeam() {
        System.out.println(footballClub.showFootballClub());
    }

    public void trainPlayer() {
        training.train(footballClub.getFootballTeam(), footballClub.getTrainer().getSkillLevel());
    }

    public FootballClub getFootballClub() {
        return footballClub;
    }

    public void buyPlayer(TransferMarket transferMarket) {
        int countPlayersOnTransfer = transferMarket.getPlayersOnTransfer().size();

        Random random = new Random();

        int indexRandomPlayer = random.nextInt(countPlayersOnTransfer) - 1;
        boolean isBuy = random.nextBoolean();

        if(isBuy) {
            FootballPlayer footballPlayer = transferMarket.getPlayersOnTransfer().elementAt(indexRandomPlayer);

            if(budget > footballPlayer.calculateCost()) {
                footballClub.addPlayerToFootballTeam(footballPlayer);
                transferMarket.deletePlayerFromTransfer(footballPlayer);
                budget -= footballPlayer.calculateCost();
            }
        }
    }

    public void sellPlayer(TransferMarket transferMarket) {
        if (footballClub.getFootballTeam().size() > 4) {
            Random random = new Random();

            boolean isSell = random.nextBoolean();

            if(isSell) {
               int indexRandomPlayer = random.nextInt(footballClub.getFootballTeam().size());
               FootballPlayer footballPlayer = footballClub.getFootballTeam().elementAt(indexRandomPlayer);

               transferMarket.addPlayerToTransfer(footballPlayer);
               footballClub.deletePlayerToFootballTeam(footballPlayer);

               budget += footballPlayer.calculateCost();
            }
        }
    }

    public int getBudget() {
        return budget;
    }

    public void levelUpTrainer() {
        qualificationCourse.levelUpTrainer(footballClub.getTrainer());
    }
}
