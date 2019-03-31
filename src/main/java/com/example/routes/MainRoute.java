package com.example.routes;

import com.example.service.mapper.TemperatureMapper;
import com.example.service.mapper.GeolocationMapper;
import com.example.service.mapper.RemoteAddressMapper;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MainRoute extends RouteBuilder {

    @Override
    public void configure() {
        restConfiguration()
            .component("jetty")
            .host("{{application.server.host}}")
            .port("{{application.server.port}}");

        rest("/api")
            .get()
            .route()
            .bean(RemoteAddressMapper.class)
            .removeHeaders("*")
            .setHeader(Exchange.HTTP_METHOD, constant("GET"))
            .toD("jetty:http://ipinfo.io/${body}/json?bridgeEndpoint=true")
            .bean(GeolocationMapper.class)
            .removeHeaders("*")
            .toD("jetty:https://api.darksky.net/forecast/{{application.darksky.api-key}}/${body}?units=si&bridgeEndpoint=true")
            .bean(TemperatureMapper.class);
    }
}
