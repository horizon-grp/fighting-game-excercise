package org.example;

import org.example.types.Attack;
import org.example.types.Defend;
import org.example.types.Gender;

import java.util.Random;

public class Opponent extends Player{
    public Opponent(String name, Gender gender) {
        super(name, gender);
    }

    @Override
    public Attack attack() {
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

    @Override
    public Defend defend() {
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
}
