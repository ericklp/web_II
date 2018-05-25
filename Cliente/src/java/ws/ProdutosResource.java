/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import beans.Produto;
import dao.ProdutoDAO;
import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author ericklopes
 */
@Path("")
public class ProdutosResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ProdutosResource
     */
    public ProdutosResource() {
    }
    
    @GET
    @Path("produtos/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obterProduto(
            @PathParam("id") int id
        ) throws SQLException, ClassNotFoundException {
        ProdutoDAO produtodao = new ProdutoDAO();
        Produto produto = produtodao.getProdutoById(id);

        return Response.ok(produto).build();
    }

    @GET
    @Path("produtos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obterProdutos()             
            throws SQLException, ClassNotFoundException {
        ProdutoDAO produtodao = new ProdutoDAO();
        List<Produto> produtos = produtodao.getProdutos();
        GenericEntity<List<Produto>> lista =
            new GenericEntity<List<Produto>>(produtos) {};        

        return Response.ok().entity(lista).build();
    }

    /**
     * PUT method for updating or creating an instance of ProdutosResource
     * @param content representation for the resource
     */
    @PUT
    @Path("produtos/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response putJson(@PathParam("id") int id, Produto produto) 
            throws SQLException, ClassNotFoundException {
        ProdutoDAO produtodao = new ProdutoDAO();
        produtodao.updateProdutoById(produto);     

        System.err.println("Sending response to put: "+produto.getNome());
        return Response.ok().build();
    }
    
    @POST
    @Path("produtos")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insereProduto(Produto produto) 
            throws SQLException, ClassNotFoundException {
        ProdutoDAO produtodao = new ProdutoDAO();
        produtodao.insertProduto(produto);     

        System.err.println("Inserindo "+produto.getNome() + " ID:" + produto.getId());
        return Response.ok().build();
    }
    
    @DELETE
    @Path("produtos/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletarProduto(
            @PathParam("id") int id
        ) throws SQLException, ClassNotFoundException {
        ProdutoDAO produtodao = new ProdutoDAO();
        produtodao.removeProdutoById(id);

        return Response.ok().build();
    }
}
