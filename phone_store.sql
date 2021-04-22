create database PHONESTORE character set utf8mb4 COLLATE utf8mb4_unicode_ci;
use PHONESTORE;

create table OS(
	id_os char(5) primary key,
    name_os varchar(20) not null
);

create table MANUFACTURE(
	id_manufacture char(5) primary key,
    name_manufacture varchar(20) not null
); 

create table COLOR(
	id_color char(5) primary key,
    name_color varchar(20) not null
);

create table PHONE(
	id_phone char(5) primary key,
    phone_name varchar(50) not null,
    price int check (price>0),
    id_os char(5), foreign key (id_os) references OS(id_os),
    id_manufacture char(5), foreign key (id_manufacture) references MANUFACTURE(id_manufacture),
    version varchar(50) default '0'
);

create table PHONE_DETAIL(
	id_phone char(5), foreign key (id_phone) references PHONE(id_phone),
    id_color char(5), foreign key (id_color) references COLOR(id_color),
    performanace varchar(40) not null,
    screen float default 0.0,
    pin int check (pin > 0),
    amount int default 0,
    primary key (id_phone, id_color)
);

create table ACCOUNT_USER(
	id_user char(5) primary key,
    pwd varchar(16) not null
);

create table USER_DETAIL(
	id_user char(5), foreign key (id_user) references ACCOUNT_USER(id_user),
    username varchar(50) not null,
    address varchar(50),
    phone_number char(10) default '0',
    email varchar(40),
    dayofbirth date,
    primary key (id_user)
);

create table ORDERS(
	id_order char(5) primary key,
    id_user char(5), foreign key (id_user) references ACCOUNT_USER(id_user),
    order_time timestamp default now()
);

create table ORDER_DEATIL(
	id_order_detail char(5) primary key,
    id_order char(5), foreign key (id_order) references ORDERS(id_order),
    id_phone char(5), foreign key (id_phone) references PHONE(id_phone),
    id_color char(5), foreign key (id_color) references COLOR(id_color),
    quantity int default 1,
    total int default 0
);