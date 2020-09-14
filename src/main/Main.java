package main;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;



public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        TransferMarket transferMarket = new TransferMarket();
        Trainer trainerDnepr = new Trainer("Cohen", 3);
        Trainer trainerDynamo = new Trainer("Hughes", 5);
        Trainer trainerShakhtar = new Trainer("Sandoval",4);
        FootballClub footballClubDnepr = new FootballClub("Dnepr", trainerDnepr);
        FootballClub footballClubDynamo = new FootballClub("Dynamo", trainerDynamo);
        FootballClub footballClubShacktar = new FootballClub("Shakhtar", trainerShakhtar);

        Manager managerDnepr = new Manager(footballClubDnepr, 1000000);
        Manager managerDynamo = new Manager(footballClubDynamo, 20000000);
        Manager managerShakhtar = new Manager(footballClubShacktar, 30000000);

        Vector<Manager> managers = new Vector<Manager>();
        managers.add(managerDnepr);
        managers.add(managerDynamo);
        managers.add(managerShakhtar);

        FootballWorld footballWorld = new FootballWorld(managers, transferMarket);

        for(Manager manager:footballWorld.getManagers()) {
            manager.showFootballTeam();
        }

        for(int i = 0; i < 10; ++i) {
            for(Manager manager:footballWorld.getManagers()) {
                Random random = new Random();
                int key = random.nextInt(5);

                switch (key) {
                    case 1:
                        manager.trainPlayer();
                        break;
                    case 2:
                        manager.levelUpTrainer();
                        break;
                    case 3:
                        manager.buyPlayer(footballWorld.getTransferMarket());
                        break;
                    case 4:
                        manager.sellPlayer(footballWorld.getTransferMarket());
                        break;
                }
            }

            System.out.println(footballWorld.playRound());
        }
    }
}
