 create table Submissoes (
   id bigint auto_increment not null,
   even_id bigint not null,
   usua_id bigint not null,
   nome_art varchar(255) not null,
   resumo_art varchar(255) not null,
   dt_submissao DATETIME not null,
   anexo_art varchar(255) not null,
   primary key (id),
   foreign key (even_id) references eventos(id),
   foreign key (usua_id) references usuario(id)
)
