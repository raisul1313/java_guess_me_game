package com.example.guessmegame;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Guess me Game");
        System.out.print("Please Enter your Name: ");

        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.println("Hello, " + name);

        boolean rePlay = false;

        do {
            System.out.println("Shall we begin ?");
            System.out.println("\t1. Yes");
            System.out.println("\t2. No");

            int beginAnswer = scanner.nextInt();
            while (beginAnswer != 1) {
                System.out.println("Shall we begin ?");
                System.out.println("\t1. Yes");
                System.out.println("\t2. No");
                beginAnswer = scanner.nextInt();
            }

            Random random = new Random();
            int x = random.nextInt(20) + 1;
            System.out.print("Please Guess a Number: ");
            int userInput = scanner.nextInt();

            int timeTried = 0;
            boolean hasWon = false;
            boolean shouldFinish = false;

            while (!shouldFinish) {
                if (timeTried < 5) {
                    if (userInput == x) {
                        hasWon = true;
                        shouldFinish = true;
                    } else if (userInput > x) {
                        System.out.println("Guess Lower");
                        userInput = scanner.nextInt();
                    } else {
                        System.out.println(" Guess Higher");
                        userInput = scanner.nextInt();
                    }
                } else {
                    shouldFinish = true;
                }
                timeTried++;
            }

            if (hasWon) {
                System.out.println("Congratulation!!! The Number is " + x + ". You have guess in your " + timeTried + " guess.");
            } else {
                System.out.println("Game Over !!!");
                System.out.println("The Number was: " + x);
            }
        } while (!rePlay);
    }
}
