package main;

import java.util.Vector;

public class FootballWorld {
    private final TransferMarket transferMarket;
    private final Vector<Manager> managers;
    private final Championship championship;

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
