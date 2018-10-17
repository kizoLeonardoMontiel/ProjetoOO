create table role (
  id bigint auto_increment not null,
  role varchar(255) not null,
  primary key (id),
  unique key UK_ROLE(role)
  )
