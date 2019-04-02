package com.sam.mongo.routes;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class TwitterRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        String consumerKey= "z7PCBNmhM6tySoagBMR06ySR3-00";
        String consumerSecret="Uswp8JfqYnB9Kvu0owfAxiwZNPtovKtvMW0tYj8C9hr7rp1vDx";
        String accessToken="1113062061183889409-BIMNd7TVRJaZWQ3HeoZ1iO4Asw9P7j";
        String accessTokenSecret="XcXslKnTxEq8NkPYdd8lOhhax0nPzdyZcuKmbSbURkcKp";

        from("twitter://timeline/home?type=polling&delay=6000" +
                "&consumerKey=" + consumerKey+
                "&consumerSecret=" + consumerSecret+
                "&accessToken=" +accessToken+
                "&accessTokenSecret="+accessTokenSecret
        )
                .log(LoggingLevel.INFO, "${body}")
                ;
    }
}
