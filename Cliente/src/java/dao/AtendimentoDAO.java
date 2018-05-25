/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.Atendimento;
import beans.Cliente;
import beans.Produto;
import beans.TipoAtendimento;
import beans.Usuario;
import java.sql.Connection;
import java.util.Date;
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
public class AtendimentoDAO {

    private Connection conn;
    
    public AtendimentoDAO() throws SQLException, ClassNotFoundException
    {
            this.conn = (Connection) new dao.ConnectionFactory().getConnection();
    }
    public List<Atendimento> getAtendimentos() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM tb_atendimento atend, tb_usuario us, tb_produto prod, tb_tipo_atendimento tipo , tb_cliente cl "
                + "WHERE atend.id_usuario = us.id_usuario  "
                + "AND atend.id_usuario = us.id_usuario "
                + "AND atend.id_cliente = cl.id_cliente "
                + "AND atend.id_produto = prod.id_produto "
                + "AND atend.id_tipo_atendimento = tipo.id_tipo_atendimento "
                + "ORDER BY atend.dt_hr_atendimento DESC;";
		
        PreparedStatement stmt = conn.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();
        
        List<Atendimento> atendimentos = new ArrayList<>();

        while (rs.next())
        { 
            int idatendimento = rs.getInt("id_atendimento");
            Date data = rs.getTimestamp("dt_hr_atendimento");
            //System.err.println("data_dao_get_list:" + data.toString());
            String descricao = rs.getString("dsc_atendimento");
            int idproduto = rs.getInt("id_produto");
            String nomeproduto = rs.getString("nome_produto");
            int idtipoatendimento = rs.getInt("id_tipo_atendimento");
            String nometipoatendimento = rs.getString("nome_tipo_atendimento");
            int idusuario = rs.getInt("id_usuario");
            String login = rs.getString("login_usuario");
            String senha = rs.getString("senha_usuario");
            String nomeusuario = rs.getString("nome_usuario");
            String resatendimento = rs.getString("res_atendimento");
            int idcliente = rs.getInt("id_cliente");
            
            Atendimento atendimento = new Atendimento();
            atendimento.setId(idatendimento);
            atendimento.setData(data);
            atendimento.setDescricao(descricao);
            atendimento.setRes_atendimento(resatendimento);
            
            Produto produto = new Produto();
            produto.setId(idproduto);
            produto.setNome(nomeproduto);
            
            TipoAtendimento tipo = new TipoAtendimento();
            tipo.setId(idtipoatendimento);
            tipo.setNome(nometipoatendimento);
            
            Usuario usuario = new Usuario();
            usuario.setId(idusuario);
            usuario.setLogin(login);
            usuario.setNome(nomeusuario);
            usuario.setSenha(senha);
            
            Cliente cliente = new ClienteDAO().getClienteById(idcliente);

            atendimento.setProduto(produto);
            atendimento.setTipo_atendimento(tipo);
            atendimento.setUsuario(usuario);
            atendimento.setCliente(cliente);
            
            atendimentos.add(atendimento);
        }

