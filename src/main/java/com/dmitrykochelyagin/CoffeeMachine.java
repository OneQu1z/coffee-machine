package com.dmitrykochelyagin;

public class CoffeeMachine {

    private int cleanCounter = 0;
    private int money = 550;
    private int water = 400;
    private int milk = 540;
    private int coffeeBeans = 120;
    private int cups = 9;

    public String buy(CoffeeType type) {
        if (!canMake(type)) {
            return getLackMessage(type);
        }

        water -= type.getWater();
        milk -= type.getMilk();
        coffeeBeans -= type.getBeans();
        money += type.getPrice();
        cups--;
        cleanCounter++;

        return "I have enough resources, making you a coffee!";
    }

    public void fill(int water, int milk, int beans, int cups) {
        this.water += water;
        this.milk += milk;
        this.coffeeBeans += beans;
        this.cups += cups;
    }

    public int takeMoney() {
        int result = money;
        money = 0;
        return result;
    }

    public void clean() {
        cleanCounter = 0;
    }

    public boolean needsCleaning() {
        return cleanCounter >= 10;
    }


    private boolean canMake(CoffeeType type) {
        return water >= type.getWater()
                && milk >= type.getMilk()
                && coffeeBeans >= type.getBeans()
                && cups >= 1;
    }

    private String getLackMessage(CoffeeType type) {
        if (water < type.getWater()) return "Sorry, not enough water!";
        if (milk < type.getMilk()) return "Sorry, not enough milk!";
        if (coffeeBeans < type.getBeans()) return "Sorry, not enough coffee beans!";
        if (cups < 1) return "Sorry, not enough cups!";
        return "";
    }


    public String getState() {
        return """
                The coffee machine has:
                %d ml of water
                %d ml of milk
                %d g of coffee beans
                %d disposable cups
                $%d of money
                """.formatted(water, milk, coffeeBeans, cups, money);
    }
}