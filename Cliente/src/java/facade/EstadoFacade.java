/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import beans.Estado;
import dao.EstadoDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ericklopes
 */
public class EstadoFacade {
    public static List<Estado> buscarTodosEstados() throws SQLException, ClassNotFoundException {
        EstadoDAO estadodao = new EstadoDAO();
        return estadodao.getEstados();
    }
    
    public static Estado buscarEstado(int id) throws SQLException, ClassNotFoundException {
        EstadoDAO cidadedao = new EstadoDAO();
        return cidadedao.getEstadoById(id);
    }
}
