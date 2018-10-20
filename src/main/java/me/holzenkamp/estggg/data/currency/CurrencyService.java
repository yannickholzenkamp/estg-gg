package me.holzenkamp.estggg.data.currency;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class CurrencyService {

    private static final String API_URL = "http://free.currencyconverterapi.com/api/v5/convert?q=EUR_CHF&compact=y";

    public static Double eurToChf() throws IOException {
        return 1.15;
        // TODO do not hardcode exchange rate
        /*
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        return mapper.readValue(getUrlContents(API_URL), CurrencyJson.class).getEur_chf().getVal();
        */
    }

    private static String getUrlContents(String urlString) throws IOException {
        URL url = new URL(urlString);
        InputStreamReader inputStream = new InputStreamReader(url.openStream());

        return IOUtils.toString(inputStream);
    }

}
