package week7.labs;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Sale{
    private String productCategory;
    private double price;
    private LocalDate date;

    public Sale(String productCategory, double price, LocalDate date){
        this.productCategory = productCategory;
        this.price = price;
        this.date = date;
    }

    public String getProductCategory(){
        return productCategory;
    }

    public double getPrice(){
        return price;
    }

    public LocalDate getDate(){
        return date;
    }
}
public class SalesReport {
    public static void generateReport(List<Sale> sales) {
        double totalSales = sales.stream().mapToDouble(Sale::getPrice).sum();
        double averageSales = sales.stream().mapToDouble(Sale::getPrice).average().orElse(0);

        System.out.println("Full Report");
        System.out.println("Total Sales: " + totalSales);
        System.out.println("Average Sales: " + averageSales);
    }

    public static void generateReport(List <Sale> sales, String productCategory) {
        List<Sale> filteredSales = sales.stream()
                .filter(sale -> sale.getProductCategory().equals(productCategory)).collect(Collectors.toList());

        double totalSales = filteredSales.stream().mapToDouble(Sale::getPrice).sum();
        double averageSales = filteredSales.stream().mapToDouble(Sale::getPrice).average().orElse(0);

        System.out.println("Report for " + productCategory);
        System.out.println("Total Sales: " + totalSales);
        System.out.println("Average Sales: " + averageSales);
    }

    public static void generateReport(List <Sale> sales, LocalDate startDate, LocalDate endDate) {
        List<Sale> filteredSales = sales.stream()
                .filter(sale -> sale.getDate().isAfter(startDate) && sale.getDate().isBefore(endDate)).collect(Collectors.toList());

        double totalSales = filteredSales.stream().mapToDouble(Sale::getPrice).sum();
        double averageSales = filteredSales.stream().mapToDouble(Sale::getPrice).average().orElse(0);

        System.out.println("Report for " + startDate + " to " + endDate);
        System.out.println("Total Sales: " + totalSales);
        System.out.println("Average Sales: " + averageSales);
    }
}

class Main{
    public static void main(String[] args) {
        List<Sale> sales = Arrays.asList(
                new Sale("Electronics", 1000, LocalDate.of(2024, 1, 1)),
                new Sale("Electronics", 2000, LocalDate.of(2024, 1, 2)),
                new Sale("Electronics", 3000, LocalDate.of(2024, 1, 3)),
                new Sale("Clothing", 500, LocalDate.of(2024, 1, 1)),
                new Sale("Clothing", 1000, LocalDate.of(2024, 1, 2)),
                new Sale("Clothing", 1500, LocalDate.of(2024, 1, 3))
        );

        SalesReport.generateReport(sales);

        SalesReport.generateReport(sales, "Electronics");

        SalesReport.generateReport(sales, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 3));
    }
}
