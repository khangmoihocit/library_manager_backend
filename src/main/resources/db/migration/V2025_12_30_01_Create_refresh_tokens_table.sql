create table refresh_tokens(
                                  id bigint unsigned auto_increment primary key ,
                                  refresh_token varchar(255) not null unique,
                                  expiry_date timestamp not null ,
                                  user_id bigint unsigned not null,
                                  create_at timestamp default current_timestamp,
                                  update_at timestamp default current_timestamp on update current_timestamp,
                                  foreign key (user_id) references users(id)
);