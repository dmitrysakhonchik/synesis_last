package com.neo.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class ResponseService {
    public static final String DUMMY_URL = "http://v-nginx2/nginx_status";

    public String getResponseBodyFromNginx() {
        RestTemplate restTemplate = new RestTemplate();
        String response = "";

        try {
            response = restTemplate.getForObject(DUMMY_URL, String.class);
        } catch (RestClientException exception) {
            System.out.println("Exception in Response Service");
        }

        return response;
    }
}
