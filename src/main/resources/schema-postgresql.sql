DROP TABLE IF EXISTS question;

CREATE TABLE IF NOT EXISTS question(
    id serial PRIMARY KEY,
    title varchar(130) NOT NULL,
    description varchar(130) NOT NULL

    );