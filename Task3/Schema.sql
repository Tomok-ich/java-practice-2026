create table Product(
					id serial unique not null,
					product_name char(40) not null,
					cost integer check(cost >= 0)
);

select * from Product

insert into Product (product_name, cost) values ('PC', 175000);

insert into Product (product_name, cost) values ('Paper', 0,7);

insert into Product (product_name, cost) values ('Paper', 0);

select * from Product

insert into Product (product_name, cost) values ('Pen', -45);

insert into Product (product_name, cost) values ('Pen', 0,6);

insert into Product (product_name, cost) values ('Pen', 50);

select * from Product