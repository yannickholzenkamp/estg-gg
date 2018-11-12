package me.holzenkamp.estggg.api;

import me.holzenkamp.estggg.business.dto.Result;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class ApiEndpointTest {
    
    private ApiEndpoint endpoint = new ApiEndpoint();

    @Test
    void simple() throws IOException {
        final Result result = (Result) endpoint.simple(1000.0);
        System.out.println(result);
    }
    
}
