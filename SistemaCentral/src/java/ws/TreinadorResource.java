/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import beans.Treinador;
import dao.TreinadorDAO;
import java.sql.SQLException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author ericklopes
 */
@Path("")
public class TreinadorResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of TreinadorResource
     */
    public TreinadorResource() {
    }

    @GET
    @Path("treinador/{login}/{senha}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obterTreinador(
            @PathParam("login") String login,
            @PathParam("senha") String senha
        ) throws SQLException, ClassNotFoundException {
        TreinadorDAO treinadordao = new TreinadorDAO();
        Treinador treinador;
        try {
            treinador = treinadordao.getTreinador(login, senha);
            if(treinador==null)
                return Response.status(Response.Status.NOT_FOUND).build();
        } catch (SQLException ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

        return Response.ok(treinador).build();
    }
    
    @PUT
    @Path("treinador/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response putJson(@PathParam("id") int id, Treinador treinador) 
            throws SQLException, ClassNotFoundException {
        TreinadorDAO treinadorDAO = new TreinadorDAO();
        
        try {
            Treinador treinador_aux = treinadorDAO.getTreinadorById(treinador.getId());
            if(treinador_aux==null)
                return Response.status(Response.Status.NOT_FOUND).build();
            treinadorDAO.updateTreinador(treinador);     
        } catch (SQLException ex) {
            System.out.print(ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        
        System.err.println("Sending response to put: "+treinador.getNome());
        return Response.ok().build();
    }
}
