CREATE ROLE todo_user LOGIN PASSWORD 'todo_pass';
CREATE DATABASE todo_db WITH OWNER = todo_user;
\c todo_db todo_user
CREATE TABLE todo_items (
    id SERIAL PRIMARY KEY,
    title VARCHAR(40),
    done_flg NUMERIC(1) DEFAULT 0,
    time_limit DATE
);