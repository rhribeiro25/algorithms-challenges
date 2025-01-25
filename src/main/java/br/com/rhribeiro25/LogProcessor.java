package br.com.rhribeiro25;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class LogProcessor {

    // Method to process a log file and find the most frequent error message
    public String findMostFrequentError(String filePath) throws IOException {
        // Map to store error message counts
        Map<String, Integer> errorCounts = new HashMap<>();

        // Open the log file
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Read each line of the file
            while ((line = br.readLine()) != null) {
                // Check if the line contains an error message (assuming "ERROR" is part of the message)
                if (line.contains("ERROR")) {
                    // Extract the error message (assuming the error message is the rest of the line after "ERROR:")
                    String errorMessage = line.substring(line.indexOf("ERROR:") + 7).trim();

                    // Count the occurrences of each error message
                    errorCounts.put(errorMessage, errorCounts.getOrDefault(errorMessage, 0) + 1);
                }
            }
        }

        // Find the most frequent error message
        String mostFrequentError = null;
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : errorCounts.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFrequentError = entry.getKey();
            }
        }

        return mostFrequentError;
    }

    // Main method to demonstrate the log processing
    public static void main(String[] args) {
        LogProcessor logProcessor = new LogProcessor();

        try {
            // Provide the path to the log file
            String logFilePath = "path/to/logfile.log";

            // Find and print the most frequent error message
            String mostFrequentError = logProcessor.findMostFrequentError(logFilePath);
            System.out.println("Most frequent error: " + mostFrequentError);
        } catch (IOException e) {
            System.err.println("An error occurred while processing the log file: " + e.getMessage());
        }
    }
}

/*
 * Problem Description: Processing Logs
 *
 * In this problem, we are tasked with parsing a large log file to identify the most frequent error message.
 * Logs typically contain various types of messages, and our goal is to extract the error messages and count their occurrences.
 * We need to process the log file line by line and find the error message that appears the most frequently.
 *
 * Approach:
 * - Read the log file line by line.
 * - Identify lines that contain error messages (e.g., lines containing "ERROR").
 * - Extract the error message from each line and store it in a map with its count.
 * - After reading the entire file, determine which error message has the highest count.
 *
 * The system assumes that error messages are labeled with "ERROR:" in the log file.
 *
 * Requirements:
 * - Efficiently handle large log files (memory and time-efficient).
 * - Count the occurrences of each error message.
 * - Output the most frequent error message in the log file.
 */
