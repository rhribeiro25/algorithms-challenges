-- Index Utilization Example: How indexing improves query performance

-- Example Table: `employees`
-- Assume we have an `employees` table with the following columns:
-- employee_id (int), first_name (varchar), last_name (varchar), department_id (int), salary (decimal)

-- Creating the `employees` table (for demonstration purposes)
CREATE TABLE employees (
    employee_id INT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    department_id INT,
    salary DECIMAL(10, 2)
);

-- Example Data Insertion
INSERT INTO employees (employee_id, first_name, last_name, department_id, salary) VALUES
(1, 'John', 'Doe', 101, 55000),
(2, 'Jane', 'Smith', 102, 60000),
(3, 'Michael', 'Brown', 101, 45000),
(4, 'Alice', 'Johnson', 103, 70000),
(5, 'David', 'White', 102, 50000);

-- Example 1: Query without an index
-- A query that searches for employees by department_id without using an index
SELECT * FROM employees WHERE department_id = 101;

-- This query will have to scan the entire `employees` table to find the matching rows.
-- This is called a "full table scan," and it can be slow for large tables because every row in the table must be checked.

-- Example 2: Create an index on department_id column
CREATE INDEX idx_department_id ON employees(department_id);

-- Example 3: Query with an index
-- Now, let's run the same query, but with the index on the `department_id` column
SELECT * FROM employees WHERE department_id = 101;

-- With the index in place, the database will use the index to quickly locate the rows with department_id = 101.
-- This significantly reduces the number of rows the database needs to scan, improving the query performance.

-- Example 4: Query with a composite index
CREATE INDEX idx_department_salary ON employees(department_id, salary);

-- Example 5: Query with a composite index
-- Now, a query filtering by both department_id and salary can benefit from the composite index
SELECT * FROM employees WHERE department_id = 101 AND salary > 50000;

-- The composite index `idx_department_salary` allows the database to quickly find the rows where both conditions are true,
-- improving performance by reducing the number of rows scanned.

-- Example 6: Query with an index on the salary column (if necessary)
CREATE INDEX idx_salary ON employees(salary);

-- Query filtering by salary without department_id will now also benefit from the index
SELECT * FROM employees WHERE salary > 60000;

-- This index allows the database to perform a more efficient search for employees with salaries above 60000, avoiding a full table scan.

-- Example 7: Query with a range condition
SELECT * FROM employees WHERE salary BETWEEN 50000 AND 70000;

-- If an index exists on the `salary` column, the query will use the index to find the rows within the specified range more efficiently.

-- Indexing improves query performance by allowing the database to quickly locate specific rows using the index instead of scanning the entire table.

-- Indexes can be created on one or more columns. A **composite index** (like `idx_department_salary`) improves performance for queries
-- that filter on multiple columns.
-- However, it's important to note that while indexes improve **read query performance**, they can degrade performance for **write operations**
-- (INSERT, UPDATE, DELETE) because the index needs to be updated whenever data is modified.

-- Performance Considerations:
-- - Indexes are useful when querying large datasets, especially for search queries, joins, and range queries.
-- - When choosing which columns to index, consider columns that are frequently used in WHERE clauses, JOIN conditions, or ORDER BY clauses.
-- - Having too many indexes can slow down write operations (INSERT, UPDATE, DELETE) since the index needs to be updated whenever the table data changes.

-- Dropping an Index:
-- If an index is no longer needed, it can be dropped to improve performance on write operations
DROP INDEX idx_department_id;
DROP INDEX idx_department_salary;
DROP INDEX idx_salary;

-- Summary: Index utilization in SQL is an essential optimization technique that enhances query performance,
-- particularly in large tables. Indexes allow the database engine to quickly locate the rows that match query conditions, reducing
-- the time it takes to execute queries. However, indexing comes with trade-offs, and indexes should be used thoughtfully to balance
-- query performance with write performance.

