package com.neo.services;

import com.neo.entities.NginxStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class NginxStatusService {

    public NginxStatus getStatus(String nginxInfo) {
        String[] inputInfo = nginxInfo.trim().split(" ");
        Map<String, Integer> requests = new HashMap<>();

        int activeConnection = Integer.parseInt(inputInfo[2]);

        int accepts = Integer.parseInt(inputInfo[7]);

        int handled = Integer.parseInt(inputInfo[8]);

        int req = Integer.parseInt(inputInfo[9]);

        requests.put("accepts", accepts);
        requests.put("handled", handled);
        requests.put("requests", req);


        return new NginxStatus(activeConnection, requests);
    }

}
