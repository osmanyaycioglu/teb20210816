package com.ee.training.rest;

import javax.validation.Valid;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/person")
public class PersonRest {

    @Path("/hello/ad/{abc}/soyad/{xyz}")
    @GET
    public String hello1(@PathParam("abc") final String name,
                         @PathParam("xyz") final String surname) {
        return "Hello " + name + " " + surname;
    }

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String add(@Valid final Person personParam) {
        //        String nameLoc = personParam.getName();
        //        if ((nameLoc == null) || nameLoc.isEmpty()) {
        //            throw new IllegalArgumentException("İsim boş olamaz");
        //        }
        return "Hello 3 "
               + personParam.getName()
               + " "
               + personParam.getSurname()
               + " "
               + personParam.getWeight()
               + "/"
               + personParam.getHeight();
    }

    @Path("/addx")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response addX(@Valid final Person personParam) {
        return Response.status(203)
                       .header("deneme",
                               "deneme")
                       .entity("Hello 3 "
                               + personParam.getName()
                               + " "
                               + personParam.getSurname()
                               + " "
                               + personParam.getWeight()
                               + "/"
                               + personParam.getHeight())
                       .build();
    }

    @Path("/hello2")
    @GET
    public String hello2(@QueryParam("isim") final String name,
                         @QueryParam("soy") final String surname) {
        return "Hello 2 " + name + " " + surname;
    }

    @Path("/hello3/{asd}")
    @GET
    public String hello3(@PathParam("asd") final String name,
                         @QueryParam("soy") final String surname) {
        return "Hello 3 " + name + " " + surname;
    }

    @Path("/hello4")
    @GET
    public String hello4(@HeaderParam("isim") final String name,
                         @HeaderParam("soy") final String surname) {
        return "Hello 4 " + name + " " + surname;
    }

    @Path("/hello5")
    @GET
    public String hello5(@FormParam("isim") final String name,
                         @FormParam("soy") final String surname) {
        return "Hello 5 " + name + " " + surname;
    }

    @Path("/add3/{is}")
    @POST
    @Produces({
                MediaType.APPLICATION_JSON,
                MediaType.APPLICATION_XML
    })
    public Person add3(@BeanParam final Person personParam) {
        personParam.setName("test");
        return personParam;
    }


    @Path("/add2")
    @POST
    @Consumes({
                MediaType.APPLICATION_JSON,
                MediaType.APPLICATION_XML
    })
    @Produces({
                MediaType.APPLICATION_JSON,
                MediaType.APPLICATION_XML
    })
    public Person add2(final Person personParam) {
        personParam.setName("test");
        return personParam;
    }

    //    @Inject
    //    private HttpServletRequest htp;
    //
    //    @Path("/hello4/{cmd}")
    //    @GET
    //    public String hello4(@PathParam("cmd") final String command) {
    //        switch (command) {
    //            case "add":
    //                String parameterLoc = htp.getParameter("name");
    //                break;
    //
    //            default:
    //                break;
    //        }
    //        return "Hello 3 " ;
    //    }

}
