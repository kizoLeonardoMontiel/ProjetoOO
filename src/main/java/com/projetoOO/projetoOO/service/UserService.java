package com.projetoOO.projetoOO.service;

import com.projetoOO.projetoOO.projModel.Usuario;

public interface UserService {
     Usuario findUserByEmail(String email);
     void saveUser(Usuario user);


}