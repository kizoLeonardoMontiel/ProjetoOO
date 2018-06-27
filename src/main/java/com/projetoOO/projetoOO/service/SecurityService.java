package com.projetoOO.projetoOO.service;

import com.projetoOO.projetoOO.projModel.Usuario;

public interface SecurityService {

    String findLoggedInUsername();

    Usuario findLoggedInUser();

    void autologin(String username, String password);
}
