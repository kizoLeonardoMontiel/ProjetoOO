package com.projetoOO.projetoOO.projRepository;

import com.projetoOO.projetoOO.projModel.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	Usuario findById(long id);
	Usuario findByUsername(String username);
}
