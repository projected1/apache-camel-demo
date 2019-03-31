package com.example.service.mapper;

import org.apache.camel.Body;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class GeolocationMapper {

    public String getGeolocation(@Body String json) {
        return new JSONObject(json).getString("loc");
    }
}
