package br.com.rhribeiro25;

import java.util.LinkedList;
import java.util.Queue;

class ProducerConsumer {

    // Shared buffer between producers and consumers
    private final Queue<Integer> queue;
    private final int MAX_SIZE;

    // Constructor to initialize the queue and its max size
    public ProducerConsumer(int maxSize) {
        this.queue = new LinkedList<>();
        this.MAX_SIZE = maxSize;
    }

    // Producer thread that adds items to the queue
    public synchronized void produce(int item) throws InterruptedException {
        // Wait if the queue is full
        while (queue.size() == MAX_SIZE) {
            wait();
        }
        queue.add(item); // Add item to the queue
        System.out.println("Produced: " + item);
        notifyAll(); // Notify consumers that an item is available
    }

    // Consumer thread that removes items from the queue
    public synchronized int consume() throws InterruptedException {
        // Wait if the queue is empty
        while (queue.isEmpty()) {
            wait();
        }
        int item = queue.poll(); // Remove item from the queue
        System.out.println("Consumed: " + item);
        notifyAll(); // Notify producers that space is available
        return item;
    }

    // Main method to test the Producer-Consumer scenario
    public static void main(String[] args) {
        int MAX_SIZE = 5; // Maximum size of the queue
        ProducerConsumer pc = new ProducerConsumer(MAX_SIZE);

        // Producer thread
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    pc.produce(i);
                    Thread.sleep(500); // Simulate some delay
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Consumer thread
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    pc.consume();
                    Thread.sleep(1000); // Simulate some delay
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}

/*
 * Problem Description: Producer-Consumer Problem
 *
 * The Producer-Consumer problem is a classic synchronization problem that involves two types of threads:
 * producers and consumers. The producer generates data and adds it to a shared buffer (queue), while the consumer
 * retrieves and processes the data from the buffer. The problem ensures that producers do not add data to the buffer
 * when it is full, and consumers do not consume data when the buffer is empty.
 *
 * Approach:
 * - The solution involves using a thread-safe queue to hold the data being passed between the producer and consumer.
 * - The producer will wait if the queue is full (i.e., cannot add more items) and the consumer will wait if the queue is empty.
 * - Synchronized blocks are used to ensure mutual exclusion and to prevent race conditions.
 * - The `notifyAll` method is used to notify all waiting threads (producers or consumers) whenever a change in state occurs.
 *
 * Requirements:
 * - The producer should only be able to produce if the queue is not full, and the consumer should only be able to consume if the queue is not empty.
 * - Both the producer and consumer should be able to run concurrently, without any issues of data corruption or inconsistent states.
 *
 * Constraints:
 * - The queue has a fixed maximum size (MAX_SIZE) which is shared between producers and consumers.
 * - Multiple producer and consumer threads can be created and managed efficiently.
 *
 * Time Complexity:
 * - The time complexity of both `produce` and `consume` methods is O(1), as they perform constant-time operations (adding and removing elements from the queue).
 *
 * Space Complexity:
 * - The space complexity is O(N), where N is the maximum size of the queue, as it stores the items produced by the producers.
 */
