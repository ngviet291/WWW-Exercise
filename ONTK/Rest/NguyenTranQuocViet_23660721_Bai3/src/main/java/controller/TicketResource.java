package controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import model.Passenger;
import service.TicketService;

import java.util.List;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
@Path("/ticket")
public class TicketResource {
    @Inject
    private TicketService ticketService;

    @GET
    @Path("/getAll")
    public List<Passenger> getAll(){
        return  ticketService.getAll();
    }

    @GET
    @Path("/getByName/{name}")
    public Passenger getByName(@PathParam("name") String name){
        return  ticketService.getByName(name);
    }

    @PUT
    @Path("/update")
    public Passenger update(Passenger passenger){
        return  ticketService.updateByName(passenger);
    }

    @DELETE
    @Path("/delete/{name}")
    public boolean delete(@PathParam("name") String name){
        return  ticketService.delete(name);
    }
}
