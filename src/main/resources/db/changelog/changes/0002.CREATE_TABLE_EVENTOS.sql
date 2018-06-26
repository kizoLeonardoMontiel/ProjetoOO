create table Eventos (
  id bigint auto_increment not null,
  nome_evento varchar(255) not null,
  usua_id bigint not null,
  dt_evento DATETIME not null,
  dt_iinscr DATETIME not null,
  dt_finscr DATETIME not null,
  primary key (id),
  foreign key (usua_id) references usuario(id)
)
