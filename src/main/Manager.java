package main;

import java.util.Random;

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

        FootballPlayer footballPlayer = transferMarket.getPlayersOnTransfer().elementAt(indexRandomPlayer);

        Deal deal = new Deal(footballPlayer, TypeDeal.Buying);

        if(budget > deal.getCostDeal()) {
            if(deal.makeDeal(transferMarket, footballClub)) {
                budget -= deal.getCostDeal();
            }
        }
    }

    public void sellPlayer(TransferMarket transferMarket) {
        if (footballClub.getFootballTeam().size() > 4) {
            Random random = new Random();

            int indexRandomPlayer = random.nextInt(footballClub.getFootballTeam().size());
            FootballPlayer footballPlayer = footballClub.getFootballTeam().elementAt(indexRandomPlayer);

            Deal deal = new Deal(footballPlayer, TypeDeal.Selling);
            deal.makeDeal(transferMarket, footballClub);

            if(deal.makeDeal(transferMarket, footballClub)) {
                budget += deal.getCostDeal();
            }
        }
    }

    public void levelUpTrainer() {
        qualificationCourse.levelUpTrainer(footballClub.getTrainer());
    }
}
