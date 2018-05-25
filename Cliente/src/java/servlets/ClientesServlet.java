/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.Cidade;
import beans.Cliente;
import beans.Estado;
import beans.LoginBean;
import dao.ClienteDAO;
import facade.CidadeFacade;
import facade.ClienteFacade;
import facade.EstadoFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ericklopes
 */
@WebServlet(name = "ClientesServlet", urlPatterns = {"/ClientesServlet"})
public class ClientesServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String acao = request.getParameter("action");
        
        System.err.println("ERICK");
        
        LoginBean lb = (LoginBean) session.getAttribute("usuario");
        if (lb == null) {
            request.setAttribute("msg", "Usuário deve se autenticar para acessar o sistema.");

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
            return;
        }
        
        if (acao == null || acao.equals("list")) {
            List<Cliente> clientes;
            try {
                clientes = ClienteFacade.buscarTodosClientes();
                request.setAttribute("clientes", clientes);
            } catch (SQLException | ClassNotFoundException ex) {
                request.setAttribute("exception", ex);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
                rd.forward(request, response);
            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/clientesListar.jsp");
            rd.forward(request, response);
        } else {
            if (acao.equals("show")) {
                try {
                    int id = Integer.parseInt(request.getParameter("id"));
                    Cliente cliente = ClienteFacade.buscar(id);
                    request.setAttribute("visualizarcliente", cliente);
                } catch (NumberFormatException | SQLException | ClassNotFoundException ex) {
                    request.setAttribute("exception", ex);
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
                    rd.forward(request, response);
                }
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/clientesVisualizar.jsp");
                rd.forward(request, response);
            } else { 
                if (acao.equals("formUpdate")) {
                    try {
                        int id = Integer.parseInt(request.getParameter("id"));
                        Cliente cliente = ClienteFacade.buscar(id);
                        List<Estado> estados = new ArrayList<>();
                        estados = EstadoFacade.buscarTodosEstados();
                        request.setAttribute("alterarcliente", cliente);
                        System.err.println("estados:"+estados);
                        request.setAttribute("estados", estados);
                    } catch (NumberFormatException | SQLException | ClassNotFoundException ex) {
                        request.setAttribute("exception", ex);
                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
                        rd.forward(request, response);
                    }
                    
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/clientesForm.jsp?form=alterar");
                    rd.forward(request, response);
                } else {
                    if (acao.equals("remove")) {
                        try {
                            int id = Integer.parseInt(request.getParameter("id"));
                            ClienteFacade.remover(id);
                        } catch (NumberFormatException ex) {
                            request.setAttribute("exception", ex);
                            RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
                            rd.forward(request, response);
                        } catch (SQLException ex) {
                            request.setAttribute("exception", ex);
                            RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
                            rd.forward(request, response);
                        } catch (ClassNotFoundException ex) {
                            request.setAttribute("exception", ex);
                            RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
                            rd.forward(request, response);
                        }
                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/ClientesServlet?action=list");
                        rd.forward(request, response);
                    } else {
                        if (acao.equals("update")) {
                            Cliente cliente = new Cliente();
                            try {
                                int id = Integer.parseInt(request.getParameter("id"));
                                cliente.setId(id);
                                String cpf = request.getParameter("cpf");
                                cpf = cpf.replace(".", "");
                                cpf = cpf.replace("-", "");
                                Cliente cl = ClienteFacade.buscarClienteByCpf(cpf, id);
                                if (cl != null) {
                                    request.setAttribute("msg", "CPF já cadastrado no sistema.");

                                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/ClientesServlet?action=list");
                                    rd.forward(request, response);
                                }
                                cliente.setCpf(cpf);
                                String email = request.getParameter("email");
                                
                                
                                cl = ClienteFacade.buscarClienteByEmail(email, id);
                                if (cl != null) {
                                    request.setAttribute("msg", "E-mail já cadastrado no sistema.");

                                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/ClientesServlet?action=list");
                                    rd.forward(request, response);
                                }
                                cliente.setEmail(email);
                            } catch (NumberFormatException | SQLException | ClassNotFoundException ex) {
                                request.setAttribute("exception", ex);
                                RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
                                rd.forward(request, response);
                            }
                            
                            cliente.setNome(request.getParameter("nome"));
                            
                            
                            String dataString = request.getParameter("data");
                            DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
                            try {
                                Date data = new Date(fmt.parse(dataString).getTime());
                                cliente.setData(data);
                            } catch (ParseException ex) {
                                request.setAttribute("exception", ex);
                                RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
                                rd.forward(request, response);
                            }
                            String cep = request.getParameter("cep");
                            cep = cep.replace("-", "");
                            cliente.setCep(cep);
                            cliente.setRua(request.getParameter("rua"));
                            try {
                                int numero = Integer.parseInt(request.getParameter("numero"));
                                int idcidade = Integer.parseInt(request.getParameter("cidade"));
                                Cidade cidade = CidadeFacade.buscarCidade(idcidade);
                                cliente.setCidade(cidade);
                                cliente.setNumero(numero);
                            } catch (NumberFormatException | SQLException | ClassNotFoundException ex) {
                                request.setAttribute("exception", ex);
                                RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
                                rd.forward(request, response);
                            }                            
                            
                            try {
                                ClienteFacade.alterar(cliente);
                            } catch (SQLException | ClassNotFoundException ex) {
                                request.setAttribute("exception", ex);
                                RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
                                rd.forward(request, response);
                            }
                            RequestDispatcher rd = getServletContext().getRequestDispatcher("/ClientesServlet?action=list");
                            rd.forward(request, response);
                        } else {
                            if (acao.equals("formNew")) {
                                try {
                                    List<Estado> estados = new ArrayList<>();
                                    estados = EstadoFacade.buscarTodosEstados();
                                    request.setAttribute("estados", estados);
                                } catch (NumberFormatException | SQLException | ClassNotFoundException ex) {
                                    request.setAttribute("exception", ex);
                                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
                                    rd.forward(request, response);
                                }
                                
                                RequestDispatcher rd = getServletContext().getRequestDispatcher("/clientesForm.jsp");
                                rd.forward(request, response);
                            } else {
                                if (acao.equals("new")) {
                                    Cliente cliente = new Cliente();
                                    cliente.setNome(request.getParameter("nome"));
                                    String cpf = request.getParameter("cpf");
                                    cpf = cpf.replace(".", "");
                                    cpf = cpf.replace("-", "");
                                    try {
                                        Cliente cl = ClienteFacade.buscarClienteByCpf(cpf, 0);
                                        if(cl != null) {
                                            request.setAttribute("msg", "CPF já cadastrado no sistema.");

                                            RequestDispatcher rd = getServletContext().getRequestDispatcher("/ClientesServlet?action=list");
                                            rd.forward(request, response);
                                        }
                                    } catch (SQLException | ClassNotFoundException ex) {
                                        request.setAttribute("exception", ex);
                                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
                                        rd.forward(request, response);
                                    }
                                    cliente.setCpf(cpf);
                                    cliente.setCpf(cpf);
                                    String email = request.getParameter("email");
                                    try {
                                        Cliente cl = ClienteFacade.buscarClienteByEmail(email, 0);
                                        if (cl != null) {
                                            request.setAttribute("msg", "E-mail já cadastrado no sistema.");

                                            RequestDispatcher rd = getServletContext().getRequestDispatcher("/ClientesServlet?action=list");
                                            rd.forward(request, response);
                                        }
                                    } catch (SQLException | ClassNotFoundException ex) {
                                        request.setAttribute("exception", ex);
                                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
                                        rd.forward(request, response);
                                    }
                                    cliente.setEmail(email);
                                    String dataString = request.getParameter("data");
                                    DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
                                    try {
                                        Date data = new Date(fmt.parse(dataString).getTime());
                                        cliente.setData(data);
                                    } catch (ParseException ex) {
                                        request.setAttribute("exception", ex);
                                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
                                        rd.forward(request, response);
                                    }
                                    String cep = request.getParameter("cep");
                                    cep = cep.replace("-", "");
                                    cliente.setCep(cep);
                                    cliente.setRua(request.getParameter("rua"));
                                    try {
                                        int numero = Integer.parseInt(request.getParameter("numero"));
                                        int idcidade = Integer.parseInt(request.getParameter("cidade"));
                                        Cidade cidade = CidadeFacade.buscarCidade(idcidade);
                                        cliente.setCidade(cidade);
                                        cliente.setNumero(numero);
                                    } catch (NumberFormatException | SQLException | ClassNotFoundException ex) {
                                        request.setAttribute("exception", ex);
                                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
                                        rd.forward(request, response);
                                    }
                                    try {
                                        ClienteFacade.inserir(cliente);
                                    } catch (SQLException | ClassNotFoundException ex) {
                                        request.setAttribute("exception", ex);
                                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
                                        rd.forward(request, response);
                                    }
                                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/ClientesServlet?action=list");
                                    rd.forward(request, response);
                                }
                            }
                        }
                    }
                }
            }
        } 
            
    }
        
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            processRequest(request, response);
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            processRequest(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
