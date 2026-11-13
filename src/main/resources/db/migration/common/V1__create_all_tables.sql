drop table if exists book;
drop table if exists author;

create table book (
                      id bigint AUTO_INCREMENT PRIMARY KEY,
                      isbn varchar(255),
                      publisher varchar(255),
                      title varchar(255),
                      author_id BIGINT
);

create table author
(
    id bigint AUTO_INCREMENT PRIMARY KEY,
    first_name varchar(255),
    last_name varchar(255)
);