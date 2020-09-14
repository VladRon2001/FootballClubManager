package main;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;
import java.io.File;

public class TransferMarket {
    private final Vector<FootballPlayer> playersOnTransfer;

    public TransferMarket() throws FileNotFoundException {
        playersOnTransfer = new Vector<FootballPlayer>(0);
        File file = new File("C:\\Users\\Vlad\\IdeaProjects\\first\\src\\main\\PlayerList");
        fillTransferMarket(file);
    }

    public void addPlayerToTransfer(FootballPlayer footballPlayer) {
       playersOnTransfer.add(footballPlayer);
    }

    public void deletePlayerFromTransfer(FootballPlayer footballPlayer) {
        playersOnTransfer.remove(footballPlayer);
    }

    public FootballPlayer getPlayerByPosition(Position position) {
        for(FootballPlayer footballPlayer:playersOnTransfer) {
            if(footballPlayer.getPosition() == position) {
                playersOnTransfer.remove(footballPlayer);
                return footballPlayer;
            }
        }
        return null;
    }

    public Vector<FootballPlayer> getPlayersOnTransfer() {
        return playersOnTransfer;
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

    public void fillTransferMarket(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            String stringPlayerName = sc.next();
            int ratingScore = sc.nextInt();
            String titlePosition = sc.next();
            int age = sc.nextInt();

            addPlayerToTransfer(
                    new FootballPlayer(stringPlayerName, age, ratingScore,
                            stringToPosition(titlePosition)));
        }
    }

    @Override
    public String toString() {
        String listPlayersOnTransfer = "";
        for (FootballPlayer footballPlayer: playersOnTransfer) {
            listPlayersOnTransfer += footballPlayer.toString();
            listPlayersOnTransfer += "\n";
        }

        return listPlayersOnTransfer;
    }
}
