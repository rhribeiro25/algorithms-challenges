-- Problem: Find users who made the highest number of transactions in a specific month.

-- Assumptions:
-- We have two tables:
-- 1. `users` table: Contains user information (user_id, user_name, etc.)
-- 2. `transactions` table: Contains transaction records (transaction_id, user_id, transaction_date)

-- The goal is to identify the user(s) who performed the highest number of transactions in a given month.

-- SQL Query to solve the problem:

WITH MonthlyTransactions AS (
    -- Step 1: Extract transactions for the given month
    SELECT
        user_id,
        COUNT(*) AS transaction_count
    FROM
        transactions
    WHERE
        transaction_date BETWEEN '2025-01-01' AND '2025-01-31'  -- Specify the date range for the month (e.g., January 2025)
    GROUP BY
        user_id
),
MaxTransactions AS (
    -- Step 2: Find the maximum transaction count in the specified month
    SELECT
        MAX(transaction_count) AS max_transaction_count
    FROM
        MonthlyTransactions
)
-- Step 3: Find the users with the highest transaction count
SELECT
    u.user_id,
    u.user_name,
    mt.transaction_count
FROM
    MonthlyTransactions mt
JOIN
    users u ON u.user_id = mt.user_id
JOIN
    MaxTransactions mt_max ON mt.transaction_count = mt_max.max_transaction_count
ORDER BY
    mt.transaction_count DESC;

/*
 * Problem Description: SQL Query Optimization to Find Users with the Highest Number of Transactions
 *
 * In this problem, we are tasked with writing an optimized SQL query to identify the users who have made
 * the highest number of transactions within a given month.
 *
 * Approach:
 * - First, we extract all transactions that occurred within the specified month from the `transactions` table.
 * - Next, we count the number of transactions each user made in that month, using `COUNT(*)` and grouping by `user_id`.
 * - Afterward, we identify the highest transaction count by selecting the maximum value of `transaction_count` from the result.
 * - Finally, we join the `users` table with the transaction counts and return the users who match the maximum count of transactions.
 *
 * Key Elements:
 * - **`WITH` clause**: We use the `WITH` clause (Common Table Expressions or CTEs) to structure the query into logical steps, improving readability and performance.
 * - **Date Filtering**: We filter the transactions to only include those that occurred within the specified month using `BETWEEN`.
 * - **`COUNT(*)`**: This function is used to count the number of transactions for each user.
 * - **Join Operations**: We use `JOIN` to combine data from the `users`, `transactions`, and the intermediate results (CTEs) to return the final list of users with the highest transaction counts.
 *
 * Requirements:
 * - The query should efficiently handle a large number of transaction records and return only the users with the maximum number of transactions.
 * - The database tables must be properly indexed for performance optimization (index on `user_id`, `transaction_date`).
 *
 * Constraints:
 * - This solution assumes that the `transactions` table contains a `transaction_date` field, which is of a suitable date type.
 * - The `user_id` in the `transactions` table corresponds to `user_id` in the `users` table.
 *
 * Performance Considerations:
 * - Using the `WITH` clause helps to break the query into digestible parts and avoid repetitive calculations.
 * - By filtering transactions to a specific month first, we reduce the number of records being processed, improving performance.
 * - `COUNT(*)` is an efficient way to count rows, but indexes on `user_id` and `transaction_date` will be crucial for performance in large datasets.
 *
 * Time Complexity:
 * - The time complexity of this query is O(N), where N is the number of transactions in the specified month, since we are aggregating over all transactions and performing a few additional operations like joins and comparisons.
 *
 * Space Complexity:
 * - The space complexity is O(M), where M is the number of distinct users who made transactions in the specified month. This is the space used by the `MonthlyTransactions` CTE and any intermediate results.
 */
