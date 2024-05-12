package org.example.garbbage;

import org.example.Player;
import org.example.types.Attack;
import org.example.types.Defend;
import org.example.types.Gender;

import java.io.InputStream;
import java.util.Random;
import java.util.Scanner;

public class MainV1 {
    private static Player player1;
    private static Player player2;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        loadGame();

        System.out.println("Select your player");
        player1 = selectPlayer();

        System.out.println("Select opponent");
        player2 = selectPlayer();

        System.out.print("\n");
        startFight();

        while (player1.getHealth() >= 1 && player2.getHealth() >= 1) {
            System.out.print("\n");
            displayGameHeader();
            System.out.println("Enter your attack \n1.");
            Attack attack1 = getAttack();
            Defend defend1 = systemDefend();
            updateHP(player2, attack1, defend1);

            System.out.print("\n");
            if(player2.getHealth() < 1)
                break;

            displayGameHeader();
            Attack attack2 = systemAttack();
            System.out.println("Enter your defend \n1.");
            Defend defend2 = getDefend();
            updateHP(player1, attack2, defend2);
        }

        displayWinner();

        System.out.println("\n Game Ended");

    }

    private static void loadGame() {
        InputStream inputStream = MainV1.class.getClassLoader().getResourceAsStream("title.txt");
        if (inputStream != null) {
            try (Scanner scanner = new Scanner(inputStream)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                }
            }
        }
    }
    private static Attack getAttack(){
        int option;
        Attack attack = null;

        do {
            System.out.println("1. Box \n2. Kick \n3. Shoot");
            option = scanner.nextInt();
        } while (option < 1 || option > 3);

        switch (option) {
            case 1:
                attack = Attack.BOX;
                break;
            case 2:
                attack = Attack.KICK;
                break;
            case 3:
                attack = Attack.SHOOT;
                break;
            default:
                break;
        }
        return attack;
    }
    private static Defend getDefend(){
        int option;
        Defend defend = null;

        do {
            System.out.println("1. Bend \n2. Jump \n3. Down");
            option = scanner.nextInt();
        } while (option < 1 || option > 3);

        switch (option) {
            case 1:
                defend = Defend.BEND;
                break;
            case 2:
                defend = Defend.JUMP;
                break;
            case 3:
                defend = Defend.DOWN;
                break;
            default:
                break;
        }
        return defend;
    }
    private static Attack systemAttack(){
        int option;
        Attack attack = null;

        do {
            Random rand = new Random();
            option = rand.nextInt(3) + 1;
        } while (option < 1 || option > 3);

        switch (option) {
            case 1:
                attack = Attack.BOX;
                break;
            case 2:
                attack = Attack.KICK;
                break;
            case 3:
                attack = Attack.SHOOT;
                break;
            default:
                break;
        }
        return attack;
    }
    private static Defend systemDefend(){
        int option;
        Defend defend = null;

        do {
            Random rand = new Random();
            option = rand.nextInt(3) + 1;
        } while (option < 1 || option > 3);

        switch (option) {
            case 1:
                defend = Defend.BEND;
                break;
            case 2:
                defend = Defend.JUMP;
                break;
            case 3:
                defend = Defend.DOWN;
                break;
            default:
                break;
        }
        return defend;
    }
    private static Player selectPlayer(){
        Scanner scanner = new Scanner(System.in);
        int option;
        Player player = null;

        do {
            System.out.println("1. Viktor(M) \n2. Jax(M) \n3. Slade(M) \n4. Maya(F) \n5. Akira(F)");
            option = scanner.nextInt();
        } while (option < 1 || option > 5);

        switch (option) {
            case 1:
                player = new Player("Viktor", Gender.M);
                break;
            case 2:
                player = new Player("Jax", Gender.M);
                break;
            case 3:
                player = new Player("Slade", Gender.M);
                break;
            case 4:
                player = new Player("Maya", Gender.F);
                break;
            case 5:
                player = new Player("Akira", Gender.F);
                break;
            default:
                break;
        }

        return player;
    }
    private static void startFight(){
        for (int i = 1; i <= 3; i++) {
            System.out.print(i + ".. ");
            try {
                Thread.sleep(300); // wait for 1 second
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            Thread.sleep(300); // wait for 1 second
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("FIGHT!!");
    }
    private static void displayGameHeader(){
        System.out.println("P1: " + player1.getName() + "(" + player1.getHealth() + "pts)" + " >> VS << P2: " + player2.getName() + "(" + player2.getHealth() + "pts)");
    }
    private static void updateHP(Player player, Attack attack, Defend defend){
        if ((attack == Attack.BOX && defend == Defend.BEND) ||
                (attack == Attack.KICK && defend == Defend.JUMP) ||
                (attack == Attack.SHOOT && defend == Defend.DOWN)
        ){
            System.out.println(player.getName() + " dodged the attack");
        } else if (attack == Attack.BOX){
            System.out.println(player.getName() + " was boxed, -10pts");
            player.setHealth(player.getHealth() - 10);
        }
        else if (attack == Attack.KICK){
            System.out.println(player.getName() + " was kicked, -20pts");
            player.setHealth(player.getHealth() - 20);
        }
        else if (attack == Attack.SHOOT){
            System.out.println(player.getName() + " was shot, -50pts");
            player.setHealth(player.getHealth() - 50);
        }
    }
    private static void displayWinner(){
        if (player1.getHealth() > 0){
            System.out.println("YOU WON");
            System.out.println(player1);
        } else {
            System.out.println("YOU LOST TO: ");
            System.out.println(player2);
        }
    }
}