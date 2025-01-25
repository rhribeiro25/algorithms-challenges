package br.com.rhribeiro25;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Currency Conversion: A program to calculate exchange rates between currencies.
 *
 * Problem Description:
 * Given a set of currencies and their exchange rates, we need to calculate the conversion
 * from one currency to another. The program should allow the user to input the amount to convert,
 * the source currency, and the target currency, and then it should output the converted amount.
 *
 * Approach:
 * - We define exchange rates as a map, where each key is a currency code (e.g., USD, EUR, GBP)
 *   and the value is the exchange rate relative to a base currency (e.g., USD).
 * - The program will take the amount, source currency, and target currency as input.
 * - It will then calculate the converted amount by dividing the source currency's amount by the
 *   exchange rate for the source currency and multiplying by the exchange rate for the target currency.
 *
 * Example:
 * - Convert 100 USD to EUR when 1 USD = 0.85 EUR.
 * - Input: Amount = 100, Source Currency = USD, Target Currency = EUR
 * - Output: 85.0 EUR
 *
 * Note: This implementation uses a simple in-memory map for exchange rates. In a real-world
 * scenario, exchange rates would be fetched from a real-time API such as those provided by financial
 * institutions or currency conversion services.
 */

public class CurrencyConverter {

    // A map to hold the exchange rates relative to USD
    private static final Map<String, Double> exchangeRates = new HashMap<>();

    static {
        // Populating the exchange rates (values relative to USD)
        exchangeRates.put("USD", 1.0); // Base currency is USD
        exchangeRates.put("EUR", 0.85); // 1 USD = 0.85 EUR
        exchangeRates.put("GBP", 0.75); // 1 USD = 0.75 GBP
        exchangeRates.put("JPY", 110.0); // 1 USD = 110 JPY
        exchangeRates.put("AUD", 1.35); // 1 USD = 1.35 AUD
        // Additional currencies can be added as needed
    }

    // Method to perform the currency conversion
    public static double convertCurrency(double amount, String fromCurrency, String toCurrency) {
        // Check if the currencies are valid
        if (!exchangeRates.containsKey(fromCurrency) || !exchangeRates.containsKey(toCurrency)) {
            throw new IllegalArgumentException("Invalid currency code.");
        }

        // Get the exchange rate for the source and target currencies
        double fromRate = exchangeRates.get(fromCurrency);
        double toRate = exchangeRates.get(toCurrency);

        // Convert the amount to the base currency (USD), then to the target currency
        return (amount / fromRate) * toRate;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: amount, source currency, and target currency
        System.out.print("Enter the amount to convert: ");
        double amount = scanner.nextDouble();

        System.out.print("Enter the source currency (e.g., USD, EUR, GBP): ");
        String fromCurrency = scanner.next().toUpperCase();

        System.out.print("Enter the target currency (e.g., USD, EUR, GBP): ");
        String toCurrency = scanner.next().toUpperCase();

        // Perform the conversion
        try {
            double convertedAmount = convertCurrency(amount, fromCurrency, toCurrency);
            System.out.printf("%.2f %s = %.2f %s%n", amount, fromCurrency, convertedAmount, toCurrency);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}

/**
 * Explanation of the program:
 * 1. **Data Representation**:
 *    - The exchange rates are stored in a `HashMap`, with each currency code as the key and its
 *      corresponding exchange rate (relative to USD) as the value.
 *    - The supported currencies include USD, EUR, GBP, JPY, and AUD.
 * 2. **convertCurrency Method**:
 *    - This method takes the amount, the source currency, and the target currency as input.
 *    - It looks up the exchange rates for both the source and target currencies, and performs
 *      the conversion by first converting the amount into the base currency (USD), and then into the target currency.
 * 3. **Main Method**:
 *    - The main method allows the user to input the amount to convert, as well as the source and target currencies.
 *    - It calls the `convertCurrency` method to compute the converted amount and displays the result.
 * 4. **Error Handling**:
 *    - If the user enters an invalid currency code, the program throws an `IllegalArgumentException`
 *      and informs the user about the invalid input.
 * 5. **Possible Extensions**:
 *    - The program currently uses hardcoded exchange rates. In a real-world application, exchange rates
 *      would be fetched from a live API to ensure they are up-to-date.
 *    - Additional currencies could be added to the `exchangeRates` map.
 *    - The program could be extended to support more complex features, such as multiple base currencies
 *      or real-time conversion rates from an API.
 */
