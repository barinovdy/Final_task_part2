mysql> CREATE DATABASE Human_friends;
Query OK, 1 row affected (0,01 sec)

mysql> USE Human_friends;
Database changed

mysql> CREATE TABLE Pets (
    -> ID INT AUTO_INCREMENT PRIMARY KEY,
    -> Name VARCHAR(50),
    -> Type VARCHAR(20),
    -> BirthDate DATE,
    -> Commands TEXT
    -> );
Query OK, 0 rows affected (0,06 sec)

mysql> CREATE TABLE PackAnimals (
    -> ID INT AUTO_INCREMENT PRIMARY KEY,
    -> Name VARCHAR(50),
    -> Type VARCHAR(20),
    -> BirthDate DATE,
    -> Commands TEXT
    -> );
Query OK, 0 rows affected (0,04 sec)

mysql> INSERT INTO Pets (Name, Type, BirthDate, Commands) VALUES
    -> ('Fido', 'Dog', '2020-01-01', 'Sit, Stay, Fetch'),
    -> ('Whiskers', 'Cat', '2019-05-15', 'Sit, Pounce'),
    -> ('Hammy', 'Hamster', '2021-03-10', 'Roll, Hide'),
    -> ('Buddy', 'Dog', '2018-12-10', 'Sit, Paw, Bark'),
    -> ('Smudge', 'Cat', '2020-02-20', 'Sit, Pounce, Scratch'),
    -> ('Peanut', 'Hamster', '2021-08-01', 'Roll, Spin'),
    -> ('Bella', 'Dog', '2019-11-11', 'Sit, Stay, Roll'),
    -> ('Oliver', 'Cat', '2020-06-30', 'Meow, Scratch, Jump');
Query OK, 8 rows affected (0,02 sec)
Records: 8  Duplicates: 0  Warnings: 0

mysql> INSERT INTO PackAnimals (Name, Type, BirthDate, Commands) VALUES
    -> ('Thunder', 'Horse', '2015-07-21', 'Trot, Canter, Gallop'),
    -> ('Sandy', 'Camel', '2016-11-03', 'Walk, Carry Load'),
    -> ('Eeyore', 'Donkey', '2017-09-18', 'Walk, Carry Load, Bray'),
    -> ('Storm', 'Horse', '2014-05-05', 'Trot, Canter'),
    -> ('Dune', 'Camel', '2018-12-12', 'Walk, Sit'),
    -> ('Burro', 'Donkey', '2019-01-23', 'Walk, Bray, Kick'),
    -> ('Blaze', 'Horse', '2016-02-29', 'Trot, Jump, Gallop'),
    -> ('Sahara', 'Camel', '2015-08-14', 'Walk, Run');
Query OK, 8 rows affected (0,01 sec)
Records: 8  Duplicates: 0  Warnings: 0

mysql> SELECT * FROM Pets
    -> ;
+----+----------+---------+------------+----------------------+
| ID | Name     | Type    | BirthDate  | Commands             |
+----+----------+---------+------------+----------------------+
|  1 | Fido     | Dog     | 2020-01-01 | Sit, Stay, Fetch     |
|  2 | Whiskers | Cat     | 2019-05-15 | Sit, Pounce          |
|  3 | Hammy    | Hamster | 2021-03-10 | Roll, Hide           |
|  4 | Buddy    | Dog     | 2018-12-10 | Sit, Paw, Bark       |
|  5 | Smudge   | Cat     | 2020-02-20 | Sit, Pounce, Scratch |
|  6 | Peanut   | Hamster | 2021-08-01 | Roll, Spin           |
|  7 | Bella    | Dog     | 2019-11-11 | Sit, Stay, Roll      |
|  8 | Oliver   | Cat     | 2020-06-30 | Meow, Scratch, Jump  |
+----+----------+---------+------------+----------------------+
8 rows in set (0,00 sec)

mysql> SELECT * FROM PackAnimals;
+----+---------+--------+------------+------------------------+
| ID | Name    | Type   | BirthDate  | Commands               |
+----+---------+--------+------------+------------------------+
|  1 | Thunder | Horse  | 2015-07-21 | Trot, Canter, Gallop   |
|  2 | Sandy   | Camel  | 2016-11-03 | Walk, Carry Load       |
|  3 | Eeyore  | Donkey | 2017-09-18 | Walk, Carry Load, Bray |
|  4 | Storm   | Horse  | 2014-05-05 | Trot, Canter           |
|  5 | Dune    | Camel  | 2018-12-12 | Walk, Sit              |
|  6 | Burro   | Donkey | 2019-01-23 | Walk, Bray, Kick       |
|  7 | Blaze   | Horse  | 2016-02-29 | Trot, Jump, Gallop     |
|  8 | Sahara  | Camel  | 2015-08-14 | Walk, Run              |
+----+---------+--------+------------+------------------------+
8 rows in set (0,00 sec)

