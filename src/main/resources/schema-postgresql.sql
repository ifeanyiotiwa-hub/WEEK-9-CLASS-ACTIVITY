DROP TABLE IF EXISTS question;

CREATE TABLE IF NOT EXISTS question(
    id serial PRIMARY KEY,
    title varchar(130) NOT NULL,
    description varchar(130) NOT NULL

    );


CREATE TABLE IF NOT EXISTS answer(
     id serial PRIMARY KEY,
     text varchar(130) NOT NULL,
     question_id serial,
    foreign key(question_id) references question(id)
    );