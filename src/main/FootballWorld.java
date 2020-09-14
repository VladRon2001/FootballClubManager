package main;

import java.util.Scanner;
import java.util.Vector;

public class FootballWorld {
    private TransferMarket transferMarket;
    private Vector<Manager> managers;
    private Championship championship;

    public FootballWorld(Vector<Manager> managers, TransferMarket transferMarket) {
         this.managers = managers;
         this.transferMarket = transferMarket;

         Vector<FootballClub> footballClubs = new Vector<>();

         for(Manager manager:this.managers) {
             fillFootballClub(manager.getFootballClub());
             footballClubs.add(manager.getFootballClub());
         }

        championship = new Championship(footballClubs);
    }


    public void showTransferPlayers() {
        System.out.println(transferMarket.toString());
    }

    public Vector<Manager> getManagers() {
        return managers;
    }

    private void fillFootballClub(FootballClub footballClub) {
        footballClub.addPlayerToFootballTeam(transferMarket.getPlayerByPosition(Position.Goalkeeper));
        footballClub.addPlayerToFootballTeam(transferMarket.getPlayerByPosition(Position.Defender));
        footballClub.addPlayerToFootballTeam(transferMarket.getPlayerByPosition(Position.Midfielder));
        footballClub.addPlayerToFootballTeam(transferMarket.getPlayerByPosition(Position.Striker));
    }

    public String playRound() {
        championship.playRound();
        return championship.toString();
    }

    public TransferMarket getTransferMarket() {
        return transferMarket;
    }
}
