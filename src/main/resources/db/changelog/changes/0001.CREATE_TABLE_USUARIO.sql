create table Usuario (
  id bigint auto_increment not null,
  nome varchar(255) not null,
  email varchar(255) not null,
  username varchar(255) not null,
  password varchar(255) not null,
  primary key (id),
  unique key UK_USERNAME(username),
  unique key UK_EMAIL(email)
)


