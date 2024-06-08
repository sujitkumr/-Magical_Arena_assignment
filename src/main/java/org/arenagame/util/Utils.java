package org.arenagame.util;

import org.arenagame.modules.Player;

import java.util.Random;
import java.util.Scanner;

public class Utils {
    public static int rollDice() {
        int min = 1, max = 6;
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
    public static Scanner scanner = new Scanner(System.in);

    private static String inputStringFromUser(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static int inputIntegerFromUser(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            scanner.next(); // to consume the incorrect input
            System.out.print("Invalid input. Please enter a valid integer: ");
        }
        return scanner.nextInt();
    }

    public static Player inputNewPlayerDetails() {
        Random random = new Random();
        int id = random.nextInt(Integer.MAX_VALUE);
        String name = inputStringFromUser("Enter the player's name: ");
        int health = inputIntegerFromUser(String.format("Enter %s's health: ", name));
        int attack = inputIntegerFromUser(String.format("Enter %s's attack: ", name));
        int strength = inputIntegerFromUser(String.format("Enter %s's strength: ", name));
        return new Player(id, name, health, strength, attack);
    }
}
