package week7.labs;

import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface DiscountStrategy {
    double applyDiscount(double price, int quantity);
}

class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}

class DiscountEngine {
    public static double applyDiscounts(List<Product> products, DiscountStrategy strategy) {
        double total = 0;
        for (Product product : products) {
            total += strategy.applyDiscount(product.getPrice(), product.getQuantity()) * product.getQuantity();
        }
        return total;
    }
}

class ECommerceDiscountEngine {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Product 1", 100, 2),
                new Product("Product 2", 200, 3),
                new Product("Product 3", 300, 4),
                new Product("Product 4", 400, 5),
                new Product("Product 5", 500, 6)
        );

        DiscountStrategy percentageDiscount = (price, quantity) -> price * 0.90;
        DiscountStrategy fixedDiscount = (price, quantity) -> price - 5.0;
        DiscountStrategy bulkDiscount = (price, quantity) -> quantity > 5 ? price * 0.85 : price;

        System.out.println("Products:");
        for(Product product : products) {
            System.out.println(product.getName() + " - " + product.getPrice() + " - " + product.getQuantity());
        }
        System.out.println("Total with Percentage Discount: " + DiscountEngine.applyDiscounts(products, percentageDiscount));
        System.out.println("Total with Fixed Discount: " + DiscountEngine.applyDiscounts(products, fixedDiscount));
        System.out.println("Total with Bulk Discount: " + DiscountEngine.applyDiscounts(products, bulkDiscount));
    }
}
