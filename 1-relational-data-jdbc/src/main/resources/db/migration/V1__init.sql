create table customers (
id integer primary key generated always as identity,
firstname varchar(40) not null,
lastname varchar(40) not null
);
