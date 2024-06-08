package org.arenagame;

import org.arenagame.modules.Arena;
import org.arenagame.modules.Player;

import static org.arenagame.util.Utils.*;

class Main {
    public static void main(String[] args) {
        Arena arena = new Arena();
        while (true) {
            arena.displayPlayers();
            System.out.println("Options: \n\t1> Add new player\n\t2> Battle\n\t3> End game\n");
            int option = inputIntegerFromUser("Enter your choice (integer): ");
            scanner.nextLine();

            if (option == 1) {
                Player newPlayer = inputNewPlayerDetails();
                arena.addPlayer(newPlayer.getName(),newPlayer.getHealth(), newPlayer.getStrength(), newPlayer.getAttack());
            } else if (option == 2) {
                if (arena.getPlayerCount() < 2) {
                    System.out.println("There should be at least two players in the Arena.\nPlease add more players to continue.\n");
                } else {
                    int id_first = inputIntegerFromUser("Enter the first player's id: ");
                    int id_second = inputIntegerFromUser("Enter the second player's id: ");
                    scanner.nextLine();
                    arena.battle(id_first, id_second);
                }
            } else if (option == 3) {
                System.out.println("Exiting Arena...\n");
                break;
            }

            System.out.println("\n____________________________________________________________________________________________________\n\n");
        }

        scanner.close();
    }
}