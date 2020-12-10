package com.sakhonchik.controller;

import com.sakhonchik.entities.NginxStatus;
import com.sakhonchik.services.NginxStatusService;
import com.sakhonchik.services.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NginxStatusController {
    private final NginxStatusService nginxStatusService;
    private final ResponseService responseService;

    @Autowired
    public NginxStatusController(NginxStatusService service, ResponseService responseService) {
        this.nginxStatusService = service;
        this.responseService = responseService;
    }

    @GetMapping("/nginx/statistics")
    public NginxStatus getNginxStatus() {
        String response = responseService.getResponseBodyFromNginx();
        return nginxStatusService.getStatus(response);
    }


}




