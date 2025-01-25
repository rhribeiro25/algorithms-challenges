package br.com.rhribeiro25;

import java.util.HashMap;
import java.util.Map;

public class PaymentGateway {

    // Map to simulate a database of user accounts with their balances
    private Map<String, Double> userAccounts;

    // Constructor to initialize the payment gateway system
    public PaymentGateway() {
        userAccounts = new HashMap<>();

        // Adding some users with initial balances
        userAccounts.put("user1", 1000.0); // User 1 has $1000
        userAccounts.put("user2", 500.0);  // User 2 has $500
        userAccounts.put("user3", 300.0);  // User 3 has $300
    }

    // Method to process a payment from one user to another
    public boolean processPayment(String sender, String receiver, double amount) {
        // Check if both users exist and if the sender has enough balance
        if (!userAccounts.containsKey(sender)) {
            System.out.println("Sender account does not exist.");
            return false;
        }

        if (!userAccounts.containsKey(receiver)) {
            System.out.println("Receiver account does not exist.");
            return false;
        }

        if (userAccounts.get(sender) < amount) {
            System.out.println("Sender has insufficient funds.");
            return false;
        }

        // Deduct the amount from the sender's account
        userAccounts.put(sender, userAccounts.get(sender) - amount);

        // Add the amount to the receiver's account
        userAccounts.put(receiver, userAccounts.get(receiver) + amount);

        // Log the transaction (for simplicity, we just print it here)
        System.out.println("Payment of $" + amount + " processed from " + sender + " to " + receiver);
        return true;
    }

    // Method to verify the balance of a user
    public double getBalance(String user) {
        if (!userAccounts.containsKey(user)) {
            System.out.println("User account does not exist.");
            return -1;
        }
        return userAccounts.get(user);
    }

    // Main method to demonstrate the payment gateway
    public static void main(String[] args) {
        PaymentGateway paymentGateway = new PaymentGateway();

        // Process a payment from user1 to user2
        paymentGateway.processPayment("user1", "user2", 200.0);

        // Check balances after the transaction
        System.out.println("User1 balance: $" + paymentGateway.getBalance("user1"));
        System.out.println("User2 balance: $" + paymentGateway.getBalance("user2"));
    }
}

/*
 * Problem Description: Design a Payment Gateway
 *
 * The payment gateway is a system that securely processes and verifies transactions between users.
 * The system is responsible for verifying that the sender has sufficient funds, processing the payment,
 * updating the user balances, and ensuring security throughout the transaction process.
 *
 * Approach:
 * - The payment gateway should have a method for processing payments from one user to another.
 * - The system should verify that both the sender and receiver exist and that the sender has enough funds before proceeding with the transaction.
 * - After the payment is processed, the sender's balance should be decreased, and the receiver's balance should be increased by the payment amount.
 * - The system should also allow querying the balance of any user.
 *
 * Security Considerations:
 * - Ensure that payments are only processed if the sender has sufficient funds.
 * - Use encryption for sensitive data (in a real-world system, passwords and transaction data should be encrypted).
 * - Implement logging and transaction records for audit purposes.
 * - Implement fraud detection mechanisms, such as monitoring for unusual transaction patterns.
 *
 * Requirements:
 * - The system should be able to process transactions securely and efficiently.
 * - Transactions should only be allowed if both the sender and receiver exist and if the sender has enough funds.
 * - The system should update the user balances after each transaction and allow querying balances.
 *
 * Limitations:
 * - This is a simplified version of a payment gateway. In a real-world system, additional features such as multi-factor authentication, fraud detection, and encryption would be necessary.
 */
