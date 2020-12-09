package com.neo.controller;

import com.neo.entities.NginxStatus;
import com.neo.services.NginxStatusService;
import com.neo.services.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VisitorController {
    private final NginxStatusService nginxStatusService;
    private final ResponseService responseService;

    @Autowired
    public VisitorController(NginxStatusService service, ResponseService responseService) {
        this.nginxStatusService = service;
        this.responseService = responseService;
    }

    @GetMapping("/nginx/statistics")
    public NginxStatus getNginxStatus() {
        String response = responseService.getResponseBodyFromNginx();
        return nginxStatusService.getStatus(response);
    }


}




