CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    login VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL,
    token_expiration TIMESTAMP,
    token_mail VARCHAR(255),
    validated BOOLEAN DEFAULT false,
    token_confirmation VARCHAR(255)
);