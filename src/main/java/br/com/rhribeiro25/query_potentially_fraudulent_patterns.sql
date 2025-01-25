-- Fraud Detection Example: Identifying Potentially Fraudulent Patterns in Transactions

-- Problem:
-- We are given a set of transaction data, and we need to identify potentially fraudulent patterns.
-- Fraudulent patterns may include:
-- 1. Unusual transaction amounts (e.g., transactions above a threshold).
-- 2. Rapid consecutive transactions from the same user.
-- 3. Transactions made in geographically distant locations in a short time.
-- 4. Multiple transactions from different users with similar behaviors.

-- Example Data:
-- Assume we have a `transactions` table with the following columns:
-- transaction_id (int), user_id (int), amount (decimal), transaction_date (timestamp), location (varchar).

-- Create the `transactions` table (for demonstration purposes)
CREATE TABLE transactions (
    transaction_id INT PRIMARY KEY,
    user_id INT,
    amount DECIMAL(10, 2),
    transaction_date TIMESTAMP,
    location VARCHAR(100)
);

-- Example Data Insertion (for demonstration)
INSERT INTO transactions (transaction_id, user_id, amount, transaction_date, location) VALUES
(1, 101, 2000.00, '2025-01-01 10:00:00', 'New York'),
(2, 101, 500.00, '2025-01-01 10:30:00', 'New York'),
(3, 102, 12000.00, '2025-01-01 11:00:00', 'Los Angeles'),
(4, 103, 300.00, '2025-01-01 12:00:00', 'Chicago'),
(5, 101, 2500.00, '2025-01-01 13:00:00', 'New York'),
(6, 102, 8000.00, '2025-01-01 14:00:00', 'Los Angeles');

-- Fraud Detection Criteria:

-- 1. Identifying transactions above a high threshold (e.g., $10,000)
SELECT * FROM transactions WHERE amount > 10000;

-- 2. Identifying users who made rapid consecutive transactions (e.g., within 1 hour)
WITH UserTransactions AS (
    SELECT
        user_id,
        transaction_id,
        transaction_date,
        LAG(transaction_date) OVER (PARTITION BY user_id ORDER BY transaction_date) AS previous_transaction_date
    FROM transactions
)
SELECT
    user_id,
    transaction_id,
    transaction_date,
    previous_transaction_date
FROM UserTransactions
WHERE
    EXTRACT(EPOCH FROM (transaction_date - previous_transaction_date)) < 3600; -- Transactions within 1 hour

-- 3. Identifying transactions that are geographically distant in a short time
-- We assume a list of locations is available with associated latitudes and longitudes for each city.
-- Here, we'll check if two transactions occurred in different cities within a short timeframe.
WITH LocationChange AS (
    SELECT
        user_id,
        location,
        transaction_date,
        LAG(location) OVER (PARTITION BY user_id ORDER BY transaction_date) AS previous_location,
        LAG(transaction_date) OVER (PARTITION BY user_id ORDER BY transaction_date) AS previous_transaction_date
    FROM transactions
)
SELECT
    user_id,
    location,
    previous_location,
    transaction_date,
    previous_transaction_date
FROM LocationChange
WHERE
    previous_location IS NOT NULL AND
    previous_transaction_date IS NOT NULL AND
    EXTRACT(EPOCH FROM (transaction_date - previous_transaction_date)) < 3600; -- Same user, but different locations in less than 1 hour

-- 4. Identifying multiple transactions from different users with similar behavior (e.g., same amount)
SELECT
    user_id,
    amount,
    COUNT(*) AS similar_transactions
FROM transactions
GROUP BY user_id, amount
HAVING COUNT(*) > 1;

-- The queries above demonstrate some patterns commonly associated with fraudulent activity:
-- - High-value transactions
-- - Rapid consecutive transactions
-- - Transactions from geographically distant locations in short time
-- - Multiple transactions with similar amounts made by different users (which could indicate coordination)

-- Fraud Detection Strategy:
-- In a real-world scenario, machine learning models would be trained on historical transaction data
-- to identify complex fraud patterns. Features such as transaction amounts, frequency, user behavior,
-- geographic locations, and historical fraud patterns could be used to detect suspicious activities.

-- Performance Considerations:
-- - In large datasets, consider indexing the `user_id`, `transaction_date`, and `amount` columns for faster searches.
-- - Use partitioning to optimize queries on large tables, especially if working with time-series data.

-- Dropping a table (if needed)
-- DROP TABLE transactions;

-- Summary: Fraud detection involves identifying unusual patterns in transaction data. By analyzing the frequency,
-- amount, timing, and location of transactions, we can flag potentially fraudulent behavior. Machine learning models
-- are often used to build more sophisticated fraud detection systems, which can adapt and learn over time based on new data.

