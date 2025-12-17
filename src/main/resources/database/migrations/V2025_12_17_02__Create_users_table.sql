create table users(
                      id bigint unsigned auto_increment primary key ,
                      user_catalogue_id bigint unsigned default null,
                      name varchar(50) not null,
                      email varchar(100) not null unique,
                      password varchar(200) not null,
                      phone varchar(20) not null unique,
                      address varchar(255) default null,
                      image varchar(255) default null,
                      create_at timestamp default current_timestamp,
                      update_at timestamp default current_timestamp on update current_timestamp,
    constraint fk_user_catalogue_id foreign key (user_catalogue_id) references user_catalogues(id)
                  on delete cascade
);