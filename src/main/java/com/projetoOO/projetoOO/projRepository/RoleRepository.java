package com.projetoOO.projetoOO.projRepository;

import com.projetoOO.projetoOO.projModel.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("roleRepository")
public interface RoleRepository extends CrudRepository<Role, Long> {

    Role findByRole(String role);

}