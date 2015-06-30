package com.kahveci.rest;

import com.google.gson.Gson;
import com.kahveci.dao.BeverageService;
import com.kahveci.model.Beverage;
import com.kahveci.model.Syrup;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/beverages")
public class BeverageResource {

    private final Gson gson = new Gson(); //TODO not needed if and only if jersey-json works fine for marshaling!

    private final BeverageService service = BeverageService.instance;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        Beverage[] all = service.getAll();
        String s = gson.toJson(all);
        return Response.ok(s).build();
    }


    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response inquire(@PathParam("name") String name) {
        return Response.ok(service.inquire(name)).build();
    }

    @GET
    @Path("/syrups")
    @Produces(MediaType.APPLICATION_JSON)
    public Response inquire() {
        String entity = gson.toJson(Syrup.values());
        return Response.ok(entity).build();
    }


}
