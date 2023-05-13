package com.techelevator.game;

public class Zombie {
    private String name = "Zombie";
    private int hitpoints = 50;
    private boolean isDead = false;

    // empty constructor
    // no return type
    // name matches class name
    // public Zombie() {}
    public Zombie() {}

    public Zombie(String name, int hitpoints) {
        this.name = name;
        this.hitpoints = hitpoints;
    }

    public boolean isDead() {
        return isDead;
    }

    // GETTERS - VERY IMPORTANT TO MEMORIZE
    public int getHitpoints() {
        return hitpoints;
    }

    public String getName() {
        return name;
    }

    // SETTERS
    public void setHitpoints(int value){
        if (value < 0){
            hitpoints = 0;
        } else {
            hitpoints = value;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void attack() {
        System.out.println("The Zombie attacks!");
    }

    public void damage(int damage) {
        hitpoints -= damage;
        if (hitpoints > 0){
            System.out.println(name + " gets hit for " + damage + " hit points!");
        } else {
            isDead = true;
            hitpoints = 0;
            System.out.println(name + " is conquered and falls to the ground!!!");
        }
    }

    public void attackPlayer(Player player) {
        int damage = (int)(Math.random()* 5) + 1;
        System.out.println(name + " snarls at " + player.getName() + " and swipes and claws at his face.");
        player.damage(this, damage);
    }

    @Override
    public String toString() {
        return "Zombie{" +
                "name='" + name + '\'' +
                ", hitpoints=" + hitpoints +
                ", isDead=" + isDead +
                '}';
    }
}
