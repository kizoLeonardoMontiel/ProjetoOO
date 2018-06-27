package com.projetoOO.projetoOO.projRepository;

import com.projetoOO.projetoOO.projModel.Submissoes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SubmissoesRepository extends CrudRepository<Submissoes, Long> {
	Submissoes findById(long id);
	//Submissoes findBySubmissoes(String nome_art);
}
