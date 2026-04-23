package com.dmitrykochelyagin;
import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Machine machine = new Machine();
        Scanner scanner = new Scanner(System.in);
        currentState(machine);
        System.out.println();
        System.out.println("Write action (buy, fill, take):");
        switch(scanner.nextLine()) {
            case("buy"):
                buyCoffee(scanner, machine);
                break;
            case("fill"):
                fillCoffeeMachine(scanner, machine);
                break;
            case("take"):
                takeMoney(machine);
                break;
        }
        currentState(machine);
    }

    public static void buyCoffee(Scanner scanner, Machine machine) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        int choice = scanner.nextInt();
        switch(choice) {
            case(1):
                if (machine.water < 250) {
                    System.out.println("Sorry, not enough water!");
                    return;
                }
                if (machine.coffeeBeans < 16) {
                    System.out.println("Sorry, not enough coffee beans!");
                    return;
                }
                if (machine.disposableCups < 1) {
                    System.out.println("Sorry, not enough disposable cups!");
                    return;
                }
                System.out.println("I have enough resources, making you a coffee!");
                machine.water -= 250;
                machine.coffeeBeans -= 16;
                machine.money += 4;
                machine.disposableCups--;
                break;
            case(2):
                if (machine.water < 350) {
                    System.out.println("Sorry, not enough water!");
                    return;
                }
                if (machine.milk < 75) {
                    System.out.println("Sorry, not enough milk!");
                    return;
                }
                if (machine.coffeeBeans < 20) {
                    System.out.println("Sorry, not enough coffee beans!");
                    return;
                }
                if (machine.disposableCups < 1) {
                    System.out.println("Sorry, not enough disposable cups!");
                    return;
                }
                System.out.println("I have enough resources, making you a coffee!");
                machine.water -= 350;
                machine.milk -= 75;
                machine.coffeeBeans -= 20;
                machine.money += 7;
                machine.disposableCups--;
                break;
            case(3):
                if (machine.water < 200) {
                    System.out.println("Sorry, not enough water!");
                    return;
                }
                if (machine.milk < 100) {
                    System.out.println("Sorry, not enough milk!");
                    return;
                }
                if (machine.coffeeBeans < 12) {
                    System.out.println("Sorry, not enough coffee beans!");
                    return;
                }
                if (machine.disposableCups < 1) {
                    System.out.println("Sorry, not enough disposable cups!");
                    return;
                }
                System.out.println("I have enough resources, making you a coffee!");
                machine.water -= 200;
                machine.milk -= 100;
                machine.coffeeBeans -= 12;
                machine.money += 6;
                machine.disposableCups--;
                break;
        }
    }

    public static void fillCoffeeMachine(Scanner scanner, Machine machine) {
        System.out.println("Write how many ml of water you want to add:");
        machine.water += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        machine.milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        machine.coffeeBeans += scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add:");
        machine.disposableCups += scanner.nextInt();
    }

    public static void takeMoney(Machine machine) {
        System.out.println("I gave you $" + machine.money);
        machine.money = 0;
    }

    public static void currentState(Machine machine) {
        System.out.println("The coffee machine has:");
        System.out.println(machine.water + " ml of water");
        System.out.println(machine.milk + " ml of milk");
        System.out.println(machine.coffeeBeans + " g of coffee beans");
        System.out.println(machine.disposableCups + " disposable cups");
        System.out.println("$" + machine.money + " of money");
    }
}

