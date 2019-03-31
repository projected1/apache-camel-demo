package com.example.service.mapper;

import org.apache.camel.Body;
import org.json.JSONObject;

public class TemperatureMapper {

    public Double getTemperature(@Body String json) {
        return new JSONObject(json).getJSONObject("currently").getDouble("temperature");
    }
}