        return atendimentos;
    }
    
    public Atendimento getAtendimentoById(int id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM tb_atendimento atend, tb_usuario us, tb_produto prod, tb_tipo_atendimento tipo , tb_cliente cl "
                + "WHERE  id_atendimento=(?) AND "
                + "atend.id_usuario = us.id_usuario "
                + "AND atend.id_produto = prod.id_produto "
                + "AND atend.id_tipo_atendimento = tipo.id_tipo_atendimento;";
		
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1,id);

        ResultSet rs = stmt.executeQuery();
        Atendimento atendimento = new Atendimento();

        while (rs.next())
        { 
            int idatendimento = rs.getInt("id_atendimento");
            Date data = rs.getTimestamp("dt_hr_atendimento");
            String descricao = rs.getString("dsc_atendimento");
            int idproduto = rs.getInt("id_produto");
            String nomeproduto = rs.getString("nome_produto");
            int idtipoatendimento = rs.getInt("id_tipo_atendimento");
            String nometipoatendimento = rs.getString("nome_tipo_atendimento");
            int idusuario = rs.getInt("id_usuario");
            String login = rs.getString("login_usuario");
            String senha = rs.getString("senha_usuario");
            String nomeusuario = rs.getString("nome_usuario");
            String resatendimento = rs.getString("res_atendimento");
            int idcliente = rs.getInt("id_cliente");
            
            atendimento.setId(id);
            atendimento.setData(data);
            atendimento.setDescricao(descricao);
            atendimento.setRes_atendimento(resatendimento);
            
            Produto produto = new Produto();
            produto.setId(idproduto);
            produto.setNome(nomeproduto);
            
            TipoAtendimento tipo = new TipoAtendimento();
            tipo.setId(idtipoatendimento);
            tipo.setNome(nometipoatendimento);
            
            Usuario usuario = new Usuario();
            usuario.setId(idusuario);
            usuario.setLogin(login);
            usuario.setNome(nomeusuario);
            usuario.setSenha(senha);
            
            Cliente cliente = new ClienteDAO().getClienteById(idcliente);

            atendimento.setProduto(produto);
            atendimento.setTipo_atendimento(tipo);
            atendimento.setUsuario(usuario);
            atendimento.setCliente(cliente);
            return atendimento;
        }

        return null;
    }
    
    public List<Atendimento> getAtendimentoByIdUsuario(int id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM tb_atendimento atend, tb_usuario us, tb_produto prod, tb_tipo_atendimento tipo , tb_cliente cl "
                + "WHERE  us.id_usuario=(?)  "
                + "AND atend.id_usuario = us.id_usuario "
                + "AND atend.id_cliente = cl.id_cliente "
                + "AND atend.id_produto = prod.id_produto "
                + "AND atend.id_tipo_atendimento = tipo.id_tipo_atendimento "
                + "ORDER BY atend.dt_hr_atendimento DESC;";
		
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1,id);

        ResultSet rs = stmt.executeQuery();
        
        List<Atendimento> atendimentos = new ArrayList<>();

        while (rs.next())
        { 
            int idatendimento = rs.getInt("id_atendimento");
            Date data = rs.getTimestamp("dt_hr_atendimento");
            //System.err.println("data_dao_get_list:" + data.toString());
            String descricao = rs.getString("dsc_atendimento");
            int idproduto = rs.getInt("id_produto");
            String nomeproduto = rs.getString("nome_produto");
            int idtipoatendimento = rs.getInt("id_tipo_atendimento");
            String nometipoatendimento = rs.getString("nome_tipo_atendimento");
            int idusuario = rs.getInt("id_usuario");
            String login = rs.getString("login_usuario");
            String senha = rs.getString("senha_usuario");
            String nomeusuario = rs.getString("nome_usuario");
            String resatendimento = rs.getString("res_atendimento");
            int idcliente = rs.getInt("id_cliente");
            
            Atendimento atendimento = new Atendimento();
            atendimento.setId(idatendimento);
            atendimento.setData(data);
            atendimento.setDescricao(descricao);
            atendimento.setRes_atendimento(resatendimento);
            
            Produto produto = new Produto();
            produto.setId(idproduto);
            produto.setNome(nomeproduto);
            
            TipoAtendimento tipo = new TipoAtendimento();
            tipo.setId(idtipoatendimento);
            tipo.setNome(nometipoatendimento);
            
            Usuario usuario = new Usuario();
            usuario.setId(idusuario);
            usuario.setLogin(login);
            usuario.setNome(nomeusuario);
            usuario.setSenha(senha);
            
            Cliente cliente = new ClienteDAO().getClienteById(idcliente);

            atendimento.setProduto(produto);
            atendimento.setTipo_atendimento(tipo);
            atendimento.setUsuario(usuario);
            atendimento.setCliente(cliente);
            
            atendimentos.add(atendimento);
        }

        return atendimentos;
    }

    public void removeAtendimentoById(int id) throws SQLException {
        String sql = "DELETE FROM tb_atendimento where id_atendimento=(?);";
		
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1,id);
        stmt.executeUpdate();
    }
    
    public void updateAtendimentoById(Atendimento atendimento) throws SQLException {
        String sql = "UPDATE tb_atendimento SET dt_hr_atendimento=(?), dsc_atendimento=(?), id_produto=(?), id_tipo_atendimento=(?), id_usuario=(?), res_atendimento=(?) where id_atendimento=(?);";
		
        PreparedStatement stmt = conn.prepareStatement(sql);
        Object param = new java.sql.Timestamp(atendimento.getData().getTime());
        stmt.setObject(1,param);
        stmt.setString(2,atendimento.getDescricao());
        stmt.setInt(3,atendimento.getProduto().getId());
        stmt.setInt(4,atendimento.getTipo_atendimento().getId());
        stmt.setInt(5,atendimento.getUsuario().getId());
        stmt.setString(6,atendimento.getRes_atendimento());
        stmt.setInt(7,atendimento.getId());
        stmt.executeUpdate();
    }

    public void insertAtendimento(Atendimento atendimento) throws SQLException {
        String sql = "insert into tb_atendimento values((?), (?), (?), (?), (?), (?), (?), (?));";
        System.err.println(atendimento.getTipo_atendimento().getId());
        PreparedStatement stmt = conn.prepareStatement(sql);
        int id = this.getMaxId();
        ++id;
        stmt.setInt     (1, id);
        Object param = new java.sql.Timestamp(atendimento.getData().getTime());
        stmt.setObject(2,param);
        stmt.setString  (3, atendimento.getDescricao());
        stmt.setInt(4, atendimento.getProduto().getId());
        stmt.setInt     (5, atendimento.getTipo_atendimento().getId());
        stmt.setInt     (6, atendimento.getUsuario().getId());
        stmt.setString  (7, atendimento.getRes_atendimento());
        stmt.setInt     (8, atendimento.getCliente().getId());
        System.out.println("Statement: "+stmt.toString());
        stmt.executeUpdate();
    }
    
    public int getMaxId() throws SQLException {
        String sql = "SELECT MAX(id_atendimento) FROM tb_atendimento;";
		
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet res = stmt.executeQuery();
        while (res.next())
        { 
            return res.getInt(1);
        }
        return 0;
    }
}
