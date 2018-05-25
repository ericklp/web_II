/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import beans.Cidade;
import beans.Cliente;
import dao.CidadeDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ericklopes
 */
public class CidadeFacade {
    public static List<Cidade> buscarTodasCidades() throws SQLException, ClassNotFoundException {
        CidadeDAO cidadedao = new CidadeDAO();
        return cidadedao.getCidades();
    }
    
    public static Cidade buscarCidade(int id) throws SQLException, ClassNotFoundException {
        CidadeDAO cidadedao = new CidadeDAO();
        return cidadedao.getCidadeById(id);
    }
    
    public static List<Cidade> buscarCidadeByIdEstado(int id) throws SQLException, ClassNotFoundException {
        CidadeDAO cidadedao = new CidadeDAO();
        return cidadedao.getCidadesByIdEstado(id);
    }
}
