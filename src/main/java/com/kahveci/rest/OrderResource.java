package com.kahveci.rest;

import com.google.common.collect.Lists;
import com.kahveci.model.Order;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/order")
public class OrderResource {

    @GET
    public List<Order> allGivenOrders() {
        return Lists.newArrayList();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response order(Order order) {
        // TODO validate the order... (Check your resources whether it is available to make that order or not)
        return Response.ok(order).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces("text/plain")
    public Response delete(@PathParam("id") Long id) {
        return Response.ok("Deleted Successfully").build();
    }


    @POST
    @Path("/form")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void orderForm(@FormParam("name") String beverageName,
                          @FormParam("topping") String topping,
                          @FormParam("syrup") String syrup,
                          @FormParam("size") String size) {

        // TODO form submission will go here
    }

}
