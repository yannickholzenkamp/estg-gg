package me.holzenkamp.estggg.api;

import me.holzenkamp.estggg.business.calculation.Calculator;
import me.holzenkamp.estggg.business.configuration.Configuration;
import me.holzenkamp.estggg.business.configuration.Configuration2018;
import me.holzenkamp.estggg.business.dto.CalculationParameters;
import me.holzenkamp.estggg.business.dto.Result;

import javax.interceptor.Interceptors;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

import static me.holzenkamp.estggg.util.ValidationUtil.validateMandatory;
import static me.holzenkamp.estggg.util.ValidationUtil.validateNotNegative;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class ApiEndpoint {

    private static final String PARAM_LOHN = "lohn";
    private static final String PARAM_PROGVORB = "progVorb";
    private static final String PARAM_WECHSELKURS = "wechselkurs";
    private static final String PARAM_ABZGCHF = "abzgChf";

    private static final Configuration configuration = new Configuration2018();

    @GET
    @Path("/test")
    public String test() {
        return "API OK - Version 1.0.0";
    }

    @GET
    @Path("/simple")
    @Interceptors(ApiInterceptor.class)
    public Result simple(@QueryParam(PARAM_LOHN) Double lohn) throws IOException {

        validateMandatory(lohn, PARAM_LOHN);
        validateNotNegative(lohn, PARAM_LOHN);

        CalculationParameters parameters = new CalculationParameters();
        parameters.setLohn(lohn);

        return Calculator.calculate(parameters, configuration);
    }

    @GET
    @Path("/complex")
    @Interceptors(ApiInterceptor.class)
    public Result complex(@QueryParam(PARAM_LOHN) Double lohn,
                          @QueryParam(PARAM_PROGVORB) Double progVorb,
                          @QueryParam(PARAM_WECHSELKURS) Double wechselkurs) throws IOException {

        validateMandatory(lohn, PARAM_LOHN);
        validateNotNegative(lohn, PARAM_LOHN);
        validateNotNegative(progVorb, PARAM_PROGVORB);
        validateNotNegative(wechselkurs, PARAM_WECHSELKURS);

        CalculationParameters parameters = new CalculationParameters();
        parameters.setLohn(lohn);
        parameters.setProgressionsVorbehalt(progVorb);
        parameters.setWechselkurs(wechselkurs);

        return Calculator.calculate(parameters, configuration);
    }

}
