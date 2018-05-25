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
        ResultSet rs;
        List<Produto> produtos = new ArrayList<>();
        Statement stmt = conn.createStatement();
        String query = "select * from tb_produto";
        rs = stmt.executeQuery(query);
        while (rs.next()) {
            int id = rs.getInt("id_produto");
            String nome = rs.getString("nome_produto");
            Produto produto = new Produto();
            produto.setId(id);
            produto.setNome(nome);
            produtos.add(produto);
        }
        return produtos;
    }

    public Produto getProdutoById(int idproduto) throws SQLException {
        String sql = "SELECT * FROM tb_produto e WHERE id_produto=(?);";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idproduto);

        ResultSet res = stmt.executeQuery();

        while (res.next()) {
            int id = res.getInt("id_produto");
            String nome = res.getString("nome_produto");
            Produto produto = new Produto();
            produto.setId(id);
            produto.setNome(nome);
            return produto;
        }
        return null;
    }
    
    public void insertProduto(Produto produto) throws SQLException {
        String sql = "insert into tb_produto values((?), (?));";
		
        PreparedStatement stmt = conn.prepareStatement(sql);
        int id = this.getMaxId();
        ++id;
        stmt.setInt(1,id);
        stmt.setString(2, produto.getNome());
        stmt.executeUpdate();
    }
    
    public void updateProdutoById(Produto produto) throws SQLException {
        String sql = "UPDATE tb_produto SET nome_produto=(?) where id_produto=(?);";
		
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1,produto.getNome());
        stmt.setInt(2,produto.getId());
        stmt.executeUpdate();
    }
    
    public void removeProdutoById(int id) throws SQLException {
        String sql = "DELETE FROM tb_produto where id_produto=(?);";
		
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1,id);
        stmt.executeUpdate();
    }
    
    public int getMaxId() throws SQLException {
        String sql = "SELECT MAX(id_produto) FROM tb_produto;";
		
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet res = stmt.executeQuery();
        while (res.next())
        { 
            return res.getInt(1);
        }
        return 0;
    }
}