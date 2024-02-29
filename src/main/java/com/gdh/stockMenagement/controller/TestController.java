package com.gdh.stockMenagement.controller;

import com.gdh.stockMenagement.service.api.kis.KisCertificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final KisCertificationService kisCertificationService;

    @RequestMapping(value ="/test0001", method = RequestMethod.POST)
    public void test0001() throws Exception {
        kisCertificationService.receiveWebSocketAccessKey();
    }
}
