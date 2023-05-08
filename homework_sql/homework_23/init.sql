CREATE TABLE homework(
id BIGSERIAL PRIMARY KEY,
name VARCHAR(255) NOT NULL,
description TEXT
);

CREATE TABLE Lesson(
id BIGSERIAL PRIMARY KEY,
name VARCHAR(255) NOT NULL,
updatedAt TIMESTAMP DEFAULT NOW(),
homework_id BIGINT NOT NULL,
CONSTRAINT homework_id_fk FOREIGN KEY (homework_id) REFERENCES homework(id)
);

CREATE TABLE Schedule(
id BIGSERIAL PRIMARY KEY,
name VARCHAR(255) NOT NULL,
updatedAt TIMESTAMP DEFAULT NOW()
);

CREATE TABLE lesson_schedule(
lesson_id BIGINT REFERENCES lesson(id) ON DELETE CASCADE,
schedule_id BIGINT REFERENCES schedule(id) ON DELETE CASCADE,
PRIMARY KEY (lesson_id, schedule_id)
);

INSERT FROM homework (name, description) VALUES
('Homework #1', 'Do exercise 10-13'),
('Homework #2', 'Take a short test to revise topic');

INSERT INTO lesson (name, homework_id) VALUES
('Lesson #1', 1),
('Lesson #2', 1),
('Lesson #3', 2);

INSERT INTO schedule (name) VALUES
('Schedule #1'),
('Schedule #2');

INSERT INTO lesson_schedule (lesson_id, schedule_id) VALUES
(1, 1),
(2, 1),
(3, 2);