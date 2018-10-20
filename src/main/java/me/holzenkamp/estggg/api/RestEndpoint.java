package me.holzenkamp.estggg.api;

import me.holzenkamp.estggg.business.calculation.Calculator;
import me.holzenkamp.estggg.business.configuration.Configuration2018;
import me.holzenkamp.estggg.business.dto.CalculationParameters;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.logging.Logger;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RestEndpoint {

    private final Logger LOGGER = Logger.getLogger(this.getClass().getName());

    @GET
    @Path("/2018/{lohn}")
    public Response calculate2018(@PathParam("lohn") Double lohn) {
        // TODO fix API according to swagger definition
        // TODO Validate input data
        LOGGER.info("2018 with lohn: " + lohn);
        try {
            CalculationParameters parameters = new CalculationParameters();
            parameters.setLohn(lohn);
            LOGGER.info("Params: " + parameters);

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
