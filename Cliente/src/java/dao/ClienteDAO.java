/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.Cidade;
import java.sql.Connection;
import java.sql.SQLException;
import beans.Cliente;
import beans.Estado;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ericklopes
 */
public class ClienteDAO {
    private Connection conn;
    
    public ClienteDAO() throws SQLException, ClassNotFoundException
    {
            this.conn = (Connection) new dao.ConnectionFactory().getConnection();
    }
    
    public List<Cliente> getClientes() throws SQLException{
    ResultSet rs;    
    List<Cliente> clientes = new ArrayList<>();
        Statement stmt = conn.createStatement();
        String query = "SELECT cl.*, ci.nome_cidade, es.*  FROM tb_cliente cl, tb_cidade ci, tb_estado es WHERE cl.id_cidade = ci.id_cidade AND ci.id_estado = es.id_estado  ORDER BY id_cliente";
        rs = stmt.executeQuery(query);
        while (rs.next()) {
            int id = rs.getInt("id_cliente");
            String cpf = rs.getString("cpf_cliente");
            String nome = rs.getString("nome_cliente");
            String email = rs.getString("email_cliente");
            Date data = rs.getDate("data_cliente");
            String rua = rs.getString("rua_cliente");
            int numero = rs.getInt("nr_cliente");
            String cep = rs.getString("cep_cliente");
            int idcidade = rs.getInt("id_cidade");
            String nomecidade = rs.getString("nome_cidade");
            int idestado = rs.getInt("id_estado");
            String nomeestado = rs.getString("nome_estado");
            String sigla = rs.getString("sigla_estado");
            Cliente cliente = new Cliente();
            cliente.setId(id);
            cliente.setCpf(cpf);
            cliente.setNome(nome);
            cliente.setEmail(email);
            cliente.setData(data);
            cliente.setRua(rua);
            cliente.setNumero(numero);
            cliente.setCep(cep);
            Estado estado = new Estado();
            estado.setId(idestado);
            estado.setNome(nomeestado);
            estado.setSigla(sigla);
            Cidade cidade = new Cidade();
            cidade.setId(idcidade);
            cidade.setNome(nomecidade);
            cidade.setEstado(estado);
            cliente.setCidade(cidade);
            clientes.add(cliente);
        }
        return clientes;
    }
    
    public Cliente getClienteById(int id) throws SQLException {
        String sql = "SELECT cl.*, ci.nome_cidade, es.* FROM tb_cliente cl, tb_cidade ci, tb_estado es  WHERE id_cliente=(?) AND cl.id_cidade = ci.id_cidade AND ci.id_estado = es.id_estado;";
		
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1,id);

        ResultSet res = stmt.executeQuery();
        Cliente cliente = new Cliente();

        while (res.next())
        { 
            cliente.setId(res.getInt(1));
            cliente.setCpf(res.getString(2));
            cliente.setNome(res.getString(3));
            cliente.setEmail(res.getString(4));
            cliente.setData(res.getDate(5));
            cliente.setRua(res.getString(6));
            cliente.setNumero(res.getInt(7));
            cliente.setCep(res.getString(8));
            Cidade cidade = new Cidade();
            cidade.setId(res.getInt(9));
            cidade.setNome(res.getString(10));
            Estado estado = new Estado();
            estado.setId(res.getInt(11));
            estado.setNome(res.getString(12));
            estado.setSigla(res.getString(13));
            cidade.setEstado(estado);
            cliente.setCidade(cidade);
            return cliente;
        }

