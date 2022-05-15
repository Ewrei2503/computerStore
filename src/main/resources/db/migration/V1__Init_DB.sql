create table hibernate_sequence (
    next_val bigint
) engine=InnoDB;

create table message(
    id bigint not null,
    message_for varchar(255),
    tag varchar(255),
    text varchar(2048) not null,
    user_id bigint,
    primary key (id)
)engine=InnoDB;

create table user_role(
    user_id bigint not null,
     roles varchar(255)
)engine=InnoDB;

create table usr(
    id bigint not null,
    password varchar(255) not null,
    username varchar(255) not null,
    primary key (id)
)engine=InnoDB;

create table brak(
    by_warranty bit,
    sold_position_id bigint not null,
    primary key (sold_position_id)
) engine=InnoDB;

create table drive (
    memory integer,
    type_drive bit,
    product_id bigint not null,
    primary key (product_id)
) engine=InnoDB;

create table motherboard (
    socket varchar(255),
    product_id bigint not null,
    primary key (product_id)
) engine=InnoDB;

create table orders (
    id bigint not null,
    type bit, wait bit,
    user_id bigint,
    primary key (id)
) engine=InnoDB;

create table position (
    id bigint not null auto_increment,
    order_id bigint,
    product_id bigint,
    primary key (id)
) engine=InnoDB;

create table processor (
    clock integer,
    cores integer,
    thread integer,
    product_id bigint not null,
    primary key (product_id)
) engine=InnoDB;

create table product (
    id bigint not null auto_increment,
    company varchar(255),
    model varchar(255),
    num integer,
    price double precision,
    type varchar(255),
    primary key (id)
) engine=InnoDB;

create table ram (
    clock integer,
    memory integer,
    product_id bigint not null,
    primary key (product_id)
) engine=InnoDB;

create table sold (
    warranty bit,
    position_id bigint not null,
    primary key (position_id)
) engine=InnoDB;

create table supplier (
    id bigint not null,
    email varchar(255),
    name varchar(255),
    primary key (id)
) engine=InnoDB;

create table videocard (
    clock integer,
    memory integer,
    product_id bigint not null,
    primary key (product_id)
) engine=InnoDB;



alter table brak
    add constraint brak_sold_fk
        foreign key (sold_position_id) references sold (position_id);

alter table drive
    add constraint drive_product_fk
        foreign key (product_id) references product (id);

alter table motherboard
    add constraint motherboard_product_fk
        foreign key (product_id) references product (id);

alter table orders
    add constraint orders_usr_fk
        foreign key (user_id) references usr (id);

alter table position
    add constraint position_orders_fk
        foreign key (order_id) references orders (id);

alter table position
    add constraint position_product_fk
        foreign key (product_id) references product (id);

alter table processor
    add constraint processor_product_fk
        foreign key (product_id) references product (id);

alter table ram
    add constraint ram_product_fk
        foreign key (product_id) references product (id);

alter table sold
    add constraint sold_position_fk
        foreign key (position_id) references position (id);

alter table videocard
    add constraint videocard_product_fk
        foreign key (product_id) references product (id);

alter table message
    add constraint message_user_fk
    foreign key (user_id) references usr (id);

alter table user_role
    add constraint user_role_user_fk
    foreign key (user_id) references usr (id);