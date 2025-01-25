package br.com.rhribeiro25;

import java.util.HashMap;
import java.util.Map;

public class RateLimiter {

    // Map to store the number of requests and timestamp for each user
    private Map<String, UserRequestInfo> userRequests;

    // Maximum number of allowed requests per time window (e.g., 5 requests per minute)
    private int maxRequestsPerWindow;

    // Time window in milliseconds (e.g., 60 seconds)
    private long timeWindowMillis;

    // Constructor to initialize the rate limiter
    public RateLimiter(int maxRequestsPerWindow, long timeWindowMillis) {
        this.maxRequestsPerWindow = maxRequestsPerWindow;
        this.timeWindowMillis = timeWindowMillis;
        this.userRequests = new HashMap<>();
    }

    // Method to check if a user is allowed to make a request
    public boolean allowRequest(String userId) {
        long currentTime = System.currentTimeMillis();

        // If the user does not exist, initialize the user's request data
        if (!userRequests.containsKey(userId)) {
            userRequests.put(userId, new UserRequestInfo(currentTime, 1));
            return true; // Allow the first request
        }

        // Retrieve the user's request info
        UserRequestInfo userRequestInfo = userRequests.get(userId);

        // If the current time exceeds the time window, reset the request count
        if (currentTime - userRequestInfo.timestamp > timeWindowMillis) {
            userRequestInfo.timestamp = currentTime; // Reset timestamp to current time
            userRequestInfo.requestCount = 1; // Reset request count to 1 for the new window
            return true; // Allow the request in the new window
        }

        // If the user has exceeded the max request count, deny the request
        if (userRequestInfo.requestCount >= maxRequestsPerWindow) {
            return false; // Deny the request
        }

        // Increment the request count and allow the request
        userRequestInfo.requestCount++;
        return true; // Allow the request
    }

    // Inner class to store the request count and timestamp for each user
    private static class UserRequestInfo {
        long timestamp;  // The timestamp of the last request
        int requestCount;  // The number of requests made within the current time window

        UserRequestInfo(long timestamp, int requestCount) {
            this.timestamp = timestamp;
            this.requestCount = requestCount;
        }
    }

    // Main method to demonstrate the rate limiter
    public static void main(String[] args) {
        // Create a RateLimiter that allows 5 requests per 60 seconds
        RateLimiter rateLimiter = new RateLimiter(5, 60000);

        String userId = "user123";

        // Simulate 10 requests from the user
        for (int i = 0; i < 10; i++) {
            if (rateLimiter.allowRequest(userId)) {
                System.out.println("Request " + (i + 1) + " allowed");
            } else {
                System.out.println("Request " + (i + 1) + " denied - Rate limit exceeded");
            }

            // Simulate 1 second passing between requests
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

/*
 * Problem Description: Rate Limiter
 *
 * The rate-limiting algorithm is designed to prevent excessive API usage by limiting the number of requests a user can make within a specific time frame.
 * This is essential to ensure fairness, prevent abuse, and protect the underlying system from overloads. In this problem, we will implement a fixed window rate limiter,
 * where users can make a set number of requests within a defined time window (e.g., 100 requests per minute). After the time window expires, the request count resets.
 *
 * Requirements:
 * - The system should support checking whether a user is allowed to make a request at any given time.
 * - The rate limiter should track the number of requests made by each user within the current time window.
 * - If a user exceeds the allowed number of requests, further requests should be denied until the time window resets.
 * - The time window should be reset after the specified duration (e.g., every 60 seconds).
 */
