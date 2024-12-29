package week13.labs.task6;

import java.util.ArrayList;
import java.util.List;

interface CoffeeBuilder {
    void buildType();
    void buildSize();
    void buildToppings();
    Coffee getCoffee();
}

class Coffee {
    private String type;
    private String size;
    private List<String> toppings;

    public Coffee(String type, String size, List<String> toppings) {
        this.type = type;
        this.size = size;
        this.toppings = toppings;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "type='" + type + '\'' +
                ", size='" + size + '\'' +
                ", toppings=" + toppings +
                '}';
    }
}

class EspressoBuilder implements CoffeeBuilder {
    private String type;
    private String size;
    private List<String> toppings = new ArrayList<>();

    @Override
    public void buildType() {
        type = "Espresso";
    }

    @Override
    public void buildSize() {
        size = "Small";
    }

    @Override
    public void buildToppings() {
        toppings.add("None");
    }

    @Override
    public Coffee getCoffee() {
        return new Coffee(type, size, toppings);
    }
}

class LatteBuilder implements CoffeeBuilder {
    private String type;
    private String size;
    private List<String> toppings = new ArrayList<>();

    @Override
    public void buildType() {
        type = "Latte";
    }

    @Override
    public void buildSize() {
        size = "Medium";
    }

    @Override
    public void buildToppings() {
        toppings.add("Milk");
    }

    @Override
    public Coffee getCoffee() {
        return new Coffee(type, size, toppings);
    }
}

class CappuccinoBuilder implements CoffeeBuilder {
    private String type;
    private String size;
    private List<String> toppings = new ArrayList<>();

    @Override
    public void buildType() {
        type = "Cappuccino";
    }

    @Override
    public void buildSize() {
        size = "Large";
    }

    @Override
    public void buildToppings() {
        toppings.add("Foam");
    }

    @Override
    public Coffee getCoffee() {
        return new Coffee(type, size, toppings);
    }
}

class CoffeeDirector {
    public Coffee constructCoffee(CoffeeBuilder builder) {
        builder.buildType();
        builder.buildSize();
        builder.buildToppings();
        return builder.getCoffee();
    }
}

class Main {
    public static void main(String[] args) {
        CoffeeDirector director = new CoffeeDirector();

        CoffeeBuilder espressoBuilder = new EspressoBuilder();
        Coffee espresso = director.constructCoffee(espressoBuilder);
        System.out.println(espresso);

        CoffeeBuilder latteBuilder = new LatteBuilder();
        Coffee latte = director.constructCoffee(latteBuilder);
        System.out.println(latte);

        CoffeeBuilder cappuccinoBuilder = new CappuccinoBuilder();
        Coffee cappuccino = director.constructCoffee(cappuccinoBuilder);
        System.out.println(cappuccino);
    }
}

