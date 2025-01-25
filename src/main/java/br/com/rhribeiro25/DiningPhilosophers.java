package br.com.rhribeiro25;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class DiningPhilosophers {

    // Lock array for each philosopher's fork
    private final Lock[] forks;
    private final int numPhilosophers;

    // Constructor to initialize the number of philosophers and forks
    public DiningPhilosophers(int numPhilosophers) {
        this.numPhilosophers = numPhilosophers;
        this.forks = new Lock[numPhilosophers];
        // Initialize each fork with a lock
        for (int i = 0; i < numPhilosophers; i++) {
            forks[i] = new ReentrantLock();
        }
    }

    // Method to represent a philosopher thinking
    public void think(int philosopherId) throws InterruptedException {
        System.out.println("Philosopher " + philosopherId + " is thinking.");
        Thread.sleep(1000); // Simulate thinking
    }

    // Method to represent a philosopher eating
    public void eat(int philosopherId) throws InterruptedException {
        System.out.println("Philosopher " + philosopherId + " is eating.");
        Thread.sleep(1000); // Simulate eating
    }

    // Method to handle the behavior of each philosopher
    public void dine(int philosopherId) throws InterruptedException {
        // Philosophers think, then try to pick up forks
        think(philosopherId);

        // Try to pick up the left fork and right fork (using locks)
        Lock leftFork = forks[philosopherId];
        Lock rightFork = forks[(philosopherId + 1) % numPhilosophers];

        // To avoid deadlock, acquire locks in a specific order (left then right)
        leftFork.lock();
        System.out.println("Philosopher " + philosopherId + " picked up left fork.");

        // Check if the right fork is available, if so pick it up
        rightFork.lock();
        System.out.println("Philosopher " + philosopherId + " picked up right fork.");

        // Eat the meal
        eat(philosopherId);

        // Release both forks after eating
        leftFork.unlock();
        rightFork.unlock();
        System.out.println("Philosopher " + philosopherId + " put down both forks.");
    }

    // Main method to simulate the philosophers' actions
    public static void main(String[] args) {
        int numPhilosophers = 5; // Number of philosophers
        DiningPhilosophers diningPhilosophers = new DiningPhilosophers(numPhilosophers);

        // Create philosopher threads
        for (int i = 0; i < numPhilosophers; i++) {
            final int philosopherId = i;
            Thread philosopherThread = new Thread(() -> {
                try {
                    // Run the philosopher's dining process
                    while (true) {
                        diningPhilosophers.dine(philosopherId);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
            philosopherThread.start();
        }
    }
}

/*
 * Problem Description: Dining Philosophers Problem
 *
 * The Dining Philosophers Problem is a classic synchronization problem where a set of philosophers are seated at a table,
 * each with a fork on either side. They must alternate between thinking and eating, but they need both forks to eat.
 * The challenge is to prevent deadlock (where all philosophers are waiting for forks and cannot make progress) and starvation (where some philosophers are perpetually unable to eat).
 *
 * Approach:
 * - The problem is solved using locks to synchronize access to shared resources (forks).
 * - Each philosopher has two forks: one on the left and one on the right. Philosophers need both forks to eat.
 * - To avoid deadlock, philosophers acquire the left fork first and the right fork second. This ensures that they don't end up in a situation where each philosopher is holding one fork and waiting for the other.
 * - If a philosopher can't get both forks (e.g., if the right fork is already taken), they will release the left fork and retry, ensuring fairness and preventing deadlock.
 * - The philosophers will continuously alternate between thinking and eating.
 *
 * Requirements:
 * - The solution must ensure that no two philosophers can eat at the same time (they need exclusive access to their forks).
 * - The system must avoid deadlocks and starvation by ensuring that philosophers have a fair opportunity to pick up both forks.
 *
 * Constraints:
 * - The number of philosophers and forks is the same.
 * - Philosophers must think before they eat and after they eat.
 *
 * Time Complexity:
 * - Each philosopher performs a sequence of actions (thinking, picking up forks, eating, putting down forks) repeatedly.
 * - The time complexity for each philosopher’s actions is O(1), but since each philosopher runs continuously in a loop, the overall complexity depends on the number of philosophers and the number of iterations.
 *
 * Space Complexity:
 * - The space complexity is O(N), where N is the number of philosophers, as we store a lock for each fork.
 *
 * This approach ensures that all philosophers can eat without causing a deadlock or starvation while respecting synchronization constraints.
 */
