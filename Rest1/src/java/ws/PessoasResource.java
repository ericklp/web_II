/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import bean.Pessoa;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author ericklopes
 */
@Path("pessoas")
public class PessoasResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PessoasResource
     */
    public PessoasResource() {
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Pessoa obterPessoa(@PathParam("id") int numero ) {
        Pessoa p = new Pessoa();
        p.setId(numero);
        p.setNome("Razer");
        p.setEmail("razer.anthom@gmail.com");
        return p;
    }
    /**
     * Retrieves representation of an instance of ws.PessoasResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of PessoasResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
