/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import beans.LoginBean;
import beans.Usuario;
import dao.UsuarioDAO;
import exceptions.UsuarioSenhaInvalidosException;
import java.sql.SQLException;

/**
 *
 * @author ericklopes
 */
public class LoginFacade {
    public static Usuario pesquisarUsuario(String login) throws SQLException, ClassNotFoundException, UsuarioSenhaInvalidosException {
        UsuarioDAO dao = new UsuarioDAO();
        return dao.getUsuario(login);
    }

}
