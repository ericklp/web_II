/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.Pokemon;
import beans.Treinador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ericklopes
 */
public class TreinadorDAO {
    
    private Connection conn;
    
    public TreinadorDAO() throws SQLException, ClassNotFoundException
    {
            this.conn = (Connection) new dao.ConnectionFactory().getConnection();
    }

    public Treinador getTreinadorByIdPreferido(int id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * from tb_treinador where idtreinador=(?) LIMIT 1;";
		
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1,id);

        ResultSet res = stmt.executeQuery();
        Treinador treinador = new Treinador();
        PokemonDAO pokedao = new PokemonDAO();

        while (res.next())
        { 
            treinador.setId(res.getInt(1));
            treinador.setLogin(res.getString(2));
            treinador.setNome(res.getString(3));
            treinador.setSenha(res.getString(4));
            //treinador.setPreferido(pokedao.getPokemonPreferido(res.getInt(5)));
            return treinador;
        }
        return null;
    }
        
    public Treinador getTreinadorById(int id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * from tb_treinador where idtreinador=(?) LIMIT 1;";
		
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1,id);

        ResultSet res = stmt.executeQuery();
        Treinador treinador = new Treinador();
        PokemonDAO pokedao = new PokemonDAO();

        while (res.next())
        { 
            treinador.setId(res.getInt(1));
            treinador.setLogin(res.getString(2));
            treinador.setNome(res.getString(3));
            treinador.setSenha(res.getString(4));
            treinador.setId_preferido(res.getInt(5));
            return treinador;
        }
        return null;
    }
    
    public Treinador getTreinador(String login, String senha) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * from tb_treinador where login=(?) AND senha=(?) LIMIT 1;";
		
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1,login);
        stmt.setString(2,senha);

        ResultSet res = stmt.executeQuery();
        Treinador treinador = new Treinador();
        PokemonDAO pokedao = new PokemonDAO();

        while (res.next())
        { 
            treinador.setId(res.getInt(1));
            treinador.setLogin(res.getString(2));
            treinador.setNome(res.getString(3));
            treinador.setSenha(res.getString(4));
            treinador.setId_preferido(res.getInt(5));

            return treinador;
        }
        return null;
    }
    
    public void updateTreinador(Treinador treinador) throws SQLException {
        String sql = "UPDATE tb_treinador SET nome=(?), login=(?), senha=(?), pokemon_preferido=(?) where idtreinador=(?);";
		
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1,treinador.getNome());
        stmt.setString(2,treinador.getLogin());
        stmt.setString(3,treinador.getSenha());
        stmt.setInt(4,treinador.getId_preferido());
        stmt.setInt(5,treinador.getId());
        stmt.executeUpdate();
    }
}
