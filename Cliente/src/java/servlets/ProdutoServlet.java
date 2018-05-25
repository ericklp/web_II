/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.Atendimento;
import beans.Cidade;
import beans.Cliente;
import beans.Estado;
import beans.Produto;
import beans.TipoAtendimento;
import beans.Usuario;
import facade.AtendimentoFacade;
import facade.CidadeFacade;
import facade.ClienteFacade;
import facade.EstadoFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
@WebServlet(name = "ProdutoServlet", urlPatterns = {"/ProdutoServlet"})
public class ProdutoServlet extends HttpServlet {

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
        
        if (acao == null || acao.equals("list")) {
            List<Produto> produtos;
            try {
                produtos = AtendimentoFacade.buscarTodosProdutos();
                request.setAttribute("produtos", produtos);
            } catch (SQLException | ClassNotFoundException ex) {
                request.setAttribute("exception", ex);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
                rd.forward(request, response);
            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/produtoListar.jsp");
            rd.forward(request, response);
        } else {
            switch (acao)
            {
                case "show":
                {
                    try {
                        int id = Integer.parseInt(request.getParameter("id"));
                        Produto produto = AtendimentoFacade.getProduto(id);
                        request.setAttribute("visualizarproduto", produto);
                    } catch (NumberFormatException | SQLException | ClassNotFoundException ex) {
                        request.setAttribute("exception", ex);
                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
                        rd.forward(request, response);
                    }
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/produtoVisualizar.jsp");
                    rd.forward(request, response);
                }
                break;
                
                case "formUpdate":
                {
                    try {
                        int id = Integer.parseInt(request.getParameter("id"));
                        Produto produto = AtendimentoFacade.getProduto(id);
                        request.setAttribute("alterarproduto", produto);
                    } catch (NumberFormatException | SQLException | ClassNotFoundException ex) {
                        request.setAttribute("exception", ex);
                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
                        rd.forward(request, response);
                    }
                    
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/produtoForm.jsp?form=alterar");
                    rd.forward(request, response);
                }
                break;
                
                case "remove":
                {
                    try {
                        int id = Integer.parseInt(request.getParameter("id"));
                        AtendimentoFacade.removerProduto(id);
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
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/ProdutoServlet?action=list");
                    rd.forward(request, response);
                }
                break;

                case "update":
                {
                    Produto produto = new Produto();
                    int id = Integer.parseInt(request.getParameter("id"));
                    produto.setId(id);
                    String nome = request.getParameter("nome");
                    produto.setNome(nome);

                    try {
                        AtendimentoFacade.alterarProduto(produto);
                    } catch (SQLException | ClassNotFoundException ex) {
                        request.setAttribute("exception", ex);
                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
                        rd.forward(request, response);
                    }
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/ProdutoServlet?action=list");
                    rd.forward(request, response);
                }
                break;

                case "formNew":
                {
                    try {
                        System.err.println("TESTE");
                        List<Produto> produtos = new ArrayList<>();
                        produtos = AtendimentoFacade.getProdutos();

                        request.setAttribute("produtos", produtos);
                    } catch (NumberFormatException | SQLException | ClassNotFoundException ex) {
                        request.setAttribute("exception", ex);
                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
                        rd.forward(request, response);
                    }

                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/produto.jsp");
                    rd.forward(request, response);
                }
                break;

                case "new":
                {
                    Produto produto = new Produto();
                    String nome = request.getParameter("nome");
                    produto.setNome(nome);
                    
                    try {
                        AtendimentoFacade.inserirProduto(produto);
                    } catch (SQLException | ClassNotFoundException ex) {
                        request.setAttribute("exception", ex);
                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
                        rd.forward(request, response);
                    }
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/ProdutoServlet?action=list");
                    rd.forward(request, response);
                }
                break;
            }
        } 
        return;
            
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
