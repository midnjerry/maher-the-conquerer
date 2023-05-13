package com.techelevator.game;

public class Player {
    private String name;
    private int hitPoints = 100;
    private String weapon;

    public boolean isDead(){
        return hitPoints <= 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getHitPoints(){
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public String getWeapon(){
        return weapon;
    }

    public void setWeapon(String weapon){
        this.weapon = weapon;
    }

    public void attackZombie(Zombie zombie) {
        int damage = getDamage();
        System.out.println(name + " attacks with his " + weapon + "!");
        zombie.damage(damage);
    }

    public void damage(Zombie zombieAttacker, int damage) {
        int dodgeRoll = (int)Math.random() * 6 + 1;
        if (dodgeRoll >= 3){
            System.out.println(name + " adeptly dodges to his right, sneers and strikes back!");
            int heroDamage = getDamage();
            zombieAttacker.damage(heroDamage);
        } else {
            System.out.println(name + " get hit in the face and loses " + damage + " hit points!");
            hitPoints -= damage;
            if (hitPoints <= 0){
                System.out.println(name + " has been beaten like he owed the zombie money!   Game Over...");
            }
        }
    }

    private int getDamage() {
        switch(weapon.toUpperCase()) {
            case("BATTLE AXE"): return 25;
            case("BROAD SWORD"): return 20;
            case("SHORT SWORD"): return 15;
            default: return 5;
        }
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", hitPoints=" + hitPoints +
                ", weapon='" + weapon + '\'' +
                '}';
    }


}
