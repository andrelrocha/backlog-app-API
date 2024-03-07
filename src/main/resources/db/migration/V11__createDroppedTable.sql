CREATE TABLE dropped (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    console VARCHAR(100),
    note INTEGER,
    reason TEXT,
    game_id INTEGER REFERENCES games(id)
);