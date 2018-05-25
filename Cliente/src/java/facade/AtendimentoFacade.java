/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import beans.Atendimento;
import beans.Produto;
import beans.TipoAtendimento;
import dao.AtendimentoDAO;
import dao.ProdutoDAO;
import dao.TipoAtendimentoDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ericklopes
 */
public class AtendimentoFacade {
    public static List<Atendimento> buscarTodosAtendimentosByUsuario(int id) throws SQLException, ClassNotFoundException {
        AtendimentoDAO atendimentodao = new AtendimentoDAO();
        return atendimentodao.getAtendimentoByIdUsuario(id);
    }
    
    public static List<Atendimento> buscarTodosAtendimentos() throws SQLException, ClassNotFoundException {
        AtendimentoDAO atendimentodao = new AtendimentoDAO();
        return atendimentodao.getAtendimentos();
    }
    
    public static Atendimento buscar(int id) throws SQLException, ClassNotFoundException {
        AtendimentoDAO atendimentodao = new AtendimentoDAO();
        return atendimentodao.getAtendimentoById(id);
    }
    
    public static void remover(int id) throws SQLException, ClassNotFoundException {
        AtendimentoDAO atendimentodao = new AtendimentoDAO();
        atendimentodao.removeAtendimentoById(id);
    }
    
    public static void alterar(Atendimento atendimento) throws SQLException, ClassNotFoundException {
        AtendimentoDAO atendimentodao = new AtendimentoDAO();
        atendimentodao.updateAtendimentoById(atendimento);
    }
    
    public static void inserir(Atendimento atendimento) throws SQLException, ClassNotFoundException {
        AtendimentoDAO atendimentodao = new AtendimentoDAO();
        atendimentodao.insertAtendimento(atendimento);
    }

    public static List<Produto> getProdutos() throws SQLException, ClassNotFoundException {
        ProdutoDAO produtodao = new ProdutoDAO();
        return produtodao.getProdutos();
    }

    public static List<TipoAtendimento> getTipos() throws SQLException, ClassNotFoundException {
        TipoAtendimentoDAO tipodaodao = new TipoAtendimentoDAO();
        return tipodaodao.getTipoAtendimento();
    }

    public static TipoAtendimento getTipo(int idtipo) throws SQLException, ClassNotFoundException {
        TipoAtendimentoDAO tipodaodao = new TipoAtendimentoDAO();
        return tipodaodao.getTipoAtendimentoById(idtipo);
    }

    public static Produto getProduto(int idproduto) throws SQLException, ClassNotFoundException {
        ProdutoDAO produtodao = new ProdutoDAO();
        return produtodao.getProdutoById(idproduto);
    }
    
    public static List<Produto> buscarTodosProdutos() throws SQLException, ClassNotFoundException {
        ProdutoDAO produtodao = new ProdutoDAO();
        return produtodao.getProdutos();
    }
    
    public static void inserirProduto(Produto produto) throws SQLException, ClassNotFoundException {
        ProdutoDAO produtodao = new ProdutoDAO();
        produtodao.insertProduto(produto);
    }
    
    public static void alterarProduto(Produto produto) throws SQLException, ClassNotFoundException {
        ProdutoDAO produtodao = new ProdutoDAO();
        produtodao.updateProdutoById(produto);
    }
    
    public static void removerProduto(int id) throws SQLException, ClassNotFoundException {
        ProdutoDAO produtodao = new ProdutoDAO();
        produtodao.removeProdutoById(id);
    }
    
}
