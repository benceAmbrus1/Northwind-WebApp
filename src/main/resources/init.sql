DROP TABLE IF EXISTS users;


CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    user_email TEXT UNIQUE NOT NULL,
    user_password TEXT NOT NULL,
    user_name TEXT NULL,
    user_firstName TEXT NULL,
    user_lastName TEXT NULL,
    user_introduction TEXT NULL,
    user_image TEXT NULL,
    user_role TEXT NOT NULL,
	CONSTRAINT email_not_empty CHECK (user_email <> ''),
	CONSTRAINT password_not_empty CHECK (user_password <> '')
);