mysql> DELETE FROM PackAnimals WHERE Type = 'Camel';
Query OK, 3 rows affected (0,00 sec)

mysql> SELECT * FROM PackAnimals;
+----+---------+--------+------------+------------------------+
| ID | Name    | Type   | BirthDate  | Commands               |
+----+---------+--------+------------+------------------------+
|  1 | Thunder | Horse  | 2015-07-21 | Trot, Canter, Gallop   |
|  3 | Eeyore  | Donkey | 2017-09-18 | Walk, Carry Load, Bray |
|  4 | Storm   | Horse  | 2014-05-05 | Trot, Canter           |
|  6 | Burro   | Donkey | 2019-01-23 | Walk, Bray, Kick       |
|  7 | Blaze   | Horse  | 2016-02-29 | Trot, Jump, Gallop     |
+----+---------+--------+------------+------------------------+
5 rows in set (0,00 sec)

ysql> CREATE TABLE YoungPets AS 
    -> SELECT * FROM Pets 
    -> WHERE DATEDIFF(CURDATE(), BirthDate) BETWEEN 365 AND 1095;
Query OK, 0 rows affected (0,07 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> CREATE TABLE YoungPackAnimals AS 
    -> SELECT * FROM PackAnimals 
    -> WHERE DATEDIFF(CURDATE(), BirthDate) BETWEEN 365 AND 1095;
Query OK, 0 rows affected (0,08 sec)
Records: 0  Duplicates: 0  Warnings: 0

ysql> CREATE TABLE YoungAnimals AS
    -> SELECT * 
    -> FROM YoungPets
    -> UNION ALL
    -> SELECT *
    -> FROM YoungPackAnimals;
Query OK, 0 rows affected (0,07 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> DROP TABLE YoungPets;
Query OK, 0 rows affected (0,03 sec)

mysql> DROP TABLE YoungPackAnimals;
Query OK, 0 rows affected (0,03 sec)

mysql> ALTER TABLE YoungAnimals
    -> ADD Age INT Null;
Query OK, 0 rows affected (0,06 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> UPDATE YoungAnimals
    -> SET Age = DATEDIFF(CURDATE(), BirthDate)/30;
Query OK, 0 rows affected (0,00 sec)
Rows matched: 0  Changed: 0  Warnings: 0

mysql> CREATE TABLE Animals AS
    -> SELECT
    -> 'Pets' AS Category,
    -> ID,
    -> Name,
    -> Type,
    -> BirthDate,
    -> Commands
    -> FROM
    -> Pets
    -> UNION ALL
    -> SELECT
    -> 'PackAnimals' AS Category,
    -> ID,
    -> Name,
    -> Type,
    -> BirthDate,
    -> Commands
    -> FROM
    -> PackAnimals;
Query OK, 13 rows affected (0,07 sec)
Records: 13  Duplicates: 0  Warnings: 0

mysql> SELECT * FROM Animals;
+-------------+----+----------+---------+------------+------------------------+
| Category    | ID | Name     | Type    | BirthDate  | Commands               |
+-------------+----+----------+---------+------------+------------------------+
| Pets        |  1 | Fido     | Dog     | 2020-01-01 | Sit, Stay, Fetch       |
| Pets        |  2 | Whiskers | Cat     | 2019-05-15 | Sit, Pounce            |
| Pets        |  3 | Hammy    | Hamster | 2021-03-10 | Roll, Hide             |
| Pets        |  4 | Buddy    | Dog     | 2018-12-10 | Sit, Paw, Bark         |
| Pets        |  5 | Smudge   | Cat     | 2020-02-20 | Sit, Pounce, Scratch   |
| Pets        |  6 | Peanut   | Hamster | 2021-08-01 | Roll, Spin             |
| Pets        |  7 | Bella    | Dog     | 2019-11-11 | Sit, Stay, Roll        |
| Pets        |  8 | Oliver   | Cat     | 2020-06-30 | Meow, Scratch, Jump    |
| PackAnimals |  1 | Thunder  | Horse   | 2015-07-21 | Trot, Canter, Gallop   |
| PackAnimals |  3 | Eeyore   | Donkey  | 2017-09-18 | Walk, Carry Load, Bray |
| PackAnimals |  4 | Storm    | Horse   | 2014-05-05 | Trot, Canter           |
| PackAnimals |  6 | Burro    | Donkey  | 2019-01-23 | Walk, Bray, Kick       |
| PackAnimals |  7 | Blaze    | Horse   | 2016-02-29 | Trot, Jump, Gallop     |
+-------------+----+----------+---------+------------+------------------------+
13 rows in set (0,00 sec)