package me.holzenkamp.estggg.api;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class ApiInterceptor {

    private final Logger LOGGER = Logger.getLogger(this.getClass().getName());

    @AroundInvoke
    public Object intercept(InvocationContext invocationContext) {
        LOGGER.info(String.format("API operation '%s' called with params: %s",
                invocationContext.getMethod().getName(),
                getParamsAsString(invocationContext.getParameters())
        ));

        try {
            Object operationResult = invocationContext.proceed();
            LOGGER.info(String.format("Result for API operation '%s' with params: %s. Result: %s",
                    invocationContext.getMethod().getName(),
                    getParamsAsString(invocationContext.getParameters()),
                    operationResult.toString()
            ));

            return Response.ok(operationResult).build();
        } catch (Exception e) {
            LOGGER.severe(String.format("ERROR in API operation '%s' with params: %s. Error: %s",
                    invocationContext.getMethod().getName(),
                    getParamsAsString(invocationContext.getParameters()),
                    e.toString()
            ));
            return Response.serverError().build();
        }

    }

    private String getParamsAsString(Object[] objects) {
        return Arrays.stream(objects).map(Object::toString).collect(Collectors.joining(", "));
    }

}
