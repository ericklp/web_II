package dao;


import beans.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ericklopes
 */
public class UsuarioDAO {
    
    private Connection conn;
    
    public UsuarioDAO() throws SQLException, ClassNotFoundException
    {
            this.conn = (Connection) new dao.ConnectionFactory().getConnection();
    }
    
    public Usuario findUsuarioByLogin(String login) throws SQLException {
        String sql = "SELECT * from tb_usuario where login_usuario=(?) LIMIT 1;";
		
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1,login);

        ResultSet res = stmt.executeQuery();
        Usuario usuario = new Usuario();

        while (res.next())
        { 
            usuario.setLogin(res.getString(2));
            usuario.setSenha(res.getString(3));
            usuario.setNome(res.getString(4));
            return usuario;
        }
        System.out.println("Executed: "+ usuario.toString());

        return null;
    }
   
}
