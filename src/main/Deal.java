package main;

import java.util.Random;
import java.util.Scanner;

public class Deal {
    private int costDeal;
    final private TypeDeal typeDeal;
    final private FootballPlayer playerInDeal;
    private boolean accept;

    public Deal(FootballPlayer player, TypeDeal typeDeal) {
        costDeal = player.calculateCost();
        this.typeDeal = typeDeal;
        playerInDeal = player;
        accept = false;
    }

    public void makeDeal() {
        System.out.println("Cost deal - " + costDeal + "\n1 - confirm deal\n2 - change cost");

        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int anInt = sc.nextInt();

        if (anInt == 1) {
            accept = true;
            return;
        }
        else {
            System.out.println("Enter your cost");
            int costByManger = sc.nextInt();
            int randomPercentage;
            if(typeDeal == TypeDeal.Buying) {
                 randomPercentage = (costDeal-costByManger)*random.nextInt(10);
            }
            else {
                randomPercentage = (costByManger-costDeal)*random.nextInt(10);
            }

            if (randomPercentage < 1000) {
                costDeal = costByManger;
                accept = true;
            }
        }
    }

    public boolean isAccept() {
        return accept;
    }

    public int getCostDeal() {
        return costDeal;
    }
}
