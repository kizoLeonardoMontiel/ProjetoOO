package com.projetoOO.projetoOO.projRepository;

import com.projetoOO.projetoOO.projModel.Eventos;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventosRepository extends JpaRepository<Eventos, Long> {

    Eventos findById(long id);
	Eventos findByEventos(String nome_evento);


}
