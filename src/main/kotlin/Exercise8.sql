-------------------------------------- CREATE TABLE --------------------------------------
create table Clients(
   id serial PRIMARY KEY,
   username VARCHAR (50) NOT NULL,
   gender VARCHAR (50) NOT NULL
)

create table Orders(
   id serial PRIMARY KEY,
   client_id integer not null,
   delivered bool NOT null,
   CONSTRAINT order_client_id_fk FOREIGN KEY (client_id )
      REFERENCES Clients(id)
)

create table Products(
   id serial PRIMARY KEY,
   productName VARCHAR (50) NOT NULL,
   price integer NOT NULL
)

create table orders_products(
	order_id integer not null,
	product_id integer not null,
	quantity integer not null,
   CONSTRAINT orders_products_order_id_fk FOREIGN KEY (order_id)
      REFERENCES orders(id),
   CONSTRAINT orders_products_product_id_fk FOREIGN KEY (product_id)
      REFERENCES products(id)
)
-------------------------------------- INSERTS --------------------------------------
insert into clients values(1, 'Gabriel', 'male')
insert into clients values(2, 'Mary', 'female')

insert into orders values(1, 1, false)
insert into orders values(2, 1, true)

insert into products values(1, 'Pizza', 15)
insert into products values(2, 'Hamburguer', 10)

insert into orders_products values(1, 1, 2)
insert into orders_products values(1, 2, 1)
insert into orders_products values(2, 1, 1)
----------------------------------- SELECTS(finally)---------------------------------
select * from orders_products 
select * from clients
select * from orders 
select * from products

--how many orders do I have?
select count(*) from orders where client_id=1

--how many of them are active?
select count(*) from orders where client_id=1 and delivered=false

--what do I ordered?
select product_id from orders_products where order_id=(select id from orders where client_id=1 and delivered=false)

--product_id 1 and 2...
select productName from products where id=1
select productName from products where id=2

--how many is it going to cost?
select product_id, quantity from orders_products where order_id=(select id from orders where client_id=1 and delivered=false)
select productName, price from products where id=1 -- 2 pizzas
select productName, price from products where id=2 -- 1 hamburguer
-- (2 * 15) + (1 * 10) = 40

--listing orders by number of items
select id from orders where client_id=1 -- 1 and 2

select order_id, sum(quantity) from orders_products where order_id=1 group by order_id
UNION
select order_id, sum(quantity) from orders_products where order_id=2 group by order_id



