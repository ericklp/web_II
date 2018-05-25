/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import beans.Cliente;
import dao.ClienteDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ericklopes
 */
public class ClienteFacade {
    public static List<Cliente> buscarTodosClientes() throws SQLException, ClassNotFoundException {
        ClienteDAO clientedao = new ClienteDAO();
        return clientedao.getClientes();
    }
    
    public static Cliente buscar(int id) throws SQLException, ClassNotFoundException {
        ClienteDAO clientedao = new ClienteDAO();
        return clientedao.getClienteById(id);
    }
    
    public static Cliente buscarClienteByCpf(String cpf, int id) throws SQLException, ClassNotFoundException {
        ClienteDAO cidadedao = new ClienteDAO();
        return cidadedao.getClienteByCpf(cpf, id);
    }
    
    public static Cliente buscarClienteByEmail(String email, int id) throws SQLException, ClassNotFoundException {
        ClienteDAO cidadedao = new ClienteDAO();
        return cidadedao.getClienteByEmail(email, id);
    }
    
    public static void remover(int id) throws SQLException, ClassNotFoundException {
        ClienteDAO clientedao = new ClienteDAO();
        clientedao.removeClienteById(id);
    }
    
    public static void alterar(Cliente cliente) throws SQLException, ClassNotFoundException {
        ClienteDAO clientedao = new ClienteDAO();
        clientedao.updateClienteById(cliente);
    }
    
    public static void inserir(Cliente cliente) throws SQLException, ClassNotFoundException {
        ClienteDAO clientedao = new ClienteDAO();
        clientedao.insertCliente(cliente);
    }
}
