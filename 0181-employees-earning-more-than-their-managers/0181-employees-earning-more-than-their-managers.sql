# Write your MySQL query statement below
SELECT
    employee.name as 'Employee'
FROM
    Employee AS employee,
    Employee AS manager
WHERE
    employee.managerId = manager.id
        AND employee.salary > manager.salary