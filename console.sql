CREATE DATABASE movie_management;
USE movie_management;
# DROP DATABASE movie_management;
CREATE TABLE customer
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100),
    password VARCHAR(100),
    phone    VARCHAR(20),
    address  VARCHAR(255),
    gender   VARCHAR(100),
    email    VARCHAR(100),
    role     ENUM ('ADMIN','USER')
);

CREATE TABLE movie
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    title       VARCHAR(100),
    director    VARCHAR(100),
    genre       VARCHAR(100),
    description VARCHAR(100),
    duration    INT,
    language    VARCHAR(100)
);

CREATE TABLE screen_room
(
    id               INT AUTO_INCREMENT PRIMARY KEY,
    screen_room_name VARCHAR(100),
    total_seat       INT
);

CREATE TABLE schedule
(
    id              INT AUTO_INCREMENT PRIMARY KEY,
    movie_title     VARCHAR(100),
    movie_id        INT,
    show_time       DATE,
    screen_room_id  INT,
    available_seats INT,
    format          VARCHAR(100)
);

-- hiển thị lịch chiếu phim
DELIMITER $$
CREATE PROCEDURE get_all_schedule()
BEGIN
    SELECT * FROM schedule;
END
$$ DELIMITER ;

-- thêm mới lịch chiếu
DELIMITER $$
CREATE PROCEDURE add_schedule(
    IN in_movie_id INT,
    IN in_show_time DATE,
    IN in_screen_room_id INT,
    IN in_available_seats INT,
    IN in_format VARCHAR(100)
)
BEGIN
    INSERT INTO schedule(movie_id, show_time, screen_room_id, available_seats, format)
    VALUES (in_movie_id, in_show_time, in_screen_room_id, in_available_seats, in_format);
END
$$ DELIMITER ;

-- cập nhật lịch chiếu
DELIMITER $$
CREATE PROCEDURE update_schedule(
    IN in_schedule_id INT,
    IN in_movie_id INT,
    IN in_show_time DATE,
    IN in_screen_room_id INT,
    IN in_available_seats INT,
    IN in_format VARCHAR(100)
)
BEGIN
    UPDATE schedule
    SET movie_id        = in_movie_id,
        show_time       = in_show_time,
        screen_room_id  = in_screen_room_id,
        available_seats = in_available_seats,
        format          = in_format
    WHERE id = in_schedule_id;
END $$
DELIMITER ;

-- xóa lịch chiếu
DELIMITER $$
CREATE PROCEDURE delete_schedule(
    IN in_schedule_id INT
)
BEGIN
    DELETE
    FROM schedule
    WHERE id = in_schedule_id;
END
$$ DELIMITER

-- tên tiêu đề đc cập nhật
DELIMITER $$
CREATE TRIGGER before_insert_schedule
    BEFORE INSERT
    ON schedule
    FOR EACH ROW
BEGIN
    DECLARE movie_title_1 VARCHAR(100);
    -- Lấy title từ bảng movie theo movie_id
    SELECT title
    INTO movie_title_1
    FROM movie
    WHERE id = NEW.movie_id;
    -- Gán giá trị lấy được vào movie_title
    SET NEW.movie_title = movie_title_1;
END$$
DELIMITER ;

-- tên tiêu đề đc cập nhật
DELIMITER $$
CREATE TRIGGER after_update_movie_title
    AFTER UPDATE
    ON movie
    FOR EACH ROW
BEGIN
    -- Nếu title bị thay đổi, thì cập nhật lại movie_title trong bảng schedule
    IF OLD.title <> NEW.title THEN
        UPDATE schedule
        SET movie_title = NEW.title
        WHERE movie_id = NEW.id;
    END IF;
END$$
DELIMITER ;

ALTER TABLE schedule
    ADD CONSTRAINT schedule_screen_room_id
        FOREIGN KEY (screen_room_id)
            REFERENCES screen_room (id)
            ON DELETE CASCADE;

ALTER TABLE schedule
    ADD CONSTRAINT schedule_movie_id
        FOREIGN KEY (movie_id)
            REFERENCES movie (id)
            ON DELETE CASCADE;

