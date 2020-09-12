package main;

import java.util.Scanner;

public class Manager {
    private int budget;
    private final FootballClub footballClub;
    private final TransferMarket transferMarket;
    ITraining training;
    IQualificationCourse qualificationCourse;

    Manager(FootballClub footballClub, TransferMarket transferMarket, int budget) {
        this.budget = budget;
        this.footballClub = footballClub;
        this.transferMarket = transferMarket;
        training = new Training();
        qualificationCourse = new QualificationCourse();
    }

    public void showTransferPlayers() {
        System.out.println(transferMarket.toString());
    }

    public void showFootballTeam() {
        System.out.println(footballClub.showFootballClub());
    }

    private FootballPlayer searchPlayer(String playerName, TypeDeal typeDeal) {
        if(typeDeal == TypeDeal.Buying) {
            for(FootballPlayer footballPlayer:transferMarket.getPlayersOnTransfer()) {
                if(playerName.equals(footballPlayer.getName())) {
                    return footballPlayer;
                }
            }
        }
        else {
            for(FootballPlayer footballPlayer:footballClub.getFootballTeam()) {
                if(playerName.equals(footballPlayer.getName())) {
                    return footballPlayer;
                }
            }
        }

        return null;
    }

    public void makeDeal(TypeDeal typeDeal) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter name player");
        String playerName = sc.next();

        FootballPlayer footballPlayerOnTransfer = searchPlayer(playerName, typeDeal);

        while (footballPlayerOnTransfer == null) {
            System.out.println("Not found. Enter again");
            playerName = sc.next();

            footballPlayerOnTransfer = searchPlayer(playerName, typeDeal);
        }


        Deal deal = new Deal(footballPlayerOnTransfer, typeDeal);
        deal.makeDeal();

        if(deal.isAccept()) {
            if(typeDeal == TypeDeal.Buying) {
                if(deal.getCostDeal() < budget) {
                    budget -= deal.getCostDeal();

                    transferMarket.deletePlayerFromTransfer(footballPlayerOnTransfer);
                    footballClub.addPlayerToFootballTeam(footballPlayerOnTransfer);
                }
                else {
                    System.out.println("You don't have money");
                }
            }

            else {
                budget += deal.getCostDeal();
                footballClub.deletePlayerToFootballTeam(footballPlayerOnTransfer);
                transferMarket.addPlayerToTransfer(footballPlayerOnTransfer);
            }
        }
    }

    public void trainPlayer() {
        training.train(footballClub.getFootballTeam(), footballClub.getTrainer().getSkillLevel());
    }

    public int getBudget() {
        return budget;
    }

    public void levelUpTrainer() {
        qualificationCourse.levelUpTrainer(footballClub.getTrainer());
    }
}
