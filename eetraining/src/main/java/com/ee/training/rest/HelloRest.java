package com.ee.training.rest;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import com.ee.training.ejb.StatefulCalculator;
import com.ee.training.ejb.StatelessCalculator;

@Path("/first")
//@RequestScoped
//@SessionScoped
//@ApplicationScoped
//@ConversationScoped
public class HelloRest implements Serializable {

    private static final long serialVersionUID = -3051204073200686057L;

    // @Inject
    @EJB
    private StatelessCalculator sc;

    @EJB
    private StatefulCalculator  scs;

    @Path("/calc/stateless")
    @GET
    public String calc1(@QueryParam("v1") final Integer val1,
                        @QueryParam("v2") final Integer val2) {
        int addLoc = this.sc.add(val1,
                                 val2);
        int addLoc2 = this.sc.add(val1,
                                  val2);
        int addLoc3 = this.sc.add(val1,
                                  val2);
        int prevTotalLoc = this.sc.getPrevTotal();
        return "Sonuç : " + addLoc;
    }

    @Path("/calc/stateful")
    @GET
    public String calc2(@QueryParam("v1") final Integer val1,
                        @QueryParam("v2") final Integer val2) {
        int addLoc = this.scs.add(val1,
                                  val2);
        int addLoc2 = this.scs.add(val1,
                                   val2);
        int addLoc3 = this.scs.add(val1,
                                   val2);
        int prevTotalLoc = this.scs.getPrevTotal();
        return "Sonuç : " + addLoc + " prev total : " + prevTotalLoc;
    }

    @Path("/calc/stateful/total")
    @GET
    public String getTotal() {
        return "Total : " + this.scs.getPrevTotal();
    }


    @Path("/hello")
    @GET
    public String hello1() {
        return "Hello world";
    }

    @Path("/hello")
    @POST
    public String helloPost() {
        return "Hello world Post";
    }

    @Path("/hello")
    @DELETE
    public String helloDelete() {
        return "Hello world Delete";
    }

    @Path("/greet")
    @GET
    public String greet1() {
        return "Greetings 1 !!";
    }

    @Path("/greet")
    @PUT
    public String greet2() {
        return "Greetings 2 !!";
    }

}
