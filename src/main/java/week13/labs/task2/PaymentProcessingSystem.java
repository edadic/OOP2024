package week13.labs.task2;

interface Payment{
    void processPayment();
}

interface PaymentFactory {
    Payment createPayment();
}

class CreditCardPayment implements Payment {
    @Override
    public void processPayment() {
        System.out.println("Processing credit card payment...");
        System.out.println("Credit card payment processed successfully!");
    }
}

class PayPalPayment implements Payment {
    @Override
    public void processPayment() {
        System.out.println("Processing PayPal payment...");
        System.out.println("PayPal payment processed successfully!");
    }
}

class CreditCardPaymentFactory implements PaymentFactory {
    @Override
    public Payment createPayment() {
        return new CreditCardPayment();
    }
}

class PayPalPaymentFactory implements PaymentFactory {
    @Override
    public Payment createPayment() {
        return new PayPalPayment();
    }
}
public class PaymentProcessingSystem {
    public static void main(String[] args) {
        PaymentFactory creditCardFactory = new CreditCardPaymentFactory();
        Payment creditCardPayment = creditCardFactory.createPayment();
        creditCardPayment.processPayment();

        PaymentFactory payPalFactory = new PayPalPaymentFactory();
        Payment payPalPayment = payPalFactory.createPayment();
        payPalPayment.processPayment();
    }

}
