package main;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;



public class Main {
    static void menu(Manager manager) {
        Scanner sc = new Scanner(System.in);
        int keyMenu;
        do {
            System.out.println("Choose the variant");
            System.out.println("1 - show football club");
            System.out.println("2 - show transfer market");
            System.out.println("3 - buy player");
            System.out.println("4 - sell player");
            System.out.println("5 - train player");
            System.out.println("6 - show budget");
            System.out.println("7 - level up trainer");
            System.out.println("0 - quit");

            keyMenu = sc.nextInt();
            switch (keyMenu) {
                case 1:
                    manager.showFootballTeam();
                    break;
                case 2:
                    manager.showTransferPlayers();
                    break;
                case 3:
                    manager.makeDeal(TypeDeal.Buying);
                    break;
                case 4:
                    manager.makeDeal(TypeDeal.Selling);
                    break;
                case 5:
                    manager.trainPlayer();
                    break;
                case 6:
                    System.out.println(manager.getBudget());
                    break;
                case 7:
                    manager.levelUpTrainer();
            }

        } while (keyMenu != 0);
    }

    public static void main(String[] args) throws FileNotFoundException {
        TransferMarket transferMarket = new TransferMarket();
        FootballClub footballClub = new FootballClub("Dnepr");

        Manager manager = new Manager(footballClub, transferMarket, 10000);

        menu(manager);
    }

}
