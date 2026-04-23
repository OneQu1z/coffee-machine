package com.dmitrykochelyagin;
import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int water;
        int milk;
        int coffeeBeans;
        int cups;
        System.out.println("Write how many ml of water the coffee machine has:");
        water = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        coffeeBeans = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        cups = scanner.nextInt();

        int waterCups = water / 200;
        int milkCups = milk / 50;
        int coffeeCups = coffeeBeans / 15;
        int canCups = Math.min(waterCups, Math.min(milkCups, coffeeCups));

        if (canCups == cups) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (canCups < cups) {
            System.out.printf("No, I can make only %d cups of coffee\n", canCups);
        } else {
            System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)\n", canCups-cups);
        }

    }
}