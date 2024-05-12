package org.example;

import org.example.types.Attack;
import org.example.types.Defend;
import org.example.types.Gender;

import java.io.InputStream;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Player player;
    private static Opponent opponent;
    public static void main(String[] args) {
        loadGame();
        Fight fight = new Fight();

        System.out.println("Select your player");
        player = fight.selectPlayer();

        System.out.println("Select opponent");
        opponent = fight.selctOpponent();

        System.out.print("\n");
        fight.startFight();

        while (player.getHealth() >= 1 && opponent.getHealth() >= 1) {
            System.out.print("\n");
            displayGameHeader();
            System.out.println("Enter your attack \n1.");
            Attack attack1 = player.attack();
            Defend defend1 = opponent.defend();
            fight.updateHP(opponent, attack1, defend1);

            System.out.print("\n");
            if(opponent.getHealth() < 1)
                break;

            displayGameHeader();
            Attack attack2 = opponent.attack();
            System.out.println("Enter your defend \n1.");
            Defend defend2 = player.defend();
            fight.updateHP(player, attack2, defend2);
        }

        if (player.getHealth() > 0){
            System.out.println("YOU WON");
            System.out.println(player);
        } else {
            System.out.println("YOU LOST TO: ");
            System.out.println(opponent);
        }

        fight.endFight();
    }
    private static void loadGame() {
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("title.txt");
        if (inputStream != null) {
            try (Scanner scanner = new Scanner(inputStream)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                }
            }
        }
    }
    private static void displayGameHeader(){
        System.out.println("P1: " + player.getName() + "(" + player.getHealth() + "pts)" + " >> VS << P2: " + opponent.getName() + "(" + opponent.getHealth() + "pts)");
    }

}