        return null;
    }
    
    public Cliente getClienteByCpf(String cpf , int id) throws SQLException {
        String sql = "SELECT cl.*, ci.nome_cidade, es.* FROM tb_cliente cl, tb_cidade ci, tb_estado es  WHERE cpf_cliente=(?) AND id_cliente!=(?) AND cl.id_cidade = ci.id_cidade AND ci.id_estado = es.id_estado;";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, cpf);
        stmt.setInt(2, id);
        ResultSet res = stmt.executeQuery();
        Cliente cliente = new Cliente();

        while (res.next()) {
            cliente.setId(res.getInt(1));
            cliente.setCpf(res.getString(2));
            cliente.setNome(res.getString(3));
            cliente.setEmail(res.getString(4));
            cliente.setData(res.getDate(5));
            cliente.setRua(res.getString(6));
            cliente.setNumero(res.getInt(7));
            cliente.setCep(res.getString(8));
            Cidade cidade = new Cidade();
            cidade.setId(res.getInt(9));
            cidade.setNome(res.getString(10));
            Estado estado = new Estado();
            estado.setId(res.getInt(11));
            estado.setNome(res.getString(12));
            estado.setSigla(res.getString(13));
            cidade.setEstado(estado);
            cliente.setCidade(cidade);
            return cliente;
        }

        return null;
    }
    
    public Cliente getClienteByEmail(String email, int id) throws SQLException {
        String sql = "SELECT cl.*, ci.nome_cidade, es.* FROM tb_cliente cl, tb_cidade ci, tb_estado es  WHERE email_cliente=(?) AND id_cliente!=(?) AND cl.id_cidade = ci.id_cidade AND ci.id_estado = es.id_estado;";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, email);
        stmt.setInt(2, id);
        ResultSet res = stmt.executeQuery();
        Cliente cliente = new Cliente();

        while (res.next()) {
            cliente.setId(res.getInt(1));
            cliente.setCpf(res.getString(2));
            cliente.setNome(res.getString(3));
            cliente.setEmail(res.getString(4));
            cliente.setData(res.getDate(5));
            cliente.setRua(res.getString(6));
            cliente.setNumero(res.getInt(7));
            cliente.setCep(res.getString(8));
            Cidade cidade = new Cidade();
            cidade.setId(res.getInt(9));
            cidade.setNome(res.getString(10));
            Estado estado = new Estado();
            estado.setId(res.getInt(11));
            estado.setNome(res.getString(12));
            estado.setSigla(res.getString(13));
            cidade.setEstado(estado);
            cliente.setCidade(cidade);
            return cliente;
        }

        return null;
    }

    public void removeClienteById(int id) throws SQLException {
        String sql = "DELETE FROM tb_cliente where id_cliente=(?);";
		
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1,id);
        stmt.executeUpdate();
    }
    
    public void updateClienteById(Cliente cliente) throws SQLException {
        String sql = "UPDATE tb_cliente SET nome_cliente=(?), cpf_cliente=(?), email_cliente=(?), data_cliente=(?), cep_cliente=(?), rua_cliente=(?), nr_cliente=(?), id_cidade=(?) where id_cliente=(?);";
		
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1,cliente.getNome());
        stmt.setString(2,cliente.getCpf());
        stmt.setString(3,cliente.getEmail());
        stmt.setDate(4,new java.sql.Date(cliente.getData().getTime()));
        stmt.setString(5,cliente.getCep());
        stmt.setString(6,cliente.getRua());
        stmt.setInt(7,cliente.getNumero());
        stmt.setInt(8,cliente.getCidade().getId());
        stmt.setInt(9,cliente.getId());
        stmt.executeUpdate();
    }

    public void insertCliente(Cliente cliente) throws SQLException {
        String sql = "insert into tb_cliente values((?), (?), (?), (?), (?), (?), (?), (?), (?));";
		
        PreparedStatement stmt = conn.prepareStatement(sql);
        int id = this.getMaxId();
        ++id;
        stmt.setInt(1,id);
        stmt.setString(2,cliente.getCpf());
        stmt.setString(3,cliente.getNome());
        stmt.setString(4,cliente.getEmail());
        stmt.setDate(5,new java.sql.Date(cliente.getData().getTime()));
        stmt.setString(6,cliente.getRua());
        stmt.setInt(7,cliente.getNumero());
        stmt.setString(8,cliente.getCep());
        stmt.setInt(9,cliente.getCidade().getId());
        
        stmt.executeUpdate();
    }
    
    public int getMaxId() throws SQLException {
        String sql = "SELECT MAX(id_cliente) FROM tb_cliente;";
		
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet res = stmt.executeQuery();
        while (res.next())
        { 
            return res.getInt(1);
        }
        return 0;
    }
}
