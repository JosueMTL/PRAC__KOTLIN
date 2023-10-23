CREATE TABLE IF NOT EXISTS author (
    id SERIAL PRIMARY KEY,
    nationality VARCHAR(50),
    first_name VARCHAR(50),
    last_name VARCHAR(50)
    );

CREATE TABLE IF NOT EXISTS book (
    book_id SERIAL PRIMARY KEY,
    title VARCHAR(100),
    isbn VARCHAR(20),
    publication_year INT,
    author_id INT,
    FOREIGN KEY (author_id) REFERENCES author(id)
    );
