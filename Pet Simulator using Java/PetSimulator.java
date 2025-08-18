// Pet Simulator: Pixel the Cat
// Author: [SMDR]
// Description: A simple text-based game where you care for your pet Pixel!
// Actions: play (p), eat (e), rest (r), quit (q)

import java.util.Scanner;

public class PetSimulator {
    public static String describeStat(int stat) {
        if (stat >= 15) return " (Excellent)";
        else if (stat >= 10) return " (Okay)";
        else if (stat >= 5) return " (Getting low)";
        else return " (Very low!)";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hunger = 10;
        int energy = 10;
        int fun = 10;
        System.out.println("""
        Name of Sim: Pixel 🐱

        |\\__/,|   (`\\
        |o o  |__ _)
        _.( T   )  `  /
        ((_ `^--' /_<  \\
        `` `-'(((/  (((/

        """);
        System.out.println("Hunger: " + hunger);
        System.out.println("Energy: " + energy);
        System.out.println("Fun: " + fun);
        boolean playing = true;
        String[] playMessages = {
            "You tossed a ball, and Pixel chased it around!",
            "Pixel pounced on a toy mouse!",
            "You played hide and seek with Pixel!"
        };
        String[] eatMessages = {
            "Pixel munched on some crunchy kibble!",
            "You gave Pixel a delicious treat!",
            "Pixel slurped up some tasty milk!"
        };

        String[] restMessages = {
            "Pixel curled up in a sunny spot and snoozed.",
            "Pixel purred softly while napping on your lap.",
            "Pixel stretched out and took a cozy nap."
        };

        while (playing) {
            // Display stats

            System.out.println();
            System.out.println("Choose an action:");
            System.out.println("[p] Play  [e] Eat  [r] Rest  [q] Quit");
            System.out.print("Action: ");
            String action = scanner.nextLine();

            switch (action.toLowerCase()) {
                case "p":
                    System.out.println(playMessages[(int)(Math.random() * playMessages.length)]);
                    fun += 2;
                    energy -= 2;
                    hunger -= 1;
                    break;
                case "e":
                    System.out.println(eatMessages[(int)(Math.random() * eatMessages.length)]);
                    hunger += 3;
                    energy += 1;
                    break;
                case "r":
                    System.out.println(restMessages[(int)(Math.random() * restMessages.length)]);
                    energy += 4;
                    fun -= 1;
                    break;
                case "q":
                    System.out.println("Goodbye!");
                    playing = false;
                    continue;
                default:
                    System.out.println("Invalid command.");
                    continue;
            }

            // Clamp values to be between 0 and 20
            hunger = Math.max(0, Math.min(hunger, 20));
            energy = Math.max(0, Math.min(energy, 20));
            fun = Math.max(0, Math.min(fun, 20));

            if (hunger <= 4) {
                System.out.println("⚠️ Pixel is starving!");
            }
            if (energy <= 4) {
                System.out.println("⚠️ Pixel is exhausted!");
            }
            if (fun <= 4) {
                System.out.println("⚠️ Pixel is very bored!");
            }

            if (hunger == 0 || energy == 0 || fun == 0) {
                System.out.println("Oh no! Pixel's needs weren't met!");
                System.out.println("Game Over.");
                break;
            }
            
            System.out.println("Hunger: " + hunger + describeStat(hunger));
            System.out.println("Energy: " + energy + describeStat(energy));
            System.out.println("Fun: " + fun + describeStat(fun));

            int mood = (hunger + energy + fun) / 3;
            System.out.print("Mood: ");
            if (mood >= 15) System.out.println("😺 Happy!");
            else if (mood >= 10) System.out.println("😼 Okay.");
            else if (mood >= 5) System.out.println("🙀 Sad.");
            else System.out.println("😿 Miserable...");

            System.out.println("-------------------------------");
        }

        scanner.close();
    }
}
