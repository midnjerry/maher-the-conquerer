package com.techelevator.game;

import com.techelevator.toys.JackInTheBox;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public static void main(String[] args) {
        Player player = new Player();
        player.setName("Maher the Conquerer");
        player.setHitPoints(75);
        player.setWeapon("Battle Axe");

        List<Zombie> zombies = new ArrayList<>();
        zombies.add(new Zombie("Shawn", 100));
        zombies.add(new Zombie("James", 99));
        zombies.add( new Zombie("Jerry", 98));
        zombies.add(new Zombie());

        for (Zombie z: zombies){
            System.out.println(z);
        }

        for (int i = 0; i < 50 && zombies.size() > 0; i++) {
            int index = (int) (Math.random() * zombies.size());
            Zombie victim = zombies.get(index);
            player.attackZombie(victim);
            if (victim.isDead()) {
                zombies.remove(victim);
            } else {
                victim.attackPlayer(player);
            }
            if (player.isDead()){
                break;
            }
        }

        if (!player.isDead()){
            System.out.println(player.getName() + " is standing amongst the limbs of his enemies as he walks into the sunset.");
        }
    }

    private static void playJackInTheBox() {
        JackInTheBox jack = new JackInTheBox();
        jack.closeLid();
        for (int i = 0; i < 10; i++){
            jack.turnCrank();
        }
        jack.closeLid();
        for (int i = 0; i < 5; i++){
            jack.turnCrank();
        }
    }
}
