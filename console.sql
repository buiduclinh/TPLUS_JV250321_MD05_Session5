CREATE DATABASE md5_ss6;
USE md5_ss6;

CREATE TABLE product
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    productName VARCHAR(100),
    price       DECIMAL(10, 2),
    description VARCHAR(100),
    image       VARCHAR(100)
);

-- hiển thị sản phẩm
DELIMITER $$
CREATE PROCEDURE get_all_products()
BEGIN
    SELECT * FROM product;
END
$$ DELIMITER ;

-- thêm mới sản phẩm
DELIMITER $$
CREATE PROCEDURE add_product(
    IN in_new_product_name VARCHAR(100),
    IN in_new_product_price DECIMAL(10, 2),
    IN in_new_product_description VARCHAR(100),
    IN in_new_product_image VARCHAR(100)
)
BEGIN
    INSERT INTO product(productName, price, description, image)
    VALUES (in_new_product_name, in_new_product_price, in_new_product_description, in_new_product_image);
END
$$
DELIMITER ;

CREATE TABLE user
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    name     VARCHAR(100),
    age      INT,
    birthday DATE,
    email    VARCHAR(100),
    phone    VARCHAR(20)
);

-- hiển thị tất cả người dùng
DELIMITER $$
CREATE PROCEDURE get_all_users()
BEGIN
    SELECT * FROM user;
END
$$ DELIMITER ;

-- thêm mới người dùng
DELIMITER $$
CREATE PROCEDURE add_user(
    IN in_user_name VARCHAR(100),
    IN in_user_age INT,
    IN in_user_birthday DATE,
    IN in_user_email VARCHAR(100),
    IN in_user_phone VARCHAR(20)
)
BEGIN
    INSERT INTO user(name, age, birthday, email, phone)
    VALUES (in_user_name, in_user_age, in_user_birthday, in_user_email, in_user_phone);
END $$
DELIMITER ;


-- lấy số điện thoại người dùng


-- lấy email người dùng


CREATE TABLE employee
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    name     VARCHAR(100),
    email    VARCHAR(100),
    position VARCHAR(100)
);

-- lấy danh sách nhân viên
DELIMITER $$
CREATE PROCEDURE get_all_employee()
BEGIN
    SELECT * FROM employee;
END
$$ DELIMITER ;

-- thêm mới nhân viên
DELIMITER $$
CREATE PROCEDURE add_employee(
    IN in_employee_name VARCHAR(100),
    IN in_employee_email VARCHAR(100),
    IN in_employee_position VARCHAR(100)
)
BEGIN
    INSERT INTO employee(name, email, position)
    VALUES (in_employee_name, in_employee_email, in_employee_position);
END
$$
DELIMITER ;

CREATE TABLE question
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    imageUrl VARCHAR(100),
    answer   VARCHAR(100)
);

-- lấy ngẫu nhiên câu hỏi
DELIMITER $$

CREATE PROCEDURE get_random_question_id(OUT random_id INT)
BEGIN
    SELECT id
    INTO random_id
    FROM question
    ORDER BY RAND()
    LIMIT 1;
END$$

DELIMITER ;

-- thêm mới câu hỏi
DELIMITER $$
CREATE PROCEDURE add_question(
    IN in_question_imageUrl VARCHAR(100),
    IN in_question_answer VARCHAR(100)
)
BEGIN
    INSERT INTO question(imageUrl, answer)
    VALUES (in_question_imageUrl, in_question_answer);
END
$$
DELIMITER ;


CREATE TABLE seed
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    seedsName VARCHAR(100),
    price     DECIMAL(10, 2),
    imageUrl  VARCHAR(100)
);

CREATE TABLE user_player
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100),
    password VARCHAR(100),
    email    VARCHAR(100),
    balance  DECIMAL(10, 2)
);