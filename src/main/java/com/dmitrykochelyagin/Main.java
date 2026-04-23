package com.dmitrykochelyagin;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWrite action (buy, fill, take, clean, remaining, exit):");
            String action = scanner.nextLine();

            switch (action) {
                case "buy":
                    if (machine.needsCleaning()) {
                        System.out.println("I need cleaning!");
                        break;
                    }

                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back:");
                    String choice = scanner.nextLine();

                    CoffeeType type = CoffeeType.fromChoice(choice);
                    if (type == null) break;

                    String result = machine.buy(type);
                    System.out.println(result);
                    break;

                case "fill":
                    System.out.println("Write how many ml of water:");
                    int water = scanner.nextInt();

                    System.out.println("Write how many ml of milk:");
                    int milk = scanner.nextInt();

                    System.out.println("Write how many grams of beans:");
                    int beans = scanner.nextInt();

                    System.out.println("Write how many cups:");
                    int cups = scanner.nextInt();
                    scanner.nextLine();

                    machine.fill(water, milk, beans, cups);
                    break;

                case "take":
                    int money = machine.takeMoney();
                    System.out.println("I gave you $" + money);
                    break;

                case "clean":
                    machine.clean();
                    System.out.println("I have been cleaned!");
                    break;

                case "remaining":
                    System.out.println(machine.getState());
                    break;

                case "exit":
                    return;
            }
        }
    }
}