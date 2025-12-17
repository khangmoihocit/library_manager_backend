create table user_catalogues(
                      id bigint unsigned auto_increment primary key ,
                      name varchar(50) not null,
    create_at timestamp default current_timestamp,
    update_at timestamp default current_timestamp on update current_timestamp
);