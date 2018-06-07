/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import beans.Pokemon;
import dao.PokemonDAO;
import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
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
public class PokemonResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PokemonResource
     */
    public PokemonResource() {
    }

    @GET
    @Path("pokemons/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obterAtendimento(
            @PathParam("id") int id
        ) throws SQLException, ClassNotFoundException {
        PokemonDAO pokemondao = new PokemonDAO();
        Pokemon pokemon;
        try {
            pokemon = pokemondao.getPokemonById(id);
            if(pokemon==null)
                return Response.status(Response.Status.NOT_FOUND).build();
        } catch (SQLException ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

        return Response.ok(pokemon).build();
    }

    @GET
    @Path("pokemons")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obterPokemons()             
            throws SQLException, ClassNotFoundException {
        PokemonDAO pokemondao = new PokemonDAO();
        List<Pokemon> pokemons;
        try{
            pokemons = pokemondao.getPokemons();
            if(pokemons==null)
                return Response.status(Response.Status.NO_CONTENT).build();
        } catch (SQLException ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

        GenericEntity<List<Pokemon>> lista =
            new GenericEntity<List<Pokemon>>(pokemons) {};        

        return Response.ok().entity(lista).build();
    }
    
    @POST
    @Path("pokemons")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response inserePokemon(Pokemon pokemon) 
            throws SQLException, ClassNotFoundException {
        System.out.print("TESTE");
        PokemonDAO pokemondao = new PokemonDAO();
        try {
            pokemondao.insertPokemon(pokemon);
        } catch (SQLException ex) {
            System.out.print(ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

        return Response.ok().build();
    }
}
