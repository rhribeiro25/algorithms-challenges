package br.com.rhribeiro25;

import java.util.HashMap;
import java.util.Map;

public class URLShortener {

    // Base URL for the shortened URLs
    private static final String BASE_URL = "http://short.ly/";

    // Map to store the mapping of long URLs to short URLs
    private Map<String, String> urlMap;

    // Constructor to initialize the URLShortener
    public URLShortener() {
        urlMap = new HashMap<>();
    }

    // Method to generate a short URL for a given long URL
    public String shortenURL(String longURL) {
        // Generate a unique short URL (simple hash-based approach for demonstration)
        String shortURL = BASE_URL + Long.toHexString(longURL.hashCode());

        // Store the mapping in the map
        urlMap.put(shortURL, longURL);

        return shortURL;
    }

    // Method to retrieve the original long URL from the short URL
    public String getOriginalURL(String shortURL) {
        // Lookup the long URL from the map
        return urlMap.getOrDefault(shortURL, null);
    }

    // Main method to demonstrate the URL shortener
    public static void main(String[] args) {
        URLShortener urlShortener = new URLShortener();

        // Example long URL
        String longURL = "https://www.example.com/this-is-a-very-long-url";

        // Generate a short URL
        String shortURL = urlShortener.shortenURL(longURL);
        System.out.println("Short URL: " + shortURL);

        // Retrieve the original URL using the short URL
        String retrievedURL = urlShortener.getOriginalURL(shortURL);
        System.out.println("Original URL: " + retrievedURL);
    }
}

/*
 * Problem Description: URL Shortener
 *
 * A URL shortener is a system designed to take a long URL and generate a short, unique URL that redirects to the original URL. The goal is to create a scalable
 * system that can handle billions of URL shortening requests and map them back to the original URLs when requested.
 *
 * Approach:
 * - Generate short URLs by encoding long URLs into a fixed-length string that uniquely represents the long URL.
 * - The short URL should be small, typically containing a base URL (e.g., "http://short.ly/") followed by a short alphanumeric code.
 * - Store the mapping between the short URL and the long URL in a database or a key-value store for quick retrieval.
 * - Ensure the system can scale to handle a massive number of requests, potentially billions, while maintaining high availability and performance.
 *
 * Simplified Implementation:
 * - In this simplified example, a hash-based approach is used to generate the short URL. The hash code of the long URL is used to create a short URL.
 * - A map (HashMap) stores the mapping of short URLs to long URLs.
 *
 * Requirements:
 * - The system should generate short URLs that are unique for every long URL.
 * - The system should handle redirection by mapping the short URL back to the original long URL.
 * - The system should be scalable to handle billions of requests.
 *
 * Limitations:
 * - This is a simplified approach and does not include features like collision handling, persistence, or distributed systems.
 */
