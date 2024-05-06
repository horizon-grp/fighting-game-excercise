package org.example;

import org.example.types.Attack;
import org.example.types.Defend;
import org.example.types.Gender;

import java.util.Objects;

public class Player {


    private String name;
    private Gender gender;
    private int health;

    public Player(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
        setHealth(100);
    }

    public boolean attack(Attack attack){
        return true;
    }
    public boolean defend(Defend defend){
        return true;
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
