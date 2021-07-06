package functionalInterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {
        Customer customer = new Customer("Prince","51421558");

        // Regular way
        greetCustomer(customer);

        // Consumer and BiConsumer way
        greetCustomerConsumerV1.accept(customer);
        greetCustomerConsumerV2.accept(customer, false);
    }

    static class Customer{
        private final String customerName;
        private final String customerPhoneNumber;

        public Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "customerName='" + customerName + '\'' +
                    ", customerPhoneNumber='" + customerPhoneNumber + '\'' +
                    '}';
        }
    }

    //Regular way
    static void greetCustomer(Customer Customer){
        System.out.println(" Hi " + Customer.customerName + " Your phone number is " + Customer.customerPhoneNumber);
    }

    //Consumer and BiConsumer way

    static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 = (customer, showPhone) ->
            System.out.println(" Hi " + customer.customerName + " Your phone number is " +
                    (showPhone ? customer.customerPhoneNumber : "********"));

    static Consumer<Customer> greetCustomerConsumerV1 = customer ->
            System.out.println(" Hi " + customer.customerName + " Your phone number is " + customer.customerPhoneNumber);
}