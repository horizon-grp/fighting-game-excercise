package org.example;

import org.example.types.Attack;
import org.example.types.Defend;
import org.example.types.Gender;
import org.example.types.Status;

import java.util.Scanner;

public class Fight {
    Status status;

    public Fight() {
        this.status = Status.INIT;
    }

    public void startFight(){
        this.status = Status.STARTED;
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
    public Player selectPlayer(){
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
    public Opponent selctOpponent(){
        Scanner scanner = new Scanner(System.in);
        int option;
        Opponent opponent = null;

        do {
            System.out.println("1. Viktor(M) \n2. Jax(M) \n3. Slade(M) \n4. Maya(F) \n5. Akira(F)");
            option = scanner.nextInt();
        } while (option < 1 || option > 5);

        switch (option) {
            case 1:
                opponent = new Opponent("Viktor", Gender.M);
                break;
            case 2:
                opponent = new Opponent("Jax", Gender.M);
                break;
            case 3:
                opponent = new Opponent("Slade", Gender.M);
                break;
            case 4:
                opponent = new Opponent("Maya", Gender.F);
                break;
            case 5:
                opponent = new Opponent("Akira", Gender.F);
                break;
            default:
                break;
        }

        return opponent;
    }
    public void updateHP(Player player, Attack attack, Defend defend){
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
    public void endFight(){
        this.status = Status.STOPPED;
        System.out.println("\nFight Ended");
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
}
