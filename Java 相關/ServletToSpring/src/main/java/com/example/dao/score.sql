Drop Table if exists score;

CREATE TABLE `score` (
  studentId int not null auto_increment,
  studentName varchar(20) not null,
  chinese int not null default 0,
  english int not null default 0,
  math int not null default 0,
  science int not null default 0,
  social  int not null default 0,
  Primary key(studentId)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `score` (`studentName`, `chinese`, `english`, `math`, `science`, `social`)
VALUES
('Alice', 90, 85, 78, 92, 88),
('Bob', 75, 88, 95, 80, 87),
('Charlie', 82, 79, 91, 88, 76),
('David', 94, 87, 72, 90, 84),
('Eva', 88, 90, 85, 78, 92),
('Frank', 78, 95, 80, 87, 75),
('Grace', 91, 82, 79, 91, 88),
('Henry', 72, 94, 87, 72, 90),
('Ivy', 85, 88, 90, 85, 78),
('Jack', 80, 78, 95, 80, 87),
('Kate', 79, 91, 82, 79, 91),
('Leo', 85, 80, 78, 95, 80),
('Mia', 76, 83, 89, 94, 77),
('Nathan', 93, 86, 71, 89, 83),
('Olivia', 89, 89, 86, 77, 91),
('Patrick', 81, 77, 93, 84, 89),
('Quinn', 74, 92, 84, 79, 85),
('Rachel', 87, 78, 90, 88, 82),
('Samuel', 70, 93, 77, 83, 94),
('Tina', 84, 85, 88, 76, 90),
('Ulysses', 79, 84, 94, 85, 78),
('Victoria', 88, 87, 79, 92, 86),
('Walter', 95, 80, 76, 91, 83),
('Xena', 83, 76, 92, 87, 79),
('Yasmine', 86, 81, 83, 89, 92),
('Zachary', 92, 89, 77, 80, 88),
('Bella', 82, 78, 91, 86, 75),
('Caleb', 89, 94, 85, 78, 91),
('Diana', 76, 85, 88, 92, 79),
('Elijah', 91, 80, 77, 87, 93),
('Fiona', 83, 92, 89, 78, 84),
('George', 78, 86, 94, 82, 88),
('Hannah', 94, 88, 81, 79, 90),
('Isaac', 87, 79, 92, 88, 75),
('Julia', 75, 91, 83, 94, 87),
('Kevin', 80, 84, 88, 76, 93),
('Lily', 85, 77, 95, 80, 91),
('Mason', 92, 93, 79, 85, 88),
('Nora', 88, 76, 90, 89, 82),
('Oscar', 77, 85, 92, 78, 94),
('Penelope', 93, 78, 86, 93, 81),
('Quincy', 86, 90, 75, 88, 92),
('Ruby', 79, 87, 91, 79, 85),
('Seth', 84, 89, 88, 91, 76),
('Tessa', 90, 80, 83, 77, 95),
('Ursula', 87, 91, 78, 85, 92),
('Vincent', 75, 83, 92, 89, 80),
('Wendy', 94, 87, 79, 93, 82),
('Xavier', 78, 92, 85, 87, 91),
('Yara', 83, 79, 94, 88, 85),
('Zander', 89, 88, 82, 76, 90);