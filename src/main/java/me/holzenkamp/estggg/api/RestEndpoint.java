package me.holzenkamp.estggg.api;

import me.holzenkamp.estggg.business.calculation.Calculator;
import me.holzenkamp.estggg.business.configuration.Configuration2018;
import me.holzenkamp.estggg.business.dto.CalculationParameters;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RestEndpoint {

    @GET
    @Path("/2018/{lohn}")
    public Response calculate2018(@QueryParam("lohn") Double lohn) {
        // TODO fix API according to swagger definition
        // TODO Validate input data
        try {
            CalculationParameters parameters = new CalculationParameters();
            parameters.setLohn(lohn);

            return Response.ok(Calculator.calculate(parameters, new Configuration2018())).build();
        } catch (IOException e) {
            return Response.serverError().build();
        }
    }

    @POST
    public Response calculate(CalculationParameters parameters) {
        try {
            return Response.ok(Calculator.calculate(parameters, new Configuration2018())).build();
        } catch (IOException e) {
            return Response.serverError().build();
        }
    }

}
