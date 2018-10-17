 create table user_role (
  id bigint auto_increment not null,
  user_id bigint not null,
  role_id bigint not null,
  primary key (id),
  unique key UK_USER_ROLE(user_id, role_id),
  foreign key (id) references usuario(id),
  foreign key (id) references role(id)
)
