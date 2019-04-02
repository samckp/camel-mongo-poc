package com.sam.mongo.routes;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TwitterRoute extends RouteBuilder {

    @Value("${consumerKey}")
    String consumerKey;
    @Value("${consumerSecret}")
    String consumerSecret;
    @Value("${accessToken}")
    String accessToken;
    @Value("${accessTokenSecret}")
    String accessTokenSecret;

    @Override
    public void configure() throws Exception {

      from("twitter://timeline/home?type=polling&delay=6000" +
                "&consumerKey=" + consumerKey+
                "&consumerSecret=" + consumerSecret+
                "&accessToken=" +accessToken+
                "&accessTokenSecret="+accessTokenSecret
        )
                .log(LoggingLevel.INFO, "${body}")
                .to("direct:insertTwitterMsg")
                ;
    }
}
