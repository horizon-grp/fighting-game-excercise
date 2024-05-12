package org.example;

import org.example.types.Attack;
import org.example.types.Defend;
import org.example.types.Gender;

import java.util.Objects;
import java.util.Scanner;

public class Player {
    private String name;
    private Gender gender;
    private int health;

    public Player(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
        setHealth(100);
    }

    public Attack attack(){
        Scanner scanner = new Scanner(System.in);
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
    public Defend defend(){
        Scanner scanner = new Scanner(System.in);
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

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", health=" + health +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name) && gender == player.gender;
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, gender);
    }
}
