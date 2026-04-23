package com.dmitrykochelyagin;
import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int water = 200;
        int milk = 50;
        int coffeeBeans = 15;
        System.out.println("Write how many cups of coffee you will need:");
        int cups = scanner.nextInt();
        System.out.printf("For %d cups of coffee you will need:\n", cups);
        System.out.printf("%d ml of water\n", cups*water);
        System.out.printf("%d ml of milk\n", cups*milk);
        System.out.printf("%d g of coffee beans\n", cups*coffeeBeans);
    }
}