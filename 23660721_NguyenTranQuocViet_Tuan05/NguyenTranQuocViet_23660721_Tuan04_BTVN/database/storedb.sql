CREATE DATABASE IF NOT EXISTS storedb
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

USE storedb;

-- ========================================
-- TABLE: accounts
-- ========================================
CREATE TABLE IF NOT EXISTS accounts (
    ID INT UNSIGNED NOT NULL AUTO_INCREMENT,
    FIRSTNAME VARCHAR(50),
    LASTNAME VARCHAR(50),
    EMAIL VARCHAR(50),
    PASSWORD VARCHAR(50),
    DATEOFBIRTH DATE,
    PRIMARY KEY (ID)
);

INSERT INTO accounts
(FIRSTNAME, LASTNAME, EMAIL, PASSWORD, DATEOFBIRTH)
VALUES
('vinh', 'hoang', 'vinh@gmail.com', '123123', '2013-11-15'),
('ngoc', 'ngoc', 'ngoc@gmail.com', '111', '2011-12-14'),
('Dang', 'Ha', 'dtthuha79@gmail.com', '12212', '2011-10-14');


-- ========================================
-- TABLE: product
-- ========================================
CREATE TABLE IF NOT EXISTS product (
    ID INT UNSIGNED NOT NULL AUTO_INCREMENT,
    NAME VARCHAR(50),
    DESCRIPTION VARCHAR(50),
    PRICE FLOAT,
    PRIMARY KEY (ID)
);

INSERT INTO product
(NAME, DESCRIPTION, PRICE)
VALUES
('HP', 'HP Laptop', 2000),
('ASUS', 'ASUS Laptop', 3000),
('LENOVO', 'LENOVO Laptop', 4000);


-- ========================================
-- TABLE: users
-- ========================================
CREATE TABLE IF NOT EXISTS users (
    ID INT UNSIGNED NOT NULL AUTO_INCREMENT,
    FIRSTNAME VARCHAR(50),
    LASTNAME VARCHAR(50),
    PICFILE VARCHAR(50),
    PRIMARY KEY (ID)
);

INSERT INTO users
(FIRSTNAME, LASTNAME, PICFILE)
VALUES
('Dang', 'Ha', 'pic1.jpg'),
('Minh', 'Thư', '0. CourseIntro.pptx'),
('Dang', 'Ha', 'STT_MSSV_Hoten_Ketqua.docx');


-- ========================================
-- TABLE: books
-- Dùng cho BookDAO
-- ========================================
CREATE TABLE IF NOT EXISTS books (
    bookId VARCHAR(20) NOT NULL,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255),
    price DOUBLE,
    quantity INT,
    image VARCHAR(255),
    PRIMARY KEY (bookId)
);

-- ========================================
-- DATA: books
-- ========================================
INSERT INTO books
(bookId, title, author, price, quantity, image)
VALUES
('B001', 'Lập trình Java', 'Nguyễn Văn A', 120000, 10, 'book1.jpg'),
('B002', 'Lập trình Web', 'Trần Văn B', 150000, 8, 'book2.jpg'),
('B003', 'Cơ sở dữ liệu', 'Lê Văn C', 130000, 15, 'book3.jpg'),
('B004', 'Lập trình Spring Boot', 'Nguyễn Văn D', 180000, 7, 'book4.jpg'),
('B005', 'Java nâng cao', 'Phạm Văn E', 200000, 5, 'book5.jpg');