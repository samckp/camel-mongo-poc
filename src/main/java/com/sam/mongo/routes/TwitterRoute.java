package com.sam.mongo.routes;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class TwitterRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        String consumerKey= "z7PCBNmhM6tySoSR3";
        String consumerSecret="Uswp8JfqYnB9KvKtvMW0tYj8C9hr7rp1vDx";
        String accessToken="11130620611838eoZ1iO4Asw9P7j";
        String accessTokenSecret="XcXslKnTxEbSbURkcKp";

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
