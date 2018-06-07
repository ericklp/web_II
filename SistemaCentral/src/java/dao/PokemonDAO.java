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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ericklopes
 */
public class PokemonDAO {
   private final Connection conn;

    public PokemonDAO() throws SQLException, ClassNotFoundException {
        this.conn = (Connection) new ConnectionFactory().getConnection();
    }

    public List<Pokemon> getPokemons() throws SQLException, ClassNotFoundException {
        ResultSet rs;
        List<Pokemon> pokemons = new ArrayList<>();
        Statement stmt = conn.createStatement();
        String query = "select * from tb_pokemon";
        rs = stmt.executeQuery(query);
        while (rs.next()) {
            int id = rs.getInt("idpokemon");
            String nome = rs.getString("nome");
            String especie = rs.getString("especie");
            String imagem = rs.getString("imagem");
            float altura = rs.getFloat("altura");
            float peso = rs.getFloat("peso");
            int idtreinador = rs.getInt("idtreinador");
            TreinadorDAO treinadordao = new TreinadorDAO();
            Treinador treinador = treinadordao.getTreinadorById(idtreinador);
            Pokemon pokemon = new Pokemon();
            pokemon.setId(id);
            pokemon.setNome(nome);
            pokemon.setEspecie(especie);
            pokemon.setAltura(altura);
            pokemon.setPeso(peso);
            pokemon.setTreinador(treinador);
            pokemon.setImagem(imagem);

            pokemons.add(pokemon);
        }
        return pokemons;
    }

    public Pokemon getPokemonById(int idpokemon) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM tb_pokemon WHERE idpokemon=(?) LIMIT 1;";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idpokemon);

        ResultSet res = stmt.executeQuery();

        while (res.next()) {
            int id = res.getInt("idpokemon");
            String nome = res.getString("nome");
            String especie = res.getString("especie");
            String imagem = res.getString("imagem");
            float altura = res.getFloat("altura");
            float peso = res.getFloat("peso");
            int idtreinador = res.getInt("idtreinador");
            TreinadorDAO treinadordao = new TreinadorDAO();
            Treinador treinador = treinadordao.getTreinadorById(idtreinador);
            Pokemon pokemon = new Pokemon();
            pokemon.setId(id);
            pokemon.setNome(nome);
            pokemon.setEspecie(especie);
            pokemon.setAltura(altura);
            pokemon.setPeso(peso);
            pokemon.setTreinador(treinador);
            pokemon.setImagem(imagem);
            return pokemon;
        }
        return null;
    }

    public Pokemon getPokemonPreferido(int id_poke) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM tb_pokemon WHERE idpokemon=(?) LIMIT 1;";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id_poke);

        ResultSet res = stmt.executeQuery();

        while (res.next()) {
            int id = res.getInt("idpokemon");
            String nome = res.getString("nome");
            String especie = res.getString("especie");
            String imagem = res.getString("imagem");
            float altura = res.getFloat("altura");
            float peso = res.getFloat("peso");
            int idtreinador = res.getInt("idtreinador");
            Pokemon aux_pokemon = new Pokemon();
            aux_pokemon.setId(id);
            aux_pokemon.setNome(nome);
            aux_pokemon.setEspecie(especie);
            aux_pokemon.setAltura(altura);
            aux_pokemon.setPeso(peso);
            TreinadorDAO treinadordao = new TreinadorDAO();
            Treinador treinador = treinadordao.getTreinadorByIdPreferido(idtreinador);
            aux_pokemon.setTreinador(treinador);
            aux_pokemon.setImagem(imagem);
            return aux_pokemon;
        }
        return null;
    }
    
        public void insertPokemon(Pokemon pokemon) throws SQLException {
        String sql = "insert into tb_pokemon values((?), (?), (?), (?), (?), (?), (?));";
        //TODO adicionar check se pokemon já está cadastrado.

        PreparedStatement stmt = conn.prepareStatement(sql);
        int id = this.getMaxId();
        ++id;
        stmt.setInt(1,id);
        stmt.setString(2, pokemon.getNome());
        stmt.setString(3, pokemon.getEspecie());
        stmt.setFloat(4, pokemon.getAltura());
        stmt.setFloat(5, pokemon.getPeso());
        stmt.setInt(6, pokemon.getTreinador().getId());
        stmt.setString(7, pokemon.getImagem());
        System.out.print(stmt.toString());
        stmt.executeUpdate();
    }
    
    public void updatePokemonById(Pokemon pokemon) throws SQLException {
        String sql = "UPDATE tb_pokemon SET nome=(?), especie=(?), altura=(?), peso=(?), idtreinador=(?), imagem=(?) where idpokemon=(?);";
		
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1,pokemon.getNome());
        stmt.setString(2, pokemon.getEspecie());
        stmt.setFloat(3, pokemon.getAltura());
        stmt.setFloat(4, pokemon.getPeso());
        stmt.setInt(5, pokemon.getTreinador().getId());
        stmt.setInt(6, pokemon.getId());
        stmt.setString(7, pokemon.getImagem());
        stmt.executeUpdate();
    }
    
    public void removePokemonById(int id) throws SQLException {
        String sql = "DELETE FROM tb_pokemon where idpokemon=(?);";
		
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1,id);
        stmt.executeUpdate();
    }
    
    public int getMaxId() throws SQLException {
        String sql = "SELECT MAX(idpokemon) FROM tb_pokemon;";
		
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet res = stmt.executeQuery();
        while (res.next())
        { 
            return res.getInt(1);
        }
        return 0;
    }
}
