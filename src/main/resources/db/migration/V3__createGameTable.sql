CREATE TABLE games (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    length INTEGER,
    metacritic INTEGER,
    excitement INTEGER,
    genre VARCHAR(255),
    played BOOLEAN
);