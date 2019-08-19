CREATE TABLE employee (
  id        INT(11) PRIMARY KEY,
  name      VARCHAR(32),
  Salary    DECIMAL(12),
  ManagerId INT(11)
);

INSERT INTO employee
VALUES (1, 'Joe', 70000, 3), (2, 'Henry', 80000, 4), (3, 'Sam', 60000, NULL), (4, 'max', 90000, NULL);


CREATE TABLE World (
  name       VARCHAR(32) PRIMARY KEY,
  continent  VARCHAR(32),
  area       INT(12),
  population INT(11),
  gdp        INT(11)
);

INSERT INTO World
VALUES ('Afghanistan', 'Asia', 652230, 25500100, 20343000),
  ('Albania', 'Europe', 28748, 2831741, 12960000),
  ('Algeria', 'Africa', 2381741, 37100000, 188681000),
  ('Andorra', 'Europe', 468, 78115, 3712000),
  ('Angola', 'Africa', 1246700, 20609294, 100990000);


CREATE TABLE Person (
  Id    INT(1) PRIMARY KEY,
  Email VARCHAR(7)
);
INSERT INTO Person VALUES (1, "a@b.com"), (2, "c@d.com"), (3, "a@b.com");


CREATE TABLE Weather (
  Id          INT(1) PRIMARY KEY,
  RecordDate  DATE,
  Temperature INT(2)
);
INSERT INTO Weather VALUES (1, "2015-01-01", 10), (2, "2015-01-02", 25), (3, "2015-01-03", 20), (4, "2015-01-04", 30);

CREATE TABLE courses (
  student VARCHAR(1) PRIMARY KEY,
  class   VARCHAR(8)
);
INSERT INTO courses
VALUES ("A", "Math"), ("B", "English"), ("C", "Math"), ("D", "Biology"), ("E", "Math"), ("F", "Computer"),
  ("G", "Math"), ("H", "Math"), ("I", "Math");


CREATE TABLE cinema (
  id          INT(1) PRIMARY KEY,
  movie       VARCHAR(10),
  description VARCHAR(11),
  rating      VARCHAR(3)
);
INSERT INTO cinema VALUES (1, "War", "great 3D", 8.9), (2, "Science", "fiction", 8.5), (3, "irish", "boring", 6.2),
  (4, "Ice song", "Fantacy", 8.6), (5, "House card", "Interesting", 9.1);


CREATE TABLE salary (
  id     INT(1) PRIMARY KEY,
  name   VARCHAR(1),
  sex    VARCHAR(1),
  salary INT(4)
);
INSERT INTO salary VALUES (1, "A", "m", 2500), (2, "B", "f", 1500), (3, "C", "m", 5500), (4, "D", "f", 500);

