package com.projetoOO.projetoOO.projRepository;

import com.projetoOO.projetoOO.projModel.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
	Evento findById(long id);
}
