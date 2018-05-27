create table submissoes (
  id bigint auto_increment not null,
  nome_art varchar(255) not null,
  resumo varchar(255) not null,
  datasub date(255) not null,
  password varchar(255) not null,
  primary key (id),
  unique key UK_SUBMISSOES(nome_art),
   foreign key (user_id) references user(id),
    foreign key (name_id) references eventos(id),

)
