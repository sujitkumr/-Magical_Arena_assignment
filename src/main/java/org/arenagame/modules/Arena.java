package org.arenagame.modules;

import java.util.HashMap;
import java.util.Map;

import static org.arenagame.util.Utils.rollDice;

public class Arena {
    private int totalPlayers;
    private Map<Integer, Player> players;

    public Arena() {
        this.totalPlayers = 0;
        this.players = new HashMap<>();
        System.out.println("Welcome to the arena!!!\n");
    }

    public boolean isPresent(int id) {
        return this.players.containsKey(id);
    }

    public int getPlayerCount() {
        return this.players.size();
    }

    public int addPlayer(String name, int health, int strength, int attack) {
        if (health <= 0 || strength <= 0 || attack <= 0) {
            System.out.println("Health, strength, and attack should be positive integers.");
            return -1;
        }

        int id = this.totalPlayers;
        Player newPlayer = new Player(id, name, health, strength, attack);
        this.players.put(id, newPlayer);
        this.totalPlayers += 1;

        return id;
    }

    public void deletePlayer(int id) {
        if (this.players.containsKey(id)) {
            Player player = this.players.get(id);
            System.out.println(player.getName() + " has been un-alived...\n");
            this.players.remove(id);
        } else {
            System.out.println("No player with id = " + id + " exists.\n");
        }
    }

    public void displayPlayers() {
        System.out.println("|\tId\t|\tName\t|\tHealth\t|\tStrength\t|\tAttack\t|");
        for (Map.Entry<Integer, Player> entry : this.players.entrySet()) {
            Player player = entry.getValue();
            System.out.println("|\t" + entry.getKey() + "\t|\t" + player.getName() + "\t|\t" + player.getHealth() + "\t|\t" + player.getStrength() + "\t|\t" + player.getAttack() + "\t|");
        }
        System.out.println();
    }

    public void battle(int idFirst, int idSecond) {
        if (idFirst == idSecond) {
            System.out.println("Id's cannot be the same for both players.\n");
            return;
        }
        if (!this.players.containsKey(idFirst) || !this.players.containsKey(idSecond)) {
            System.out.println("One or both players do not exist.\n");
            return;
        }

        Player attacker = this.players.get(idFirst);
        Player defender = this.players.get(idSecond);
        System.out.println("\n____________" + attacker.getName() + " vs " + defender.getName() + "____________\n");

        if (defender.getHealth() < attacker.getHealth()) {
            // Swap players so that the one with lower health attacks first
            Player temp = attacker;
            attacker = defender;
            defender = temp;
        }

        while (defender.getHealth() > 0) {
            int diceRollResultForAttack = rollDice();
            int diceRollResultForDefence = rollDice();
            int attackingPower = attacker.getAttack() * diceRollResultForAttack;
            int defendingPower = defender.getStrength() * diceRollResultForDefence;

            System.out.println(attacker.getName() + " gets dice roll of " + diceRollResultForAttack  +  " and hits " + defender.getName() + " with power = " + attackingPower);
            System.out.println(defender.getName() + " gets dice roll of " + diceRollResultForDefence  + " and defends with power = " + defendingPower);

            if (attackingPower > defendingPower) {
                defender.setHealth(defender.getHealth() - (attackingPower - defendingPower));
                defender.setHealth(Math.max(0, defender.getHealth()));
            }

            System.out.println(defender.getName() + "'s health: " + defender.getHealth());

            if (defender.getHealth() > 0) {
                Player temp = attacker;
                attacker = defender;
                defender = temp;
            }
        }

        System.out.println(attacker.getName() + " has emerged victorious!!!\n");
        this.deletePlayer(defender.getId());
    }
}
