create table Eventos (
  id bigint auto_increment not null,
  nome_evento varchar(255) not null,
  usua_id bigint not null,
  dt_evento date not null,
  dt_iinscr date not null,
  dt_finscr date not null,
  primary key (id),
  unique key UK_EVENTOS(nome_evento),
  unique key UK_USUARIO(usua_id),
  foreign key (usua_id) references usuario(id)
)
