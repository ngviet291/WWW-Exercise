CREATE DATABASE shopdb;

USE shopdb;

CREATE TABLE products (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    MODEL VARCHAR(255),
    DESCRIPTION VARCHAR(255),
    QUANTITY INT,
    PRICE DOUBLE,
    IMGURL LONGTEXT
);

INSERT INTO products (MODEL, DESCRIPTION, QUANTITY, PRICE, IMGURL)
VALUES
('iPhone 15', 'Apple iPhone 15 128GB', 10, 19990000, 'iphone15.jpg'),
('Samsung Galaxy S24', 'Samsung Galaxy S24 256GB', 8, 21990000, 'samsung-s24.jpg'),
('MacBook Air M2', 'Apple MacBook Air M2 13 inch', 5, 24990000, 'macbook-air-m2.jpg'),
('Dell Inspiron 15', 'Laptop Dell Inspiron 15 Core i5', 7, 15990000, 'dell-inspiron.jpg'),
('Xiaomi Redmi Note 13', 'Xiaomi Redmi Note 13 256GB', 12, 6990000, 'redmi-note-13.jpg');