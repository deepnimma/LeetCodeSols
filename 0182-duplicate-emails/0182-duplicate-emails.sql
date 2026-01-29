# Write your MySQL query statement below
Select Email from
(
    SELECT email, COUNT(email) as num
    FROM Person
    GROUP BY email
) as stat
where num > 1;