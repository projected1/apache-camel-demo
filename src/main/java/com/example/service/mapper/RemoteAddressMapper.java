package com.example.service.mapper;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class RemoteAddressMapper {

    public String getRemoteAddress(Exchange exchange) {
        return exchange.getIn().getBody(HttpServletRequest.class).getRemoteAddr();
    }
}
