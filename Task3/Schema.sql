create table Product(
					id serial unique not null,
					product_name char(40) not null,
					cost integer check(cost >= 0)
);