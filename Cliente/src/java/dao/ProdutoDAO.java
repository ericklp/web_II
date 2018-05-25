/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.Cliente;
import beans.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author ericklopes
 */
public class ProdutoDAO {
   private final Connection conn;

    public ProdutoDAO() throws SQLException, ClassNotFoundException {
        this.conn = (Connection) new ConnectionFactory().getConnection();
    }

    public List<Produto> getProdutos() throws SQLException {
        String uriWS = "http://localhost:8080/aula2/webresources/produtos";        
        Client client = ClientBuilder.newClient();
        Response resp = client
                            .target(uriWS)
                            .request(MediaType.APPLICATION_JSON)
                            .get();

        List<Produto> lista =
                        resp.readEntity( new GenericType<List<Produto>>() {});
        
        return lista;
    }

    public Produto getProdutoById(int idproduto) throws SQLException {
        Produto produto = new Produto();

        String uriWS = "http://localhost:8080/aula2/webresources/produtos";        
        Client client = ClientBuilder.newClient();
        Response resp = client
                            .target(uriWS)
                            .path(Integer.toString(idproduto))
                            .request(MediaType.APPLICATION_JSON)
                            .get();

        produto = resp.readEntity(Produto.class);
        
        return produto;
    }
    
    public void insertProduto(Produto produto) throws SQLException {
        String uriWS = "http://localhost:8080/aula2/webresources/produtos";        
        Client client = ClientBuilder.newClient();
        Response resp = client
                            .target(uriWS)
                            .request(MediaType.APPLICATION_JSON)
                            .post(Entity.json(produto));
        
        return;
    }
    
    public void updateProdutoById(Produto produto) throws SQLException {
        String uriWS = "http://localhost:8080/aula2/webresources/produtos";        
        Client client = ClientBuilder.newClient();
        Response resp = client
                            .target(uriWS)
                            .path(Integer.toString(produto.getId()))
                            .request(MediaType.APPLICATION_JSON)
                            .put(Entity.json(produto));
        return;
    }
    
    public void removeProdutoById(int id) throws SQLException {
        String uriWS = "http://localhost:8080/aula2/webresources/produtos";        
        Client client = ClientBuilder.newClient();
        Response resp = client
                            .target(uriWS)
                            .path(Integer.toString(id))
                            .request(MediaType.APPLICATION_JSON)
                            .delete();
        return;
    }

}