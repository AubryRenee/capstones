BEGIN TRANSACTION;

DROP TABLE IF EXISTS check_in;
DROP TABLE IF EXISTS user_badge;
DROP TABLE IF EXISTS location;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS badge;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE badge(
	badge_id serial NOT NULL,
	badge_name varchar(100) NOT NULL,
	CONSTRAINT PK_badge PRIMARY KEY (badge_id)
);

CREATE TABLE category(
	category_id serial NOT NULL,
	category_name varchar(100) NOT NULL,
	badge_id int NOT NULL,
	CONSTRAINT PK_category PRIMARY KEY (category_id),
	CONSTRAINT FK_category_badge FOREIGN KEY(badge_id) REFERENCES badge (badge_id)
);

CREATE TABLE location(
	location_id serial NOT NULL,
	location_name varchar(100) NOT NULL,
	category_id int NOT NULL,
	CONSTRAINT PK_location PRIMARY KEY (location_id),
	CONSTRAINT FK_location_category FOREIGN KEY(category_id) REFERENCES category (category_id),
	phone_number varchar (20),
	street varchar (100),
	city varchar (50),
	state varchar (25),
	zip varchar (5),
	latitude varchar(20),
	longitude varchar (20)

);

CREATE TABLE user_badge(
	user_id int NOT NULL,
	badge_id int NOT NULL,
	CONSTRAINT PK_user_badge PRIMARY KEY (user_id, badge_id),
	CONSTRAINT FK_ub_badge_id FOREIGN KEY (badge_id) REFERENCES badge (badge_id),
	CONSTRAINT FK_ub_user_id FOREIGN KEY(user_id) REFERENCES users (user_id)
);

CREATE TABLE check_in(
	user_id int NOT NULL,
	location_id int NOT NULL,
	CONSTRAINT PK_user_location PRIMARY KEY (user_id, location_id),
	CONSTRAINT FK_ci_location_id FOREIGN KEY (location_id) REFERENCES location (location_id),
	CONSTRAINT FK_ci_user_id FOREIGN KEY(user_id) REFERENCES users (user_id)
);
COMMIT TRANSACTION;
