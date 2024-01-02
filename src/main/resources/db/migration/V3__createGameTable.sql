CREATE TABLE games (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    length INTEGER,
    metacritic INTEGER,
    excitement INTEGER,
    played BOOLEAN,
    genre VARCHAR(255)
);