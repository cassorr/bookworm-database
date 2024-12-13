INSERT INTO co203478.USER_FOLLOWS (Follower_ID, Followee_ID, Follow_Date)
VALUES
(1, 2, '2024-01-01'), -- Alice follows Bob
(1, 3, '2024-01-02'), -- Alice follows Charlie
(2, 1, '2024-01-01'), -- Bob follows Alice
(2, 4, '2024-01-02'), -- Bob follows Diana
(3, 5, '2024-01-01'), -- Charlie follows Ethan
(4, 1, '2024-01-01'), -- Diana follows Alice
(4, 5, '2024-01-03'), -- Diana follows Ethan
(5, 2, '2024-01-01'), -- Ethan follows Bob
(5, 3, '2024-01-02'), -- Ethan follows Charlie
(3, 4, '2024-01-04'); -- Charlie follows Diana
