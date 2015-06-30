package com.kahveci.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.io.InputStream;

@Path("/")
public class IndexResource {

    @GET
    @Path("/")
    @Produces("text/html")
    public Response index() {
        InputStream resourceAsStream = this.getClass().getResourceAsStream("/index.html");
        return Response.ok(resourceAsStream).build();
    }

    @GET
    @Path("/info")
    @Produces("text/plain")
    public Response info() {

        String welcome = " == Welcome to the KAHVECI resources API ==\n" +
                "\n" +
                " The service will respond to the following requests:\n" +
                "\n" +
                " *  GET    /                           -   index.html\n" +
                " *  GET    /info                       -   Shows this message\n" +
                " *  GET    /beverages                  -   Return all Beverage\n" +
                " *  GET    /beverages/[name]           -   Inquire Beverage with name\n" +
                " *  GET    /beverages/[name]/toppings  -   Inquire Toppings related with selected Beverage\n" +
                " *  GET    /price/extra/[name]         -   Inquire price of the extra\n" +
                " *  GET    /price/syrup/[name]         -   Inquire price of the syrup\n" +
                " *  GET    /price/size/[name]          -   Inquire price of the size\n" +
                " *  POST   /order                      -   Order! \n" +
                " *  DELETE /order/[id]                 -   Delete Order given with id! \n";

        return Response.ok(welcome).build();
    }

    @GET
    @Path("/css/{name}")
    @Produces("text/css")
    public Response css(@PathParam("name") String name) {
        InputStream resourceAsStream = this.getClass().getResourceAsStream("/css/" + name);
        return Response.ok(resourceAsStream).build();
    }

    @GET
    @Path("/js/{name}")
    @Produces("text/plain")
    public Response js(@PathParam("name") String name) {
        InputStream resourceAsStream = this.getClass().getResourceAsStream("/js/" + name);
        return Response.ok(resourceAsStream).build();
    }

    @GET
    @Path("/fonts/{name}")
    @Produces("text/plain")
    public Response fonts(@PathParam("name") String name) {
        InputStream resourceAsStream = this.getClass().getResourceAsStream("/fonts/" + name);
        return Response.ok(resourceAsStream).build();
    }

}
