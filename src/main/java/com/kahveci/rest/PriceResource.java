package com.kahveci.rest;


import com.google.gson.Gson;
import com.kahveci.model.Extra;
import com.kahveci.model.Size;
import com.kahveci.model.Syrup;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/price")
public class PriceResource {
    private final Gson gson = new Gson();

    @GET
    @Path("size/{name}")
    @Produces("application/json")
    public Response getSizePrice(@PathParam("name") String name) {
        return Response.ok(gson.toJson(Size.valueOf(name).getPrice())).build();
    }

    @GET
    @Path("extra/{name}")
    @Produces("application/json")
    public Response getExtraPrice(@PathParam("name") String name) {
        return Response.ok(gson.toJson(Extra.valueOf(name).getPrice())).build();
    }

    @GET
    @Path("syrup/{name}")
    @Produces("application/json")
    public Response getSyrupPrice(@PathParam("name") String name) {
        return Response.ok(gson.toJson(Syrup.valueOf(name).getPrice())).build();
    }

}
