create table if not exists Gadget_Order (
     id identity,
     delivery_Name varchar(50) not null,
     delivery_Street varchar(50) not null,
     delivery_City varchar(50) not null,
     delivery_State varchar(2) not null,
     delivery_Zip varchar(10) not null,
     cc_number varchar(16) not null,
     cc_expiration varchar(5) not null,
     cc_cvv varchar(3) not null,
     placed_at timestamp not null
);

create table if not exists Gadget (
    id identity,
    name varchar(5) not null,
    gadget_order bigint not null,
    gadget_order_key bigint not null,
    created_at timestamp not null
);

create table if not exists Specification_Ref (
     specification varchar(4) not null,
     gadget bigint not null,
     gadget_key bigint not null
);

create table if not exists Specification (
     id varchar(4) not null,
     brand varchar(25) not null,
     size varchar(25) not null,
     type varchar(10) not null
);

alter table Gadget
 add foreign key (gadget_order) references Gadget_Order(id);
alter table Specification_Ref
 add foreign key (specification) references Specification(id);


--Data
delete from Specification_Ref;
delete from Gadget;
delete from Gadget_Order;


delete from Specification;
insert into Specification (id, brand, size, type) values ('1', 'ASUS', '16 GB', 'RAM');
insert into Specification (id, brand, size, type) values ('2', 'HP', '16 GB', 'RAM');
insert into Specification (id, brand, size, type) values ('3', 'ASUS', '8 GB', 'RAM');
insert into Specification (id, brand, size, type) values ('4', 'DELL', '1 TB', 'HDD');
insert into Specification (id, brand, size, type) values ('5', 'SAMSUNG', '512 GB', 'HDD');
insert into Specification (id, brand, size, type) values ('6', 'ASUS', '2 TB', 'HDD');
insert into Specification (id, brand, size, type) values ('7', 'DELL', '256 GB', 'HDD');
insert into Specification (id, brand, size, type) values ('8', 'HP', '13.6 inch', 'DISPLAY');
insert into Specification (id, brand, size, type) values ('9', 'HP', '14.6 inch', 'DISPLAY');
insert into Specification (id, brand, size, type) values ('10','DELL', '1.6 inch', 'DISPLAY');
insert into Specification (id, brand, size, type) values ('11','SAMSUNG', 'core i7', 'PROCESSOR');
insert into Specification (id, brand, size, type) values ('12','INTEL', 'core i5', 'PROCESSOR');
insert into Specification (id, brand, size, type) values ('13','AMD', 'core i3', 'PROCESSOR');


