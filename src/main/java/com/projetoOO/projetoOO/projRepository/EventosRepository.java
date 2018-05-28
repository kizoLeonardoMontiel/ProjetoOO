package com.projetoOO.projetoOO.projRepository;

import com.projetoOO.projetoOO.projModel.Eventos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventosRepository extends CrudRepository<Eventos, Long> {

}
