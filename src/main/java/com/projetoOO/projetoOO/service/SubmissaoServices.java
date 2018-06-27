package com.projetoOO.projetoOO.service;

import com.projetoOO.projetoOO.projModel.Eventos;
import com.projetoOO.projetoOO.projModel.Submissoes;
import com.projetoOO.projetoOO.projRepository.EventosRepository;
import com.projetoOO.projetoOO.projRepository.SubmissoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SubmissaoServices {

    @Autowired
    private SubmissoesRepository submissaorepository;

    public List<Submissoes> findAll() {
        return (List<Submissoes>) submissaorepository.findAll();
    }


    //public Eventos findOne(Long id) {
    //    return repository.findOne(id);
    //}

   // public Eventos save(Eventos eventos) {
    //    return repository.saveAndFlush(eventos);
   // }

    //public void delete(Long id) {
    //    repository.delete(id);
    //}
}
