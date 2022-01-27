create table if not exists Ingredient
(
    id varchar(4) not null,
    name varchar(35) not null,
    type varchar(10) not null
);

create table if not exists Taco
(
    id bigint AUTO_INCREMENT,
    name varchar(50) not null,
    createdAt timestamp not null
);

create table if not exists Taco_Ingredients
(
    taco bigint references Taco(id),
    ingredient varchar(4) references Ingredient(id)
);

create table if not exists Taco_Order
(
    id bigint AUTO_INCREMENT,
    deliveryName varchar(50) not null,
    deliveryStreet varchar(50) not null,
    deliveryCity varchar(50) not null,
    deliveryState varchar(2) not null,
    deliveryZip varchar(10) not null,
    ccNumber varchar(16) not null,
    ccExpiration varchar(5) not null,
    ccCCV varchar(3) not null,
    placedAt timestamp not null
);

create table if not exists Taco_Order_Tacos (
    id bigint AUTO_INCREMENT,
    order_id bigint not null,
    taco_id bigint not null
);
