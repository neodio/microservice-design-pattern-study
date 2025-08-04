CREATE DATABASE IF NOT EXISTS shard1 CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE DATABASE IF NOT EXISTS shard2 CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- User
DROP USER IF EXISTS 'user'@'%';
CREATE USER 'user'@'%' IDENTIFIED BY '1234';
GRANT ALL PRIVILEGES ON shard1.* TO 'user'@'%';
GRANT ALL PRIVILEGES ON shard2.* TO 'user'@'%';
FLUSH PRIVILEGES;

use shard1;

create table users (
    id int(11) auto_increment primary key,
    email varchar(50) null,
    name varchar(50) null,
    user_id varchar(50) null,
    encrypted_pwd varchar(100) null
);

use shard2;

create table users (
    id int(11) auto_increment primary key,
    email varchar(50) null,
    name varchar(50) null,
    user_id varchar(50) null,
    encrypted_pwd varchar(100) null
);
