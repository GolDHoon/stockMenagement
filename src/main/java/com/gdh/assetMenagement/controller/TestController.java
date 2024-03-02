package com.gdh.assetMenagement.controller;

import com.gdh.assetMenagement.dto.common.CommonComponent;
import com.gdh.assetMenagement.service.api.kis.KisCertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    private final KisCertificationService kisCertificationService;
    private final CommonComponent commonComponent;

    @Autowired
    public TestController(KisCertificationService kisCertificationService
                            , CommonComponent commonComponent) {
        this.kisCertificationService = kisCertificationService;
        this.commonComponent = commonComponent;
    }
    @RequestMapping(value ="/test0001", method = RequestMethod.POST)
    public void test0001() throws Exception {
//        kisCertificationService.receiveWebSocketAccessKey();
    }
}
