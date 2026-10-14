CREATE DATABASE LibraryDB;
USE LibraryDB;

CREATE TABLE publishers (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    address VARCHAR(200)
);

CREATE TABLE books (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(200),
    author VARCHAR(100),
    price DECIMAL(10,2),
    publisher_id INT,
    FOREIGN KEY (publisher_id) REFERENCES publishers(id)
);
INSERT INTO publishers (name, address) VALUES
('Kim Dong', 'Ha Noi'),
('Tre', 'Ho Chi Minh'),
('Giao Duc', 'Da Nang'),
('Van Hoc', 'Ha Noi');

INSERT INTO books (title, author, price, publisher_id) VALUES
('De Men Phieu Luu Ky', 'To Hoai', 80000, 1),
('Dat Rung Phuong Nam', 'Doan Gioi', 90000, 2),
('Cho Toi Xin Mot Ve Di Tuoi Tho', 'Nguyen Nhat Anh', 100000, 2),
('Mat Biec', 'Nguyen Nhat Anh', 120000, 2),
('Toan Lop 12', 'Nguyen Van A', 70000, 3),
('Van Hoc Viet Nam', 'Nguyen Van B', 60000, 3),
('Truyen Ngan', 'Nguyen Van C', 50000, 1);