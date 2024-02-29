package com.gdh.stockMenagement.controller;

import com.gdh.stockMenagement.dto.common.CodeDto;
import com.gdh.stockMenagement.dto.common.CommonComponent;
import com.gdh.stockMenagement.service.api.kis.KisCertificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;

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
        kisCertificationService.receiveWebSocketAccessKey();
    }
}
