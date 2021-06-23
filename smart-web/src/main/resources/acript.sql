INSERT INTO User_info (id, firstname, lastname, username, password, salary, age) VALUES (900001, 'Alex','Knr', 'alex123','$2a$04$4vwa/ugGbBVDvbWaKUVZBuJbjyQyj6tqntjSmG8q.hi97.xSdhj/2', 3456, 33);
INSERT INTO User_info (id, firstname, lastname, username, password, salary, age)  VALUES (900002, 'Tom', 'Asr', 'tom234', '$2a$04$QED4arFwM1AtQWkR3JkQx.hXxeAk/G45NiRd3Q4ElgZdzGYCYKZOW', 7823, 23);
INSERT INTO User_info (id, firstname, lastname, username, password, salary, age)  VALUES (900003, 'Adam', 'Psr', 'adam', '$2a$04$WeT1SvJaGjmvQj34QG8VgO9qdXecKOYKEDZtCPeeIBSTxxEhazNla', 4234, 45);

CREATE TABLE user_info(
	id bigserial not null,
	age INT,
	firstName VARCHAR(255),
	lastName VARCHAR(255),
	password VARCHAR(255),
	salary int,
	username VARCHAR(255),
	PRIMARY KEY (id)
)