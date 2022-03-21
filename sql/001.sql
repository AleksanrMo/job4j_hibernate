create table company2 (
    id serial primary key,
    name varchar(255)
);

create table model2 (
    id serial primary key,
    name varchar(255),
    company_id int references company2(id)
);

