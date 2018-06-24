create table Evento (
  id bigint auto_increment not null,
  nevento varchar(255) not null,
  usuaid varchar(10) not null,
  dtevento varchar(10) not null,
  dtiinscr varchar(10) not null,
  dtfinscr varchar(10) not null,
  primary key (id)
)