CREATE TABLE ticket
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    schedule_id INT,
    seat_name   VARCHAR(100),
    total_money DOUBLE,
    created_at  DATE
);

ALTER TABLE ticket
    ADD CONSTRAINT ticket_customer_id
        FOREIGN KEY (customer_id)
            REFERENCES customer (id)
            ON DELETE CASCADE;

ALTER TABLE ticket
    ADD CONSTRAINT ticket_schedule_id
        FOREIGN KEY (schedule_id)
            REFERENCES schedule (id)
            ON DELETE CASCADE;

-- hiển thị tất cả người dùng
DELIMITER $$
CREATE PROCEDURE get_all_customer(
)
BEGIN
    SELECT *
    FROM customer;
END $$
DELIMITER ;

-- tìm kiếm người dùng
DELIMITER $$
CREATE PROCEDURE get_customer_by_id(
    IN in_customer_id int
)
BEGIN
    SELECT *
    FROM customer
    WHERE id = in_customer_id;
END $$
DELIMITER ;

INSERT INTO customer(id, username, password, phone, address, gender, email, role)
VALUES ('0', 'admin', '1', null, null, null, null, 'ADMIN');

-- tìm kiếm theo username và password
DELIMITER $$
CREATE PROCEDURE get_customer_by_username_and_password(
    IN customer_username VARCHAR(100),
    IN customer_password VARCHAR(100)
)
BEGIN
    SELECT *
    FROM customer
    WHERE username = customer_username
      AND password = customer_password;
END $$
DELIMITER ;


-- hiển thị toàn bộ phim
DELIMITER $$
CREATE PROCEDURE get_all_movies(
)
BEGIN
    SELECT * FROM movie;
END $$
DELIMITER ;


-- tìm kiếm phim theo id
DELIMITER $$
CREATE PROCEDURE get_movie_by_id(
    IN in_movie_id int
)
BEGIN
    SELECT *
    FROM movie
    WHERE id = in_movie_id;
END $$
DELIMITER ;


-- tìm kiếm phim theo tiêu đề
DELIMITER $$
CREATE PROCEDURE get_movie_by_title(
    IN in_movie_title VARCHAR(100)
)
BEGIN
    SELECT *
    FROM movie
    WHERE title = in_movie_title;
END $$
DELIMITER ;

-- add new movie

# title       VARCHAR(100),
#     director    VARCHAR(100),
#     genre       VARCHAR(100),
#     description VARCHAR(100),
#     duration    INT,
#     language    VARCHAR(100)

DELIMITER $$
CREATE PROCEDURE add_movie(
    IN in_movie_title VARCHAR(100),
    IN in_movie_director VARCHAR(100),
    IN in_movie_genre VARCHAR(100),
    IN in_movie_description VARCHAR(100),
    IN in_movie_duration INT,
    IN in_movie_language VARCHAR(100)
)
BEGIN
    INSERT INTO movie(title, director, genre, description, duration, language)
    VALUES (in_movie_title, in_movie_director, in_movie_genre, in_movie_description, in_movie_duration,
            in_movie_language);
END
$$
DELIMITER ;

-- update movie
DELIMITER $$
CREATE PROCEDURE update_movie(
    IN in_movie_id INT,
    IN in_movie_title VARCHAR(100),
    IN in_movie_director VARCHAR(100),
    IN in_movie_genre VARCHAR(100),
    IN in_movie_description VARCHAR(100),
    IN in_movie_duration INT,
    IN in_movie_language VARCHAR(100)
)
BEGIN
    UPDATE movie
    SET title       = in_movie_title,
        director    = in_movie_director,
        genre       = in_movie_genre,
        description = in_movie_description,
        duration    = in_movie_duration,
        language    = in_movie_language
    WHERE id = in_movie_id;
END $$
DELIMITER ;

-- delete movie
DELIMITER $$
CREATE PROCEDURE delete_movie(
    IN in_movie_id INT
)
BEGIN
    DELETE
    FROM movie
    WHERE id = in_movie_id;
end $$
DELIMITER ;