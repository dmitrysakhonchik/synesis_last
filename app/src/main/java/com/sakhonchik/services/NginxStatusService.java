package com.sakhonchik.services;

import com.sakhonchik.entities.NginxStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class NginxStatusService {

    public NginxStatus getStatus(String nginxInfo) {
        Map<String, Integer> requests = new HashMap<>();
        String[] inputInfo;
        int activeConnection = 0;
        int accepts = 0;
        int handled = 0;
        int req = 0;

        try {
            inputInfo = nginxInfo.trim().split(" ");

            activeConnection = Integer.parseInt(inputInfo[2]);

            accepts = Integer.parseInt(inputInfo[7]);

            handled = Integer.parseInt(inputInfo[8]);

            req = Integer.parseInt(inputInfo[9]);

        } catch (NullPointerException | NumberFormatException exception) {
            System.out.println("Exception in NginxStatusService");
        } finally {
            requests.put("accepts", accepts);
            requests.put("handled", handled);
            requests.put("requests", req);
        }
        return new NginxStatus(activeConnection, requests);
    }

}
